package enums;

public class Enums {
	
	enum Day { PONEDELJAK, UTORAK, SREDA, CETVRTAK, PETAK, SUBOTA, NEDELJA}
	enum Month { JANUAR, FEBRUAR, MART, APRIL, MAJ, JUN, JUL, AUGUST, SEPTEMBAR, NOVEMBAR, DECEMBAR }

	public static void main(String[] args) {
		Day birthDay; // promenljiva tipa Dan.
		Month birthMonth; // promenljiva tipa Mesec.
		birthDay = Day.SUBOTA; // dodela vrednosti promenljivoj tipa Dan.
		birthMonth = Month.FEBRUAR; // dodela vrednosti promenljivoj tipa Mesec.
		System.out.println("Moj znak je vodolija, jer sam ja rodjen u " + birthMonth + "u.");
		System.out.println("To je "+ (birthMonth.ordinal() + 1) + ". mesec godine."); // zasto +1
		System.out.println("Dan kada sam se rodio je " + birthDay + ".");
		System.out.println( birthDay + " je " + birthDay.ordinal() + ". dan nedelje.");

	}

}
