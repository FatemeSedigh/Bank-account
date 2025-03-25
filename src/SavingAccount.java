public class SavingAccount extends BankAccount{

    private final double interestRate = 0.03 ;

    public SavingsAccount(String accountNumber, String accountHolderName, double initialBalance){
        super(accountNumber, accountHolderName, initialBalance);
    }

    @Override
    public void calculateInterest() {
        double interest = balance * interestRate;
        deposit(interest);
        System.out.println("سود حساب پس‌انداز به مبلغ " + interest + " تومان محاسبه و واریز شد.");
    }
}
