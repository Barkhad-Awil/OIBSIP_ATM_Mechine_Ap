
// Interface for ATM operations
interface ATM {
    void displayMenu();
    void withdraw(double amount);
    void deposit(double amount);
    void transfer(User recipient, double amount);
    void viewTransactionHistory();
    void checkBalance();
}