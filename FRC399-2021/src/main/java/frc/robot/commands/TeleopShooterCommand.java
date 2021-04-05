/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ShooterSubsystem;

/**
 * An example command that uses an example subsystem.
 */
public class TeleopShooterCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ShooterSubsystem shooter;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public TeleopShooterCommand(ShooterSubsystem subsystem) {
    shooter = subsystem;
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

    // open loop
    double speed = 0.0;

    double topscale = 0.8;

    if(RobotContainer.operator.getRawButton(1)) {
      speed = 0.5;

    } else if(RobotContainer.operator.getRawButton(2)) {
      speed = 0.75;
    } else if(RobotContainer.operator.getRawButton(3)) {
      speed = 1;
    } else if(RobotContainer.operator.getRawButton(4)) {
      speed = 1;
      topscale = 1;
    }

     shooter.set(speed, speed * topscale);

    // double speed = 0.0;

    // if(RobotContainer.operator.getRawButton(1)) {
    //   speed = 1000;
    // } else if(RobotContainer.operator.getRawButton(2)) {
    //   speed = 2000;
    // } else if(RobotContainer.operator.getRawButton(3)) {
    //   speed = 4000;
    // } else if(RobotContainer.operator.getRawButton(4)) {
    //   speed = 6000;
    // }

    // shooter.setVelocity(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
