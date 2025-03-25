## 🏦 سیستم بانکی شیءگرا 


##سلااام


مثل تمام Readme ها توی پروژه های قبلیم اول میام و دو تا از مهم ترین کلاس هایی که توی پروژه زدم رو کامل توضیح میدم


(همه‌ی کلاس ها مهمن ولی خب من از اونا که بیشتر پایه رو تشکیل میدن شروع میکنم)



و بعد کد رو به صورت کلی توضیح میدم و نهایت هم خروجی رو براتون میزارم 


##🎯اول از کلاس BankCustomers: 



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


##توضیحات مربوطه :   


🏢 BankCustomers

addAccount(account) - افزودن حساب
showAllBalances() - نمایش موجودی‌ها
findAccount(number) - جستجوی حساب


کلاس BankCustomers نقش مدیر مرکزی حساب‌های بانکی را در سیستم ایفا می‌کند. 


این کلاس با استفاده از یک لیست پویا، تمام حساب‌های ایجاد شده (اعم از حساب‌های پس‌انداز و جاری) را مدیریت می‌نماید.




🛠️ متدهای کلاس



1. افزودن حساب جدید (addAccount)




java
Copy
public void addAccount(BankAccount account) {
    accountsList.add(account);
    System.out.println("✅ حساب با شماره " + account.getAccountNumber() + " اضافه شد");
}



ویژگی‌ها:

پارامتر ورودی: شیء از نوع BankAccount (یا زیرکلاس‌های آن)
امکان افزودن همه انواع حساب‌ها (پس‌انداز/جاری)
چاپ پیام تایید با شماره حساب اضافه شده
مثال استفاده:



java
Copy
BankCustomers bank = new BankCustomers();
bank.addAccount(new SavingsAccount("SA123", "علی", 1_000_000));




2. نمایش موجودی همه حساب‌ها (showAllBalances)



java
Copy
public void showAllBalances() {
    System.out.println("\n📊 لیست موجودی حساب‌ها:");
    for (BankAccount account : accountsList) {
        System.out.printf(
            "شماره: %s | نام: %-15s | موجودی: %,15.2f تومان%n",
            account.getAccountNumber(),
            account.getAccountHolderName(),
            account.getBalance()
        );
    }
}
خروجی نمونه:


📊 لیست موجودی حساب‌ها:
شماره: SA123 | نام: علی             | موجودی:    1,000,000.00 تومان
شماره: TA456 | نام: رضا             | موجودی:    2,500,000.00 تومان


3. جستجوی حساب (findAccount)




java
Copy
public BankAccount findAccount(String accountNumber) {
    for (BankAccount account : accountsList) {
        if (account.getAccountNumber().equals(accountNumber)) {
            System.out.println("🔍 حساب پیدا شد: " + accountNumber);
            return account;
        }
    }
    System.out.println("❌ حساب با شماره " + accountNumber + " یافت نشد!");
    return null;
}



مکانیزم عملکرد:




جستجوی خطی در لیست حساب‌ها


مقایسه شماره حساب ورودی با شماره حساب‌های موجود


در صورت یافتن:

چاپ پیام موفقیت


برگرداندن شیء حساب مربوطه


در صورت عدم یافتن:


چاپ پیام خطا


برگرداندن null





##🎯حالا کلاس BankAccount:




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



##توضیحات مربوطه :





این یک کلاس انتزاعی (abstract) در جاوا است که نماینده یک حساب بانکی عمومی است و به عنوان پایه برای انواع خاص حساب‌های بانکی استفاده می‌شود.



ویژگی‌های اصلی کلاس:



متغیرهای شیء:


accountNumber (شماره حساب): یک رشته نهایی که یک بار مقداردهی می‌شود و تغییر نمی‌کند


accountHolderName (نام صاحب حساب): رشته قابل تغییر


balance (موجودی): یک مقدار عددی که در کلاس‌های فرزند می‌تواند به شکل‌های مختلفی استفاده شود


سازنده (Constructor):


سه پارامتر می‌گیرد: شماره حساب، نام صاحب حساب و موجودی اولیه


این مقادیر را به متغیرهای مربوطه اختصاص می‌دهد



متدهای انتزاعی:


calculateInterest(): یک متد انتزاعی که باید توسط کلاس‌های فرزند پیاده‌سازی شود تا سود حساب را محاسبه کند


