// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

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
      new MotorTime(7, 7, 0.625, drivetrain),
      new MotorTime(-1, 7, 0.35, drivetrain),
      new MotorTime(7, 7, 0.65, drivetrain),
      new MotorTime(-7, 7, 0.3, drivetrain),
      new MotorTime(7, 7, 0.9, drivetrain),
      new MotorTime(7, -7, 0.05, drivetrain),
      new MotorTime(7, 7, 0.2, drivetrain));
  }
}
