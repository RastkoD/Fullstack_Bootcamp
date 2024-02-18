package eStore;

public class Patisserie extends Store {
    private String[] menu = {"Tiramisu", "Cake", "Doughnut", "Croissant", "Espresso", "Tea"};

    public Patisserie(int maxClientNumber, int maxEmployeeNumber) {
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
