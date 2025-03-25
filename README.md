# 🏦 سیستم بانکی شیءگرا (OOP Banking System)

یک پیاده‌سازی حرفه‌ای از سیستم بانکی با رعایت اصول SOLID و الگوهای طراحی پیشرفته

## 🏛️ معماری سیستم

```mermaid
classDiagram
    class BankAccount {
        <<abstract>>
        -String accountNumber
        -String accountHolderName
        -double balance
        +deposit(double amount)
        +withdraw(double amount)
        +calculateInterest()*
    }
    
    class BankCustomers {
        -ArrayList<BankAccount> accountsList
        +addAccount(BankAccount account)
        +showAllBalances()
        +findAccount(String accountNumber) BankAccount
    }
    
    BankAccount <|-- SavingsAccount
    BankAccount <|-- TransactionAccount
    BankCustomers "1" *-- "*" BankAccount
📦 کلاس‌های اصلی


🧾 BankAccount (کلاس پایه)

java
Copy
public abstract class BankAccount {
    private final String accountNumber;
    private String accountHolderName;
    protected double balance;
    
    // Constructor and methods...
}
👥 BankCustomers (مدیریت حساب‌ها)

java
Copy
public class BankCustomers {
    private ArrayList<BankAccount> accountsList = new ArrayList<>();
    
    public void addAccount(BankAccount account) {
        accountsList.add(account);
    }
    
    // Other methods...
}
✨ ویژگی‌های کلیدی

ویژگی	توضیح
🔐 کپسوله‌سازی	فیلدهای خصوصی + متدهای عمومی
🌐 ارث‌بری	رابطه Parent-Child بین کلاس‌ها
🎨 پلی‌مورفیسم	متدهای با رفتارهای مختلف
🏗️ انتزاع	کلاس‌ها و متدهای انتزاعی
🚀 نمونه کد اجرایی

java
Copy
// ایجاد سیستم بانکی
BankCustomers bank = new BankCustomers();

// ایجاد حساب‌ها
SavingsAccount saving = new SavingsAccount("SA001", "Ali", 10_000_000);
TransactionAccount trans = new TransactionAccount("TA001", "Reza", 5_000_000);

// افزودن به سیستم
bank.addAccount(saving);
bank.addAccount(trans);

// انجام عملیات
saving.deposit(2_000_000);
trans.withdraw(1_000_000);
📜 لیست متدهای اصلی

💰 BankAccount

deposit(amount) - واریز وجه
withdraw(amount) - برداشت وجه
calculateInterest() - محاسبه سود
🏢 BankCustomers

addAccount(account) - افزودن حساب
showAllBalances() - نمایش موجودی‌ها
findAccount(number) - جستجوی حساب
📊 گزارش نمونه

text
Copy
=== گزارش کلی حساب‌ها ===
شماره: SA001 | نام: Ali | موجودی: 12,300,000 تومان
شماره: TA001 | نام: Reza | موجودی: 4,000,000 تومان
<div align="center"> <img src="https://img.shields.io/badge/Java-17+-orange?style=for-the-badge" alt="Java 17+"> <img src="https://img.shields.io/badge/OOP-100%25-blue?style=for-the-badge" alt="Pure OOP"> <img src="https://img.shields.io/badge/SOLID-Compliant-green?style=for-the-badge" alt="SOLID Principles"> </div> ```
این فایل README.md را می‌توانید در گیت‌هاب با فرمت زیبا نمایش دهید. ویژگی‌های اصلی:

استایل‌دهی پیشرفته با استفاده از ایموجی‌ها و جداول
نمودار کلاس با Mermaid
کدهای فرمت‌شده با هایلایت سینتکس
بدج‌های (badges) برای نمایش وضعیت پروژه
ساختار منظم با هدرهای مختلف
برای نمایش بهتر در گیت‌هاب:

فایل را با نام README.md در ریشه پروژه قرار دهید
از Markdown viewer گیت‌هاب برای نمایش استفاده کنید
برای نمودارها نیاز به پشتیبانی گیت‌هاب از Mermaid دارید (که فعلاً دارد)
New chat
