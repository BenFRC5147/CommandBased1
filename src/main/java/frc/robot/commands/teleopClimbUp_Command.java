package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.DriverStation;




public class teleopClimbUp_Command extends Command {
  public teleopClimbUp_Command() {
    requires(Robot.climber);
  }




  @Override
  protected void initialize() {
    DriverStation.reportWarning("Climber initiating", false);
  }




  @Override
  protected void execute() {



    
    while(Robot.m_oi.getOperatorJoystick().getRawButton(2) == true){
      Robot.climber.armUp();
    }
    Robot.climber.Stop();



    
    while(Robot.m_oi.getOperatorJoystick().getRawButton(3) == true){
      Robot.climber.armDown();
    }
    Robot.climber.Stop();




    while(Robot.m_oi.getOperatorJoystick().getRawButton(4) == true){
      Robot.climber.climbUp();
    }
    Robot.climber.Stop();




    while(Robot.m_oi.getOperatorJoystick().getRawButton(5) == true){
      Robot.climber.climbDown();
    }
    Robot.climber.Stop();



  }




  @Override
  protected boolean isFinished() {
    return false;
  }




  @Override
  protected void end() {
  }




  @Override
  protected void interrupted() {
  }
}
