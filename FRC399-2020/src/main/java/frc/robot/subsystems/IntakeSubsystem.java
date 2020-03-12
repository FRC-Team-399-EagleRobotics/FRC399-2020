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
import frc.robot.commands.TeleopIntakeCommand;

public class IntakeSubsystem extends SubsystemBase {

  private TalonSRX intake, pivot;

  /**
   * Creates a new IntakeSubsystem.
   */
  public IntakeSubsystem() {
    
    intake = new TalonSRX(Constants.Intake.INTAKE_ID);
    pivot = new TalonSRX(Constants.Intake.PIVOT_ID);

    this.setDefaultCommand(new TeleopIntakeCommand(this));

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
    pivot.set(ControlMode.PercentOutput, angle);
  }

  public void setPivotPreset(double angle){

    pivot.set(ControlMode.Position, angle);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public TalonSRX init(int id) {
    TalonSRX talon = new TalonSRX(id);

    // Do common talon initialization stuff here.

    talon.configFactoryDefault();
    
    SupplyCurrentLimitConfiguration supplyCurrentLimit = new SupplyCurrentLimitConfiguration(true, 40, 45, 0.5);    talon.configSupplyCurrentLimit(supplyCurrentLimit);

    talon.setNeutralMode(NeutralMode.Brake);
    // Do common talon initialization stuff here.

    double kP = 3.5;
    double kI = 0.0;
    double kD = 0.0;
    double kF = 0.0;
    int iZone = 0;

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
    talon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
    
    //talon.setSelectedSensorPosition(0, 0, 0);

    talon.configClosedloopRamp(.15, 0);
    talon.setSensorPhase(true);
    talon.setInverted(false);

    talon.config_kP(0, .55, 0);
    talon.config_kI(0, 0, 0);
    talon.config_kD(0, 0, 0);
    talon.config_kF(0, 0, 0);
    
    System.out.println("INTAKE PIVOT:" + talon.getSelectedSensorPosition());

    return talon;

  }
  
}
