package algorithm.tsm;

public class Leg {

	Coordinates a;
	Coordinates b;
	double distance;
	
	public Leg(Coordinates a, Coordinates b) {
		this.a = a;
		this.b = b;
		distance = Math.sqrt((Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2)));
	}

	public static Leg create(Coordinates a, Coordinates b) {
		return new Leg(a, b);
	}

	public double getDistance() {
		return distance;
	}

	public Coordinates getStart() {
		return a;
	}

	public Coordinates getFinish() {
		return b;
	}
	
	
	
}
