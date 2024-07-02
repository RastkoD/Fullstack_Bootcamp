package bank;

import java.util.ArrayList;

public class Bank implements WorkWithClients, WorkWithTransactions {
	 private ArrayList<Client> clients;
	 
	 
	public Bank() {
		this.clients = new ArrayList<>();
	}


	@Override
	public boolean makeInternalTransaction(Client sender, Client receiver, float amount) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void addClient(Client c) {
		clients.add(c);
		
	}


	@Override
	public void deleteClient(Client c) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int findClient(String ssn) {
		// TODO Auto-generated method stub
		return 0;
	}

}
