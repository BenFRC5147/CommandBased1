package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
  Joystick driver = new Joystick(0);
  Joystick operator = new Joystick(1);




  public OI(){
  }




  public Joystick getJoystick(){
    return driver;

  }



  
  public Joystick getOperatorJoystick(){
    return operator;
  }

  
}
