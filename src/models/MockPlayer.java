package models;

public class MockPlayer {
	
	private String name;
	private String team;
	private PlayerPosition position;
	private Integer price;
	private Integer[] scores = new Integer[10];
	
	public MockPlayer() {}
	
	public MockPlayer(String name, String team, PlayerPosition position, Integer price) {
		this.name = name;
		this.team = team;
		this.position = position;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public PlayerPosition getPosition() {
		return position;
	}

	public void setRole(PlayerPosition position) {
		this.position = position;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer[] getScores() {
		return scores;
	}

	public void setScores(Integer[] scores) {
		this.scores = scores;
	}
	
	public void scoreForWeek(int week, Integer score) {
		this.scores[week] = score;
	}
}
