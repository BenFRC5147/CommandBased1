package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;




public class intake_Subsystem extends Subsystem {
  private WPI_TalonSRX elevatorMotor = new WPI_TalonSRX(RobotMap.ELEVATOR_MOTOR);
  private Solenoid clamper = new Solenoid(RobotMap.CLAMP_SOLENOID);




  @Override
  public void initDefaultCommand(){
  }



  public void elevateUp(){
    elevatorMotor.set(1);
  }

  public void doNotAttack(){
    clamper.set(false);
  }

  public void attack(){
    clamper.set(true);
  }


  public void elevateDown(){
    elevatorMotor.set(-1);
  }




  public void clampClose(){
    clamper.set(true);
  }




  public void clampOpen(){
    clamper.set(false);
  }




  public void Stop(){
    elevatorMotor.set(0);
  }
}
