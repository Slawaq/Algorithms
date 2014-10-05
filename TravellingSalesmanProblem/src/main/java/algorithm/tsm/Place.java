package algorithm.tsm;

import java.util.UUID;

public class Place {
	
	private int id = (int)UUID.randomUUID().getMostSignificantBits();
	private String Name;
	
	public Place(String name) {
		Name = name;
	}

	public String getName() {
		return Name;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		return hashCode() == obj.hashCode();
	}

	
}
