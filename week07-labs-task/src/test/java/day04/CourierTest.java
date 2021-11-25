package day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CourierTest {

    Courier courier = new Courier();

    Ride rideOne = new Ride(1, 1, 12);
    Ride rideTwo = new Ride(1, 2, 2);
    Ride rideThree = new Ride(1, 3, 10);
    Ride rideFour = new Ride(2, 1, 8);
    Ride rideFive = new Ride(4, 1, 7);
    Ride rideSix = new Ride(5, 1, 21);

    @Test
    void addValidRidesTest() {
        courier.addRide(rideOne);
        courier.addRide(rideTwo);
        courier.addRide(rideThree);
        courier.addRide(rideFour);
        courier.addRide(rideFive);
        courier.addRide(rideSix);

        assertEquals(6, courier.getRides().size());
        assertEquals(8, courier.getRides().get(3).getKms());
        assertEquals(5,courier.getRides().get(5).getDayOfWeek());
        assertEquals(3, courier.getRides().get(2).getNumberOfRide());
    }

    @Test
    void addInvalidNumberOfDaysTest() {
        courier.addRide(rideFour);
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> courier.addRide(rideOne));

        assertEquals("Invalid parameters!", iae.getMessage());
    }

    @Test
    void addLargerNumberOfRidesTest() {
        courier.addRide(rideOne);
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> courier.addRide(rideThree));

        assertEquals("Invalid parameters!", iae.getMessage());
    }

    @Test
    void addSmallerNumberOfRidesTest() {
        courier.addRide(rideOne);
        courier.addRide(rideTwo);
        Ride wrongRide = new Ride(1,1,10);
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> courier.addRide(wrongRide));

        assertEquals("Invalid parameters!", iae.getMessage());
    }

    @Test
    void addNumberOfRidesLargerThanOneFirstTest() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> courier.addRide(rideTwo));

        assertEquals("Invalid parameters!", iae.getMessage());
    }
}