
import java.text.NumberFormat;
import java.util.Locale;


public abstract class Bank {
    protected double startBalance;
    protected double currentBalance;
    protected double totalOfDeposit;
    protected int numberOfDeposit;
    protected double totalOfWithdrawals;
    protected int numberOfWithdrawals;
    protected double annualInterest;
    protected double serviceCharge;
    protected boolean currentStatus;
    private double monthlyInterest;
    NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
    
    public Bank(double startBalance, double annualInterest){
        this.startBalance = startBalance;
        this.annualInterest = annualInterest;
        this.currentBalance = this.startBalance;
    }
    
    public void makeDeposit(double deposit){
        this.currentBalance += deposit;
        this.numberOfDeposit++;
        this.totalOfDeposit += deposit;
        System.out.println("New deposit:\t" + currency.format(deposit) +
                "\nCurrent Balance:\t" + currency.format(currentBalance) +
                "\ntotal deposit amount:\t" + currency.format(totalOfDeposit) +"\n"+
                "==============================================" );
    }
    
    public void makeWithdraw(double withdrawal){
        this.currentBalance -= withdrawal;
        this.numberOfWithdrawals++;
        this.totalOfWithdrawals += withdrawal;
        System.out.println("New withdrawal:\t" + currency.format(withdrawal) +
                "\nCurrent Balance:\t" + currency.format(currentBalance)
                    + "\ntotal withdrawal amount:\t" + currency.format(totalOfWithdrawals) + "\n"
                    + "==============================================");
                
    }
    
    public double calculateInterest(){
        double monthlyRate = (annualInterest / 12);
        if (currentBalance > 0 ){
            monthlyInterest = this.currentBalance * monthlyRate;
            this.currentBalance += monthlyInterest;
        } else
            monthlyInterest = 0;
        return monthlyInterest;
    }
    
    public void doMonthlyReport(){
        System.out.println("Starting balance:\t" + currency.format(startBalance) +
                "\nTotal amount of deposit:\t" + currency.format(totalOfDeposit) +
                "\nTotal amount of withdrawals:\t" + currency.format(totalOfWithdrawals) +
                "\nService charges:\t" + currency.format(serviceCharge) +
                "\nMonthly Interest:\t" + currency.format(monthlyInterest) +
                "\nCurrent balance:\t" + currency.format(currentBalance) + 
                "\nAccount status:\t" + currentStatus + "\n"
                + "==============================================");
        startBalance = currentBalance;
        totalOfDeposit = 0;
        totalOfWithdrawals = 0;
        numberOfWithdrawals = 0;
        numberOfDeposit = 0;
        serviceCharge = 0;
    }
    
    public abstract void doDeposit(double deposit);
    public abstract void doWithdraw(double withdrawal);
    public abstract void monthlyReport();
     
}
