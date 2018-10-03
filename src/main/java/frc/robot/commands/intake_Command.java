package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;




public class intake_Command extends Command {
  public intake_Command() {
    requires(Robot.intake);
  }




  @Override
  protected void initialize() {
    DriverStation.reportWarning("Intake Initiating", false);
  }

 


  @Override
  protected void execute() {
    while(Robot.m_oi.getJoystick().getRawButton(5) == true){
      Robot.intake.clampClose();
    }

    while(Robot.m_oi.getJoystick().getRawButton(6) == true){
      Robot.intake.clampOpen();
    }

    while(Robot.m_oi.getJoystick().getRawButton(7) == true){
      Robot.intake.elevateUp();
    }
    Robot.intake.Stop();

    while(Robot.m_oi.getJoystick().getRawButton(8) == true){
      Robot.intake.elevateDown();
    }
    Robot.intake.Stop();
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
