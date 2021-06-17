// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class AutonomousTime extends SequentialCommandGroup {
  /**
   * Creates a new Autonomous Drive based on time. This will drive out for a period of time, turn
   * around for time (equivalent to time to turn around) and drive forward again. This should mimic
   * driving out, turning around and driving back.
   *
   * @param drivetrain The drive subsystem on which this command will run
   */
  public AutonomousTime(Drivetrain drivetrain) {
    addCommands(
      new WaitCommand(5),
      new MotorTime(1, 1, 3, drivetrain),
      new MotorTime(-2, -2, 3, drivetrain),
      new MotorTime(3, -3, 2, drivetrain),
      new MotorTime(-4, 4, 2, drivetrain)
    );
  }
}

/*
First Challenge:
  new WaitCommand(5),
  new DriveDistance(0.8, 14, drivetrain),
  new MotorTime(-1, 7, 0.35, drivetrain),
  new DriveDistance(0.8, 14.25, drivetrain),
  new WaitCommand(0.2),
  new TurnDegrees(-0.7, 82, drivetrain),
  new WaitCommand(0.2),
  new MotorTime(7, 7, 0.7, drivetrain),
  new MotorTime(7, 5, 0.4, drivetrain),
  new MotorTime(7, 7, 0.15, drivetrain),
  new WaitCommand(0.2),
  new TurnDegrees(0.8, 34, drivetrain),
  new WaitCommand(0.2),
  new MotorTime(7, 7, 0.55, drivetrain),
  new MotorTime(6, 2, 0.47, drivetrain),
  new MotorTime(7, 7, 0.4, drivetrain)

Second Challenge:
  new MotorTime(2, 2, 0.5, drivetrain),
  new MotorTime(4, 4, 0.4, drivetrain),
  new MotorTime(2, 4, 0.5, drivetrain),
  new MotorTime(5, 6, 0.5, drivetrain),
  new MotorTime(6, 2, 0.45, drivetrain),
  new MotorTime(7, 7, 1.0, drivetrain),
  new MotorTime(7, 5, 0.8, drivetrain),
  new MotorTime(3, 7, 2.1, drivetrain),
  new MotorTime(7, 3, 0.45, drivetrain),
  new MotorTime(7, 7, 1.3, drivetrain),
  new MotorTime(7, 4, 0.5, drivetrain),
  new MotorTime(4, 7, 0.6, drivetrain),
  new MotorTime(5, 5, 0.4, drivetrain),
  new MotorTime(5, 5, 0.4, drivetrain)
*/