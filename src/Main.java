public class Main {
    public static void main(String[] args) {

        BankCustomers bank = new BankCustomers();

        SavingsAccount saving1 = new SavingsAccount("SA001", "فاطمه صدیق", 1000);
        SavingsAccount saving2 = new SavingsAccount("SA002", "نگین حسینی", 2000);
        SavingsAccount saving3 = new SavingsAccount("SA003", "زهرا محمدی", 3000);

        TransactionAccount trans1 = new TransactionAccount("TA001", "پارسا کریمی", 1500);
        TransactionAccount trans2 = new TransactionAccount("TA002", "امیر عباسی", 2500);
        TransactionAccount trans3 = new TransactionAccount("TA003", "سارا جلالی", 3500);

        bank.addAccount(saving1);
        bank.addAccount(saving2);
        bank.addAccount(saving3);
        bank.addAccount(trans1);
        bank.addAccount(trans2);
        bank.addAccount(trans3);

        System.out.println("\nجستجوی حساب‌ها:");
        BankAccount foundAccount = bank.findAccount("SA002");
        BankAccount notFoundAccount = bank.findAccount("SA999");

        System.out.println("\nتغییر موجودی حساب:");
        System.out.println("موجودی اولیه: " + saving1.getBalance());
        saving1.deposit(500);
        System.out.println("موجودی بعد از واریز: " + saving1.getBalance());

        System.out.println("\nتلاش برای واریز مبلغ نادرست:");
        trans1.deposit(-100);

        System.out.println("\nمحاسبه سود حساب پس‌انداز:");
        saving1.calculateInterest();
        System.out.println("موجودی جدید: " + saving1.getBalance());

        System.out.println("\nمحاسبه سود حساب جاری:");
        trans1.calculateInterest();

        System.out.println("\nبرداشت از حساب جاری:");
        trans1.withdraw(100);
        trans1.withdraw(-50);
        trans1.withdraw(2000);

        System.out.println("\nبرداشت از حساب پس‌انداز:");
        saving1.withdraw(100);
        saving1.withdraw(-50);
        saving1.withdraw(5000);

        System.out.println("\nوضعیت نهایی تمام حساب‌ها:");
        bank.showAllBalances();


    }
}