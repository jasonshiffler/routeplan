/**
 * Created by jason on 12/3/16.
 */
import java.util.Scanner;



public class routeplan {

    public static void main(String... args) {
      Scanner keyboard;
      int input;

      dialPlan dp = new dialPlan();     //create a new dialplan object
      dp.buildSites();                  //build the site list from the DIDNUMBERS.csv file
      dp.buildUsedNumbers();            //build the used number list from the routeplan.csv file
      dp.checkAvailability();           //use the routeplan.csv file to mark each number used or available

        keyboard = new Scanner(System.in);
        while (true){

            System.out.println("***Enter an option***");
            System.out.println("1. print out all available numbers");
            System.out.println("2. print all numbers");
            System.out.println("3. print out all available numbers at a specific site");
            input = keyboard.nextInt();

            if (input == 1) {dp.printAllAvailableSiteNumbers();}

            if (input == 2) {dp.printAllSiteNumbers();}

        }





    }
}