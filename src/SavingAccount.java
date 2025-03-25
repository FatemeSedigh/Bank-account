class SavingsAccount extends BankAccount {
    private final double interestRate = 0.03; // نرخ سود 3%

    // Constructor
    public SavingsAccount(String accountNumber, String accountHolderName, double initialBalance) {
        super(accountNumber, accountHolderName, initialBalance);
    }

    // Calculate interest and add to balance
    @Override
    public void calculateInterest() {
        double interest = balance * interestRate;
        deposit(interest);
        System.out.println("سود حساب پس‌انداز به مبلغ " + interest + " تومان محاسبه و واریز شد.");
    }

    // Override withdraw to prevent negative balance
    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("مبلغ برداشتی نامعتبر است!");
        } else if (amount > balance) {
            System.out.println("در حساب پس‌انداز نمی‌توان بیش از موجودی برداشت کرد!");
        } else {
            balance -= amount;
            System.out.println(amount + " تومان از حساب پس‌انداز شماره " + getAccountNumber() + " برداشت شد.");
        }
    }
}