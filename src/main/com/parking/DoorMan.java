package com.parking;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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

    public Boolean park(String carId) {

        if(findAvailableParkingLot().isEmpty()){
            return false;
        }

        ParkingLot parkingLot = this.parkingLots.get(findAvailableParkingLot());
        Boolean isAvailable = !parkingLot.isFull();
        if(isAvailable){
            parkingLot.addCar(carId);
        }
        return isAvailable;
    }

    public String findSuitableParkingLot() {
        Map<String, Integer> parkingLotRemains = this.parkingLots.entrySet().stream()
                .collect(Collectors.toMap(
                        elem -> elem.getKey(),
                        elem -> elem.getValue().getRemains()
                ));

        Map.Entry<String, Integer> maxEntry = null;

        for (Map.Entry<String, Integer> entry : parkingLotRemains.entrySet())
        {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
            {
                maxEntry = entry;
            }
        }

        return maxEntry.getKey();
    }

}
