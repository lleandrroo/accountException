package model.entities;

import model.entities.enums.Person;
import model.exception.DomainException;

public class BusinessAccount extends Account{
	public BusinessAccount() {
		super();
	}

	public BusinessAccount(Integer number, String holder, Double balance) {
		super(number, holder, balance);
	}
	

	public void deposit(Double amount) {
		setBalance(getBalance() + amount);
	}
	
	@Override
	public void withdraw(Double amount) {
		validateWithdraw(amount);
		setBalance(getBalance() - amount - Person.PL.getTaxWithdraw());
	}
	
	@Override
	public Double withdrawLimit() {
		Person withdraw = Person.PL;
		return withdraw.getLimitWithdraw();
	}

	/*
	 * @Override
	public String validateWithdraw(double amount) {
		if (amount > getWithdrawLimit().getTaxWithdraw()) {
			return "Error withdraw: Amount over withdraw (Limit = )" + getLoanLimit();
		}else if (amount > getBalance()){
			return "Erro withdraw: Insufficient balance (Limit = )" + getLoanLimit();
		}
		return null;
	}
	*/
	
	public void validateWithdraw(double amount) {
		if (amount > withdrawLimit()) {
			throw new DomainException("Error withdraw: Amount over withdraw");
		}
		if (amount > getBalance()) {
			throw new DomainException("Erro withdraw: Insufficient balance");
		}		
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Number: " + getNumber() + "\n");
		sb.append("Hoder: " + getHolder() + "\n");
		sb.append("Balance: " + getBalance() + "\n");
		sb.append("Withdraw Limit: " + getWithdrawLimit() + "\n");
		sb.append("Interest Rate: " + getInterestRate() + "\n");
		sb.append("Loan Limit: " + getLoanLimit() + "\n");
		return sb.toString();
		
	}

}
