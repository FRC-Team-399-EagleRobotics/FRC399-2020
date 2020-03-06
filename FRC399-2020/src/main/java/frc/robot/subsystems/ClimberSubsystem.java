/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.*;

public class ClimberSubsystem extends SubsystemBase {

private TalonSRX Winch_a, Winch_b;

  /**
   * Creates a new ExampleSubsystem.
   */
  public ClimberSubsystem() {
    Winch_a = new TalonSRX(Constants.Climber.WINCH_A_ID);
    Winch_b = new TalonSRX(Constants.Climber.WINCH_B_ID);

    this.setDefaultCommand(new TeleopClimberCommand(this));
    Winch_a.set(ControlMode.PercentOutput, 0.0);
    Winch_b.set(ControlMode.Follower, Constants.Climber.WINCH_A_ID);
  }

  /**
   * Sets the output speed of the rotational motor of the spindexer
   * @param output
   */
  public void setWinch(double output) {
    Winch_a.set(ControlMode.PercentOutput, output);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
