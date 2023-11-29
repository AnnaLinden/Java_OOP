package dictionary.controller;

import dictionary.controller.DictionaryController;
import dictionary.model.Dictionary;

public class DictionaryController {
    private Dictionary dictionary;

    public DictionaryController(Dictionary dictionary) {
        this.dictionary = dictionary;
        // Populate the dictionary with some words and meanings
        initializeDictionary();
    }

    public String searchWord(String word) {
        if (word == null || word.trim().isEmpty()) {
            return "Please enter a word.";
        }
        return dictionary.getMeaning(word);
    }

    private void initializeDictionary() {

        dictionary.addWord("Hello", "A greeting used to begin a conversation.");
        dictionary.addWord("Java", "A high-level, class-based, object-oriented programming language.");

        // Java and OOP related terms
        dictionary.addWord("Threads",
                "In Java, threads allow concurrent execution of two or more parts of a program for maximum utilization of CPU.");
        dictionary.addWord("Synchronization",
                "A capability in Java to control the access of multiple threads to any shared resource.");
        dictionary.addWord("TDD",
                "Test-Driven Development, a software development approach where tests are written before the code.");
        dictionary.addWord("Enum", "A special data type in Java used to define collections of constants.");
        dictionary.addWord("Unit Testing",
                "A software testing method where individual units or components of a software are tested.");
        dictionary.addWord("Arrays",
                "A data structure in Java that can store a fixed-size sequential collection of elements of the same type.");
        dictionary.addWord("Interface",
                "In Java, an interface is a reference type, similar to a class, that can contain only constants, method signatures, default methods, static methods, and nested types.");
        dictionary.addWord("LinkedList",
                "A part of Java's Collections Framework, it is a linear data structure where the elements are not stored in contiguous locations.");
        dictionary.addWord("ArrayList", "A resizable array, which can be found in the java.util package.");
        dictionary.addWord("HashMap",
                "A part of Java's Collections Framework, it is a hash table based implementation of the Map interface.");
        dictionary.addWord("HashSet",
                "A part of Java's Collections Framework, it is a hash table based implementation of the Set interface.");
        dictionary.addWord("TreeSet",
                "A part of Java's Collections Framework, it is an implementation of the Set interface based on a TreeMap.");
        dictionary.addWord("TreeMap",
                "A part of Java's Collections Framework, it is a Red-Black tree based implementation of the Map interface.");
        dictionary.addWord("Stack",
                "A part of Java's Collections Framework, it is a linear data structure that follows the LIFO (Last In First Out) principle.");
        dictionary.addWord("Queue",
                "A part of Java's Collections Framework, it is a linear data structure that follows the FIFO (First In First Out) principle.");
        dictionary.addWord("Deque",
                "A part of Java's Collections Framework, it is a linear data structure that supports insertion and removal at both ends.");
        dictionary.addWord("PriorityQueue",
                "A part of Java's Collections Framework, it is an unbounded queue based on a priority heap.");
        dictionary.addWord("Comparable",
                "An interface in Java that is used to order the objects of user-defined class.");
        dictionary.addWord("Comparator",
                "An interface in Java that is used to order the objects of user-defined class.");
        dictionary.addWord("Lambda",
                "A feature introduced in Java 8, it is an anonymous function that can be treated as a method argument.");
        dictionary.addWord("Stream", "A sequence of elements supporting sequential and parallel aggregate operations.");
        dictionary.addWord("Optional", "A container object that may or may not contain a non-null value.");
        dictionary.addWord("Reflection",
                "A feature in Java that enables us to inspect and modify the runtime behavior of applications.");

    }
}
