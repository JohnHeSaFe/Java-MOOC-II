package validating;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) throws IllegalArgumentException {
        if (name == null || name.isBlank() || name.length() > 40) {
            throw new IllegalArgumentException("Name cannot be empty or above 40 characters in length");
        } else if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age cannot be negative or above 120");
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
