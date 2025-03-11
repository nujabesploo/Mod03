package com.pluralsight.streams;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Program to manage a list of people and perform various operations on it.
 */
public class Program {

    public static void main(String[] args) {

        ArrayList<Person> people = new ArrayList<Person>();

        // Add 10 people to the list
        people.add(new Person("Emma", "Johnson", 32));
        people.add(new Person("Noah", "Williams", 45));
        people.add(new Person("Olivia", "Smith", 28));
        people.add(new Person("Liam", "Garcia", 37));
        people.add(new Person("Sophia", "Miller", 29));
        people.add(new Person("Jackson", "Brown", 53));
        people.add(new Person("Ava", "Davis", 41));
        people.add(new Person("Lucas", "Wilson", 25));
        people.add(new Person("Isabella", "Martinez", 34));
        people.add(new Person("Aiden", "Taylor", 39));

        // Prompt the user for a first and last name
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Please enter last name: ");
        String lastName = scanner.nextLine();

        // Don't forget to close the scanner when done with it
        scanner.close();

        // Replace the for loop with a stream and filter function
        // Ensure that your new list of names still contains the correct results.

        ArrayList<Person> filteredPeople = (ArrayList<Person>) people.stream()
                .filter(person -> person.getFirstName().equals(firstName) && person.getLastName().equals(lastName))
                .collect(Collectors.toList());

        if (filteredPeople.isEmpty()) {
            System.out.printf("%s %s is not in the list %n", firstName, lastName);
        } else {
            filteredPeople.forEach(person -> System.out.printf("%s %s is in the list %n", person.getFirstName(),
                    person.getLastName()));
        }

        // Replace the for loop in your average age calculation with stream methods.
        // HINT: You will need to chain multiple methods together: i.e. map(), reduce()

        double averageAge = people.stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0);
        System.out.println("The average age is " + averageAge);

        // Using only stream methods find the following answers.
        // HINT: This could be done a few different ways: using sorted() or a
        // combination of map() and reduce()
        Person oldestPerson = people.stream()
                .max((p1, p2) -> p1.getAge() - p2.getAge())
                .get();
        System.out.println("The oldest person is " + oldestPerson.getFirstName() + " " + oldestPerson.getLastName());

        // Find the youngest person in the list and display their first and last name
        Person youngestPerson = people.stream()
                .min((p1, p2) -> p1.getAge() - p2.getAge())
                .get();
        System.out.println(
                "The youngest person is " + youngestPerson.getFirstName() + " " + youngestPerson.getLastName());
    }
}