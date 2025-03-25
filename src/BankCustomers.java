import java.util.ArrayList;
public class BankCustomers {

    private ArrayList<BankAccount> accountsList;

    public void addAccount(BankAccount account) {
        accountsList.add(account);
    }

    public void showAllBalances(){
        System.out.println("\nلیست تمام حساب‌ها:");
        for (BankAccount account : accountsList) {
            System.out.println("شماره حساب: " + account.getAccountNumber() + ", نام: " + account.getAccountHolderName() + ", موجودی: " + account.getBalance());
        }
    }

    public BankAccount findAccount(String accountNumber){
        for (BankAccount account : accountsList){
            if(account.getAccountNumber().equals(accountNumber)){
                System.out.println("شماره حساب: " + account.getAccountNumber() + ", نام: " + account.getAccountHolderName() + ", موجودی: " + account.getBalance());
                return account;
            }
        }
        System.out.println("حساب با شماره " + accountNumber + " یافت نشد!");
        return null;
    }
}
