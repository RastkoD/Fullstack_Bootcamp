package eStore;

public class EmployeeList {
    private String[] employeeName;
    private int currentEmployeeNumber = 0;
    private int maxEmployeeNumber;
    
    public EmployeeList(int maxEmployeeNumber) {
        this.maxEmployeeNumber = maxEmployeeNumber;
        this.employeeName = new String[maxEmployeeNumber];
    }
    
    public String[] getEmployeeName() {
        return employeeName;
    }
    
    public int getCurrentEmployeeNumber() {
        return currentEmployeeNumber;
    }

    public String findEmployee(String employeeName) {
        for (int i = 0; i < currentEmployeeNumber; i++) {
            if (this.employeeName[i].equals(employeeName)) {
                System.out.println(this.employeeName[i] + " works here!");
                return this.employeeName[i];
            }
        }
        System.out.println(employeeName + " does not work here!");
        return null;
    }

    public void addEmployee(String employeeName) {
        if (currentEmployeeNumber < maxEmployeeNumber) {
            this.employeeName[currentEmployeeNumber++] = employeeName;
        } else {
            System.out.println("No room for new employees!");
        }
    }
}
