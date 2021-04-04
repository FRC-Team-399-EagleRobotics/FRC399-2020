package frc.robot.util;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight{

    private String tableName = "limelight";
    private NetworkTable table;
    private NetworkTableEntry tx;
    private NetworkTableEntry ty;
    private NetworkTableEntry tv;
    private NetworkTableEntry ta;

    private static Limelight instance;

    private Limelight() {
        
        update();
    }

    public static Limelight getInstance() {
        if(instance == null) {
            instance = new Limelight();
        }

        return instance;
    }

    public double getX() {
        return tx.getDouble(0.0);
    }

    public double getY() {
        return ty.getDouble(0.0);
    }

    public boolean hasTargets() {
        return (tv.getDouble(0.0) > 0.0);
    }

    public double getArea() {
        return ta.getDouble(0);
    }

    

    public static enum VisionMode {
        TARGET, DRIVER_CAM
    }

    public void update() {
        table = NetworkTableInstance.getDefault().getTable(tableName);
        tx = table.getEntry("tx");
        ty = table.getEntry("ty");
        tv = table.getEntry("tv");
        ta = table.getEntry("ta");
    }

    public static enum LightMode {
        OFF, ON, BLINK, LEFT, RIGHT, NONE
    }

    public void setLightMode(LightMode mode) {
        int ledMode = 0;

        switch(mode) {  
            case OFF:
                ledMode = 1; break;
            case BLINK: 
                ledMode = 2; break;
            case ON:
                ledMode = 3; break;
            case LEFT:
                ledMode = 4; break;
            case RIGHT:
                ledMode = 5; break;
            case NONE:
                ledMode = 0; break;
            default: break;
        }

        table.getEntry("ledMode").setNumber(ledMode);

    }

}