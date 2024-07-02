package eStore;

public class Bookstore extends Store {
	private String[] menu = {"The Fellowship of the Ring", "The Two Towers", "The Return of the King", "The Hobbit", "The Silmarillion", "Steppenwolf"};
    
	public Bookstore(int maxClientNumber, int maxEmployeeNumber) {
        super(maxClientNumber, maxEmployeeNumber);
    }

    @Override
    public String[] getInventory() {
        return menu;
    }

    @Override
    public void buyInventoryItem(String item) {
        System.out.println(getStoreName() + " - Your order is: " + item);
    }

    @Override
    public void sellInventoryItem(String item) {
        System.out.println(getStoreName() + " - You have sold: " + item);
    }

    @Override
    protected Employee findEmployee(String employeeName) {
        return null;
    }
}
