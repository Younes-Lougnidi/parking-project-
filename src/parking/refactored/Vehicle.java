package parking.refactored;

public abstract class Vehicle {
    private final String plate;

    public Vehicle(String plate) { this.plate = plate; }

    public String getPlate() { return plate; }

    public abstract String getType();
    public abstract double getFee(int hours);
}
