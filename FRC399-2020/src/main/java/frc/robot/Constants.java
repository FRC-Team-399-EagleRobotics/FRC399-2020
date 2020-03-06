/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static class Drivetrain {
        public static final int LEFT_A_ID = 6;
        public static final int LEFT_B_ID = 4;
        public static final int RIGHT_A_ID = 8;
        public static final int RIGHT_B_ID = 7;
    }

    public static class Intake {
        public static final int INTAKE_ID = 24;
        public static final int PIVOT_ID = 5;
    }

    public static class Indexer {
        public static final int INDEXER_ID = 10;
        public static final int FEEDER_ID = 12;
    }

    public static class Shooter {
        public static final int TOP_ID = 30;
        public static final int BOT_ID = 31;
        public static final int SHOOTER_PIVOT_ID = 32;
    }
    public static class Climber {
        public static final int WINCH_A_ID = 1;
        public static final int WINCH_B_ID = 3;
    }
    public static class ColorWheel {
        public static final int WHEEL_ID = 2;
    }
}
