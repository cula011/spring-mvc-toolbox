package org.cula011.spring.mvc.model;

public class SandpitData 
{
	String accountName;
	Long accountId;
	boolean directDebit;
	
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public boolean getDirectDebit() {
		return directDebit;
	}
	public void setDirectDebit(boolean directDebit) {
		this.directDebit = directDebit;
	}
}
