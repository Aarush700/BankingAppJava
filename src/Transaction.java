class Transaction {
    private double amount;
    private String type;

    Transaction(double amount, String type) {
        this.amount = amount;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Type: " + type + ", Amount: " + amount;
    }
}
