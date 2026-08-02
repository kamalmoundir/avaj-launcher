package ro.academyplus.avaj.simulator.aircraft;
import ro.academyplus.avaj.simulator.Coordinates;

public class Helicopter extends Aircraft {

    Helicopter(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    public void updateConditions(){

        String weather = weatherTower.getWeather(coordinates);

        switch(weather){
            
            case "SUN":
                coordinates.setLongitude(coordinates.getLongitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 2);
                System.out.println();
                break;
            case "RAIN":
                coordinates.setLongitude(coordinates.getLongitude() + 5);
                System.out.println();
                break;
            case "FOG":
                coordinates.setLongitude(coordinates.getLongitude() + 1);
                System.out.println();
                break;
            case "SNOW":
                coordinates.setHeight(coordinates.getHeight() - 12);
                System.out.println();
                break; 
        }

        if(coordinates.getHeight() == 0)
        {
            System.out.println();
            weatherTower.unregister(this);
        }
    }
    
}
