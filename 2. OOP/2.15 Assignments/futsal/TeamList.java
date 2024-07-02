package futsal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TeamList {
	private ArrayList<Team> teams;

	public TeamList() {
		this.teams = new ArrayList<>();
	}

	public void addTeam(Team team) {
		if (findTeam(team.getTeamName()) == null) {
			teams.add(team);
			System.out.println("----------------------------------------------------------------");
			System.out.println("Team " + team.getTeamName() + " added");
			System.out.println("----------------------------------------------------------------");
		} else {
			System.out.println("----------------------------------------------------------------");
			System.out.println("Team " + team.getTeamName() + " already exists");
			System.out.println("----------------------------------------------------------------");
		}
	}

	public void deleteTeam(String teamName) {
		Team teamToDelete = findTeam(teamName);
		if (teamToDelete != null) {
			teams.remove(teamToDelete);
			System.out.println("----------------------------------------------------------------");
			System.out.println("Team " + teamName + " deleted");
			System.out.println("----------------------------------------------------------------");
		} else {
			System.out.println("----------------------------------------------------------------");
			System.out.println("Team " + teamName + " not found");
			System.out.println("----------------------------------------------------------------");
		}
	}

	public Team findTeam(String teamName) {
		for (Team team : teams) {
			if (team.getTeamName().equals(teamName)) {
				return team;
			}
		}
		return null;
	}

	public void printTeams() {
		System.out.println("----------------------------------------------------------------");
		System.out.println("List of Teams:");
		System.out.println("----------------------------------------------------------------");
		for (Team team : teams) {
			System.out.println(team.printTeam());
		}
	}
	
	public void loadTeamsFromFile(String filename) {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(" ");
				String teamName = parts[0];
				String city = parts[1];
				int numberOfPlayers = Integer.parseInt(parts[2]);

				Team team = new Team(teamName, city, numberOfPlayers);
				addTeam(team);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public double calcTotalTeamsFund(double teamFeePerTeam, double playerFeePerPlayer) {
	    double totalFund = 0.0;

	    for (Team team : teams) {
	        totalFund += teamFeePerTeam;

	        totalFund += team.getNumberOfPlayers() * playerFeePerPlayer;
	    }

	    return totalFund;
	}

}
