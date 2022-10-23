package project1;

public class FanRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fan fan1 = new Fan("Usha",20,"black",false);
		fan1.switchOn();
		fan1.fanState();
		fan1.getSpeed();
		
		Fan fan2 = new Fan("havells",30,"blue",true);
		fan2.changeSpeed(45);
		fan2.getSpeed();
		
		fan2.fanState();
		fan2.switchOff();
		fan2.fanState();
		

	}

}
