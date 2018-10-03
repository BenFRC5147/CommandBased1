package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.arcadeDrive_Command;
import edu.wpi.first.wpilibj.DriverStation;




public class driveTrain_Subsystem extends Subsystem {
    
    WPI_TalonSRX frontLeft = new WPI_TalonSRX(RobotMap.FRONT_LEFT_TALON);
    WPI_TalonSRX frontRight = new WPI_TalonSRX(RobotMap.FRONT_RIGHT_TALON);
    WPI_TalonSRX backLeft = new WPI_TalonSRX(RobotMap.BACK_LEFT_TALON);
    WPI_TalonSRX backRight = new WPI_TalonSRX(RobotMap.BACK_RIGHT_TALON);
    DifferentialDrive mainDrive = new DifferentialDrive(frontLeft, frontRight); 
    AHRS gyro = new AHRS(SPI.Port.kMXP);




    @Override
    public void initDefaultCommand(){
        setDefaultCommand(new arcadeDrive_Command());
    }




    public void TeleopDrive(Joystick driver){
        backLeft.follow(frontLeft);
        backRight.follow(frontRight);
        mainDrive.arcadeDrive(driver.getX(), driver.getY());

        frontLeft.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, RobotMap.TIMEOUT_MS);
        frontRight.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, RobotMap.TIMEOUT_MS);
    }

    public void AutonDrive(double leftSetpoint, double rightSetpoint){
        backLeft.follow(frontLeft);
        backRight.follow(frontRight);

        

    }

    public double getAngle(){
       double angle = gyro.getAngle();
        return angle;
    }

    public double getVelocity(){
        double velocity = gyro.getVelocityX();
        return velocity;
    }

    public double getLeftDistance(){
        double leftdist = frontLeft.getSelectedSensorPosition(0) * RobotMap.DISTANCE_PULSE;
        return leftdist;
        
    }

    public double getRightDistance(){
        double rightdist = frontRight.getSelectedSensorPosition(0) * RobotMap.DISTANCE_PULSE;
        return rightdist;
    }


    public void Stop(){
        mainDrive.arcadeDrive(0, 0);
        DriverStation.reportWarning("The DriveTrain has been stopped", false);
    }

    
}