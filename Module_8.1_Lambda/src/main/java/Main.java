import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // Create a list of Person objects
        List<Person> people = new ArrayList<>();
        people.add(new Person("Mikko", 30, "Tammisaari"));
        people.add(new Person("Liisa", 25, "Tampere"));
        people.add(new Person("Johanna", 32, "Tammisaari"));
        people.add(new Person("Antti", 23, "Turku"));
        people.add(new Person("Kaisa", 27, "Oulu"));
        people.add(new Person("Aki",50, "Helsinki"));
        people.add(new Person("Orvokki", 70,"Vantaa"));

        /// Sort the list by age using a lambda expression
        // Comparator.comparingInt(Person::getAge) is a method reference that extracts the age for comparison
        people.sort(Comparator.comparingInt(Person::getAge));

        // Filter the list to include only people from "Tammisaari" using Predicate
        // Define a Predicate for filtering
        // A Predicate is a functional interface that represents a single argument function returning a boolean
        Predicate<Person> isFromTammisaari = p -> "Tammisaari".equals(p.getCity());
        List<Person> filteredPeople = new ArrayList<>();
        for (Person person : people) {
            // Apply the Predicate 'isFromTammisaari' to each person
            // The 'test' method of Predicate returns true if the condition is met
            if (isFromTammisaari.test(person)) {
                filteredPeople.add(person);
            }
        }

        // Print the filtered list
        for (Person person : filteredPeople) {
            System.out.println(person);
        }
    }
}