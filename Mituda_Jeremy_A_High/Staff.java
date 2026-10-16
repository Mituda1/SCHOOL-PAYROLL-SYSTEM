public abstract class Staff implements Payable {

    protected String name;
    private String staffId;
    protected double baseSalary;

    public static final double TAX_RATE = 0.10;

    private static int staffCount = 0;

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

    public static int getStaffCount() {
        return staffCount;
    }

    @Override
    public void printReport() {
        System.out.println("[" + staffId + "] " + name);
    }

    @Override
    public String getLabel() {
        return name;
    }

    public double computeNet() {
        return computePay() - (computePay() * TAX_RATE);
    }

    public abstract double computePay();
}