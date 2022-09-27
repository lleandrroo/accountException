package model.entities;

import model.entities.enums.Person;
import model.exception.DomainException;

public class SavingsAccount extends Account{

	public SavingsAccount() {
		super();
	}
	
	public SavingsAccount(Integer number, String holder, Double balance) {
		super(number, holder, balance);
	}


	public void deposit(Double amount) {
		setBalance(getBalance() + amount);
	}
	
	@Override
	public void withdraw(Double amount) {
		validateWithdraw(amount);
		setBalance(getBalance() - amount - Person.PP.getTaxWithdraw());
	}
	

	public Double withdrawLimit() {
		Person withdraw = Person.PP;
		return withdraw.getLimitWithdraw();
	}

	/*@Override
	public String validateWithdraw(double amount) {
		if (amount > withdrawLimit()) {
			return "Error withdraw: Amount over withdraw (Limit = )" + getLoanLimit();
		}else if (amount > getBalance()){
			return "Erro withdraw: Insufficient balance (Limit = )" + getLoanLimit();
		}
		return null;
	}
	*/
	@Override
	public void validateWithdraw(double amount) {
		if (amount > withdrawLimit()) {
			throw new DomainException("Error withdraw: Amount over withdraw");
		}
		if (amount > getBalance()) {
			throw new DomainException("Erro withdraw: Insufficient balance");
		}		
	}
}
