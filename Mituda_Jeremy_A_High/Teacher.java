public class Teacher extends Staff {

    private int overloadHours;

    public Teacher(String name,
                   String id,
                   double baseSalary,
                   int overloadHours) {

        super(name, id, baseSalary);
        this.overloadHours = overloadHours;
    }

    public Teacher(String name,
                   String id,
                   double baseSalary) {

        this(name, id, baseSalary, 0);
    }

    @Override
    public double computePay() {
        return baseSalary + (overloadHours * 350);
    }
}