package bank;

public interface WorkWithTransactions{
	boolean makeInternalTransaction(Client sender, Client receiver, float amount);
}
