package ro.academyplus.avaj.simulator.tower;

import ro.academyplus.avaj.simulator.Coordinates;

public class WeatherProvider {

    String weather[] = {"SUN","RAIN","FOG","SNOW"};
    
    private static WeatherProvider instance;
    
    private WeatherProvider(){};
    
    
    public static WeatherProvider getInstance(){

        if(instance == null)
        {
            instance = new WeatherProvider();
        }
        return instance;
    }

    public String getCurrentWeather(Coordinates p_coordinates)
    {
        int sum = p_coordinates.getHeight() + p_coordinates.getLatitude() + p_coordinates.getLongitude();
        return weather[sum % 4];
    }

}
