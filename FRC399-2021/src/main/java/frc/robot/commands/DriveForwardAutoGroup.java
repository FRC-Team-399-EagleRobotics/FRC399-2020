package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class DriveForwardAutoGroup extends SequentialCommandGroup {
    public DriveForwardAutoGroup(DrivetrainSubsystem dt) {
        addCommands(
            new ArcadeDriveCommand(dt, 0.375, 0),
            new WaitCommand(.5),
            new ArcadeDriveCommand(dt, 0,0)
        );
    }
}