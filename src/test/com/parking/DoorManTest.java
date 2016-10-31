package com.parking;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DoorManTest {

    @Mock
    ParkingLot fullParkingLot;

    @Mock
    ParkingLot notFullParkingLot_1;

    @Mock
    ParkingLot notFullParkingLot_2;

    DoorMan doorMan;

    @Before
    public void setUp() {
        when(fullParkingLot.isFull()).thenReturn(true);
        when(fullParkingLot.getRemains()).thenReturn(0);

        when(notFullParkingLot_1.isFull()).thenReturn(false);
        when(notFullParkingLot_1.getRemains()).thenReturn(2);

        when(notFullParkingLot_2.isFull()).thenReturn(false);
        when(notFullParkingLot_2.getRemains()).thenReturn(4);

        doorMan = new DoorMan();
    }

    @Test
    public void testShouldReturnParkingLotNumberWhichIsNotFull () {
        doorMan.getParkingLots().put("parkingLot_1", fullParkingLot);
        doorMan.getParkingLots().put("parkingLot_2", notFullParkingLot_1);
        doorMan.getParkingLots().put("parkingLot_3", notFullParkingLot_2);
        assertThat(doorMan.findAvailableParkingLot(), is("parkingLot_2"));
    }

    @Test
    public void testShouldReturnParkingLotNumberWhichIsMoreSpace () {
        doorMan.getParkingLots().put("parkingLot_1", fullParkingLot);
        doorMan.getParkingLots().put("parkingLot_2", notFullParkingLot_1);
        doorMan.getParkingLots().put("parkingLot_3", notFullParkingLot_2);
        assertThat(doorMan.findSuitableParkingLot(), is("parkingLot_3"));
    }

    @Test
    public void testShouldReturnTrueWhenParkSuccess () {
        doorMan.getParkingLots().put("parkingLot_3", notFullParkingLot_2);
        assertThat(doorMan.park("car"), is(true));
    }

    @Test
    public void testShouldReturnFalseWhenParkSuccess () {
        doorMan.getParkingLots().put("parkingLot_1", fullParkingLot);
        assertThat(doorMan.park("car"), is(false));
    }


}
