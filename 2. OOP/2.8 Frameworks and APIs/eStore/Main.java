package eStore;

public class Main {
	public static void main(String[] args) {		
		Patisserie pelivan = new Patisserie(10, 3);
		Pizzeria mammaMia = new Pizzeria(15, 4);
		Restaurant prancingPony = new Restaurant(18, 6);
		Bookstore gandalfs  = new Bookstore(25, 2);

		pelivan.setStoreName("Pelivan");
		mammaMia.setStoreName("Mamma Mia");
		prancingPony.setStoreName("Prancing Pony");
		gandalfs.setStoreName("Gandalf's Scrolls");

		pelivan.buyInventoryItem("Croissant");
		mammaMia.buyInventoryItem("Four Roses Bourbon");
		prancingPony.buyInventoryItem("Lembas Bread");
		gandalfs.buyInventoryItem("The Two Towers");
		
		System.out.println();
		
		pelivan.employeeList.addEmployee("Frodo Baggins");
	    mammaMia.employeeList.addEmployee("Samwise Gamgee");
	    prancingPony.employeeList.addEmployee("Aragorn");
	    gandalfs.employeeList.addEmployee("Gandalf");
	    
	    pelivan.employeeList.findEmployee("Frodo Baggins");
	    mammaMia.employeeList.findEmployee("Samwise Gamgee");
	    prancingPony.employeeList.findEmployee("Sauron");
	    gandalfs.employeeList.findEmployee("Saruman");
		
		System.out.println();
	
		pelivan.setAccBalance(23000);
		mammaMia.setAccBalance(1233000);
		prancingPony.setAccBalance(20);
		
		System.out.println(pelivan.showAccBalance());
		System.out.println(mammaMia.showAccBalance());
		System.out.println(prancingPony.showAccBalance());
		
		System.out.println();

		mammaMia.sellInventoryItem("Four Roses Bourbon");
		
		System.out.println();

		mammaMia.generateAnnualReport();
	}

}
