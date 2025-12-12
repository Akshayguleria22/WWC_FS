public class Main {
    public static void main(String[] args) {
        BankAccount checkingAccount = new BankAccount("CHK-001", "Alice Johnson", 500.0);

        SavingsAccount savingsAccount = new SavingsAccount("SAV-001", "Bob Smith", 1000.0, 0.03);

        System.out.println("Initial account details:");
        checkingAccount.printAccountDetails();
        savingsAccount.printAccountDetails();
        checkingAccount.deposit(200.0);
        checkingAccount.withdraw(150.0);
        savingsAccount.deposit(300.0);
        savingsAccount.withdraw(500.0); 
        savingsAccount.withdraw(2000.0); 
        savingsAccount.applyInterest();

        System.out.println("\nFinal account details:");
        checkingAccount.printAccountDetails();
        savingsAccount.printAccountDetails();
    }
}
