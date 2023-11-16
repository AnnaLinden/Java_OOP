import java.util.Random;

public class Main {
    public static void main(String[] args) {
        EventList eventList = new EventList();
        Random random = new Random();

        // Generate a list of events with types
        System.out.println("Generating a list of events...");
        for (int i = 0; i < 10; i++) {
            long time = random.nextInt(1000);
            EventType type = random.nextBoolean() ? EventType.ARRIVAL : EventType.EXIT;
            eventList.add(new Event(type, time));
            System.out.println("Added " + type + " Event: " + time);
        }

        // Remove the first event
        System.out.println("\nRemoving the first event from the list...");
        Event removedEvent = eventList.remove();
        System.out.println("Removed " + removedEvent);

        // Print the sorted event list
        System.out.println("\nPrinting the contents of the EventList, ordered by event time:");
        for (Event e : eventList.toSortedArray()) {
            System.out.println(e);
        }
    }
}
