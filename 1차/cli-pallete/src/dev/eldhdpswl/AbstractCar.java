package dev.eldhdpswl;

public abstract class AbstractCar implements CarInteface{

    protected int velocity = 0;

    @Override
    public void brake(){
        if(this.velocity < 0){
            this.velocity = 0;
        }
    }
}
