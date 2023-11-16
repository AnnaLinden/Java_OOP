public class Event implements Comparable<Event> {
    private EventType type;
    private long time;

    public Event(EventType type, long time) {
        this.type = type;
        this.time = time;
    }

    public long getTime() {
        return time;
    }

    public EventType getType() {
        return type;
    }

    @Override
    public int compareTo(Event other) {
        return Long.compare(this.time, other.time);
    }

    @Override
    public String toString() {
        return "Event [" + type + "] at time: " + time;
    }
}
