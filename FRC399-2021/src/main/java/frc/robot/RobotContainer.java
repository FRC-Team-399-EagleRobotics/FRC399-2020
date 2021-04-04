/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;
import frc.robot.commands.DriveForwardAutoGroup;
import frc.robot.commands.TeleopDriveCommand;
import frc.robot.commands.TeleopShooterTiltCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.IndexerSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.ShooterTiltSubsystem;
import frc.robot.util.GamepadUtility;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  public static Joystick leftJoy = new Joystick(0);
  public static Joystick rightJoy = new Joystick(1);
  public static Joystick operator = new Joystick(2);

   public static DrivetrainSubsystem dt = new DrivetrainSubsystem();
   public static IntakeSubsystem intake = new IntakeSubsystem();
   public static IndexerSubsystem indexer = new IndexerSubsystem();
   public static ShooterSubsystem shooter = new ShooterSubsystem();
   public static ShooterTiltSubsystem tilt = new ShooterTiltSubsystem();

   public static GamepadUtility controls = GamepadUtility.getInstance();

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

  }

  Button autoAimButton;
  Button autoTiltButton;
  Button shooterIdleButton;
  

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    
    dt.setDefaultCommand(new TeleopDriveCommand(dt));
    tilt.setDefaultCommand(new TeleopShooterTiltCommand(tilt));
    
    shooterIdleButton = new Button() {
      @Override
      public boolean get() {
        return controls.getShooterTiltIdleButton();
      }
    };

    autoTiltButton = new Button() {
      @Override
      public boolean get() {
        return controls.getAutoTiltButton();
      }
    };

    autoAimButton = new Button() {
      @Override
      public boolean get() {
        return controls.getAutoAimButton();
      }
    };


    
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run
    return new DriveForwardAutoGroup(dt);
  }
}
