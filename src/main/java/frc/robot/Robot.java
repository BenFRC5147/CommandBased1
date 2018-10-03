package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.driveTrain_Subsystem;
import frc.robot.subsystems.climber_Subsystem;
import frc.robot.commands.arcadeDrive_Command;
import frc.robot.subsystems.intake_Subsystem;




public class Robot extends TimedRobot {
  public static driveTrain_Subsystem driveTrain = new driveTrain_Subsystem();
  public static OI m_oi;
  public static climber_Subsystem climber = new climber_Subsystem();
  public static intake_Subsystem intake = new intake_Subsystem();




  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();




  @Override
  public void robotInit() {
    m_oi = new OI();
    m_chooser.addDefault("Default Auto", new arcadeDrive_Command());
    SmartDashboard.putData("Auto mode", m_chooser);
  }




  @Override
  public void robotPeriodic() {
  }





  @Override
  public void disabledInit() {
  }




  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  



  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }




  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }




  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }



  
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }




  @Override
  public void testPeriodic() {
  }
}
