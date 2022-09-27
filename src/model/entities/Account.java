package model.entities;

import model.entities.enums.Person;

public abstract class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Person withdrawLimit;
	private Person loanLimit;
	private Person interestRate;
	
	public Account() {}

	public Account(Integer number, String holder, Double balance) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
	}

	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getHolder() {
		return holder;
	}
	public void setHolder(String holder) {
		this.holder = holder;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Person getWithdrawLimit() {
		return withdrawLimit;
	}
	
	public Person getLoanLimit() {
		return loanLimit;
	}
	public void setLoanLimit(Person loanLimit) {
		this.loanLimit = loanLimit;
	}
	public Person getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(Person interestRate) {
		this.interestRate = interestRate;
	}

	public abstract Double withdrawLimit();
	public abstract void deposit(Double amount);
	public abstract void withdraw(Double amount);
	public abstract void validateWithdraw(double withdraw);

	
	



	
}
