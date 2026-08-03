package ro.academyplus.avaj.simulator.aircraft;

import ro.academyplus.avaj.simulator.Coordinates;

public class AircraftFactory {

    private static AircraftFactory instance;
    private long idCount = 1;

    private AircraftFactory(){};

    public static AircraftFactory getInstance() {
          if(instance == null)
            instance = new AircraftFactory();
        return instance;
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates)
    {

        Flyable fly ;
        switch (p_type) {
            case "Balloon":
                fly = new Balloon(idCount ++, p_name, p_coordinates);
                break;
            case "Helicopter": 
                fly =  new Helicopter(idCount ++, p_name, p_coordinates);
                break;
            case "JetPlane":
                fly =  new JetPlane(idCount ++, p_name, p_coordinates);
                break;
            default:
                System.err.println("Error: unknown aircraft type " + p_type);
                System.exit(1);
                return null;
        }

        return fly;
    }
}
