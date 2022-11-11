public class CheckingAccount extends BankAccount{
	final static double FEE = 0.15;
	
	CheckingAccount(String name, double amount){
		super(name, amount);
		super.setAccountNumber("-10");
	}
	
	@Override
	public boolean withdraw(double amount) {
		double totalAmount = FEE + amount;
		return super.withdraw(totalAmount);
	}
}
