package parking.refactored;

public class Car extends Vehicle {

    public Car(String plate) {
        super(plate); }

    public String getType() { return "CAR"; }

    public double getFee(int hours) { return hours * 5.0; }
}
