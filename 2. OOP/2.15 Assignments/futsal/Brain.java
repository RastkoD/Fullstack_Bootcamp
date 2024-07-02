package futsal;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Brain {
	Scanner scanner = new Scanner(System.in);
	int choice = 0;
	private TeamList teamList;
	private PlayerList playerList;
	private GameList gameList;

	public Brain() {
		this.teamList = new TeamList();
		this.playerList = new PlayerList();
		this.gameList = new GameList();
	}

	public void setTeamList(TeamList teamList) {
		this.teamList = teamList;
	}

	public void setPlayerList(PlayerList playerList) {
		this.playerList = playerList;
	}

	public void setPlayerList(GameList gameList) {
		this.gameList = gameList;
	}

	public TeamList getTeamList() {
		return this.teamList;
	}

	public PlayerList getPlayerList() {
		return this.playerList;
	}

	public GameList getGameList() {
		return gameList;
	}

	public void menu() throws IOException {
		do {
			System.out.println("Futsal Manager 2024");
			System.out.println("---------------------- MENU ---------------------");
			System.out.println("1. Manage Teams");
			System.out.println("2. Manage Players");
			System.out.println("3. Manage Games");
			System.out.println("4. Show Prizes");
			System.out.println("5. Exit");

			try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Enter a valid number");
                scanner.nextLine();
                choice = 0;
            }

            if (choice == 1) {
                manageTeams();
            } else if (choice == 2) {
                managePlayers();
            } else if (choice == 3) {
                manageGames();
            } else if (choice == 4) {
            	calcFundAndPrizes();
            } else if  (choice == 5) {
                System.out.println("----------------------------------------------------------------");
                System.out.println("Thank you for using the program");
                System.out.println("----------------------------------------------------------------");
            } else {
                System.out.println("----------------------------------------------------------------");
                System.out.println("Unknown option. Please choose again");
                System.out.println("----------------------------------------------------------------");
            }

        } while (choice != 5);
	}

	public void manageTeams() {
		int teamMenuChoice = 0;
		do {
			System.out.println("-------- Team Management --------");
			System.out.println("1. Load Teams from a File");
			System.out.println("2. Add Team");
			System.out.println("3. Delete Team");
			System.out.println("4. Search Team");
			System.out.println("5. Print Teams");
			System.out.println("6. Back to Main Menu");

			try {
				teamMenuChoice = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Enter a valid number");
				scanner.nextLine();
				teamMenuChoice = 0;
			}

			if (teamMenuChoice == 1) {
				teamList.loadTeamsFromFile("timovi.txt");
			}else if (teamMenuChoice == 2) {
				addTeam();
			} else if (teamMenuChoice == 3) {
				deleteTeam();
			} else if (teamMenuChoice == 4) {
				searchTeam();
			} else if (teamMenuChoice == 5) {
				teamList.printTeams();
			} else if  (teamMenuChoice == 6) {
				System.out.println("----------------------------------------------------------------");
				System.out.println("Returning to the main menu");
				System.out.println("----------------------------------------------------------------");
			} else {
				System.out.println("----------------------------------------------------------------");
				System.out.println("Unknown option. Please choose again");
				System.out.println("----------------------------------------------------------------");
			}

		} while (teamMenuChoice != 6);
	}

	public void managePlayers() {
		int playersMenuChoice = 0;
		do {
			System.out.println("-------- Player Management --------");
			System.out.println("1. Load Players from a File");
			System.out.println("2. Add Player");
			System.out.println("3. Delete Player");
			System.out.println("4. Search Player");
			System.out.println("5. Print Players");
			System.out.println("6. Back to Main Menu");

			try {
				playersMenuChoice = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("----------------------------------------------------------------");
				System.out.println("Enter a valid number");
				System.out.println("----------------------------------------------------------------");
				scanner.nextLine();
				playersMenuChoice = 0;
			}

			if (playersMenuChoice == 1) {
				playerList.loadPlayersFromFile("igraci.txt", teamList);
			} else if (playersMenuChoice == 2) {
				addPlayer();
			} else if (playersMenuChoice == 3) {
				deletePlayer();
			} else if (playersMenuChoice == 4) {
				searchPlayer();
			} else if (playersMenuChoice == 5) {
				playerList.printPlayers();
			} else if  (playersMenuChoice == 6) {
				System.out.println("----------------------------------------------------------------");
				System.out.println("Returning to the main menu");
				System.out.println("----------------------------------------------------------------");
			} else {
				System.out.println("----------------------------------------------------------------");
				System.out.println("Unknown option. Please choose again");
				System.out.println("----------------------------------------------------------------");
			}

		} while (playersMenuChoice != 6);
	}

	public void manageGames() {
		int gameMenuChoice = 0;
		do {
			System.out.println("-------- Game Management --------");
			System.out.println("1. Add Game");
			System.out.println("2. Delete Game");
			System.out.println("3. Search Game");
			System.out.println("4. Print Games");
			System.out.println("5. Save Games to a File");
			System.out.println("6. Back to Main Menu");

			try {
				gameMenuChoice = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("----------------------------------------------------------------");
				System.out.println("Enter a valid number");
				scanner.nextLine();
				gameMenuChoice = 0;
			}

			if (gameMenuChoice == 1) {
				addGame();
			} else if (gameMenuChoice == 2) {
				deleteGame();
			} else if (gameMenuChoice == 3) {
				searchGame();
			} else if (gameMenuChoice == 4) {
				gameList.printGames();
			} else if  (gameMenuChoice == 5) {
				gameList.writeGamesToFile("utakmice.txt");
			} else if  (gameMenuChoice == 6) {
				System.out.println("----------------------------------------------------------------");
				System.out.println("Returning to the main menu");
				System.out.println("----------------------------------------------------------------");
			} else {
				System.out.println("----------------------------------------------------------------");
				System.out.println("Unknown option. Please choose again");
				System.out.println("----------------------------------------------------------------");
			}

		} while (gameMenuChoice != 6);
	}


	public void addTeam() {
		System.out.println("Enter team name(format: SportingCP, StokeCity)");
		String teamName = scanner.next();
		System.out.println("Enter city(format: NewYork)");
		String city = scanner.next();
		System.out.println("Enter number of players");
		int numberOfPlayers = scanner.nextInt();

		Team team = new Team(teamName, city, numberOfPlayers);

		teamList.addTeam(team);
	}

	public void deleteTeam() {
		System.out.println("Enter team name to delete(format: WestHam, RedBull)");
		String team = scanner.next();
		teamList.deleteTeam(team);
	}

	public void searchTeam() {
		System.out.println("Enter team name to search(format: AlIttihad, St.Mirren)");
		String team = scanner.next();

		Team searchedTeam = teamList.findTeam(team);
		if (searchedTeam != null) {
			System.out.println("----------------------------------------------------------------");
	        System.out.println(searchedTeam.printTeam());

	        System.out.println("Players of the team:");
	        for (Player player : playerList.getPlayers()) {
	            if (player.getPlayersForTeam().equals(searchedTeam)) {
	                System.out.println(player.printPlayer());
	            }
	        }
	        System.out.println("----------------------------------------------------------------");
	    } else {
	        System.out.println("----------------------------------------------------------------");
	        System.out.println("Team not found");
	        System.out.println("----------------------------------------------------------------");
	    }
	}

	public void addPlayer() {
		System.out.println("Enter player's first name");
		String name = scanner.next();
		System.out.println("Enter player's last name(format: vanDijk)");
		String surname = scanner.next();
		System.out.println("Enter player id");
		String id = scanner.next();
		System.out.println("Enter team name for which the player plays(format: CeltaVigo, UnionBerlin)");
		String teamName = scanner.next();

		Team playsForTeam = teamList.findTeam(teamName);
		if (playsForTeam != null) {
			Player player = new Player(name, surname, id, playsForTeam);
			playerList.addPlayer(player);
		} else {
			System.out.println("----------------------------------------------------------------");
			System.out.println("Team not found");
			System.out.println("----------------------------------------------------------------");
		}
	}

	public void deletePlayer() {
		System.out.println("Enter player name to delete");
		String player = scanner.next();

		playerList.deletePlayer(player);
	}

	public void searchPlayer() {
		System.out.println("Enter player name to search");
		String player = scanner.next();
		Player searchedPlayer = playerList.findPlayer(player);
		if (searchedPlayer != null) {
			System.out.println(searchedPlayer.printPlayer());
		} else {
			System.out.println("----------------------------------------------------------------");
			System.out.println("Player not found");
			System.out.println("----------------------------------------------------------------");

		}
	}

	public void addGame() {
		System.out.println("Enter home team name(format: LiverpoolFC, RealMadrid)");
		String homeTeamName = scanner.next();
		System.out.println("Enter away team name(format: LutonTown, SSLazio)");
		String awayTeamName = scanner.next();
		System.out.println("Enter home team score");
		String homeScore = scanner.next();
		System.out.println("Enter away team score");
		String awayScore = scanner.next();
		System.out.println("Was the game played? (true/false)");
		boolean gamePlayed = scanner.nextBoolean();

		Team homeTeam = teamList.findTeam(homeTeamName);
		Team awayTeam = teamList.findTeam(awayTeamName);

		if (homeTeam != null && awayTeam != null) {
			Game game = new Game(homeTeam, homeScore, awayScore, awayTeam, gamePlayed);
			gameList.addGame(game);
		} else {
			System.out.println("----------------------------------------------------------------");
			System.out.println("One or both teams not found.");
			System.out.println("----------------------------------------------------------------");
		}
	}

	public void deleteGame() {
		System.out.println("Enter home team name(format: VfBStuttgart, AZAlkmaar)");
		String homeTeamName = scanner.next();
		System.out.println("Enter away team name(format: ParisSG, ClubBrugge)");
		String awayTeamName = scanner.next();

		gameList.deleteGame(homeTeamName, awayTeamName);
	}

	public void searchGame() {
		System.out.println("Enter home team name(format: LeedsUnited, CelticU21)");
		String homeTeamName = scanner.next();
		System.out.println("Enter away team name(format: FCPorto, ACMilan)");
		String awayTeamName = scanner.next();

		Game searchedGame = gameList.findGame(homeTeamName, awayTeamName);

		if (searchedGame != null) {
			System.out.println(searchedGame.printGame());
		} else {
			System.out.println("----------------------------------------------------------------");
			System.out.println("Game not found");
			System.out.println("----------------------------------------------------------------");
		}
	}
	
	public void calcFundAndPrizes() {
        double teamFeePerTeam = 500.0;
        double playerFeePerPlayer = 100.0;

        double totalFund = teamList.calcTotalTeamsFund(teamFeePerTeam, playerFeePerPlayer);

        double firstPrize = totalFund * 0.5;
        double secondPrize = totalFund * 0.3;
        double thirdPrize = totalFund * 0.1;

        System.out.println("----------------------------------------------------------------");
        System.out.println("Total Competition Fund: " + totalFund + " dinars");
        System.out.println("1st Prize: " + firstPrize + " dinars");
        System.out.println("2nd Prize: " + secondPrize + " dinars");
        System.out.println("3rd Prize: " + thirdPrize + " dinars");
        System.out.println("----------------------------------------------------------------");
    }
}
