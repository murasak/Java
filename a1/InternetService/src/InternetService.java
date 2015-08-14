
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;


public class InternetService {
    private char plan;
    private int totalHours;
    private int leftHours;
    private double planCost;
    
    public InternetService() {
        super();
    }
    private void getInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please select your plan:");
        if (sc.hasNext("[a-zA-Z]"))
            plan = sc.next().toUpperCase().charAt(0);
        else
            plan = 'z';
        sc.nextLine();
        while (plan < 'A' || plan > 'C'){
            System.out.println("Invalid. Please select from Plan A to C.");
            if (sc.hasNext("[a-zA-Z]"))
                plan = sc.next().toUpperCase().charAt(0);
            else
                plan = 'z';
            sc.nextLine();
        }
        System.out.println("How many hours were used monthly?");
        if (sc.hasNextInt())
            totalHours = sc.nextInt();
        else
            totalHours = -1;
        sc.nextLine();
        while (totalHours < 0 || totalHours > 744){
            System.out.println("Invalid value. Please enter again.");
            if (sc.hasNextInt())
                totalHours = sc.nextInt();
            else
                totalHours = -1;
            sc.nextLine();
        }
    }
    
    private double calculateCharge(char p, int t){
        double charge;
        double rate=0;
        switch (p){
            case 'A':
                planCost = 9.95;
                rate = 2.0;
                leftHours = (t>10)?(t-10):0;
                break;
            case 'B':
                planCost = 14.95;
                rate = 1.0;
                leftHours = (t>20)?(t-20):0;
                break;
            case 'C':
                planCost = 19.95;
                break;              
        }
        charge = planCost + leftHours * rate;
        return charge;     
    }
    
    public void perform(){
        getInput();
        double result;
        result = calculateCharge(plan, totalHours);
        NumberFormat Currency = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("Plan " + plan + "\nTotal number of hours used: "
        + totalHours + "\nThe monthly bill amount is " + Currency.format(result));
    }
 
    public static void main(String[] args) {
        InternetService myApp = new InternetService();
        myApp.perform();
        System.exit(0);
    }
    
}
