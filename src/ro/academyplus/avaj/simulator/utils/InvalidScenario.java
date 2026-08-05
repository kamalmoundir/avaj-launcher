package ro.academyplus.avaj.simulator.utils;

public class InvalidScenario {

    public static void validateAircraftLine(String parts[]) throws InvalidScenarioException {
        if (parts.length != 5) {
            throw new InvalidScenarioException("Invalid line: expected 5 fields, got " + parts.length);
        }
        if (!isValidPositiveInt(parts[2])) {
            throw new InvalidScenarioException("Invalid longitude: " + parts[2]);
        }
        if (!isValidPositiveInt(parts[3])) {
            throw new InvalidScenarioException("Invalid latitude: " + parts[3]);
        }
        if (!isValidPositiveInt(parts[4])) {
            throw new InvalidScenarioException("Invalid height: " + parts[4]);
        }

        if (!parts[0].equals("Balloon") && !parts[0].equals("JetPlane") && !parts[0].equals("Helicopter")) {
            throw new InvalidScenarioException("Invalide Name of Aircraft type");
        }

    }

    public static boolean isValidPositiveInt(String s) {
        return s.matches("\\d+");
    }
}
