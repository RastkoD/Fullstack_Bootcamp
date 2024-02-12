package mockTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
	/*
	  Tekstualna datoteka sadrži podatke o programerima u sledećem obliku: 
	  Imenko Prezimenić 38 junior 820.00. Napisati funkciju kojom se iz ove 
	  datoteke mogu učitati podaci o proizvoljnom broju programera iz prethodnog
	  zadatka. Podaci se u programu pamte u dinamičkom nizu čiji su elementi 
	  tipa Programer.
	 */

	private ArrayList<Programmer> listOfProgrammers = new ArrayList<Programmer>();

	public void readProgrammer() {

		try {
			File fileToRead = new File("datoteka.txt");
			Scanner read = new Scanner(fileToRead);
			while (read.hasNextLine()) {
				String programerString = read.nextLine();
				String programmerInfo[] = programerString.split(" ");
				Programmer programmer = new Programmer(programmerInfo[0], programmerInfo[1], Integer.parseInt(programmerInfo[2]), programmerInfo[3], Double.parseDouble(programmerInfo[4]));
				listOfProgrammers.add(programmer);
			}
			read.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error, file not found");
			e.printStackTrace();
		}

	}

	public void setProgrameriList(ArrayList<Programmer> listOfProgrammers) {
		this.listOfProgrammers = listOfProgrammers;
	}
	
	public ArrayList<Programmer> getProgrameriList() {
		return listOfProgrammers;
	}

	/*
	public static ArrayList<Programmer> readDataFromFile(String file) {
        ArrayList<Programmer> programmers = new ArrayList<>();

        try (BufferedReader buffReader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = buffReader.readLine()) != null) {
                String[] programmerInfo = line.split(" ");
                if (programmerInfo.length == 5) {
                    Programmer programmer = new Programmer(
                            programmerInfo[0],
                            programmerInfo[1],
                            Integer.parseInt(programmerInfo[2]),
                            programmerInfo[3],
                            Double.parseDouble(programmerInfo[4])
                    );
                    programmers.add(programmer);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return programmers;
    }
	 */
}