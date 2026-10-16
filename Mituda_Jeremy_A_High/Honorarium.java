public class Honorarium implements Payable {

    private String recipient;
    private double amount;

    public Honorarium(String recipient, double amount) {
        this.recipient = recipient;
        setAmount(amount);
    }

    public void setAmount(double amount) {

        if (amount > 0) {
            this.amount = amount;
        }
    }

    @Override
    public double computePay() {
        return amount;
    }

    @Override
    public String getLabel() {
        return recipient;
    }

    @Override
    public void printReport() {
        System.out.printf(
                "Honorarium - %s: %.2f%n",
                recipient,
                amount
        );
    }
}