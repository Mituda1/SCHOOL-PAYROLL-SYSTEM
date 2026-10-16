// TASK 4: Represents a payable recipient who is not a Staff object.
public class Honorarium implements Payable {

    private String recipient;
    private double amount;

    // Sets the recipient and validates the amount.
    public Honorarium(String recipient, double amount) {
        this.recipient = recipient;
        setAmount(amount);
    }

    // Accepts only an amount greater than zero.
    public void setAmount(double amount) {
        if (amount > 0) {
            this.amount = amount;
        }
    }

    // Returns the honorarium amount.
    @Override
    public double computePay() {
        return amount;
    }

    // Returns the recipient name for searching.
    @Override
    public String getLabel() {
        return recipient;
    }

    // Prints the recipient and amount.
    @Override
    public void printReport() {
        System.out.printf(
                "Honorarium - %s: %.2f%n",
                recipient,
                amount
        );
    }
}
