package BankAccount;

public class BankAccount {
    private String accountNumber;  // Account number for identifying the account
    private String holderName;     // Name of the account holder
    private double balance;        // Current balance in the account

    // Constructor: This is used when you create a new bank account
    public BankAccount(String accountNumber, String holderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;  // Initial balance when account is created
    }

    // Method to deposit money
    public synchronized void deposit(double amount) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;  // Add the deposited amount to the balance
        System.out.println("Deposited " + amount + " into account: " + accountNumber);
    }

    // Method to withdraw money
    public synchronized void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Not enough balance for withdrawal.");
        }
        balance -= amount;  // Subtract the amount from the balance
        System.out.println("Withdrew " + amount + " from account: " + accountNumber);
    }

    // Method to check the balance
    public synchronized double checkBalance() {
        System.out.println("Current balance for account " + accountNumber + ": " + balance);
        return balance;
    }
}
