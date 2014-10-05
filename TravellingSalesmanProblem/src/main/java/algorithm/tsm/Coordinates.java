package algorithm.tsm;

public class Coordinates {

	int x;
	int y;
	
	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	@Override
	public int hashCode() {
	    int res = 17;
	    res = res * 31 + Math.min(x, y);
	    res = res * 31 + Math.max(x, y);
	    return res;
	}

	@Override
	public boolean equals(Object obj) {
		return hashCode() == obj.hashCode();
	}
	
	
	
}
