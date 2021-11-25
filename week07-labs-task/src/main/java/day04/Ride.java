package day04;

public class Ride {

    private int dayOfWeek;
    private int numberOfRide;
    private int kms;

    public Ride(int dayOfWeek, int numberOfRide, int kms) {
        this.dayOfWeek = dayOfWeek;
        this.numberOfRide = numberOfRide;
        this.kms = kms;
    }

    @Override
    public String toString() {
        StringBuilder rideStringBuilder = new StringBuilder();
        rideStringBuilder.append("Day of week: ");
        rideStringBuilder.append(this.dayOfWeek);
        rideStringBuilder.append("\nNumber of ride: ");
        rideStringBuilder.append(this.numberOfRide);
        rideStringBuilder.append("\nKms: ");
        rideStringBuilder.append(this.kms);
        return rideStringBuilder.toString();
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public int getNumberOfRide() {
        return numberOfRide;
    }

    public int getKms() {
        return kms;
    }
}
