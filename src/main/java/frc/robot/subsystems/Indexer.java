// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Indexer extends SubsystemBase {
  private CANSparkMax lowerMotor; 
  private CANSparkMax upperMotor;
  DigitalInput lowerLimitSwitch;
  DigitalInput upperLimitSwitch; 
  /** Creates a new Indexer. */

  public Indexer() {
      super.register();
      lowerMotor = new CANSparkMax(RobotMap.lowerindexerID, MotorType.kBrushless);
      upperMotor = new CANSparkMax(RobotMap.upperindexerID, MotorType.kBrushless);

      lowerMotor.setIdleMode(IdleMode.kBrake);
      upperMotor.setIdleMode(IdleMode.kBrake);

      lowerLimitSwitch = new DigitalInput(RobotMap.lowerLimitSwitchID);
      upperLimitSwitch = new DigitalInput(RobotMap.upperLimitSwitchID);

  }

  public boolean getUpperLimitSwitch() {
        return upperLimitSwitch.get();
  }
  public boolean getLowerLimitSwitch() {
        return lowerLimitSwitch.get();
  }
  public void setLowerMotor(double lowerSpeed) {
      lowerMotor.set(lowerSpeed);
  }
  public void setUpperMotor(double upperSpeed) {
      upperMotor.set(upperSpeed);
  }
  public void stopLowerMotor() {
      lowerMotor.set(0);
  }
  public void stopUpperMotor() {
      upperMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putBoolean("Upper Limit Switch", !upperLimitSwitch.get());
    SmartDashboard.putBoolean("Lower Limit Switch", !lowerLimitSwitch.get());
    SmartDashboard.putNumber("Lower Indexer Belt", lowerMotor.getEncoder().getVelocity());
    SmartDashboard.putNumber("Upper Indexer Belt", upperMotor.getEncoder().getVelocity());

  }
}
