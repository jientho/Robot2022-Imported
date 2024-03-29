// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.DrivetrainCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;

public class SetBrakeMode extends Command {
  /** Creates a new SetBrakeMode. */
  public 
  SetBrakeMode() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    Robot.drivetrain.setBrakeMode();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.drivetrain.setCoastMode();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
