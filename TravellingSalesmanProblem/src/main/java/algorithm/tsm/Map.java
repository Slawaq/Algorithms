package algorithm.tsm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Map {

	java.util.Map<Coordinates, Place> palces = new HashMap<Coordinates, Place>();
	
	public void putPlace(Place a, Coordinates coordinates) {
		if(palces.values().contains(a))
			throw new ApplicationException(String.format("Cannot put place(%s) on map, place already exist on map", a.getId()));
		
		Place placeOnCoordinates = palces.put(coordinates, a);
		
		if(placeOnCoordinates != null)
			throw new ApplicationException(String.format("Cannot put place(%s) on map, coordinates(%s) already occupied", a.getId(), coordinates.hashCode()));
	}
	
	public List<Entry<Coordinates, Place>> getAllPlacesWithCoordinates() {
		return palces
				.entrySet()
				.stream()
				.collect(Collectors.toList());
	}

	public Place getPlace(Coordinates coordinates) {
		return palces.get(coordinates);
	}
	
}
