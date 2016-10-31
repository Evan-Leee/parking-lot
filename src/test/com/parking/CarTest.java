package com.parking;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CarTest {

    @Mock
    private ParkingLot parkingLot;

    private Car car;

    @Test
    public void testShouldReturnFalseWhenParkAndParkingLotIsFull (){

        when(parkingLot.isFull()).thenReturn(true);
        car = new Car("car3");

        assertThat(car.park(parkingLot), is(false));
    }

    @Test
    public void testShouldReturnTrueWhenParkAndParkingLotNotFull (){
        when(parkingLot.isFull()).thenReturn(false);
        car = new Car("car3");

        assertThat(car.park(parkingLot), is(true));
    }

    @Test
    public void testShouldReturnTrueWhenUnparkAndParkingLotHasThisCar (){
        when(parkingLot.hasThisCar("car3")).thenReturn(true);
        car = new Car("car3");

        assertThat(car.unPark(parkingLot), is(true));
    }

    @Test
    public void testShouldReturnFalseWhenUnparkAndParkingLotHasNotThisCar (){
        when(parkingLot.hasThisCar("car1")).thenReturn(false);
        car = new Car("car1");

        assertThat(car.unPark(parkingLot), is(false));
    }
}