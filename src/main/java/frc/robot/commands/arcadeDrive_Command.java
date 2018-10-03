package frc.robot.commands;

import javax.xml.ws.ServiceMode;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.driveTrain_Subsystem;
import edu.wpi.first.wpilibj.DriverStation;
@SuppressWarnings("unused")




public class arcadeDrive_Command extends Command {
  public arcadeDrive_Command() {
    requires(Robot.driveTrain);
  }


  

  @Override
  protected void initialize() {
    DriverStation.reportWarning("DriveTrain Initiating", false);
  }




  @Override
  protected void execute() {
    Robot.driveTrain.TeleopDrive(Robot.m_oi.getJoystick());
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
