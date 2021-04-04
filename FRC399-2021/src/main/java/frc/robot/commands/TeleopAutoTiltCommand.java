/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterTiltSubsystem;
import frc.robot.util.GamepadUtility;
import frc.robot.util.Limelight;

/**
 * An example command that uses an example subsystem.
 */
public class TeleopAutoTiltCommand extends CommandBase {
    GamepadUtility Controls = GamepadUtility.getInstance();
    
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ShooterTiltSubsystem shooter;

  private Limelight limelight = null;


  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public TeleopAutoTiltCommand(ShooterTiltSubsystem subsystem) {
    shooter = subsystem;

    limelight = Limelight.getInstance();
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      

      limelight.update();

    //read values periodically
      double y = limelight.getY();
  // was .015
    double DskAim = 0.03;
    
    if(Math.abs(y) > 5) {
    //  DskAim = -0.05;
    }
    double error = -y;
    double steering_adjust = 0.0f;

    double minSteer = 0.075;

    //f(Math.abs(y) > 1) { // was .25
      steering_adjust = (DskAim*error);
    //}

    shooter.set(steering_adjust - .2);

    System.out.println(y);

    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooter.set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false; 
  }
}
