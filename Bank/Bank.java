import java.util.Scanner;

class Account {
    protected String customerName;
    protected int accountNumber;
    protected String accountType;
    protected double balance;

    
    public Account(String name, int accNo, String accType, double initialBalance) {
        this.customerName = name;
        this.accountNumber = accNo;
        this.accountType = accType;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }
    
    public void displayBalance() {
        System.out.println("Account Holder: " + customerName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Current Balance: ₹" + balance);
    }
   
    public void withdraw(double amount) { }
}

class SavAcct extends Account {
    private static final double INTEREST_RATE = 0.05; 

    public SavAcct(String name, int accNo, double initialBalance) {
        super(name, accNo, "Savings", initialBalance);
    }

    
    public void computeAndDepositInterest(int years) {
        double interest = balance * Math.pow((1 + INTEREST_RATE), years) - balance;
        balance += interest;
        System.out.println("Interest of ₹" + String.format("%.2f", interest) + " added for " + years + " year(s).");
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            balance -= amount;
            System.out.println("Withdrawal of ₹" + amount + " successful.");
        }
    }
}


class CurAcct extends Account {
    private static final double MIN_BALANCE = 1000.0;
    private static final double SERVICE_CHARGE = 100.0;

    public CurAcct(String name, int accNo, double initialBalance) {
        super(name, accNo, "Current", initialBalance);
    }

    
    private void checkMinimumBalance() {
        if (balance < MIN_BALANCE) {
            balance -= SERVICE_CHARGE;
            System.out.println("Balance below minimum! ₹" + SERVICE_CHARGE + " service charge imposed.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            balance -= amount;
            System.out.println("Withdrawal of ₹" + amount + " successful.");
            checkMinimumBalance();
        }
    }
}


public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("----- Welcome to the Bank System -----");
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        System.out.print("Enter Account Type (1 for Savings / 2 for Current): ");
        int type = sc.nextInt();
        System.out.print("Enter Initial Deposit: ₹");
        double balance = sc.nextDouble();

        Account acc;

        if (type == 1)
            acc = new SavAcct(name, accNo, balance);
        else
            acc = new CurAcct(name, accNo, balance);

        int choice;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            if (acc instanceof SavAcct)
                System.out.println("4. Compute and Deposit Interest");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ₹");
                    acc.deposit(sc.nextDouble());
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    acc.withdraw(sc.nextDouble());
                    break;

                case 3:
                    acc.displayBalance();
                    break;

                case 4:
                    if (acc instanceof SavAcct) {
                        System.out.print("Enter number of years for interest calculation: ");
                        int years = sc.nextInt();
                        ((SavAcct) acc).computeAndDepositInterest(years);
                    } else {
                        System.out.println("Interest calculation not applicable for Current Account.");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using the Bank System!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}


    

