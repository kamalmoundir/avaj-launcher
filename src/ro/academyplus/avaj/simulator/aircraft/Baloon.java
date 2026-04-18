package ro.academyplus.avaj.simulator.aircraft;

import ro.academyplus.avaj.simulator.Coordinates;
//import ro.academyplus.avaj.simulator.aircraft.*;
//import ro.academyplus.avaj.simulator.tower.*;

public class Baloon extends Aircraft{

    public Baloon(long p_id, String p_name, Coordinates p_coordinates){

       super(p_id, p_name, p_coordinates);
    } 

    public void updateConditions(){

        String weather = weatherTower.getWeather(coordinates);

        switch(weather){
            
            case "SUN":
                break;
            case "RAIN":
                break;
            case "FOG":
                break;
            case "SNOW":
                break; 
        }
    }

}
