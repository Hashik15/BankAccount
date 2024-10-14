package BankAccount;

public class Main {
    public static void main(String[] args) {
        // Create two bank accounts
        BankAccount account1 = new BankAccount("123456", "John Doe", 500.0);
        BankAccount account2 = new BankAccount("789012", "Jane Smith", 1000.0);

        // Create threads for different transactions
        Thread t1 = new Thread(new BankTransaction(account1, 200.0, "deposit"));
        Thread t2 = new Thread(new BankTransaction(account2, 300.0, "withdraw"));
        Thread t3 = new Thread(new BankTransaction(account1, 50.0, "withdraw"));

        // Start the threads (start running transactions in parallel)
        t1.start();
        t2.start();
        t3.start();

        // Wait for the threads to complete
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Check the final balance for each account
        account1.checkBalance();
        account2.checkBalance();
    }
}

