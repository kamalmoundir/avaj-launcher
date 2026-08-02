package ro.academyplus.avaj.simulator.aircraft;

import ro.academyplus.avaj.simulator.Coordinates;

public class JetPlane extends Aircraft {

    JetPlane(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    public void updateConditions(){

        String weather = weatherTower.getWeather(coordinates);

        switch(weather){
            
            case "SUN":
                coordinates.setLatitude(coordinates.getLatitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 5);
                System.out.println();
                break;
            case "RAIN":
                coordinates.setLatitude(coordinates.getLatitude() + 5);
                System.out.println();
                break;
            case "FOG":
                coordinates.setLatitude(coordinates.getLatitude() + 1);
                System.out.println();
                break;
            case "SNOW":
                coordinates.setHeight(coordinates.getLatitude() - 7);
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
