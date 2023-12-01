package access_control_and_encapsulation;

public class Message {
	private String text;

	public void setTxt(String txt) {
		this.text = txt;
	}

	public String getTxt() {
		return this.text;
	}

	public void showTxt(){
		System.out.println(getTxt());
	}
}
