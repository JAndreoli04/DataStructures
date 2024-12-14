
public class Run implements Comparable<Run>{
    private int minutes;
    private int seconds;
    private double distanceInKilometers;

    public Run(int minutes, int seconds, double distanceInKilometers) {
        this.minutes = minutes;
        this.seconds = seconds;
        this.distanceInKilometers = distanceInKilometers;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public double getDistanceInKilometers() {
        return distanceInKilometers;
    }

    public int getTotalSeconds() {
        return (minutes * 60) + seconds;
    }

    public double getSpeedInKilometersPerHour() {
        return (getDistanceInKilometers() / getSeconds()) * 3600;
    }

    public int compareTo(Run r) {
        //compare to two decimal places by multiplying each speed by 100
        //casting to ints and subtracting
        int a = (int) this.getSpeedInKilometersPerHour() * 100;
        int b = (int) r.getSpeedInKilometersPerHour() * 100;
        return a - b;
    }

    public String toString() {
        return String.format("%d:%02d (%.2f) %.2f kph", 
                minutes, seconds, distanceInKilometers,
                getSpeedInKilometersPerHour());
    }
}
