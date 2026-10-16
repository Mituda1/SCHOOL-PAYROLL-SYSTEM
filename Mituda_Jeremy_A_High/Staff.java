// TASK 1: Stores the common information and behavior of staff members.
public abstract class Staff implements Payable {

    protected String name;
    private String staffId;
    protected double baseSalary;

    public static final double TAX_RATE = 0.10;

    private static int staffCount = 0;

    // Sets staff information and validates the base salary.
    public Staff(String name, String staffId, double baseSalary) {
        this.name = name;
        this.staffId = staffId;

        if (baseSalary < 0) {
            this.baseSalary = 0;
            System.out.println("Invalid salary");
        } else {
            this.baseSalary = baseSalary;
        }

        staffCount++;
    }

    // Returns the number of Staff objects created.
    public static int getStaffCount() {
        return staffCount;
    }

    // Prints the staff ID and name.
    @Override
    public void printReport() {
        System.out.println("[" + staffId + "] " + name);
    }

    // Returns the name used for searching.
    @Override
    public String getLabel() {
        return name;
    }

    // Computes pay after subtracting 10% tax.
    public double computeNet() {
        return computePay() - (computePay() * TAX_RATE);
    }

    // Requires each Staff subclass to compute its own pay.
    @Override
    public abstract double computePay();
}
