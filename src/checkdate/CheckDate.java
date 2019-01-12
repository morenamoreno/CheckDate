/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkdate;

/**
 *
 * @author morenamoreno
 */
import java.util.Scanner;// import scanner to use

public class CheckDate { // CheckDate is the Classname, save as "CheckDate.java".

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Please enter a date: ");     // Print the instruction to the user.
        Scanner keyboard = new Scanner(System.in);       // Create scanner Object and pass string in it 
        String myDate = keyboard.nextLine();             // Read next input as String.

        String parsedDate[] = myDate.split("/");         // Break down the String into individual value.

        int month = Integer.parseInt(parsedDate[0]);     // Declare an int variable and assign the String portion for Month
        int day = Integer.parseInt(parsedDate[1]);       // Declare an int variable and assign the String portion for Day
        int year = Integer.parseInt(parsedDate[2]);      // Declare an int variable and assign the String portion for Year

        boolean dateIsValid = checkDate(month, day, year); // Check if the date is valid

        if (dateIsValid == true) {                      // If the date is valid, show the correct message to the user.
            System.out.println("Date is valid ");       // Print the message to the user for the valid date
        } else {                                        // Incase it's not valid, do the following.
            System.out.println("Date is invalid ");     // Print the message to the user for the invalid date
        }
    }

    static boolean checkDate(int myMonth, int myDay, int myYear) {  // Declare a function to check date validity for modularity.

        boolean valid = false;                                      //Initialise a validity variable to default value

        if (myDay >= 1) {                                           //Check low limit for valid days

            if (isA30DaysMonth(myMonth) && myDay <= 30) {           //Checking high limit valid days
                valid = true;                                       // Declare this as a valid case for month that have 30 days
            }

            if (isA31DaysMonth(myMonth) && myDay <= 31) {            //Checking high limit valid days
                valid = true;                                        // Declare this as a valid case for month that have 31 days
            }

            if (myMonth == 2) {                                           //If the month is February
                if (myDay <= 28) {                                        //All february month have at least 28 days
                    valid = true;                                         //Declare this as a valid case for february
                } else if ((myDay == 29) && (isLeapYear(myYear))) {       //However, if its day 29, check if it is a leap year
                    System.out.println(myYear + " is a leap year.");      //Print String text message 
                    valid = true;                                         //Declare this as valid year
                } else {                                                  // Incase it's not valid, do the following
                    System.out.println(myYear + " is not a leap year.");   // Print 
                }

            }

        }

        return valid;

    }

    static boolean isA30DaysMonth(int myMonth) {
        return (myMonth == 4 || myMonth == 6 || myMonth == 9 || myMonth == 11);
    }

    static boolean isA31DaysMonth(int myMonth) {
        return (myMonth == 1 || myMonth == 3 || myMonth == 5 || myMonth == 7 || myMonth == 8 || myMonth == 10 || myMonth == 12);

    }

    static boolean isLeapYear(int myYear) {

        return (myYear % 4 == 0 || myYear % 100 == 0 || myYear % 400 == 0);

    }

}
