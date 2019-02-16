/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.arm.wrist;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class WristManualMovement extends Command {
  public WristManualMovement() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.wrist);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {  
    SmartDashboard.putNumber("Left Trigger", (Robot.oi.getCopilot().getRawAxis(3)+1)/2);
    SmartDashboard.putNumber("Right Trigger", (Robot.oi.getCopilot().getRawAxis(4)+1)/2);
    // if(Robot.oi.getPilotTriggers() > 0.1 || Robot.oi.getPilotTriggers() < -0.1){
    //   Robot.wrist.rollerStart(-Robot.oi.getPilotTriggers());
    // } else if(Robot.oi.getCopilotTriggers() > 0.1 || Robot.oi.getCopilotTriggers() < -0.1){
      Robot.wrist.rollerStart(Robot.oi.getCopilotTriggers());
    // } else {
    //   Robot.wrist.rollerStart(0);
    // }
    Robot.wrist.moveWristTeleoperated();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.wrist.stopRoller();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.wrist.stopRoller();
  }
}
