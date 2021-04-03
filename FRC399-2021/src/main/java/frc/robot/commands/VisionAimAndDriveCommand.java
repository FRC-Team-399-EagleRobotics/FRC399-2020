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

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    limelight.update();

    //read values periodically
    double x = limelight.getX();
  // was .015
    double DskAim = -0.015; // 4/3 was -0.025;//SmartDashboard.getNumber("ll_steering", 0.0); orginally -0.012
    
    if(Math.abs(x) > 10) {
    //  DskAim = -0.05;
    }
    double heading_error = -x;
    double steering_adjust = 0.0f;

    double minSteer = 0.075;

    if(Math.abs(x) > 1) { // was .25
      steering_adjust = (DskAim*heading_error) + (Math.signum(x) * minSteer);
    }

    Controls.setControllerRumble(limelight.getArea() > 5.875);
    
    throttle = Controls.getThrottle() *.5;
    steering_adjust -= 0.15 * Controls.getTurning();
    dt.setTank(throttle + steering_adjust, throttle - steering_adjust);
  }
  

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }


}