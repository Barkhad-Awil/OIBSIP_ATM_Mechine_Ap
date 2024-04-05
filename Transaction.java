// Represents a transaction made by a user
class Transaction {
    private final String type;
    private final double amount;

    // Constructor
    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    // Getter for transaction type
    public String getType() {
        return type;
    }

    // Getter for transaction amount
    public double getAmount() {
        return amount;
    }
}
