package dev.eldhdpswl;

import java.util.ArrayList;
import java.util.List;

public class Road {
    //내부에서 구현체로 사용할떄는 List로서 interface로 만드는 것을 추천한다.
    private List<CarInteface> carsOnRoad; //ArrayList<CarInteface>

    public Road() {
        this.carsOnRoad = new ArrayList<>();
    }

    //코드상 외부에서 사용하게될 함수에서 인자는 interface형태로 받아주는 형태로 작성한다.
    public Road(List<CarInteface> carsOnRoad) {
        this.carsOnRoad =  carsOnRoad;
    }

    public void addCar(CarInteface car){
        this.carsOnRoad.add(car);
    }



}
