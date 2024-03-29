// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.IndexerCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;

public class RunIndexerBelts extends Command {
  /** Creates a new RunIndexerBelts. */
  public RunIndexerBelts() {
    addRequirements(Robot.indexer);
   
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.indexer.setUpperMotor(Constants.topindexerSpeed);
    Robot.indexer.setLowerMotor(Constants.bottomindexerSpeed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.indexer.stopUpperMotor();
    Robot.indexer.stopLowerMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
