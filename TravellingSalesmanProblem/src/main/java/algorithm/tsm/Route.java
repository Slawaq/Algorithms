package algorithm.tsm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class Route {

	private Entry<Coordinates, Place> begin;
	private Entry<Coordinates, Place> last;
	private List<Leg> legs = new ArrayList<Leg>(); 

	public Route(Entry<Coordinates, Place> entry) {
		begin = entry;
		last = begin;
	}

	public void addLeg(Entry<Coordinates, Place> p) {
		legs.add(getLeg(p));
		last = p;
	}
	
	public Leg getLeg(Entry<Coordinates, Place> p) {
		return Leg.create(last.getKey(), p.getKey());
	}
	
	public double totalDistance() {
		return legs
			.stream()
			.mapToDouble(leg -> leg.getDistance())
			.sum();
	}

	public Stream<Leg> getAllLegs() {
		return legs.stream();
	}
	
}
