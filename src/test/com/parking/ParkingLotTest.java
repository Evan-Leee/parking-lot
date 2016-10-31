package com.parking;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ParkingLotTest {

    private ParkingLot parkingLot;

    @Before
    public void setUp(){
        parkingLot = new ParkingLot(2);
    }

    @Test
    public void isFull() throws Exception {
        parkingLot.addCar("陕A8888");
        assertThat(parkingLot.isFull(), is(false));

        parkingLot.addCar("陕A6666");
        assertThat(parkingLot.isFull(), is(true));
    }

    @Test
    public void hasThisCar() throws Exception {
        parkingLot.addCar("陕A6666");

        assertThat(parkingLot.hasThisCar("陕A6666"), is(true));
        assertThat(parkingLot.hasThisCar("陕A8888"), is(false));
    }
}