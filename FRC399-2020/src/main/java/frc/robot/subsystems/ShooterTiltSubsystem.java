/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class ShooterTiltSubsystem extends SubsystemBase {
  
  private TalonSRX tilt;  
  
  //private AHRS navx;
  /**
   * Creates a new DrivetrainSubsystem.
   */
  public ShooterTiltSubsystem() {

    // BEGIN TALON INITIALIZATION 
    
    //Initialize talons with common DT configuration:
    tilt = init(Constants.Shooter.TOP_ID);

    // Do talon specific setups here...

    tilt.set(ControlMode.PercentOutput, 0.0);

    // END TALON INITIALIZATION

    // BEGIN NAVX INIT AND CALIBRATION
    // navx = new AHRS(SPI.Port.kMXP);
    // navx.reset();


    //this.setDefaultCommand(new TeleopShooterCommand(this));
  }

  /**
   * Sets the output of the drivetrain with tank drive inputs - left and right side throttles
   * @param l
   * @param r
   */
  public void set(double v) {
    tilt.set(ControlMode.PercentOutput, v);
  }

  public void setPosition(double pos) {

  }




  public TalonSRX init(int id) {
    TalonSRX talon = new TalonSRX(id);

    // Do common talon initialization stuff here.

    talon.configFactoryDefault();

    SupplyCurrentLimitConfiguration supplyCurrentLimit = new SupplyCurrentLimitConfiguration(true, 40, 45, 0.5);    talon.configSupplyCurrentLimit(supplyCurrentLimit);

    talon.setNeutralMode(NeutralMode.Brake);
    // Do common talon initialization stuff here.

    double kP = 0.0465;
    double kI = 0.0005;
    double kD = 0.0;
    double kF = 0.0478;
    int iZone = 150;

    talon.config_kP(0, kP);
    talon.config_kI(0, kI);   
    talon.config_kD(0, kD);  
    talon.config_kF(0, kF);  
    talon.config_IntegralZone(0, iZone);

    talon.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    

    
    talon.configOpenloopRamp(0.01, 0);
    talon.configPeakCurrentLimit(25, 0);
    talon.configContinuousCurrentLimit(12, 0);
    talon.configPeakCurrentDuration(500, 0);
    talon.enableCurrentLimit(true);

    talon.configPeakOutputForward(1, 0);
    talon.configPeakOutputReverse(-1, 0);

    talon.selectProfileSlot(0, 0);
    talon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
    talon.setSelectedSensorPosition(0, 0, 0);

    talon.configClosedloopRamp(.15, 0);
    talon.setSensorPhase(false);
    talon.setInverted(false);

    talon.configMotionAcceleration(6500, 0);
    talon.configMotionCruiseVelocity(5500, 0);
    talon.config_kP(0, .55, 0);

    talon.config_kI(0, 0, 0);
    talon.config_kD(0, 0, 0);
    talon.config_kF(0, 0, 0);

    return talon;

  }
}
