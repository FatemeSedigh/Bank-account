public class TransactionAccount extends BankAccount{

    private final double overDraftLimit = 500 ;

    public AccountTransaction (String accountHolderName, String accountNumber, double initialBalance){
        super(accountHolderName,accountNumber,initialBalance);
    }

    @Override
    public void calculateInterest(){
        System.out.println("حساب جاری سود ندارد");
    }

    @Override
    Public void withdraw(double amount){
        if (amount < 0){
            System.out.println("مبلغ برداشتی نامعتبر است!");
        }
        else if (amount > balance + overDraftLimit){
            System.out.println("موجودی کافی نیست");
        }
        else {
            balance -= amount;
            System.out.println(amount + " تومان از حساب جاری شماره " + getAccountNumber() + " برداشت شد.");
        }
    }

}

//        if (amount <= balance + overDraftLimit){}

