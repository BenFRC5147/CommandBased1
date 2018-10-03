package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.arcadeDrive_Command;




public class driveTrain_Subsystem extends Subsystem {
    
    WPI_TalonSRX frontLeft = new WPI_TalonSRX(RobotMap.FRONT_LEFT_TALON);
    WPI_TalonSRX frontRight = new WPI_TalonSRX(RobotMap.FRONT_RIGHT_TALON);
    WPI_TalonSRX backLeft = new WPI_TalonSRX(RobotMap.BACK_LEFT_TALON);
    WPI_TalonSRX backRight = new WPI_TalonSRX(RobotMap.BACK_RIGHT_TALON);
    DifferentialDrive mainDrive = new DifferentialDrive(frontLeft, frontRight); 



    @Override
    public void initDefaultCommand(){
        setDefaultCommand(new arcadeDrive_Command());
    }




    public void TeleopDrive(Joystick driver){
        backLeft.follow(frontLeft);
        backRight.follow(frontRight);
        mainDrive.arcadeDrive(driver.getX(), driver.getY());
    }

    public void AutonDrive(){
        backLeft.follow(frontLeft);
        backRight.follow(frontRight);

    }


    public void Stop(){
        mainDrive.arcadeDrive(0, 0);
    }

    
}