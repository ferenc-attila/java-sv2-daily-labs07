package day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RideTest {

    Ride rideOne = new Ride(2, 5, 3);

    @Test
    void initTest() {
        Ride rideTwo = new Ride(1, 2, 20);
        String expectedString = "Day of week: 1\nNumber of ride: 2\nKms: 20";
        assertEquals(expectedString, rideTwo.toString());
    }

    @Test
    void getDayOfWeekTest() {
        assertEquals(2, rideOne.getDayOfWeek());
    }

    @Test
    void getNumberOfRideTest() {
        assertEquals(5, rideOne.getNumberOfRide());
    }

    @Test
    void getKmsTest() {
        assertEquals(3, rideOne.getKms());
    }
}