package avajLauncher;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.io.PrintStream;
import java.io.FileOutputStream;

public class Simulator {

    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                throw new InputException("Need one input_file_name as the only argument.");
            }

            System.setErr(System.out);
            PrintStream out = new PrintStream(new FileOutputStream("simulation.txt"));
            System.setOut(out);

            List<String> lines = Files.readAllLines(Path.of(args[0]));
            int simuTimes = Integer.parseInt(lines.remove(0));
            if (simuTimes <= 0) { throw new InputException("simuTimes must be positive"); }

            WeatherTower weatherTower = new WeatherTower();
            for (String line : lines) {
                String[] tokens = line.split("\\s+");
                AircraftFactory aircraftFactory = AircraftFactory.getInstance();
                Flyable aircraft = aircraftFactory.newAirCraft(tokens[0], tokens[1],
                        new Coordinates(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4])));
                aircraft.registerTower(weatherTower);
            }

            for (int i = 0; i < simuTimes; i++) {
                weatherTower.changeWeather();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}