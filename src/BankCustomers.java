import java.util.ArrayList;

class BankCustomers {
    private ArrayList<BankAccount> accountsList = new ArrayList<>();

    // Add an account to the list
    public void addAccount(BankAccount account) {
        accountsList.add(account);
        System.out.println("حساب شماره " + account.getAccountNumber() + " اضافه شد.");
    }

    // Show all account balances
    public void showAllBalances() {
        System.out.println("\nلیست تمام حساب‌ها:");
        for (BankAccount account : accountsList) {
            System.out.println("شماره حساب: " + account.getAccountNumber() +
                    ", نام: " + account.getAccountHolderName() +
                    ", موجودی: " + account.getBalance());
        }
    }

    // Find an account by account number
    public BankAccount findAccount(String accountNumber) {
        for (BankAccount account : accountsList) {
            if (account.getAccountNumber().equals(accountNumber)) {
                System.out.println("حساب پیدا شد: شماره " + accountNumber +
                        ", نام: " + account.getAccountHolderName() +
                        ", موجودی: " + account.getBalance());
                return account;
            }
        }
        System.out.println("حساب با شماره " + accountNumber + " یافت نشد!");
        return null;
    }
}