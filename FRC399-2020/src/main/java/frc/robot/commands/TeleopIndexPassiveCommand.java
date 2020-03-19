/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.IndexerSubsystem;
import frc.robot.util.*;

/**
 * An example command that uses an example subsystem.
 */
public class TeleopIndexPassiveCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final IndexerSubsystem indexer;


  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public TeleopIndexPassiveCommand(IndexerSubsystem subsystem) {
    indexer = subsystem;
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

   
   double indexerOutput = (RobotContainer.operator.getPOV() == 180 ? -.375 : RobotContainer.operator.getRawButton(8) ? .3750 :
   RobotContainer.operator.getRawButton(6) ? -0.375 : 0.0);
   double feederOutput = (RobotContainer.operator.getRawButton(8) ? 1.0 : RobotContainer.operator.getRawButton(6) ? -0.75 : 0.0);

   indexer.setSpin(indexerOutput);
   indexer.setFeed(feederOutput);
   
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
