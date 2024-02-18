package bank;

public class Account {
	private int accNumber;
	private float accBalance;
	private boolean isActive;
	private String currency;
	
	public Account(int accNumber, float accBalance, boolean isActive, String currency) {
		this.accNumber = accNumber;
		this.accBalance = accBalance;
		this.isActive = isActive;
		this.currency = currency;
	}
	
	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}
	
	public void setAccBalance(float accBalance) {
		this.accBalance = accBalance;
	}
	
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public int getAccNumber() {
		return this.accNumber;
	}
	
	public float getAccBalance() {
		return this.accBalance;
	}
	
	public boolean getIsActive() {
		return this.isActive;
	}
	
	public String getCurrency() {
		return this.currency;
	}
}
