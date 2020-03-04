
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class serves as the primary interface between the driver controls 
 */
public final class DriverInterface {
  Joystick leftJoy = new Joystick(0);
  Joystick rightJoy = new Joystick(1);

  Joystick operator = new Joystick(2);

  DriverInterface instance = null;
  
  private DriverInterface() {

  }

  public static DriverInterface getInstance() {
      if(instance == null) {
          instance = new DriverInterface();
      }

      return instance;
  }

  /**
   * Gets the throttle command from the driver controllers
   * @return
   */
  public double getThrottle() {
      return leftJoy.getRawAxis(1);
  }
  
  /**
   * Gets the steering command from the driver controllers.
   * @return
   */
  public double getSteering() {
      return rightJoy.getRawAxis(0);
  }

  // todo: map the modes to operator controls
  public boolean getShortShot() {
      return false;
  }

  public boolean getMedShot() {
      return false;
  }

  public boolean getLongShot() {
    return false;
  }

  public boolean getIntakeDown() {
      return false;
  }

  public double getIntakeSpeed() {
      return 0.0;
  }

  // advanced modes:

  public boolean getAutoTilt() {
        return getMedShot() || getLongShot();
  }

  public boolean getAutoSteer() {
      return false;
  }

  public boolean getRapidFire() {
      return (getShortShot() || getMedShot()) && false;
  }

  public boolean getSlowFire() {
      return getLongShot() && false;
  }

  public boolean getUnjam() {
      return false;
  }

}
