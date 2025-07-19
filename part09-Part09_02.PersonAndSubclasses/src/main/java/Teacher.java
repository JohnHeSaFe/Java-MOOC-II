public class Teacher extends Person{
    private int salary;

    public Teacher(String name, String address, int salary) {
        super(name, address);
        this.salary = salary;
    }

    public int salary() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + "  salary " + salary() +  " euro/month";
    }
}
