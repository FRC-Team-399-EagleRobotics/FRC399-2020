/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.util.*;

/**
 * An example command that uses an example subsystem.
 */
public class TeleopIntakeCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final IntakeSubsystem intake;
  GamepadUtility Controls = GamepadUtility.getInstance();

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public TeleopIntakeCommand(IntakeSubsystem subsystem) {
    intake = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  //  intake.init(Constants.Intake.PIVOT_ID);
  }

  // If the Operator Presses down on the DPAD the intake will pivot to its down position
  //Otherwise the intake will assume an up position such that the intake will clear
  // the indexer
  @Override
  public void execute() {
    
    //intake.init(Constants.Intake.PIVOT_ID);

    double speed = (Controls.DPad() == 180 ? -.75 : Controls.DPad() == 0 ? .75 : 0.0);
    intake.setRollers(speed);
    intake.setPivot(-RobotContainer.operator.getRawAxis(1));
    
    double angle = (Controls.DPad() == 180 ? Constants.Intake.INTAKE_PIVOT_DOWN_POSITION : Constants.Intake.INTAKE_PIVOT_UP_POSITION);
    intake.setPivotPreset(angle);
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
