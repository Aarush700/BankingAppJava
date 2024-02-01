import java.util.ArrayList;
import java.util.List;

class Bank {
    private List<BankAccount> accounts;

    Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public BankAccount findAccountById(String id) {
        for (BankAccount account : accounts) {
            if (account.getCustomerId().equals(id)) {
                return account;
            }
        }
        return null; // Account not found
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

}
