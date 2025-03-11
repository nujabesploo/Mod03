package com.pluralsight.streams;

import java.util.ArrayList;
import java.util.Scanner;

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

        // Search for a person by first or last name
        boolean found = false;
        for (Person person : people) { // Using enhanced for loop for cleaner code
            if (person.getFirstName().contains(firstName) ||
                    person.getLastName().contains(lastName)) {
                System.out.println(person.getFirstName() + " " + person.getLastName() + " is in the list");
                found = true;
            }
        }
        if (!found) {
            System.out.printf("%s %s is not in the list %n", firstName, lastName);
        }

        // Calculate the average age of all people in the original list and display it
        int sum = 0;
        for (Person person : people) { // Using enhanced for loop
            sum += person.getAge();
        }
        // Fixed: Use double division to get accurate average
        double average = (double) sum / people.size();
        System.out.println("The average age of all people is " + average);

        // Find the oldest person in the list and display their first and last name
        int oldest = 0;
        Person oldestPerson = null; // Track the person object directly
        for (Person person : people) {
            if (person.getAge() > oldest) {
                oldest = person.getAge();
                oldestPerson = person;
            }
        }
        System.out.println("The oldest person is " + oldestPerson.getFirstName() + " " + oldestPerson.getLastName());

        // Find the youngest person in the list and display their first and last name
        int youngest = Integer.MAX_VALUE;
        Person youngestPerson = null; // Track the person object directly
        for (Person person : people) {
            if (person.getAge() < youngest) {
                youngest = person.getAge();
                youngestPerson = person;
            }
        }
        System.out.println(
                "The youngest person is " + youngestPerson.getFirstName() + " " + youngestPerson.getLastName());
    }
}