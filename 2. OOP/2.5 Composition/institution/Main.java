package institution;

public class Main {

	public static void main(String[] args) {
		Employees dean = new Employees("Frodo", "Baggins", 83, 8.0);
		Institution ftn = new Institution("FTN", "Novi Sad", "1111", dean);
		
		ftn.addClassroom("A1", "amphitheatre ", 300, 200.0, false);
		ftn.addClassroom("MI A2-1", "cabinet", 32, 50.0, true);
		ftn.addComputerToClassroom("MI A2-1", "Intel", 2.0, 16);
		ftn.addComputerToClassroom("MI A2-1", "AMD", 3.0, 32);
		ftn.addEmployee("Bilbo", "Baggins", 111, 6.0);
		ftn.addEmployee("Peregrin", "Took", 34, 2.0);
		ftn.printData();
		System.out.println(ftn.getLegalRep());
	}

}
