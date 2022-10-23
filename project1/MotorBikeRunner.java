package project1;

public class MotorBikeRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MotorBike apache = new MotorBike(100);
		apache.start();
		
		MotorBike honda = new MotorBike(200);
		honda.start();
		
		apache.setSpeed(130);
		honda.setSpeed(140);
		
		int apacheSpeed = apache.getSpeed()+100;
		apache.setSpeed(apacheSpeed);
		System.out.println(apache.getSpeed());
		
		honda.increaseSpeed(40);
		System.out.println(honda.getSpeed());
		
		System.out.println(apache);
		
	}

}
