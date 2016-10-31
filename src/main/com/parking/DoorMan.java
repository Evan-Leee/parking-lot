package com.parking;

import java.util.HashMap;
import java.util.Map;

public class DoorMan {


    private Map<String, ParkingLot> parkingLots;

    public DoorMan (){
        this.parkingLots = new HashMap<String, ParkingLot>();
    }

    public Map<String, ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public String findAvailableParkingLot() {

        for (Map.Entry<String, ParkingLot> entry : this.parkingLots.entrySet())
        {
            if(!entry.getValue().isFull()) {
                return entry.getKey();
            }
        }
        return "";
    }

    public Boolean park(String carId, ParkingLot parkingLot) {
        Boolean isAvailable = !parkingLot.isFull();
        if(isAvailable){
            parkingLot.addCar(carId);
        }
        return isAvailable;
    }
}
