import java.io.IOException;

public class Solid {
	
	private double speed;
	private double mass;
	
	public Solid(double speed, double mass) {
		super();
		this.speed = speed;
		this.mass = mass;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public void CollideWith (Solid s) {
		
		double vi1 = s.speed;
		double vi2 = this.speed;
		
		s.speed = ((s.mass - this.mass)/(s.mass + this.mass)) * vi1 + ((2 * this.mass)/(s.mass + this.mass)) * vi2 ;
		this.speed = ((2 * s.mass)/(s.mass+this.mass)) * vi1 + ((this.mass - s.mass)/(s.mass + this.mass)) * vi2 ;		
	}
	
	public void CollideWall () {
		
		this.speed *= -1 ;
		
	}
	
	public static void main(String[] args) {
		
		long startTime = System.nanoTime();
		long counter = 0;
		int pi_digits = 12; // <== change the number of pi digits here)
		
		if (pi_digits >=10)
			System.out.println("This may take about " + Math.pow(10, pi_digits - 10) * 7.3 + " seconds"); //7 is the time it takes to calculate 10 digits of pi (depends on the computer)
			
		Solid S1 = new Solid(0,1);
		Solid S2 = new Solid(0.05,Math.pow(100, pi_digits-1));
		
		while (true) {
			
			if (S1.getSpeed() >0) {
				S1.CollideWall();
				counter++;
				//System.out.println(counter);
			}
				
			if (S1.getSpeed()< S2.getSpeed()) {
				S1.CollideWith(S2);
				counter++;
				//System.out.println(counter);
			}
				
			else 
				break;
			
		}


	long endTime = System.nanoTime();
	System.out.println("-----------------------------------");
	System.out.println("Number of Digits: "+pi_digits);
	System.out.println(counter/(Math.pow(10, pi_digits-1)));
	System.out.println("It took " + (endTime - startTime) + " nanoseconds");
	System.out.println("-----------------------------------");
	
	}
}
