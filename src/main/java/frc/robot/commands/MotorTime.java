package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class MotorTime extends CommandBase {
  private final double m_duration;
  private final double m_leftVoltage;
  private final double m_rightVoltage;
  private final Drivetrain m_drive;
  private long m_startTime;

  /**
   * Creates a new MotorTime. This command will control individual motors at a desired voltage and time.
   *
   * @param leftVoltage The speed which the robot will drive. Negative is in reverse.
   * @param rightVoltage The speed which the robot will drive. Negative is in reverse.
   * @param time How much time to drive in seconds
   * @param drive The drivetrain subsystem on which this command will run
   */
  public MotorTime(double leftVolts, double rightVolts, double time, Drivetrain drive) {
    m_leftVoltage = leftVolts;
    m_rightVoltage = rightVolts;
    m_duration = time * 1000;
    m_drive = drive;
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_startTime = System.currentTimeMillis();
    m_drive.setMotorVoltages(0, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drive.setMotorVoltages(m_leftVoltage, m_rightVoltage);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.setMotorVoltages(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (System.currentTimeMillis() - m_startTime) >= m_duration;
  }
}
