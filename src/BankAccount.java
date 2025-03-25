public class BankAccount {

    private final String accountNumber;
    private String accountHolderName;
    protected  double balance;

    public BankAccount(String accountNumber, String accountHolderName, double balance){

        accountNumber.this = accountNumber;
        accountHolderName.this = accountHolderName;
        balance.this = balance;


    }

    public abstract void calculateInterest(){

    }

    public void deposit(double amount){
        if (amount > 0){
            balance += amount;
            System.out.println(amount + " تومان به حساب شماره " + accountNumber + " اضافه شد.");
        }
        else {
            System.out.println("مبلغ واریزی نامعتبر است!");
        }
    }

    public void withdraw(double amount){
        if (amount <= 0) {
            System.out.println("مبلغ برداشتی نامعتبر است!");
        } else if (amount > balance) {
            System.out.println("موجودی کافی نیست!");
        } else {
            balance -= amount;
            System.out.println(amount + " تومان از حساب شماره " + accountNumber + " برداشت شد.");
        }
    }

    public double getBalance(){
        return balance;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public String getAccountHolderName(){
        return accountHolderName;
    }

}
