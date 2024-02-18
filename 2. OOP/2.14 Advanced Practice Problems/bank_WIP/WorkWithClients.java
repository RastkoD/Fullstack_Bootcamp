package bank;

public interface WorkWithClients {
	void addClient(Client k);
	void deleteClient(Client k);
	int findClient(String jmbg);
}
