package algorithm.tsm;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class Map {

	java.util.Map<Coordinates, Place> palces = new HashMap<Coordinates, Place>();
	
	public void putPlace(Place a, Coordinates coordinates) {
		if(palces.values().contains(a))
			throw new ApplicationException(String.format("Cannot put place(%s) on map, place already exist on map", a.getId()));
		
		Place placeOnCoordinates = palces.put(coordinates, a);
		
		if(placeOnCoordinates != null)
			throw new ApplicationException(String.format("Cannot put place(%s) on map, coordinates(%s) already occupied", a.getId(), coordinates.hashCode()));
	}
	
	public Stream<Entry<Coordinates, Place>> getAllPlacesWithCoordinates() {
		return palces.entrySet().stream();
	}

	public Place getPlace(Coordinates coordinates) {
		return palces.get(coordinates);
	}
	
}
