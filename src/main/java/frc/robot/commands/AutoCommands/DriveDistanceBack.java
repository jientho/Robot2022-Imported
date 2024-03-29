// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutoCommands;
import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Timer;

public class DriveDistanceBack extends Command {
  /** Creates a new DriveDistance. */
  double leftDistance, rightDistance, motorSpeed;
  boolean finished;
  public DriveDistanceBack(double left, double right, double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.drivetrain);
    leftDistance = -left;
    rightDistance = -right;
    motorSpeed = speed;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.drivetrain.resetEncoders();
    Robot.drivetrain.setRampUp(Constants.autoRampUp);
    Robot.drivetrain.setMotors(-motorSpeed,-motorSpeed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(Robot.drivetrain.getLeftPosition()<leftDistance && Robot.drivetrain.getRightPosition()<rightDistance) {
      Robot.drivetrain.setMotors(0,0);
      finished = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.drivetrain.setRampUp(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}
