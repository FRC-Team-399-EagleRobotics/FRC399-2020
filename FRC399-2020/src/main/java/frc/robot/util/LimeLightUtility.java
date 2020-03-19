package frc.robot.util;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LimeLightUtility{

    public static LimeLightUtility Instance;
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");
    NetworkTableEntry ts = table.getEntry("ts");
    NetworkTableEntry tl = table.getEntry("tl");

    double x;
    double y;
    double area;
    double skew;
    double latency;

    int ledOff = 1;
    int ledBlink = 2;
    int ledOn = 3;

    int visionViewMode = 0;
    int driverViewMode = 1;

    public LimeLightUtility(){
   
    SmartDashboard.putNumber("LimelightX", x);
    SmartDashboard.putNumber("LimelightY", y);
    SmartDashboard.putNumber("LimelightArea", area);
    }

    public void setLedMode(int ledMode){
        table.getEntry("ledMode").setNumber(ledMode);
    }

    public void setCameraMode(int cameraMode){
        table.getEntry("camMode").setNumber(cameraMode);
    }

    public void setPipeline(int pipeline){
        table.getEntry("pipeline").setNumber(pipeline);
    }

    public double getX(){
        x = tx.getDouble(0.0);
        return x;
    }

    public double getY(){
        y = ty.getDouble(0.0);
        return y;
    }
    
    public double getArea(){
        area = ta.getDouble(0.0);
        return area;
    }

    public static LimeLightUtility getInstance(){
		if(Instance == null){
			Instance = new LimeLightUtility();
		}
		return Instance;
	}
}