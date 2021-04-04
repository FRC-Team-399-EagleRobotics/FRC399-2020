package frc.robot.util;

import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
public class GamepadUtility{

    Joystick DriverLeft = new Joystick(0);
	Joystick DriverRight = new Joystick(1);
    Joystick OperatorGamepad = new Joystick(2);
    
    public static GamepadUtility Instance;
    
	public GamepadUtility() {
	}

	
  /**
   * Gets the driver's throttle input.
   * @return
   */
  public double getThrottle() {
    return (DriverLeft.getRawAxis(3) - DriverLeft.getRawAxis(2));
  }

  /**
   * Gets the driver's turning input.
   * @return
   */
  public double getTurning() {
    return DriverLeft.getRawAxis(0);
  }

	public int leftJoystickDpad(){
		return DriverLeft.getPOV();
	}
	public int rightJoystickDpad(){
		return DriverRight.getPOV();
	}
	public double LeftThrottle() {
		return DriverLeft.getRawAxis(1);
	}
	public double RightThrottle() {
		return DriverRight.getRawAxis(1);
	}
	public boolean RightJoystickTrigger(){
		return DriverRight.getRawButton(1);
	}
	public boolean LeftJoystickTrigger(){
		return DriverLeft.getRawButton(1);
	}
	public double GamepadRightJoystick() {
		return OperatorGamepad.getRawAxis(3);
	}
	public double GamepadLeftJoystick() {
		return OperatorGamepad.getRawAxis(1);
	}
	
	public boolean GamepadLeftJoystickButton(){
		return OperatorGamepad.getRawButton(11);
	}
	
	public boolean GamepadRightJoystickButton(){
		return OperatorGamepad.getRawButton(12);
	}
	
	public boolean X() {
		return OperatorGamepad.getRawButton(1);
	}
	public boolean Y() {
		return OperatorGamepad.getRawButton(4);
	}
	public boolean A() {
		return OperatorGamepad.getRawButton(2);
	}
	public boolean B() {
		return OperatorGamepad.getRawButton(3);
	}
	
	public boolean Start(){
		return OperatorGamepad.getRawButton(10);
	}
	public boolean Back(){
		return OperatorGamepad.getRawButton(9);
	}

	public double DPad() {
		return OperatorGamepad.getPOV();
	}

	public boolean getShooterTiltIdleButton() {
		return Button1();
	}

	public boolean getAutoTiltButton() {
		return OperatorGamepad.getRawButton(1);
	}

	public boolean getAutoAimButton() {
		return DriverLeft.getRawButton(1);
	}
	//Logitech
	public boolean Button1() {
		return OperatorGamepad.getRawButton(1);
	}
	public boolean Button2() {
		return OperatorGamepad.getRawButton(2);
	}
	public boolean Button3() {
		return OperatorGamepad.getRawButton(3);
	}
	public boolean Button4() {
		return OperatorGamepad.getRawButton(4);
	}
	
	public boolean TopLeftTrigger() {
		return OperatorGamepad.getRawButton(5);
	}
	public boolean BottomLeftTrigger() {
		return OperatorGamepad.getRawButton(7);
	}
	public boolean TopRightTrigger() {
		return OperatorGamepad.getRawButton(6);
	}
	public boolean BottonRightTrigger() {
		return OperatorGamepad.getRawButton(8);
    }
    
    public static GamepadUtility getInstance(){
		if(Instance == null){
			Instance = new GamepadUtility();
		}
		return Instance;
	}
	public void setControllerRumble(boolean state) {
		if (state) {
      setControllerRumble(1.0);
		} else {
      setControllerRumble(0.0);
		}
	}

	public void setControllerRumble(double state) {
		DriverLeft.setRumble(RumbleType.kLeftRumble, state);
		DriverLeft.setRumble(RumbleType.kRightRumble, state);
		OperatorGamepad.setRumble(RumbleType.kLeftRumble, state);
		OperatorGamepad.setRumble(RumbleType.kRightRumble, state);
	}
}
