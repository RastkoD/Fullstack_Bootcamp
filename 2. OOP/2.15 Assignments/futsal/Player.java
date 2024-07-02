package futsal;

public class Player {
	private String name;
	private String surname;
	private String id;
	private Team playsForTeam;

	Player() {};

	Player(String name, String surname, String id, Team playsForTeam) {
		this.name = name;
		this.surname = surname;
		this.id = id;
		this.playsForTeam = playsForTeam;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setID(String id) {
		this.id = id;
	}

	public void setPlaysForTeam(Team playsForTeam) {
		this.playsForTeam = playsForTeam;
	}

	public String getName() {
		return this.name;
	}

	public String getSurname() {
		return this.surname;
	}

	public String getID() {
		return this.id;
	}

	public Team getPlayersForTeam() {
		return this.playsForTeam;
	}

	public String printPlayer() {
		return getName() + " " + getSurname() + "(id:" + getID() + ")" + ", team: " + getPlayersForTeam().getTeamName();
	}
}
