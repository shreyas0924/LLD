package strategy;

public abstract class VehicleStrategy implements DriveStrategy{
    DriveStrategy driveStrategy;

    VehicleStrategy(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }
}
