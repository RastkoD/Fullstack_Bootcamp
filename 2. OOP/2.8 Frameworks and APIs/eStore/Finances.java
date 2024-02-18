package eStore;

public interface Finances {
    float showAccBalance();
    int calcSalaries();   
    float payTaxes();  
    float calcTaxes(); 
    boolean generateAnnualReport();  
    float paySalaries(); 
}