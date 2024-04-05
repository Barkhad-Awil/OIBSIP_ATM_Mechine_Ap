// Represents a user of the ATM system
class User {
    private final String userId;
    private final String pin;
    private double balance;

    public User(String userId, String pin, double balance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = balance;
    }

    // Getter for user ID
    public String getUserId() {
        return userId;
    }

    // Method to validate pin
    public boolean validatePin(String enteredPin) {
        return pin.equals(enteredPin);
    }

    // Method to check balance
    public double getBalance() {
        return balance;
    }

    // Method to update balance after deposit
    public void updateBalance(double amount) {
        balance += amount;
    }
}