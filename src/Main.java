public class Main {
    public static void main(String[] args) {
        // Create a bank
        Bank bank = new Bank();

        // Create and add accounts to the bank
        BankAccount account1 = new BankAccount("John Doe", "123");
        BankAccount account2 = new BankAccount("Jane Smith", "456");

        bank.addAccount(account1);
        bank.addAccount(account2);

        // Interact with accounts
        account1.showMenu(); // Show menu for account 1
        account2.showMenu(); // Show menu for account 2
    }
}
