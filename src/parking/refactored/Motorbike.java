package parking.refactored;

public class Motorbike extends Vehicle {

    public Motorbike(String plate) { super(plate); }

    public String getType() { return "MOTORBIKE"; }

    public double getFee(int hours) { return hours * 2.0; }
}
