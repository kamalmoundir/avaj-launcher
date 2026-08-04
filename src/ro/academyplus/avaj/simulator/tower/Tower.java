package  ro.academyplus.avaj.simulator.tower;

import ro.academyplus.avaj.simulator.aircraft.Flyable;
import java.util.List;
import java.util.ArrayList;


public class Tower
{

	private List<Flyable> observers = new  ArrayList<Flyable>();

	public void register(Flyable p_flyable){
	
		observers.add(p_flyable);
		System.out.println("Tower says: " + p_flyable + " registered to weather tower.");

	}

	public void unregister(Flyable p_flyable){
		observers.remove(p_flyable);
		System.out.println("Tower says: " + p_flyable + " unregistered from weather tower.");
	}


	protected void conditionChanged(){

		ArrayList<Flyable> listFlyables = new ArrayList<>(observers);

		for(Flyable flyable : listFlyables){
			flyable.updateConditions();
		}
	
	}
}
