import java.util.ArrayList;

abstract class BankAccount {
    private final String accountNumber;
    private String accountHolderName;
    protected double balance;

    // Constructor
    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Abstract method for calculating interest (to be implemented by subclasses)
    public abstract void calculateInterest();

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " تومان به حساب شماره " + accountNumber + " اضافه شد.");
        } else {
            System.out.println("مبلغ واریزی نامعتبر است!");
        }
    }

    // Method to withdraw money (basic version, can be overridden)
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("مبلغ برداشتی نامعتبر است!");
        } else if (amount > balance) {
            System.out.println("موجودی کافی نیست!");
        } else {
            balance -= amount;
            System.out.println(amount + " تومان از حساب شماره " + accountNumber + " برداشت شد.");
        }
    }

    // Getters
    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }
}