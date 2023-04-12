package org.example;

class AgeValidationException extends Exception {
    public AgeValidationException() {
        super("Invalid age provided. Age should be between 18 and 60.");
    }
}

class User {
    private String name;
    private int age;

    public User(String name, int age) throws AgeValidationException {
        if (age < 18 || age > 60) {
            throw new AgeValidationException();
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            User user1 = new User("John", 25);
            System.out.println("User: " + user1.getName() + ", Age: " + user1.getAge());

            User user2 = new User("Jane", 16); // Throws AgeValidationException
        } catch (AgeValidationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}