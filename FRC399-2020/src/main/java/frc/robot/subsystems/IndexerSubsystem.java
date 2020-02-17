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

public class IndexerSubsystem extends SubsystemBase {

private TalonSRX indexer, feeder;

  /**
   * Creates a new ExampleSubsystem.
   */
  public IndexerSubsystem() {
    indexer = new TalonSRX(Constants.Indexer.INDEXER_ID);
    feeder = new TalonSRX(Constants.Indexer.FEEDER_ID);

  }

  /**
   * Sets the output speed of the rotational motor of the spindexer
   * @param output
   */
  public void setSpin(double output) {
    indexer.set(ControlMode.PercentOutput, output);
  }
  
  /**
   * Sets the output speed of the feeder wheel and belts
   * @param output
   */
  public void setFeed(double output) {
    feeder.set(ControlMode.PercentOutput, output);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
