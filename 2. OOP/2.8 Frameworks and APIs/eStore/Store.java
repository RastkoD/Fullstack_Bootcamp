package eStore;

public abstract class Store implements Naming, Finances {
	protected ClientList clientList;
	protected EmployeeList employeeList;
	protected String storeName;
	protected float accBalance;

	public Store(int maxClientNumber, int maxEmployeeNumber) {
		this.clientList = new ClientList(maxClientNumber);
		this.employeeList = new EmployeeList(maxEmployeeNumber);
	}

	@Override
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	@Override
	public String getStoreName() {
		return storeName;
	}

	public void setAccBalance(float accBalance) {
		this.accBalance = accBalance;
	}

	@Override
	public float showAccBalance() {
		return accBalance;
	}

	@Override
	public int calcSalaries() {
		String[] employeeNames = employeeList.getEmployeeName();
		int totalSalaries = 0;

		for (String employeeName : employeeNames) {
			Employee employee = findEmployee(employeeName);

			if (employee != null) {
				int workDays = 20; 
				employee.setSalary(workDays);
				totalSalaries += employee.getSalary();
			}
		}

		return totalSalaries;
	}

	@Override
	public float payTaxes() {
		float taxesToPay = calcTaxes();
		accBalance -= taxesToPay;
		return taxesToPay;
	}

	@Override
	public float calcTaxes() {
		float taxRate = 0.20f;
		return accBalance * taxRate;
	}

	@Override
	public boolean generateAnnualReport() {
		System.out.println("Annual Financial Report for " + getStoreName());
		System.out.println("Total Sales: $" + showAccBalance());
		System.out.println("Total Salaries: $" + calcSalaries());
		System.out.println("Total Taxes: $" + calcTaxes());
		return true;
	}

	@Override
	public float paySalaries() {
		float totalSalaries = calcSalaries();
		accBalance -= totalSalaries;
		return totalSalaries;
	}

	public abstract String[] getInventory();

	void showInventory(String[] itemList) {
		int numOfMenuItems = 0;
		for (int i = 0; i < itemList.length; i++) {
			System.out.println(numOfMenuItems);
		}
	}

	public abstract void buyInventoryItem(String item);

	public abstract void sellInventoryItem(String item);

	protected Employee findEmployee(String employeeName) {
		return null;
	}
}

