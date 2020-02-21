/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.TeleopShooterCommand;

public class ShooterSubsystem extends SubsystemBase {
  
  private TalonFX top, bottom;  
  
  //private AHRS navx;
  /**
   * Creates a new DrivetrainSubsystem.
   */
  public ShooterSubsystem() {

    // BEGIN TALON INITIALIZATION 
    
    //Initialize talons with common DT configuration:
    top = init(Constants.Shooter.TOP_ID);
    
    bottom = init(Constants.Shooter.BOT_ID);

    // Do talon specific setups here...

    top.set(ControlMode.PercentOutput, 0.0);

    bottom.set(ControlMode.PercentOutput, 0.0);

    // END TALON INITIALIZATION

    // BEGIN NAVX INIT AND CALIBRATION
    // navx = new AHRS(SPI.Port.kMXP);
    // navx.reset();


    this.setDefaultCommand(new TeleopShooterCommand(this));
  }

  /**
   * Sets the output of the drivetrain with tank drive inputs - left and right side throttles
   * @param l
   * @param r
   */
  public void set(double l, double r) {
    top.set(ControlMode.PercentOutput, r);
    bottom.set(ControlMode.PercentOutput, l);
  }


  public TalonFX init(int id) {
    TalonFX talon = new TalonFX(id);

    // Do common talon initialization stuff here.


    return talon;

  }
}
