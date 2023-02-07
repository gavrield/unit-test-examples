package testingil.unittesting.examples.demos.d03.clean;

public class Navigator {

	private DistanceProvider distProvider;
	private Location startingPoint;
	private Location endPoint;

	public Navigator(DistanceProvider distProvider) {
		this.distProvider = distProvider;
	}

	public Distance getDistanceFromDestination()	{
		return distProvider.getDistance(startingPoint, endPoint);
	}

	public void setDestination(Location dest) {
		this.endPoint = dest;
	}

	public void setStartingPoint(Location startingPoint) {
		this.startingPoint = startingPoint;
	}

}
