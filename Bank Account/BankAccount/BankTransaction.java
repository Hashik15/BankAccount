package BankAccount;

public class BankTransaction implements Runnable {
    private BankAccount account;
    private double amount;
    private String transactionType;

    // Constructor to initialize transaction details
    public BankTransaction(BankAccount account, double amount, String transactionType) {
        this.account = account;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    // The run() method is executed when a thread starts
    @Override
    public void run() {
        try {
            if (transactionType.equalsIgnoreCase("deposit")) {
                account.deposit(amount);  // Deposit money
            } else if (transactionType.equalsIgnoreCase("withdraw")) {
                account.withdraw(amount);  // Withdraw money
            }
        } catch (Exception e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
    }
}

