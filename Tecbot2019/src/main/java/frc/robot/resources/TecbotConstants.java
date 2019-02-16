package frc.robot.resources;


public class TecbotConstants {
	/*2018
	public static final double FIRST_VELOCITY_POWER = 0.5;
	public static final double SECOND_VELOCITY_POWER = 0.9;
	public static final double ROTATION_FORCE_FRONT_LEFT_WHEEL = 0.5;
	public static final double ROTATION_FORCE_FRONT_RIGHT_WHEEL = 0.5;
	public static final double ROTATION_FORCE_REAR_LEFT_WHEEL_RIGHT_SPIN = 0.5;
	public static final double ROTATION_FORCE_REAR_LEFT_WHEEL_LEFT_SPIN = 0.25;
	public static final double ROTATION_FORCE_REAR_RIGHT_WHEEL_RIGHT_SPIN = 0.25;
	public static final double ROTATION_FORCE_REAR_RIGHT_WHEEL_LEFT_SPIN = 0.5;
	public static final double HIGHER_COLLECTOR_ORIENTATION = 100;
	public static final double MIDDLE_COLLECTOR_ORIENTATION = 1500;
	public static final double LOWER_COLLECTOR_ORIENTATION = 3000;
	*/

	 //// Extensor
    
    // Positions

    public static final double ARM_EXTENSOR_DEPLOY_BALL_CARGO = 0;
    public static final double ARM_EXTENSOR_DEPLOY_HATCH_CARGO = 0;
    public static final double ARM_EXTENSOR_DEPLOY_BALL_LOWER_ROCKET = 0.0;
    public static final double ARM_EXTENSOR_DEPLOY_BALL_MIDDLE_ROCKET = -7437.0;
    public static final double ARM_EXTENSOR_DEPLOY_BALL_UPPER_ROCKET = -35215.0;
    public static final double ARM_EXTENSOR_DEPLOY_HATCH_LOWER_ROCKET = 0.0;
    public static final double ARM_EXTENSOR_DEPLOY_HATCH_MIDDLE_ROCKET = 0.0;
    public static final double ARM_EXTENSOR_DEPLOY_HATCH_UPPER_ROCKET = -37969.0;
    public static final double ARM_EXTENSOR_GRAB_FROM_FLOOR = -6154.0;
    public static final double ARM_EXTENSOR_TRANSPORT = 0.0;


    // Offsets

    public static final double ARM_EXTENSOR_UPPER_OFFSET = 0;
    public static final double ARM_EXTENSOR_LOWER_OFFSET = -37969.0;
    public static final double ARM_EXTENSOR_DIFFERENCE_OFFSET = 0;
    public static final double ARM_EXTENSOR_MAX_DISTANCE = 5000;
    public static final double ARM_EXTENSOR_ARRIVE_OFFSET = 400;
    public static final double ARM_EXTENSOR_CORRECT_MAX_POWER = 0;
    public static final double ARM_EXTENSOR_MAX_POWER = 0.8;

    //// Angler

    // Positions
    
    public static final double ARM_ANGLER_DEPLOY_BALL_CARGO = 0;
    public static final double ARM_ANGLER_DEPLOY_HATCH_CARGO = -1000;
    public static final double ARM_ANGLER_DEPLOY_BALL_LOWER_ROCKET = 94774.0;
    public static final double ARM_ANGLER_DEPLOY_BALL_MIDDLE_ROCKET = -32742.0;
    public static final double ARM_ANGLER_DEPLOY_BALL_UPPER_ROCKET = -68630.0;
    public static final double ARM_ANGLER_DEPLOY_HATCH_LOWER_ROCKET = 169977.0;
    public static final double ARM_ANGLER_DEPLOY_HATCH_MIDDLE_ROCKET = -26540.0;
    public static final double ARM_ANGLER_DEPLOY_HATCH_UPPER_ROCKET = -54472.0;
    public static final double ARM_ANGLER_GRAB_FROM_FLOOR = 128405.0;
    public static final double ARM_ANGLER_START_CONFIGURATION = 0.0;
    public static final double ARM_ANGLER_TRANSPORT = 0.0;