متدهای عادی:



deposit(double amount): برای واریز پول به حساب


اگر مبلغ مثبت باشد، به موجودی اضافه می‌شود



اگر مبلغ منفی یا صفر باشد، پیغام خطا می‌دهد


withdraw(double amount): برای برداشت پول از حساب


بررسی می‌کند مبلغ معتبر باشد


بررسی می‌کند موجودی کافی باشد



در صورت صحت، مبلغ را از موجودی کم می‌کند



متدهای getter برای دسترسی به ویژگی‌های خصوصی:


getBalance()


getAccountNumber()


getAccountHolderName()





##کارکرد این کد در حالت کلی :



وظیفه اصلی: مدیریت لیست حساب‌های بانکی


قابلیت‌های کلیدی:


ذخیره تمام حساب‌ها در یک لیست


اضافه کردن حساب جدید به سیستم



نمایش اطلاعات همه حساب‌ها


جستجوی حساب بر اساس شماره حساب


متدهای مهم:


addAccount(حساب) ➝ حساب جدید را به لیست اضافه می‌کند


showAllBalances() ➝ موجودی همه حساب‌ها را نشان می‌دهد


findAccount(شماره حساب) ➝ یک حساب خاص را پیدا می‌کند




نحوه کار:


مثل یک دفترچه تلفن برای حساب‌های بانکی عمل می‌کند


همه حساب‌ها را در خود نگه می‌دارد


وقتی نیاز باشد، حساب مورد نظر را تحویل می‌دهد


خروجی‌های مهم:


لیست کامل حساب‌ها


نتیجه جستجوی حساب‌ها


تأییدیه اضافه شدن حساب جدید


مثال ساده:



یک حساب جدید می‌سازیم


آن را به BankCustomers اضافه می‌کنیم


وقتی خواستیم، می‌توانیم:


همه حساب‌ها را ببینیم


یک حساب خاص را پیدا کنیم


به زبان عامیانه:


این کلاس مثل یک مدیر بانک است که:



می‌داند هر حساب متعلق به کیست



می‌تواند گزارش کلی بدهد


می‌تواند اطلاعات یک حساب خاص را پیدا کند



در نهایت خروجی کد من به این شکل است :





حساب شماره SA001 اضافه شد


حساب شماره SA002 اضافه شد.


حساب شماره SA003 اضافه شد.


حساب شماره TA001 اضافه شد.


حساب شماره TA002 اضافه شد.


حساب شماره TA003 اضافه شد.

جستجوی حساب‌ها:


حساب پیدا شد: شماره SA002, نام: نگین حسینی, موجودی: 2000.0


حساب با شماره SA999 یافت نشد!

تغییر موجودی حساب:


موجودی اولیه: 1000.0


500.0 تومان به حساب شماره SA001 اضافه شد.


موجودی بعد از واریز: 1500.0



تلاش برای واریز مبلغ نادرست:


مبلغ واریزی نامعتبر است!



محاسبه سود حساب پس‌انداز:


45.0 تومان به حساب شماره SA001 اضافه شد.


سود حساب پس‌انداز به مبلغ 45.0 تومان محاسبه و واریز شد.


موجودی جدید: 1545.0


محاسبه سود حساب جاری:


حساب جاری سود ندارد!



برداشت از حساب جاری:


100.0 تومان از حساب جاری شماره TA001 برداشت شد.


مبلغ برداشتی نامعتبر است!


مبلغ درخواستی بیش از حد مجاز برداشت است!



برداشت از حساب پس‌انداز:



100.0 تومان از حساب پس‌انداز شماره SA001 برداشت شد.


مبلغ برداشتی نامعتبر است!


در حساب پس‌انداز نمی‌توان بیش از موجودی برداشت کرد!



وضعیت نهایی تمام حساب‌ها:



لیست تمام حساب‌ها:


شماره حساب: SA001, نام: فاطمه صدیق, موجودی: 1445.0


شماره حساب: SA002, نام: نگین حسینی, موجودی: 2000.0


شماره حساب: SA003, نام: زهرا محمدی, موجودی: 3000.0


شماره حساب: TA001, نام: پارسا کریمی, موجودی: 1400.0



شماره حساب: TA002, نام: امیر عباسی, موجودی: 2500.0



شماره حساب: TA003, نام: سارا جلالی, موجودی: 3500.0





