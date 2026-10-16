// TASK 3: Calculates admin staff pay and displays the allowance.
public class AdminStaff extends Staff {

    private double allowance;

    // Sends common staff information to the Staff constructor.
    public AdminStaff(String name,
                      String id,
                      double baseSalary,
                      double allowance) {

        super(name, id, baseSalary);
        this.allowance = allowance;
    }

    // Computes base salary plus allowance.
    @Override
    public double computePay() {
        return baseSalary + allowance;
    }

    // Prints the normal staff report first, then the allowance.
    @Override
    public void printReport() {
        super.printReport();
        System.out.printf("    Allowance: %.2f%n", allowance);
    }
}
