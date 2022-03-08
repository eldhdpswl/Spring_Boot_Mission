package dev.eldhdpswl;

public class GoCart extends AbstractCar implements CarInteface{

    private Driver driver;


    @Override
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void accelerate() {
        this.velocity += 5;
    }

    @Override
    public void brake() {
        this.velocity -= 5;
        super.brake(); //
    }
}
