public class Event implements Comparable<Event> {
    private long time; // Represents the event time

    // Constructor
    public Event(long time) {
        this.time = time;
    }

    // Getter for time
    public long getTime() {
        return time;
    }

    @Override
    public int compareTo(Event other) {
        return Long.compare(this.time, other.time);
    }

    @Override
    public String toString() {
        return "Event at time: " + time;
    }
}
