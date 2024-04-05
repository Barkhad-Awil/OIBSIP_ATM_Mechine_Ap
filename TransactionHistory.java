import java.util.ArrayList;
import java.util.List;

class TransactionHistory {
    private final List<Transaction> transactions;

    public TransactionHistory() {
        transactions = new ArrayList<>();
    }

    // Method to add transaction to history
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    // Method to display transaction history
    public void displayHistory() {
        System.out.println("Transaction History:");
        for (Transaction transaction : transactions) {
            System.out.println("Type: " + transaction.getType() + ", Amount: $" + transaction.getAmount());
        }
    }
}