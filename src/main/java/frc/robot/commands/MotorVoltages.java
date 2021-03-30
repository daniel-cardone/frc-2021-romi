// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.Supplier;

public class MotorVoltages extends CommandBase {
  private final Drivetrain m_drivetrain;
  private final Supplier<Double> m_leftVoltageSupplier;
  private final Supplier<Double> m_rightVoltageSupplier;

  /**
   * Creates a new ArcadeDrive. This command will drive your robot according to the speed supplier
   * lambdas. This command does not terminate.
   *
   * @param drivetrain The drivetrain subsystem on which this command will run
   * @param xaxisSpeedSupplier Lambda supplier of forward/backward speed
   * @param zaxisRotateSupplier Lambda supplier of rotational speed
   */
  public MotorVoltages(
      Drivetrain drivetrain,
      Supplier<Double> leftVolts,
      Supplier<Double> rightVolts) {
    m_drivetrain = drivetrain;
    m_leftVoltageSupplier = leftVolts;
    m_rightVoltageSupplier = rightVolts;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftVolts = m_leftVoltageSupplier.get();
    double rightVolts = m_rightVoltageSupplier.get(); 

    if (leftVolts >= -1 && leftVolts <= 1) leftVolts = 0;
    if (rightVolts >= -1 && rightVolts <= 1) rightVolts = 0;

    m_drivetrain.setMotorVoltages(leftVolts, rightVolts);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
