package frc.robot.commands.AutoCommands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.commands.IntakeCommands.ExtendRunIntake;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class DriveAndIndex34 extends ParallelDeadlineGroup {
  /** Creates a new DriveAndIndex34. */
  public DriveAndIndex34(double left, double right, double speed) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    super(new DriveDistanceBack(left, right, speed), new Indexer34(), new ExtendRunIntakeTimer());
    //setDeadline(new DriveDistanceBack(left, right, speed));
    //addCommands(new DriveDistanceBack(left, right, speed), new Indexer34(), new ExtendRunIntakeTimer());
  }
}