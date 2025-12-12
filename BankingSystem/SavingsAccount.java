public class SavingsAccount extends BankAccount {
    private double interestRate; // e.g., 0.03 for 3%

    public SavingsAccount(String accountNumber, String accountHolderName, double initialBalance, double interestRate) {
        super(accountNumber, accountHolderName, initialBalance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate;
        if (interest > 0) {
            deposit(interest);
            System.out.println("Interest applied: " + interest);
        } else {
            System.out.println("No interest applied. Balance is non-positive.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }

        if (amount > getBalance()) {
            System.out.println("Withdrawal denied. Cannot withdraw more than available balance.");
            return;
        }
        super.withdraw(amount);
    }
}
