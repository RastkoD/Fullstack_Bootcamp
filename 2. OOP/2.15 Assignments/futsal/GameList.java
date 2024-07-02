package futsal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GameList {
	ArrayList<Game> games;

	public GameList() {
		this.games = new ArrayList<>();
	}

	public void addGame(Game game) {
		games.add(game);
		System.out.println("----------------------------------------------------------------");
		System.out.println("Game between " + game.getHomeTeam().getTeamName() +
				" and " + game.getAwayTeam().getTeamName() + " added");
		System.out.println("----------------------------------------------------------------");
	}

	public void deleteGame(String homeTeamName, String awayTeamName) {
		Game gameToDelete = findGame(homeTeamName, awayTeamName);
		if (gameToDelete !=null) {
			games.remove(gameToDelete);
			System.out.println("----------------------------------------------------------------");
			System.out.println("Game between " + homeTeamName + " and " + awayTeamName + " deleted");
			System.out.println("----------------------------------------------------------------");
		} else {
			System.out.println("----------------------------------------------------------------");
			System.out.println("Game between " + homeTeamName + " and " + awayTeamName + " not found");
			System.out.println("----------------------------------------------------------------");
		}
	}

	public Game findGame(String homeTeamName, String awayTeamName) {
		for (Game game : games) {
			if (game.getHomeTeam().getTeamName().equals(homeTeamName) &&
					game.getAwayTeam().getTeamName().equals(awayTeamName)) {
				return game;
			}
		}

		return null;
	}

	public void printGames() {
		System.out.println("----------------------------------------------------------------");
		System.out.println("List of Games:");
		System.out.println("----------------------------------------------------------------");
		for (Game game : games) {
			System.out.println(game.printGame());
		}
	}
	
	public ArrayList<Game> getGames() {
        return games;
    }

	public void writeGamesToFile(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Game game : getGames()) {
                String line = String.format("%s %s : %s %s, was played(%s)%n",
                        game.getHomeTeam().getTeamName(),
                        game.getHomeScore(),
                        game.getAwayScore(),
                        game.getAwayTeam().getTeamName(),
                        game.getGamePlayed());
                bw.write(line);
            }
            System.out.println("Games successfully written to file: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
