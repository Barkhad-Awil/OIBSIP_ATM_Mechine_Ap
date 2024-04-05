import java.util.Scanner;

// Main class for ATM interface
public class Main implements ATM {
    private final User user;
    private final TransactionHistory transactionHistory;

    public Main(User user) {
        this.user = user;
        this.transactionHistory = new TransactionHistory();
    }

    // Method to display ATM menu
    @Override
    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Transfer");
        System.out.println("4. View Transaction History");
        System.out.println("5. Check Balance");
        System.out.println("6. Quit");
    }

    // Method to withdraw cash
    @Override
    public void withdraw(double amount) {
        if (amount > user.getBalance()) {
            System.out.println("Insufficient funds. Withdrawal failed.");
        } else {
            user.updateBalance(-amount);
            transactionHistory.addTransaction(new Transaction("Withdrawal", amount));
            System.out.println("Withdrawal of $" + amount + " successful.");
        }
    }

    // Method to deposit cash
    @Override
    public void deposit(double amount) {
        user.updateBalance(amount);
        transactionHistory.addTransaction(new Transaction("Deposit", amount));
        System.out.println("Deposit of $" + amount + " successful.");
    }

    // Method to transfer funds
    @Override
    public void transfer(User recipient, double amount) {
        if (amount > user.getBalance()) {
            System.out.println("Insufficient funds. Transfer failed.");
        } else {
            user.updateBalance(-amount);
            recipient.updateBalance(amount);
            transactionHistory.addTransaction(new Transaction("Transfer to " + recipient.getUserId(), amount));
            System.out.println("Transfer of $" + amount + " to " + recipient.getUserId() + " successful.");
            System.out.println("Your updated balance: $" + user.getBalance());
        }
    }


    // Method to view transaction history
    @Override
    public void viewTransactionHistory() {
        transactionHistory.displayHistory();
    }

    // Method to check balance
    @Override
    public void checkBalance() {
        double balance = user.getBalance();
        System.out.println("Current Balance: $" + balance);
    }

    public static void main(String[] args) {
        // Initialize user
        User user = new User("user123", "1234", 1000.0);
        // Initialize ATM instance
        Main atm = new Main(user);

        // Simulate ATM operations
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;

        while (!loggedIn) {
            System.out.print("Enter User ID: ");
            String userId = scanner.nextLine();
            System.out.print("Enter PIN: ");
            String pin = scanner.nextLine();

            if (userId.equals(user.getUserId()) && user.validatePin(pin)) {
                loggedIn = true;
            } else {
                System.out.println("Invalid User ID or PIN. Please enter valid User ID and PIN.");
            }
        }

        boolean quit = false;
        while (!quit) {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter recipient User ID: ");
                    String recipientId = scanner.nextLine();
                    System.out.print("Enter transfer amount: $");
                    double transferAmount = scanner.nextDouble();
                    User recipient = new User(recipientId, "", 0.0); // Dummy user as PIN is not used for validation here
                    atm.transfer(recipient, transferAmount);
                    break;
                case 4:
                    atm.viewTransactionHistory();
                    break;
                case 5:
                    atm.checkBalance();
                    break;
                case 6:
                    quit = true;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}