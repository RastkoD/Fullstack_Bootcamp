package eStore;

public class ClientList {
    private String[] clientName;
    private int currentClientNumber;
    private int maxClientNumber;

    public ClientList(int maxClientNumber) {
        this.maxClientNumber = maxClientNumber;
        this.currentClientNumber = 0;
        this.clientName = new String[maxClientNumber];
    }
    
    public String[] getClientName() {
        return clientName;
    }
    
    public int getCurrentClientNumber() {
        return currentClientNumber;
    }

    public String findClient(String clientName) {
        for (int i = 0; i < currentClientNumber; i++) {
            if (this.clientName[i].equals(clientName)) {
                return this.clientName[i];
            }
        }
        System.out.println("Client not found");
        return null;
    }

    public void addClient(String clientName) {
        if (currentClientNumber < maxClientNumber) {
            this.clientName[currentClientNumber++] = clientName;
        } else {
            System.out.println("No room for new clients!");
        }
    }
}
