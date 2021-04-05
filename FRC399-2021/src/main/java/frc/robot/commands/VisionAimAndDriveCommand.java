/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.util.GamepadUtility;
import frc.robot.util.Limelight;
import frc.robot.util.Limelight.VisionMode;
/**
 * Command that utilizes the limelight for targeting vision targets and game
 * pieces. option for manual fwd/backward throttle for teleop use.
 */

public class VisionAimAndDriveCommand extends CommandBase {
  private double throttle = 0.0;
  private Limelight limelight = null;

  private DrivetrainSubsystem dt;
  GamepadUtility Controls = GamepadUtility.getInstance();

  /**
   * Constructor - specify vision mode.
   */
  public VisionAimAndDriveCommand(DrivetrainSubsystem subsystem) {
    // Use requires() here to declare subsystem dependencies
    limelight = Limelight.getInstance();

    dt = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }




  // Called just before this Command runs the first time
  @Override
  public void initialize() {

  }
  double prevError = 0;

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    limelight.update();

    //read values periodically
    double x = limelight.getX();
  // was .015
    double DskAim = 0.05; // 4/3 was -0.025;//SmartDashboard.getNumber("ll_steering", 0.0); orginally -0.012
    
    if(Math.abs(x) < 10) {
      //DskAim = .15;
    }
    double heading_error = -x;
    double steering_adjust = 0.0f;

    double kD = 600;
    double dError = prevError - heading_error;

    double minSteer = 0.075;

    if(Math.abs(x) > 1) { // was .25
      steering_adjust = (DskAim*heading_error) + (Math.signum(x) * minSteer) - (kD * dError);
    } else {
      steering_adjust = 0;
    }
    //Controls.setControllerRumble(Math.abs(heading_error) < 2);
    
    
    throttle = Controls.getThrottle() *.5;
    steering_adjust -= 0.15 * Controls.getTurning();

    //steering_adjust = Math.max(-.25, Math.min(.25, steering_adjust));
    dt.setTank(throttle + steering_adjust, throttle - steering_adjust);
    prevError = heading_error;
  }
  

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }

  
  public void end() {
    Controls.setControllerRumble(false);
  }


}