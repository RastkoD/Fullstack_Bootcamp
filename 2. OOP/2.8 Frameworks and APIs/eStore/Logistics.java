package eStore;

public interface Logistics {
	void buyInventoryItem(String artikal);
	void sellInventoryItem(String artikal);
	int showInventory(String[] itemList); // vraca broj prikazanih artikala
}
