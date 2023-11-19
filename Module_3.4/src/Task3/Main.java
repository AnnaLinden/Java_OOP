package Task3;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Student student = new Student(1, "John Doe", 20);
        Course course = new Course("CS101", "Introduction to Computer Science", "Dr. Smith");
        Enrollment enrollment = new Enrollment(student, course, "01-01-2023");

        // Serialization
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("enrollments.ser"))) {
            out.writeObject(enrollment);
            System.out.println("Enrollment serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("enrollments.ser"))) {
            Enrollment deserializedEnrollment = (Enrollment) in.readObject();
            System.out.println("Deserialized Enrollment: " + deserializedEnrollment);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}