package futsal;

public class Team {
	private String teamName;
	private String city;
	private int numberOfPlayers;

	Team() {};

	public Team(String teamName, String city, int numOfPlayers) {
		this.teamName = teamName;
		this.city = city;
		this.numberOfPlayers = numOfPlayers;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	public String getTeamName() {
		return this.teamName;
	}

	public String getCity() {
		return this.city;
	}

	public int getNumberOfPlayers() {
		return this.numberOfPlayers;
	}

	public String printTeam() {
		return getTeamName() + " from " + getCity();
	}
}
