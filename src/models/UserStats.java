package models;

import java.util.*;

public class UserStats {
	
	private List<PlayerStats> playerStats = new ArrayList<>();
	private Integer[] scoreByRound = new Integer[10];
	private Integer totalScore = 0;
	
	public UserStats() {
		for(int i=0; i<10; i++) {
			scoreByRound[i] = 0;
		}
	}
	
	public static class PlayerStats {
		private MockPlayer player;
		private String[] stats = new String[10];
		private String totalScore = "0";
		
		public PlayerStats(MockPlayer player) {
			this.player = player;
			for(int i=0; i<10; i++) {
				stats[i] = "";
			}
		}

		public MockPlayer getPlayer() {
			return player;
		}

		public void setPlayer(MockPlayer player) {
			this.player = player;
		}

		public String[] getStats() {
			return stats;
		}

		public void setStats(String[] stats) {
			this.stats = stats;
		}
		
		public void setWeekStats(int round, String stat) {
			this.stats[round-1] = stat;
		}

		public Integer getTotalScore() {
			return Integer.parseInt(totalScore);
		}
		
		public String getTotalScoreString() {
			return totalScore;
		}

		public void setTotalScore(Integer totalScore) {
			this.totalScore = "" + totalScore;
		}
		
		public void setTotalScore(String totalScore) {
			this.totalScore = totalScore;
		}
		
		public void updateScore(Integer roundScore) {
			totalScore = "" + (Integer.parseInt(totalScore)+roundScore);
		}
	}

	public Integer[] getScoreByRound() {
		return scoreByRound;
	}

	public void setScoreByRound(Integer[] scoreByRound) {
		this.scoreByRound = scoreByRound;
	}
	
	public void setRoundScore(int round, Integer score) {
		this.scoreByRound[round-1] = score;
	}

	public List<PlayerStats> getPlayerStats() {
		return playerStats;
	}

	public void setPlayerStats(List<PlayerStats> playerStats) {
		this.playerStats = playerStats;
		sort();
	}
	
	public void addPlayerStat(PlayerStats playerStat) {
		this.playerStats.add(playerStat);
		sort();
	}
	
	public Integer getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}

	public boolean containsPlayer(MockPlayer player) {
		for(PlayerStats p : playerStats) {
			if(p.getPlayer().equals(player)) return true;
		}
		return false;
	}
	
	public PlayerStats getPlayer(MockPlayer player) {
		if(containsPlayer(player)) {
			for(PlayerStats p : playerStats) {
				if(p.getPlayer().equals(player)) return p;
			}
		}
		return new PlayerStats(new MockPlayer());
	}
	
	public void updateUserStats(Roster roster, int round) {
		for(MockPlayer p : roster.getPlayers()) {
			updatePlayerStats(p, round, roster.getSubs().contains(p), roster.getCaptain().equals(p));
		}
		for(PlayerStats pStats : playerStats) {
			if(!roster.getPlayers().contains(pStats.getPlayer())) {
				pStats.setWeekStats(round, "-");
			}
		}
		sort();
	}
	
	public void updatePlayerStats(MockPlayer player, int round, boolean sub, boolean captain) {
		if(containsPlayer(player)) {
			PlayerStats p = getPlayer(player);
			if(sub) {
				p.setWeekStats(round, "sub");
			} else if(captain) {
				p.setWeekStats(round, "" + 2*player.getScores()[round-1]);
				p.updateScore(2*player.getScores()[round-1]);
				scoreByRound[round-1] += 2*player.getScores()[round-1];
				totalScore += 2*player.getScores()[round-1];
			} else {
				p.setWeekStats(round, "" + player.getScores()[round-1]);
				p.updateScore(player.getScores()[round-1]);
				scoreByRound[round-1] += player.getScores()[round-1];
				totalScore += player.getScores()[round-1];
			}
		} else {
			PlayerStats p = new PlayerStats(player);
			for(int i=1; i<round; i++) {
				p.setWeekStats(i, "-");
			}
			if(sub) {
				p.setWeekStats(round, "sub");
			} else if(captain) {
				p.setWeekStats(round, "" + 2*player.getScores()[round-1]);
				p.updateScore(2*player.getScores()[round-1]);
				scoreByRound[round-1] += 2*player.getScores()[round-1];
				totalScore += 2*player.getScores()[round-1];
			} else {
				p.setWeekStats(round, "" + player.getScores()[round-1]);
				p.updateScore(player.getScores()[round-1]);
				scoreByRound[round-1] += player.getScores()[round-1];
				totalScore += player.getScores()[round-1];
			}
			addPlayerStat(p);
		}
		sort();
	}
	
	public void updateStatsForSoldPlayers(List<MockPlayer> rosterPlayers, int round) {
		for(PlayerStats p : playerStats) {
			if(!rosterPlayers.contains(p.player)) {
				p.setWeekStats(round, "-");
			}
		}
	}
	
	public void sort() {
		Collections.sort(playerStats, new Comparator<PlayerStats>() {
			@Override
			public int compare(PlayerStats lhs, PlayerStats rhs) {
				return -lhs.getTotalScore().compareTo(rhs.getTotalScore());
			}
		});
	}

}
