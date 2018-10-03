package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;




public class climber_Subsystem extends Subsystem {
  private WPI_TalonSRX climberMotor = new WPI_TalonSRX(RobotMap.CLIMBER_TALON);
  private WPI_TalonSRX extenderMotor = new WPI_TalonSRX(RobotMap.EXTENDER_TALON); 




  @Override
  public void initDefaultCommand() {
  }




  public void climbUp(){
    climberMotor.set(1);
  }




  public void climbDown(){
    climberMotor.set(-1);
  }




  public void armUp(){
    extenderMotor.set(1);
  }




  public void armDown(){
    extenderMotor.set(-1);
  }




  public void Stop(){
    climberMotor.set(0);
    extenderMotor.set(0);
  }
}
