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

/**
 * An example command that uses an example subsystem.
 */
public class TeleopIndexerCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final IndexerSubsystem indexer;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public TeleopIndexerCommand(IndexerSubsystem subsystem) {
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

   boolean shoot = RobotContainer.operator.getRawButton(8);
   boolean slow = RobotContainer.operator.getRawButton(6);
   

   double spin = 0.0;
   double feed = 0.0;

   if(shoot) {
     spin = .150;
     feed = 1.0;  
   }

   if(slow) {
     spin = -0.375;
     feed = -0.50;
   }
   if(RobotContainer.operator.getPOV() == 90){
    spin = -0.375;
   }
   if(RobotContainer.operator.getPOV() == 270){
    spin = 0.375;
   }

   indexer.setSpin(spin);
   indexer.setFeed(feed);
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
