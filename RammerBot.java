package Gamma;
import robocode.*;
import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * RammerBot - a robot by (your name here)
 */
public class RammerBot extends Robot
{
	/**
	 * run: RammerBot's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		setColors(Color.black,Color.red,Color.green); // body,gun,radar

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			ahead(100);
			turnGunRight(360);
			back(100);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		double bearing;
		bearing=e.getBearing();
		turnRight(bearing);

		turnRight(e.getBearing());
		ahead(e.getDistance() + 5);
		scan(); // Might want to move ahead again!
		
		//Determine a shot that won't kill the robot...
		//We want to ram him instead for bonus points!
		if (e.getEnergy() > 16) {
			fire(3);
		} else if (e.getEnergy() > 10) {
			fire(2);
		} else if (e.getEnergy() > 4) {
			fire(1);
		} else if (e.getEnergy() > 2) {
			fire(.5);
		} else if (e.getEnergy() > .4) {
			fire(.1);
		}
		ahead(40); // Ram him again!
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		
	
	}	
}
