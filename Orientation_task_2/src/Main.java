import java.util.Random;

public class Main {
    public static void main(String[] args) {
        EventList eventList = new EventList();
        Random random = new Random();

        // Part (a): Generate a list of events
        System.out.println("Generating a list of events...");
        for (int i = 0; i < 10; i++) {
            long time = random.nextInt(1000); // Random event time
            eventList.add(new Event(time));
            System.out.println("Added Event: " + time);
        }

        // Part (b): Remove the first event from the list
        System.out.println("\nRemoving the first event from the list...");
        Event removedEvent = eventList.remove();
        System.out.println("Removed Event: " + removedEvent);

        // Part (c): Print the contents of the EventList, ordered by event time
        System.out.println("\nPrinting the contents of the EventList, ordered by event time:");
        for (Event e : eventList.toSortedArray()) {
            System.out.println(e);
        }
    }
}
