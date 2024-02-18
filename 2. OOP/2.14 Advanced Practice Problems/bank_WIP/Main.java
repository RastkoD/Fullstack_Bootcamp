package bank;

public class Main {

	public static void main(String[] args) {
		Bank bank = new Bank();
		
		Client client1 = new Client("Frodo", "Baggins", "2134444", 11515);
        Client client2 = new Client("Semwise", "Gamgee", "12343333", 88548);

        
       // System.out.println(client1.getAccNumber().getBalance());
        
       bank.addClient(client1);
       bank.addClient(client2);
       
       client1.introduceYourself();
	}

}
