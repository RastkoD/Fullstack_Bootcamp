package eStore;

public class Pizzeria extends Store {
	private String[] menu = {"Quattro Formaggi Pizza", "Pepperoni Pizza", "Carbonara", "Lasagna", "Grimbergen Beer", "Four Roses Bourbon"};
    
	public Pizzeria(int maxClientNumber, int maxEmployeeNumber) {
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
