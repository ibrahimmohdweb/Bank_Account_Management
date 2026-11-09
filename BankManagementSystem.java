import java.util.HashMap;
import java.util.Scanner;

public class BankManagementSystem {

    static HashMap<Integer, BankAccount> accounts = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Bank Account Management System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositAmount();
                    break;
                case 3:
                    withdrawAmount();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    System.out.println("Thank you for using the system.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    static void createAccount() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        BankAccount account = new BankAccount(accNo, name, balance);
        accounts.put(accNo, account);

        System.out.println("Account created successfully.");
    }

    static void depositAmount() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        BankAccount account = accounts.get(accNo);
        if (account != null) {
            System.out.print("Enter amount to deposit: ");
            double amount = sc.nextDouble();
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    static void withdrawAmount() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        BankAccount account = accounts.get(accNo);
        if (account != null) {
            System.out.print("Enter amount to withdraw: ");
            double amount = sc.nextDouble();
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    static void checkBalance() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        BankAccount account = accounts.get(accNo);
        if (account != null) {
            System.out.println("Account Holder: " + account.getAccountHolder());
            System.out.println("Balance: ₹" + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }
}
