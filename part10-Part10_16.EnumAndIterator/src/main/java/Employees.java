import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employees {
    List<Person> employees;

    public Employees() {
        this.employees = new ArrayList<>();
    }

    public void add(Person personToAdd) {
        employees.add(personToAdd);
    }

    public void add(List<Person> peopleToAdd) {
        employees.addAll(peopleToAdd);
    }

    public void print() {
        employees.stream()
                 .forEach(employee -> System.out.println(employee));
    }

    public void print(Education education) {
        Iterator<Person> iterator = employees.iterator();

        while (iterator.hasNext()) {
            Person employee = iterator.next();
            if (employee.getEducation() == education) {
                System.out.println(employee);
            }
        }
    }

    public void fire(Education education) {
        Iterator<Person> iterator = employees.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().getEducation() == education) {
                iterator.remove();
            }
        }
    }
}
