
import java.util.Scanner;


public class UserTest {
    private char selection, choice;
    
    public UserTest(){
        super();
    }

    private void getAccount(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Bank Menu\nA:Savings\tB:Checking\tC:Exit:\n"
                + "Please select a bank account.");
        if (sc.hasNext("[a-zA-Z]"))
            selection = sc.next().toUpperCase().charAt(0);
        else
            selection = 'z';
        sc.nextLine();
        while (selection < 'A' || selection > 'C'){
            System.out.println("Invalid. Please select from A to C.");
            if (sc.hasNext("[a-zA-Z]"))
                selection = sc.next().toUpperCase().charAt(0);
            else
                selection = 'z';
            sc.nextLine();
        }
    }
    
    private void getOperation(){
        Scanner sc = new Scanner(System.in);
        System.out.println("==============================================\n"
                + "A:Deposit\tB:Withdrawal\tC:Report\tD:Return:\n"
                + "Please select your operation.");
        if (sc.hasNext("[a-zA-Z]"))
            choice = sc.next().toUpperCase().charAt(0);
        else
            choice = 'z';
        sc.nextLine();
        while (choice < 'A' || choice > 'D'){
            System.out.println("Invalid. Please select from A to D.");
            if (sc.hasNext("[a-zA-Z]"))
                choice = sc.next().toUpperCase().charAt(0);
            else
                choice = 'z';
            sc.nextLine();
        }
    }
    
    public double getDouble()
    {   Scanner sc  = new Scanner(System.in);
        boolean isValid = false;
        double d = 0;
        while (isValid == false)
        {
            if (sc.hasNextDouble())
            {
                d = sc.nextDouble();
                isValid = true;
            }
            else
            {
                System.out.println("Error! Invalid decimal value. Try again.");
            }
            sc.nextLine();
        }
        return d;
    }
    
    private void bankAccount(char s){
        switch (s){
            case 'A':
                System.out.println("Savings Menu\n"
                        + "==============================================");
                savingAccount(choice);
                break;
            case 'B':
                System.out.println("Checking Menu\n"
                        + "==============================================");
                checkingAccount(choice);
                break;
            case 'C':
                System.out.println("Exit");
                System.exit(0);
                break;
                        
        }
    }
    private void savingAccount(char s1){
        System.out.println("Please set the Starting Balance: ");
        double startBalance = getDouble();
        System.out.println("Please set the Annual Interest: ");
        double annualInterest = getDouble();
        Savings s = new Savings(startBalance, annualInterest);
        while(true){
            getOperation();
            s1 = choice;
            switch (s1){
                case 'A':
                    System.out.println("Please enter the Deposit Amount: ");
                    double deposit = getDouble();
                    s.doDeposit(deposit);
                    break;
                case 'B':
                    System.out.println("Please enter the Withdrawal Amount: ");
                    double withdrawal = getDouble();
                    s.doWithdraw(withdrawal);
                    break;
                case 'C':
                    System.out.println("Savings Account Report");
                    s.monthlyReport();
                    break;
                case 'D':
                    System.out.println("Return to Bank Menu\n"
                            + "==============================================");
                    getAccount();
                    bankAccount(selection);
                    break;
            }
        }
                
    }
    
    private void checkingAccount(char s2){
        System.out.println("Please set the Starting Balance: ");
        double startBalance = getDouble();
        System.out.println("Please set the Annual Interest: ");
        double annualInterest = getDouble();
        Checking c = new Checking(startBalance, annualInterest);
        while(true){
            getOperation();
            s2 = choice;       
            switch (s2){
                case 'A':
                    System.out.println("Please enter the Deposit Amount: ");
                    double deposit = getDouble();
                    c.doDeposit(deposit);
                    break;
                case 'B':
                    System.out.println("Please enter the Withdrawal Amount: ");
                    double withdrawal = getDouble();
                    c.doWithdraw(withdrawal);
                    break;
                case 'C':
                    System.out.println("Checking AccountReport");
                    c.monthlyReport();
                    break;
                case 'D':
                    System.out.println("Return to Bank Menu\n"
                            + "==============================================");
                    getAccount();
                    bankAccount(selection);
                    break;
            }
        }
     }
     
     public void perform(){
         getAccount();
         bankAccount(selection);        
     }
      
    public static void main(String[] args) {
        UserTest test = new UserTest();
        test.perform();
        System.exit(0);        
    }
}