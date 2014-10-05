package algorithm.tsm;

import java.util.Map.Entry;


public class RouteBuilder {

	public static Route buildForAllPlaces(Map map) {
		// TODO null pointer
		Entry<Coordinates, Place> begin = map.getAllPlacesWithCoordinates().findFirst().get();
		Route totalRoute = new Route(begin);
		
		map.getAllPlacesWithCoordinates()
			.skip(1)
			.forEach(p -> {
				totalRoute.addLeg(p);
			});
		
		totalRoute.addLeg(begin);
		
		return totalRoute;
	}
	
}
