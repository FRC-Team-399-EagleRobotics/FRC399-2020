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

public class ColorWheelSubsystem extends SubsystemBase {

private TalonSRX ColorWheel;

  /**
   * Creates a new ExampleSubsystem.
   */
  public  ColorWheelSubsystem() {
    ColorWheel = new TalonSRX(Constants.ColorWheel.WHEEL_ID);
    this.setDefaultCommand(new TeleopColorWheelCommand(this));
   
  }

  /**
   * Sets the output speed of the rotational motor of the spindexer
   * @param output
   */
  public void setWheel(double output) {
    ColorWheel.set(ControlMode.PercentOutput, output);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
