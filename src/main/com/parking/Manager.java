package com.parking;

import java.util.List;
import java.util.Map;

/**
 * Created by sunjing on 10/31/16.
 */
public class Manager {
    private Map<String, ParkingLot> parkingLotList;
    private List<DoorMan> doorManList;

    Manager(Map<String, ParkingLot> parkingLots, List<DoorMan> doorManList) {
        this.parkingLotList = parkingLots;
        this.doorManList = doorManList;
    }

    public void park(Car car) {
        for (Map.Entry<String, ParkingLot> entry : this.parkingLotList.entrySet()) {
            if (!entry.getValue().isFull()) {
                entry.getValue().addCar(car.getCarId());
                break;
            }
        }
    }

    public void parkWithDoorMan(Car car) {
        for (DoorMan doorMan : this.doorManList) {
            if (doorMan.park(car.getCarId())) {
                break;
            }
        }
    }

    public void printInfo() {
        System.out.println("Hello guys, I'm a parking manager, have " + this.doorManList.size() + "door man, and manage " + this.parkingLotList.size() + "parking lots");
        System.out.println("the door man list:");
        int count = 0;
        for (DoorMan doorMan : this.doorManList) {
            System.out.println("Door Man NO." + count++ + " : have " + doorMan.getParkingLots().size() + " parking lots, "+ doorMan.getSpace() + "parking lots left");
        }
    }
}
