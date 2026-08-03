package  ro.academyplus.avaj.simulator.tower;

import ro.academyplus.avaj.simulator.Coordinates;


public class WeatherTower extends Tower{


public String getWeather(Coordinates p_coordinates)
{
    return WeatherProvider.getInstance().getCurrentWeather(p_coordinates);
}

public void changeWeather()
{
    this.conditionChanged();
}


}
