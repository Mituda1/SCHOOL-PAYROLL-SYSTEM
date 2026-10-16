// TASK 3: Calculates a teacher's pay using overload hours.
public class Teacher extends Staff {

    private int overloadHours;

    // Sends common staff information to the Staff constructor.
    public Teacher(String name,
                   String id,
                   double baseSalary,
                   int overloadHours) {

        super(name, id, baseSalary);
        this.overloadHours = overloadHours;
    }

    // Calls the first constructor with zero overload hours.
    public Teacher(String name,
                   String id,
                   double baseSalary) {

        this(name, id, baseSalary, 0);
    }

    // Computes base salary plus 350 for each overload hour.
    @Override
    public double computePay() {
        return baseSalary + (overloadHours * 350);
    }
}
