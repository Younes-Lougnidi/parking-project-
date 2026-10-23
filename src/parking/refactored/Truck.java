package parking.refactored;

public class Truck extends Vehicle {

    public Truck(String plate) { super(plate); }

    public String getType() { return "TRUCK"; }

    public double getFee(int hours) { return 20 + hours * 10.0; }
}
