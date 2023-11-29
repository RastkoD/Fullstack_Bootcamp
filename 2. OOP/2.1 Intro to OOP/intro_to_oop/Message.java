package intro_to_oop;

public class Message {
	String text;
	
	void setText(String noviTekst) {
		text = noviTekst;
	}
	
	void getText() {
		System.out.println(text);
	}
}
