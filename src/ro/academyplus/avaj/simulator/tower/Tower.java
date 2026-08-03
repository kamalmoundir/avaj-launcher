package  ro.academyplus.avaj.simulator.tower;

import ro.academyplus.avaj.simulator.aircraft.Flyable;
import java.util.List;
import java.util.ArrayList;


public class Tower
{

	private List<Flyable> observers = new  ArrayList<Flyable>();

	public void register(Flyable p_flyable){
	
		observers.add(p_flyable);

	}

	public void unregister(Flyable p_flyable){
		observers.remove(p_flyable);
	}


	protected void conditionChanged(){

		for(Flyable flyable : observers){
			flyable.updateConditions();
		}
	
	}
}
