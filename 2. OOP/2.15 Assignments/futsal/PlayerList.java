package futsal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PlayerList {
	private ArrayList<Player> players;

	public PlayerList() {
		this.players = new ArrayList<>();
	}

	public void addPlayer(Player player) {
		if (findPlayer(player.getID()) == null) {
			players.add(player);
			System.out.println("----------------------------------------------------------------");
			System.out.println("Player " + player.getName() + " " + player.getSurname() + " added");
			System.out.println("----------------------------------------------------------------");
		} else {
			System.out.println("----------------------------------------------------------------");
			System.out.println("Player " + player.getName() + " " + player.getSurname() + " already exists");
			System.out.println("----------------------------------------------------------------");
		}

	}

	public void deletePlayer(String name) {
		Player playerToDelete = findPlayer(name);
		if (playerToDelete != null) {
			players.remove(playerToDelete);
			System.out.println("----------------------------------------------------------------");
			System.out.println("Player " + playerToDelete.getName() + " " + playerToDelete.getSurname() + " deleted");
			System.out.println("----------------------------------------------------------------");
		} else {
			System.out.println("----------------------------------------------------------------");
			System.out.println("Player not found");
			System.out.println("----------------------------------------------------------------");
		}
	}
	public Player findPlayer(String name) {
		for (Player player : players) {
			if (player.getName().equals(name)) {
				return player;
			}
		}

		return null;
	}

	public void printPlayers() {
		System.out.println("----------------------------------------------------------------");
		System.out.println("List of Players:");
		System.out.println("----------------------------------------------------------------");
		for (Player player : players) {
			System.out.println(player.printPlayer());
		}
	}

	public void loadPlayersFromFile(String filename, TeamList teamList) {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(" ");
				String name = parts[0];
				String surname = parts[1];
				String id = parts[2];
				String teamName = parts[3];

				Team playsForTeam = teamList.findTeam(teamName);
				if (playsForTeam != null) {
					Player player = new Player(name, surname, id, playsForTeam);
					addPlayer(player);
				} else {
					System.out.println("----------------------------------------------------------------");
					System.out.println("Team not found for player: " + name + " " + surname);
					System.out.println("----------------------------------------------------------------");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	 public ArrayList<Player> getPlayers() {
	        return players;
	    }
}
