package com.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private List<String> spaces;

    private int size;

    public ParkingLot () {
        this.size = 5;
        this.spaces = new ArrayList<String>();
    }

    public ParkingLot (int size) {
        this.size = size;
        this.spaces = new ArrayList<String>();
    }

    public Boolean isFull() {
        return (this.spaces.size() >= this.size);
    }

    public Boolean hasThisCar(String carId) {
        return this.spaces.contains(carId);
    }

    public void addCar(String carId) {
        this.spaces.add(carId);
    }

    public void removeCar(String carId) {
        this.spaces.remove(carId);
    }

    public int getSize() {
        return size;
    }

    public List<String> getSpaces() {
        return spaces;
    }

    public int getRemains () {
        return (this.size - this.spaces.size());
    }

}
