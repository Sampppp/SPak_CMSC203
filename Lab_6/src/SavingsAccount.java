public class SavingsAccount extends BankAccount {
	
	private double rate = 2.5;
	private int savingsNumber = 0;
	private String accountNumber;

	public SavingsAccount(String name, double amount) {
		super(name, amount);
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}

	public void postInterest() {
		double interest = getBalance() * (rate / 1200);
		deposit(interest);
	}

	@Override
	public String getAccountNumber() {
		return accountNumber;
	}

	public SavingsAccount(SavingsAccount account, double balance) {
		super(account, balance);
		savingsNumber++;
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}
}
