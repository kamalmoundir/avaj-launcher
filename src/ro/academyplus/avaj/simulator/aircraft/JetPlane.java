package ro.academyplus.avaj.simulator.aircraft;

import ro.academyplus.avaj.simulator.Coordinates;

public class JetPlane extends Aircraft {

   public  JetPlane(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    public void updateConditions(){

        String weather = weatherTower.getWeather(coordinates);

        switch(weather){
            
            case "SUN":
                coordinates.setLatitude(coordinates.getLatitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 2);
                System.out.println("JetPlane#" + name + "(" + id + "): Let's enjoy the good weather!");
                break;
            case "RAIN":
                coordinates.setLatitude(coordinates.getLatitude() + 5);
               System.out.println("JetPlane#" + name + "(" + id + "): Damn you rain! You messed up my JetPlane.");
                break;
            case "FOG":
                coordinates.setLatitude(coordinates.getLatitude() + 1);
                System.out.println("JetPlane#" + name + "(" + id + "): Can't see a thing, I might just crash into a bird.");
                break;
            case "SNOW":
                coordinates.setHeight(coordinates.getHeight() - 7);
                System.out.println("JetPlane#" + name + "(" + id + "): It's snowing. We're gonna crash.");
                break; 
        }
        if(coordinates.getHeight() == 0)
        {
            System.out.println("JetPlane#" + name + "(" + id + ") landing.");
            weatherTower.unregister(this);
        }
    }
    
}
