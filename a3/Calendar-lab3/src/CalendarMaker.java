
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class CalendarMaker {
    
    CalendarMaker() {
        super();
    }
    
    private void perform() {
        // Input year and month
        Scanner sc = new Scanner(System.in);
        int year = Validator.getInt(sc, "Please enter year: ", 1900, 2099);
        int month = Validator.getInt(sc, "Please enter month: ", 0, 13);
        System.out.println("================================");
        
        ArrayList<String> calendar = new ArrayList<String>();
        GregorianCalendar gregDay = new GregorianCalendar(year, month - 1, 1);

        // Format calendar title as "Month, Year"
        SimpleDateFormat m = new SimpleDateFormat("MMMM, yyyy");
        Date date = gregDay.getTime();
        System.out.println(m.format(date));

        // Print name of weekdays
        String[] calendarWeek = {"Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat"};        
        for (int i = 0; i < calendarWeek.length; i++) {
            System.out.print(calendarWeek[i] + "\t");
        }
        System.out.println();

        // Get the position for the 1st day of month & the number of days in that month.
        int dayOfWeek = gregDay.get(Calendar.DAY_OF_WEEK);        
        int daysInMonth = gregDay.getActualMaximum(Calendar.DAY_OF_MONTH);
        
        for (int i = 1; i < daysInMonth + 1; i++) {
            calendar.add(Integer.toString(i) + "\t");
        }
        
        for (int i = 0; i < dayOfWeek - 1; i++) {
            calendar.add(i, " \t");
        }

        // Format the output of the calendar as 7 days a week.
        for (int n = 7; n < calendar.size(); n += 8) {
            calendar.add(n, "\n");
        }
        
        // Arraylist to String.
        StringBuilder c = new StringBuilder(48);
        for (String calendarFormat : calendar) {
            c = c.append(calendarFormat);
        }
        System.out.println(c);
    }
    
    public static void main(String[] args) {
        CalendarMaker myCal = new CalendarMaker();
        myCal.perform();
        System.exit(0);   
    }
}
