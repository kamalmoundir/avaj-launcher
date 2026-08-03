package ro.academyplus.avaj.simulator.aircraft;

import ro.academyplus.avaj.simulator.Coordinates;
//import ro.academyplus.avaj.simulator.aircraft.*;
//import ro.academyplus.avaj.simulator.tower.*;

public class Balloon extends Aircraft{

    public Balloon(long p_id, String p_name, Coordinates p_coordinates){

       super(p_id, p_name, p_coordinates);
    } 


    public void updateConditions(){

        String weather = weatherTower.getWeather(coordinates);

        switch(weather){
            
            case "SUN":
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
                this.coordinates.setHeight(this.coordinates.getHeight() + 4);
                System.out.println("Balloon#" + name + "(" + id + "): Let's enjoy the good weather!");
                
                break;
            case "RAIN":
                coordinates.setHeight(coordinates.getHeight() - 5);
                System.out.println("Balloon#" + name + "(" + id + "): Damn you rain! You messed up my balloon.");
                break;
            case "FOG":
                coordinates.setHeight(coordinates.getHeight() - 3);
                System.out.println("Balloon#" + name + "(" + id + "): Can't see a thing, I might just crash into a bird.");
                break;
            case "SNOW":
                coordinates.setHeight(coordinates.getHeight() - 15);
                System.out.println("Balloon#" + name + "(" + id + "): It's snowing. We're gonna crash.");
                
                break; 
        }
    

        if(coordinates.getHeight() == 0)
        {
            System.out.println("Balloon#" + name + "(" + id + ") landing.");
            weatherTower.unregister(this);
        }
    }
}
