package com.parking;

public class Car {

    private String carId;

    public Car (String carId){
        this.carId = carId;
    }

    public Boolean park(ParkingLot parkingLot) {
        Boolean isAvailable = !parkingLot.isFull();
        if(isAvailable){
            parkingLot.addCar(this.carId);
        }
        return isAvailable;
    }

    public Boolean unPark(ParkingLot parkingLot) {
        Boolean isAvailable = parkingLot.hasThisCar(this.carId);
        if(isAvailable){
            parkingLot.removeCar(this.carId);
        }
        return isAvailable;
    }

    public String getCarId() {
        return carId;
    }


}
