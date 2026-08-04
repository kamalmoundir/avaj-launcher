package ro.academyplus.avaj.simulator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import ro.academyplus.avaj.simulator.aircraft.AircraftFactory;
import ro.academyplus.avaj.simulator.aircraft.Flyable;
import ro.academyplus.avaj.simulator.tower.Tower;
import ro.academyplus.avaj.simulator.tower.WeatherTower;

public class Simulator {

    
    public static void main(String[] args) {
        
        if(args.length != 1)
        {
            System.out.println("Should be one and only one argument file");
            System.exit(1);
        }
        String file = args[0];
        try {
            

            BufferedReader reader = new BufferedReader( new FileReader(file));

            String line;
            int  simulatorCount = 0;
            boolean firstline = true;

            WeatherTower weatherTower = new WeatherTower();

            while((line = reader.readLine()) != null)
            {
                if(firstline)
                {
                    simulatorCount = Integer.parseInt(line);
                    firstline = false;
                    continue;
                }
                String parts[] = line.split(" ");
                
                String type = parts[0];
                String Name = parts[1];

                int longitude = Integer.parseInt(parts[2]);
                int latitude = Integer.parseInt(parts[3]);
                int height = Integer.parseInt(parts[4]);

                Coordinates coor = new Coordinates(longitude, latitude, height);
                Flyable airecraft = AircraftFactory.getInstance().newAircraft(type, Name, coor);

                weatherTower.register(airecraft);
                airecraft.registerTower(weatherTower);

            }

            for (int i = 0; i < simulatorCount; i++) {
                   weatherTower.changeWeather();
            }


           
            reader.close();
        } catch (Exception e) {
             System.out.println(e);
                e.printStackTrace();

        }
        

    }

}
