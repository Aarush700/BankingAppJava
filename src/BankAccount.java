import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BankAccount {
    private int balance;
    private List<Transaction> transactionList;
    private String customerName;
    private String customerId;

    BankAccount(String cName, String cId) {
        customerName = cName;
        customerId = cId;
        balance = 0;
        transactionList = new ArrayList<>();
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            transactionList.add(new Transaction(amount, "Deposit"));
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(int amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                transactionList.add(new Transaction(amount, "Withdrawal"));
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public void showTransactions() {
        System.out.println("Transaction History:");
        for (Transaction transaction : transactionList) {
            System.out.println(transaction);
        }
    }

    public void calculateInterest(double rate) {
        double interest = balance * (rate / 100);
        balance += interest;
        transactionList.add(new Transaction(interest, "Interest"));
        System.out.println("Interest added: " + interest);
    }

    public String getCustomerId() {
        return customerId;
    }

    public void showMenu() {
        char option;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("Your Id is " + customerId + "\n");

        do {
            System.out.println("=====================================================");
            System.out.println("A. Check Balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. View Transaction History");
            System.out.println("E. Calculate Interest");
            System.out.println("F. Exit");
            System.out.println("=====================================================");
            System.out.println("Enter an option: ");
            option = scanner.next().charAt(0);

            switch (option) {
                case 'A':
                    System.out.println("--------------------------------");
                    System.out.println("Balance = " + balance);
                    System.out.println("--------------------------------\n");
                    break;
                case 'B':
                    System.out.println("--------------------------------");
                    System.out.println("Enter an amount to deposit: ");
                    int depositAmount = scanner.nextInt();
                    deposit(depositAmount);
                    System.out.println("--------------------------------\n");
                    break;
                case 'C':
                    System.out.println("--------------------------------");
                    System.out.println("Enter an amount to withdraw: ");
                    int withdrawAmount = scanner.nextInt();
                    withdraw(withdrawAmount);
                    System.out.println("--------------------------------\n");
                    break;
                case 'D':
                    System.out.println("--------------------------------");
                    showTransactions();
                    System.out.println("--------------------------------\n");
                    break;
                case 'E':
                    System.out.println("--------------------------------");
                    System.out.println("Enter the interest rate: ");
                    double interestRate = scanner.nextDouble();
                    calculateInterest(interestRate);
                    System.out.println("--------------------------------\n");
                    break;
                case 'F':
                    System.out.println("*********************************");
                    break;
                default:
                    System.out.println("Invalid Option!!. Please Enter again");
                    break;
            }
        } while (option != 'F');

        System.out.println("Thank you for using our services.");
    }
}
