package algorithm.tsm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class RouteBuilder {

	public static Route buildForAllPlaces(Map map) {
		List<Entry<Coordinates, Place>> places = map
				.getAllPlacesWithCoordinates();

		// TODO null pointer
		Entry<Coordinates, Place> begin = places.get(0);
		Route totalRoute = new Route(begin);
		boolean skipFirst = true;

		List<Entry<Coordinates, Place>> remainedPlaces = getWithoutFirst(places);

		while (remainedPlaces.size() > 1) {
			// TODO null pointer
			Entry<Coordinates, Place> nearestPlace = remainedPlaces.get(0);
			double minDistance = totalRoute.getLeg(nearestPlace).getDistance();
			for (int i = 1; i < remainedPlaces.size(); i++) {
				Entry<Coordinates, Place> place = remainedPlaces.get(0);
				double distance = totalRoute.getLeg(place).getDistance();
				if (minDistance > distance) {
					minDistance = distance;
					nearestPlace = place;
				}
			}

			remainedPlaces.remove(nearestPlace);
			totalRoute.addLeg(nearestPlace);
		}

		totalRoute.addLeg(remainedPlaces.get(0));
		// totalRoute.addLeg(begin);

		return totalRoute;
	}

	private static List<Entry<Coordinates, Place>> 
	getWithoutFirst(
			List<Entry<Coordinates, Place>> places) {
		List<Entry<Coordinates, Place>> remainedPlaces = new ArrayList<Entry<Coordinates, Place>>();
		for(int i = 1; i < places.size(); i++)
			remainedPlaces.add(places.get(i));
		return remainedPlaces;
	}

}
