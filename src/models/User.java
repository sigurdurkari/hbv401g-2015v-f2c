package models;

public class User {
	
	private Integer userScore;
	private Integer financialStatus;
	private String rosterName;
	
	public User() {}

	public User(Integer userScore, Integer financialStatus, String rosterName) {
		this.userScore = userScore;
		this.financialStatus = financialStatus;
		this.rosterName = rosterName;
	}

	public Integer getUserScore() {
		return userScore;
	}

	public void setUserScore(Integer userScore) {
		this.userScore = userScore;
	}

	public Integer getFinancialStatus() {
		return financialStatus;
	}

	public void setFinancialStatus(Integer financialStatus) {
		this.financialStatus = financialStatus;
	}

	public String getRosterName() {
		return rosterName;
	}

	public void setRosterName(String rosterName) {
		this.rosterName = rosterName;
	}
	
	public void updateFinancialStatus(int diff) {
		setFinancialStatus(getFinancialStatus()+diff);
	}
	
	public boolean isBuyLegal() {
		return true;
	}
	
}
