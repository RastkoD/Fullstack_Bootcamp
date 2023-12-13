package access_control_and_encapsulation;

public class Message {
	private String text;
	
	public void setText(String newTxt) {
		this.text = newTxt;
	}
	
	public String getText() {
		return this.text;
	}
	
	public void showMsg() {
		System.out.println(getText());
	}
}