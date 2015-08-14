
public class Savings extends Bank {
    
    public Savings(double startBalance, double annualInterest){
        super(startBalance, annualInterest);
    }
    
    private boolean checkStatus(){
        return currentStatus = currentBalance > 25;
    }
 
    @Override
    public void doDeposit(double deposit) {
        checkStatus();
        if (currentStatus == false){
            super.makeDeposit(deposit);
                if (currentBalance > 25)
                    currentStatus = true;   
        } else {
            super.makeDeposit(deposit);
        } 
    }

    @Override
    public void doWithdraw(double withdrawal) {
        checkStatus();
        if (currentStatus == true && (currentBalance - withdrawal) >= 0)
            super.makeWithdraw(withdrawal);
        else if ((currentBalance - withdrawal) <0)
            System.out.println("This operation is denied. Over withdraw.\n"
                    + "==============================================");
        else
            System.out.println("This operation is denied. Invalid account.\n"
                    + "==============================================");
    }

    @Override
    public void monthlyReport() {
        if (numberOfWithdrawals > 4){
            serviceCharge += (numberOfWithdrawals-4)*1.0;
        }
        currentBalance -= serviceCharge;
        super.calculateInterest();
        checkStatus();
        super.doMonthlyReport();
    }
  
}
