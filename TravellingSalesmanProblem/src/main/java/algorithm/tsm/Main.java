package algorithm.tsm;

public class Main {

	public static void main(String[] args) {
		
		Map map = new Map();
		
		Place 
		  SanFrancisco = new Place("San Francisco"),
		  LasVegas = new Place("Las vegas"),
		  LosAngeles = new Place("Los angeles");
		
		map.putPlace(SanFrancisco, new Coordinates(0, 0));
		map.putPlace(LasVegas, new Coordinates(4, 0));
		map.putPlace(LosAngeles, new Coordinates(6, 2));
		
		Route route = RouteBuilder.buildForAllPlaces(map);
		
		System.out.format("Total distance: %s\n", route.totalDistance());
		route
			.getAllLegs()
			.forEach(leg -> {
				System.out.format("From %s to %s\n", map.getPlace(leg.getStart()).getName(), map.getPlace(leg.getFinish()).getName());
			});
		
		
	}
	
}
