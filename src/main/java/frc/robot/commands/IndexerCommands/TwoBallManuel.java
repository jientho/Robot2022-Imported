// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.IndexerCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;

public class TwoBallManuel extends Command {
  /** Creates a new TwoBallManuel. */
  private Timer timer = new Timer();
  private Timer timer2 = new Timer();
  public TwoBallManuel() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.indexer);  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    
    timer2.reset();
    Robot.indexer.setLowerMotor(-Constants.bottomindexerSpeed);
    Robot.indexer.setUpperMotor(-Constants.topindexerSpeed);
    timer2.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if(timer2.get()>0.1) {
      Robot.indexer.setLowerMotor(Constants.bottomindexerSpeed);
      Robot.indexer.setUpperMotor(Constants.topindexerSpeed);
      timer.start();
    }

    if(Robot.indexer.getUpperLimitSwitch()==false && timer.get()>0.35) {
      Robot.indexer.stopLowerMotor();
      Robot.indexer.stopUpperMotor();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.indexer.stopLowerMotor();
    Robot.indexer.stopUpperMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
