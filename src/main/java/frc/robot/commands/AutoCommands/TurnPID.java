// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutoCommands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;

public class TurnPID extends Command {
  /** Creates a new TurnPID. */
  private PIDController pid;
  private double turn;
  private Timer timer;
  private Timer override;
  public TurnPID(double angle) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.drivetrain);
    pid = new PIDController(Constants.GyrokP, Constants.GyrokI, Constants.GyrokD);
    turn = angle;
    timer = new Timer();
    override = new Timer();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    pid.setSetpoint(turn);
    pid.setTolerance(3);
    timer.reset();
    override.reset();
    override.start();
    //timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double output = pid.calculate(Robot.drivetrain.getAngle());
    output = Math.min(.3, output);
    Robot.drivetrain.setMotors(output, -output);
    if(pid.atSetpoint()){
      timer.start();
    }
    else{
      timer.reset();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.drivetrain.setMotors(0, 0);
    //timer.reset();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return pid.atSetpoint() && timer.get()>.25 || override.get()>1;
  }
}