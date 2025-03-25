class TransactionAccount extends BankAccount {
    private final double overDraftLimit = 500; // حد مجاز برداشت بیش از موجودی

    // Constructor
    public TransactionAccount(String accountNumber, String accountHolderName, double initialBalance) {
        super(accountNumber, accountHolderName, initialBalance);
    }

    // No interest for transaction accounts
    @Override
    public void calculateInterest() {
        System.out.println("حساب جاری سود ندارد!");
    }

    // Override withdraw to allow overdraft up to limit
    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("مبلغ برداشتی نامعتبر است!");
        } else if (amount > (balance + overDraftLimit)) {
            System.out.println("مبلغ درخواستی بیش از حد مجاز برداشت است!");
        } else {
            balance -= amount;
            System.out.println(amount + " تومان از حساب جاری شماره " + getAccountNumber() + " برداشت شد.");
        }
    }
}