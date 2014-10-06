package algorithm.tsm;

public class Main {

	public static void main(String[] args) {
		
		Map map = new Map();
		
		Place 
			SanFrancisco = new Place("San Francisco"),
			LasVegas = new Place("Las vegas"),
			LosAngeles = new Place("Los angeles"),
			Kyiv = new Place("Kyiv"),
			NewYork = new Place("NewYork"),
			Seattle = new Place("Seattle");
		
		map.putPlace(SanFrancisco, new Coordinates(0, 0));
		map.putPlace(LasVegas, new Coordinates(4, 0));
		map.putPlace(LosAngeles, new Coordinates(6, 2));
		map.putPlace(Kyiv, new Coordinates(5, 1));
		map.putPlace(NewYork, new Coordinates(5, 0));
		map.putPlace(Seattle, new Coordinates(3, 2));
		
		Route route = RouteBuilder.buildForAllPlaces(map);
		
		System.out.format("Total distance: %s\n", route.totalDistance());
		route
			.getAllLegs()
			.forEach(leg -> {
				System.out.format("From %s to %s\n", map.getPlace(leg.getStart()).getName(), map.getPlace(leg.getFinish()).getName());
			});
		
		
	}
	
}
