package strategy;

public class Normal implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Driving normally.");
    }
}
