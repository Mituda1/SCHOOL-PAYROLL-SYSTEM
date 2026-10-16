public class AdminStaff extends Staff {

    private double allowance;

    public AdminStaff(String name,
                      String id,
                      double baseSalary,
                      double allowance) {

        super(name, id, baseSalary);
        this.allowance = allowance;
    }

    @Override
    public double computePay() {
        return baseSalary + allowance;
    }

    @Override
    public void printReport() {
        super.printReport();
        System.out.printf("    Allowance: %.2f%n", allowance);
    }
}