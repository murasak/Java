
public class Checking extends Bank {

   public Checking(double startBalance, double annualInterest){
        super(startBalance, annualInterest);
   }

    @Override
    public void doDeposit(double deposit) {
        super.makeDeposit(deposit);
    }

    @Override
    public void doWithdraw(double withdrawal) {
        if (currentBalance <= 0){
            System.out.println("This operation is denied. Over withdraw. Invalid account.\n"
                    + "==============================================");
        }
        else if (currentBalance - withdrawal < 0){
            serviceCharge = 15;
            System.out.println("Insufficient funds. $15 service charge.\n"
                    + "==============================================");
        }
        else
            super.makeWithdraw(withdrawal);
    }

    @Override
    public void monthlyReport() {
        serviceCharge += (5 + 0.10*numberOfWithdrawals);
        currentBalance -= serviceCharge;
        super.calculateInterest();
        currentStatus = currentBalance > 0;
        super.doMonthlyReport();
    }
    
    
}
