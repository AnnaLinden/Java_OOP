import java.util.PriorityQueue;
import java.util.ArrayList;

public class EventList {
    private PriorityQueue<Event> eventQueue;

    public EventList() {
        eventQueue = new PriorityQueue<>();
    }

    public void add(Event e) {
        eventQueue.add(e);
    }

    public Event remove() {
        return eventQueue.poll();
    }

    public ArrayList<Event> toSortedArray() {
        return new ArrayList<>(eventQueue);
    }
}
