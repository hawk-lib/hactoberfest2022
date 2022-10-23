package project1;

public class MotorBike {
	
	//state
	private int speed;
	
	//constructor
	MotorBike(int speed){
		this.speed=speed;
	}
	
	
	//setters
	void setSpeed(int speed){
		if(speed>=0) {
			this.speed = speed;
		}
		
	}
	
	//getters
	int getSpeed() {
		return this.speed;
	}
	
	//methods
	void start() {
		System.out.println("Bike Started");
	}
	
	void increaseSpeed(int howMuch) {
		this.speed = this.speed+howMuch;
	}
	void decreaseSpeed(int howMuch) {
		this.speed = this.speed-howMuch;
	}
}
