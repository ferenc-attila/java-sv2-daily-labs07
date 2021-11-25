package day04;

import java.util.ArrayList;
import java.util.List;

public class Courier {

    private List<Ride> rides = new ArrayList<>();

    public void addRide(Ride ride) {
        if (rides.isEmpty() && ride.getNumberOfRide() == 1) {
            rides.add(ride);
        } else if (!rides.isEmpty() && isNumberOfDaysEquals(ride) && isNewNumberOfRideLargerWithOne(ride)) {
            rides.add(ride);
        } else if (!rides.isEmpty() && isNewNumberOfDayLarger(ride) && ride.getNumberOfRide() == 1) {
            rides.add(ride);
        } else {
            throw new IllegalArgumentException("Invalid parameters!");
        }
    }

    private boolean isNewNumberOfDayLarger(Ride ride) {
        return (rides.get(rides.size() - 1).getDayOfWeek() < ride.getDayOfWeek());
    }

    private boolean isNewNumberOfRideLargerWithOne(Ride ride) {
        return ((rides.get(rides.size() - 1).getNumberOfRide()) + 1 == ride.getNumberOfRide());
    }

    private boolean isNumberOfDaysEquals(Ride ride) {
        return (rides.get(rides.size() - 1).getDayOfWeek() == ride.getDayOfWeek());
    }

    public List<Ride> getRides() {
        return rides;
    }
}
