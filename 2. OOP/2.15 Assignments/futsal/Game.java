package futsal;

public class Game {
	private Team homeTeam;
	private Team awayTeam;
	boolean gamePlayed;
	private String homeScore;
	private String awayScore;

	Game() {};

	Game(Team homeTeam, String homeScore, String awayScore, Team awayTeam, boolean gamePlayed) {
		this.homeTeam = homeTeam;
		this.homeScore = homeScore;
		this.awayScore = awayScore;
		this.awayTeam = awayTeam;
		this.gamePlayed = gamePlayed;
	}

	public void setHomeScore(String homeScore) {
		this.homeScore = homeScore;
	}

	public void setAwayScore(String awayScore) {
		this.awayScore = awayScore;
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}

	public void setGamePlayed(boolean gamePlayed) {
		this.gamePlayed = gamePlayed;
	}

	public String getHomeScore() {
		return this.homeScore;
	}

	public String getAwayScore() {
		return this.awayScore;
	}

	public Team getHomeTeam() {
		return homeTeam;
	}

	public Team getAwayTeam() {
		return awayTeam;
	}

	public boolean getGamePlayed() {
		return gamePlayed;
	}

	public String calcResult() {

		if (Integer.parseInt(getHomeScore()) > Integer.parseInt(getAwayScore())) {
			return getHomeTeam().getTeamName() + " won!";
		} else if (Integer.parseInt(getHomeScore()) < Integer.parseInt(getAwayScore())) {
			return getAwayTeam().getTeamName() + " won!";
		} else if (Integer.parseInt(getHomeScore()) == Integer.parseInt(getAwayScore())) {
			if (Integer.parseInt(getHomeScore()) <= 1) {
				return "A boring draw...";
			} else {
				return "Great game for neutral supporters, but the match ended in a draw";
			}
		} else {
			return "Sadly, the match was postponed";
		}
	}

	public String printGame() {
		String gameInfo;
		if (!getGamePlayed()) {
			gameInfo = getHomeTeam().getTeamName() + " : " + getAwayTeam().getTeamName() + "\nGame is yet to be played!";
		} else {
			gameInfo = getHomeTeam().getTeamName() + " " + getHomeScore() + " : " + getAwayScore() + " " + getAwayTeam().getTeamName() + "\n" + calcResult();
		}

		return "----------------------------------------------------------------\n" + gameInfo;
	}

}

