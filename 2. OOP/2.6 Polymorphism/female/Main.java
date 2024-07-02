package female;

public class Main {

	public static void main(String[] args) {
		Person p1 = new Person("Acid","Burn", 17);
		Person female = new Female("Kate","Murphy","Libby",32);
		
		p1.introduceYourself();
		female.introduceYourself();
	}

}
