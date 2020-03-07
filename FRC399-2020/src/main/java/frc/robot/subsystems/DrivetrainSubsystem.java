/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
//import com.kauailabs.navx.frc.AHRS;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.TeleopDriveCommand;

public class DrivetrainSubsystem extends SubsystemBase {

  private TalonFX leftA, leftB, rightA, rightB;  
  private AHRS navx;
  
  //private AHRS navx;
  /**
   * Creates a new DrivetrainSubsystem.
   */
  public DrivetrainSubsystem() {

    // BEGIN TALON INITIALIZATION 
    
    //Initialize talons with common DT configuration:
    leftA = init(Constants.Drivetrain.LEFT_A_ID);
    leftB = init(Constants.Drivetrain.LEFT_B_ID);
    rightA = init(Constants.Drivetrain.RIGHT_A_ID);
    rightB = init(Constants.Drivetrain.RIGHT_B_ID);

    // Do talon specific setups here...

    leftA.set(ControlMode.PercentOutput, 0.0);
    leftB.set(ControlMode.Follower, Constants.Drivetrain.LEFT_A_ID);

    rightA.set(ControlMode.PercentOutput, 0.0);
    rightB.set(ControlMode.Follower, Constants.Drivetrain.RIGHT_A_ID);

    // END TALON INITIALIZATION

    // BEGIN NAVX INIT AND CALIBRATION
    navx = new AHRS(SPI.Port.kMXP);
    navx.reset();


    this.setDefaultCommand(new TeleopDriveCommand(this));
  }

  /**
   * Sets the output of the drivetrain with tank drive inputs - left and right side throttles
   * @param l
   * @param r
   */
  public void setTank(double l, double r) {
    leftA.set(ControlMode.PercentOutput, r);
    leftB.set(ControlMode.Follower, Constants.Drivetrain.LEFT_A_ID);

    rightA.set(ControlMode.PercentOutput, -l);
    rightB.set(ControlMode.Follower, Constants.Drivetrain.RIGHT_A_ID);
  }

  /**
   * Sets the output of the drivetrain with arcade drive inputs - throttle and steering
   */
  public void setArcade(double throttle, double steering) {
    steering *= -1;
    setTank(throttle + steering, throttle - steering);
  }
  public void setAutoAim(boolean enable){

  }

  public void turnToAngle(double targetAngle,double p){
    double error = navx.getAngle() - targetAngle;
    double output = error*p;

    leftA.set(ControlMode.PercentOutput, output);
    leftB.set(ControlMode.Follower, Constants.Drivetrain.LEFT_A_ID);

    rightA.set(ControlMode.PercentOutput, output);
    rightB.set(ControlMode.Follower, Constants.Drivetrain.RIGHT_A_ID);
  }

  /**
   * Resets the navx yaw angle reading to zero
   */ 
  public void resetNavx() {
    //navx.reset();
  }

  /**
   * Gets the current yaw angle relative to the last reset.
   * @return
   */
  public double getYaw() {
    return 0;//navx.getAngle();
  }

  /**
   * Gets the yaw rate, or how quickly the robot is turning.
   * @return
   */
  public double getYawRate() {
    return 0;//navx.getRate();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public TalonFX init(int id) {
    TalonFX talon = new TalonFX(id);

    talon.configFactoryDefault();

    SupplyCurrentLimitConfiguration supplyCurrentLimit = new SupplyCurrentLimitConfiguration(true, 60, 65, 3);
    talon.configSupplyCurrentLimit(supplyCurrentLimit);

    talon.setNeutralMode(NeutralMode.Coast);
    // Do common talon initialization stuff here.


    return talon;

  }
}