    // Offsets

    public static final double ARM_ANGLER_LEFT_LOWER_OFFSET = -68630.0;
    public static final double ARM_ANGLER_LEFT_UPPER_OFFSET = 169977.0;
    public static final double ARM_ANGLER_RIGHT_LOWER_OFFSET = -78978.0;
    public static final double ARM_ANGLER_RIGHT_UPPER_OFFSET = 137424.0;
    public static final double ARM_ANGLER_DIFFERENCE_OFFSET = 50;
    public static final double ARM_ANGLER_MAX_DISTANCE = 4000;
    public static final double ARM_ANGLER_ARRIVE_OFFSET = 500;
    public static final double ARM_ANGLER_CORRECT_MAX_POWER = 0;
    public static final double ARM_ANGLER_MAX_POWER = 0.75;

    //// Wrist

    // Positions

    public static final double ARM_WRIST_TRANSPORT = 0.0;
    public static final double ARM_WRIST_DEPLOY_HATCH_LOWER_ROCKET = 3649.0;
    public static final double ARM_WRIST_DEPLOY_BALL_LOWER_ROCKET = 467.0;
    
    public static final double ARM_WRIST_DEPLOY_BALL_MIDDLE_ROCKET = 537.0;
    public static final double ARM_WRIST_DEPLOY_HATCH_MIDDLE_ROCKET = 2530.0;
    
    public static final double ARM_WRIST_DEPLOY_BALL_UPPER_ROCKET = 268.0;
    public static final double ARM_WRIST_DEPLOY_HATCH_UPPER_ROCKET = 2459.0;

    public static final double ARM_WRIST_BOTTOM_BALL_POSITION = 910.0;
    public static final double ARM_WRIST_BOTTOM_HATCH_POSITION = 2575.0;
    public static final double ARM_WRIST_GRAB_BALL_FLOOR = 1705.0;

    // Offsets

    public static final double ARM_WRIST_UPPER_OFFSET = 3649.0;
    public static final double ARM_WRIST_LOWER_OFFSET = 0.0;
    public static final double ARM_WRIST_MAX_DISTANCE = 700;
    public static final double ARM_WRIST_ARRIVE_OFFSET = 25;
    public static final double ARM_WRIST_MAX_POWER = 0.75;

	
	public static final double DEFAULT_MOTOR_MAX_POWER = 1;

	public static final double CHASSIS_TURN_MAX_DISTANCE = 12;
	public static final double CHASSIS_TURN_ARRIVE_OFFSET = 2;
	
	public static final double ARM_ANGLER_HATCH1_PERCENTAGE = 0.15;
	public static final double ARM_ANGLER_HATCH2_PERCENTAGE = 0.35;
	public static final double ARM_ANGLER_HATCH3_PERCENTAGE = 0.55;
	public static final double ARM_ANGLER_CARGO1_PERCENTAGE = 0.55;
	public static final double ARM_ANGLER_CARGO2_PERCENTAGE = 0.75;
	public static final double ARM_ANGLER_CARGO3_PERCENTAGE = 0.95;
	public static final double ARM_ZERO_PERCENTAGE = 0.05;
	
	public static final double CLAW_0 = 0.05;
	public static final double CLAW_90 = 0.05;
	public static final double CLAW_180 = 0.05;

	public static final double ARM_EXTENDER_ZERO = 0.10;
	public static final double ARM_EXTENDER_HATCH3 = 0.7;
	public static final double ARM_EXTENDER_CARGO2 = 0.5;
	public static final double ARM_EXTENDER_CARGO3 = 0.9;
	public static final double CORRECTION_COEFFICIENT  = 0.055;
	public enum ROLLER_STATES{
		OFF,
		CARGO_IN,
		CARGO_OUT,
		HATCH_IN,
		HATCH_OUT
	}
}