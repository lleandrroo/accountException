package model.entities.enums;

public enum Person {
	PP(1, 5.35, 3000.00, 0.15 ), 
	PL(2, 6.00, 15000.00, 0.17);

	private final int value;
	private final double taxWithdraw;
	private final double LimitWithdraw;
	private final double taxLoan;
	
	Person(int value, double taxWithdraw, double LimitWithdraw, double taxLoan) {
		this.value = value;
		this.taxWithdraw = taxWithdraw;
		this.LimitWithdraw = LimitWithdraw;
		this.taxLoan = taxLoan;
	}

	public int getValue() {
		return value;
	}
	
	public double getTaxLoan() {
		return taxLoan;
	}

	public double getTaxWithdraw() {
		return taxWithdraw;
	}

	public double getLimitWithdraw() {
		return LimitWithdraw;
	}
	
	
}
