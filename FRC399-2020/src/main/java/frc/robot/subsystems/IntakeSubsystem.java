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

public class IntakeSubsystem extends SubsystemBase {

  private TalonSRX intake, pivot;

  /**
   * Creates a new IntakeSubsystem.
   */
  public IntakeSubsystem() {
    intake = new TalonSRX(Constants.Intake.INTAKE_ID);
    pivot = new TalonSRX(Constants.Intake.PIVOT_ID);

  }

  /**
   * sets the output speed of the rollers.
   * @param speed
   */
  public void setRollers(double speed) {
    intake.set(ControlMode.PercentOutput, speed);
  }

  /**
   * Sets the setpoint for the PID controller on the intake angle
   * @param angle
   */
  public void setPivot(double angle) {
    pivot.set(ControlMode.Position, angle);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
