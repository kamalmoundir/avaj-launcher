package ro.academyplus.avaj.simulator.aircraft;
import ro.academyplus.avaj.simulator.Coordinates;

public class Helicopter extends Aircraft {

    public  Helicopter(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    public void updateConditions(){

        String weather = weatherTower.getWeather(coordinates);

        switch(weather){
            
            case "SUN":
                coordinates.setLongitude(coordinates.getLongitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 2);
                System.out.println("Helicopter#" + name + "(" + id + "): Let's enjoy the good weather!");
                break;
            case "RAIN":
                coordinates.setLongitude(coordinates.getLongitude() + 5);
               System.out.println("Helicopter#" + name + "(" + id + "): Damn you rain! You messed up my Helicopter.");
                break;
            case "FOG":
                coordinates.setLongitude(coordinates.getLongitude() + 1);
                System.out.println("Helicopter#" + name + "(" + id + "): Can't see a thing, I might just crash into a bird.");
                break;
            case "SNOW":
                coordinates.setHeight(coordinates.getHeight() - 12);
                System.out.println("Helicopter#" + name + "(" + id + "): It's snowing. We're gonna crash.");
                break; 
        }

        if(coordinates.getHeight() == 0)
        {
             System.out.println("Helicopter#" + name + "(" + id + ") landing.");
            weatherTower.unregister(this);
        }
    }
    
}
