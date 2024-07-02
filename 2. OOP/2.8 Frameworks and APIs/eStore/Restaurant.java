package eStore;

public class Restaurant extends Store {
	private String[] menu = {"Beorn's Honey Glazed Roast", "Strider's Stew", "Lembas Bread", "Gollum's Fish Tacos", "Hobbiton Apple Cider", "Dwarven Mead"};
    
	public Restaurant(int maxClientNumber, int maxEmployeeNumber) {
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
