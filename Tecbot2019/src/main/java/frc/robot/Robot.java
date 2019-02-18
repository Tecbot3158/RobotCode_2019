/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.subsystems.watcher.WatcherSubsystem;
import frc.robot.subsystems.wrist.WristSubsystem;
import frc.robot.commands.autonomous.*;
import frc.robot.commands.chassis.*;
import frc.robot.resources.TecbotConstants;
import frc.robot.resources.TecbotEncoder;
import frc.robot.resources.TecbotSpeedController;
import frc.robot.resources.TecbotSpeedController.TypeOfMotor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.chassis.DriveTrain;
import frc.robot.subsystems.extensor.ExtensorSubsystem;
import frc.robot.subsystems.angler.AnglerSubsystem;
import com.ctre.phoenix.motorcontrol.Faults;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static OI oi;

	public static TecbotEncoder leftEncoder, rightEncoder;
	public static Navx tecbotgyro;
	public static DriveTrain driveTrain;
	public static AnglerSubsystem angler;
	public static ExtensorSubsystem extensor;
	public static WristSubsystem wrist;
	public static Command actualCommand;
	DoubleSolenoid a, b;

	public Faults _faults_wrist, _faults_angler, _faults_extensor;

	public static WatcherSubsystem watcher;

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	@Override
	public void robotInit() {

		_faults_wrist = new Faults();
		_faults_angler = new Faults();
		_faults_extensor = new Faults();

		driveTrain = new DriveTrain();
		watcher = new WatcherSubsystem();
		tecbotgyro = new Navx();
		angler = new AnglerSubsystem();
		extensor = new ExtensorSubsystem();
		wrist = new WristSubsystem();

		driveTrain.getLeftEncoder().reset();
		driveTrain.getRightEncoder().reset();

		leftEncoder = driveTrain.getLeftEncoder();
		rightEncoder = driveTrain.getRightEncoder();

		tecbotgyro.reset();

		angler.resetEncoders();
		extensor.resetEncoders();
		wrist.resetEncoder();

		chooserInit();

		SmartDashboard.putData(angler);
		SmartDashboard.putData(driveTrain);
		// SmartDashboard.putNumber("Angler Starting Configuration",
		// TecbotConstants.ARM_ANGLER_START_CONFIGURATION);
		// SmartDashboard.putNumber("Extensor Starting Configuration",
		// TecbotConstants.ARM_EXTENSOR_TRANSPORT);
		// SmartDashboard.putNumber("Wrist Starting Configuration",
		// TecbotConstants.ARM_WRIST_TRANSPORT);
		// SmartDashboard.putNumber("Angler Ball Lower Rocket",
		// TecbotConstants.ARM_ANGLER_DEPLOY_BALL_LOWER_ROCKET);
		// SmartDashboard.putNumber("Extensor Ball Lower Rocket",
		// TecbotConstants.ARM_EXTENSOR_DEPLOY_BALL_LOWER_ROCKET);
		// SmartDashboard.putNumber("Wrist Ball Lower Rocket",
		// TecbotConstants.ARM_WRIST_DEPLOY_BALL_LOWER_ROCKET);
		// SmartDashboard.putNumber("Angler Ball Middle Rocket",
		// TecbotConstants.ARM_ANGLER_DEPLOY_BALL_MIDDLE_ROCKET);
		// SmartDashboard.putNumber("Extensor Ball Middle Rocket",
		// TecbotConstants.ARM_EXTENSOR_DEPLOY_BALL_MIDDLE_ROCKET);
		// SmartDashboard.putNumber("Wrist Ball Middle Rocket",
		// TecbotConstants.ARM_WRIST_DEPLOY_BALL_MIDDLE_ROCKET);

		oi = new OI();

	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
	}

	@Override
	public void autonomousInit() {
		tecbotgyro.reset();
		angler.resetEncoders();
		leftEncoder.reset();
		rightEncoder.reset();
		m_autonomousCommand = m_chooser.getSelected();
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		tecbotgyro.run();
		if (oi.getPilot().getTrigger() && actualCommand != null) {
			actualCommand.cancel();
		}

	}

	@Override
	public void teleopInit() {
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	@Override
	public void teleopPeriodic() {

		wrist.getMotor().getTalonSRX().getFaults(_faults_wrist);
		angler.getLeftMotor().getTalonSRX().getFaults(_faults_angler);
		extensor.getLeftMotor().getTalonSRX().getFaults(_faults_extensor);

		Scheduler.getInstance().run();
		tecbotgyro.run();
		SmartDashboard.putNumber("Get Triggers ", oi.getCopilotTriggers());
		angler.printEncodersSmartDashboard();
		extensor.printEncodersSmartDashboard();
		wrist.printEncodersSmartDashboard();
		driveTrain.printEncValues();

		SmartDashboard.putBoolean("Angler Out Of Phase", _faults_angler.SensorOutOfPhase);
		SmartDashboard.putBoolean("Extensor Out Of Phase", _faults_extensor.SensorOutOfPhase);
		SmartDashboard.putBoolean("Wrist Out Of Phase", _faults_wrist.SensorOutOfPhase);

	}

	@Override
	public void testPeriodic() {
	}

	public void chooserInit() {

		m_chooser.addOption("Follow Juan", new MoveAlongPath("Juan"));
		m_chooser.addOption("Move Straight Forward Angle Pivot",
				new MoveStraightForwardOneEncoder(0, 2 * RobotMap.k_meters_to_encoder));
		m_chooser.addOption("Move Straight Forward Two Encoders",
				new MoveStraightForwardTwoEncoders(-4 * RobotMap.k_meters_to_encoder));
		m_chooser.addOption("Turn Degrees", new TurnDegrees(30, 0.6));
		m_chooser.addOption("Rocket Test", new RocketTestGroup());
		m_chooser.addOption("Right to middle cargo", new RightToMiddleCargoShip(false));
		m_chooser.addOption("Right to middle cargo remastered", new RightToMiddleCargoRemastered());
		m_chooser.addOption("Left to middle cargo remastered", new LeftToMiddleCargo());
		m_chooser.addOption("Right to right SR", new RightToFurtherRocketWithSR(false));

		SmartDashboard.putData("Auto mode", m_chooser);

	}

}
