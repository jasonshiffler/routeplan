/**
 * Created by jason on 11/30/16.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class dialPlan {

    private ArrayList<site> siteList = new ArrayList<site>();    //An array list of didNumber objects
    private ArrayList<String> usedNumberList = new ArrayList<String>(); //Array list that holds the list of used numbers

    //constructor
    public dialPlan() {


    }

    //Builds the list of used numbers from routeplan.csv
    public void buildUsedNumbers(){
      String[] tokens;                          //Will use this to break each line of the file into tokens

        try {
           Scanner scan = new Scanner(new File("routeplan.csv"));
           while (scan.hasNextLine()) {
             String line = scan.nextLine();        //read the line in from the file
             if (line.substring(0,1).matches("[0-9]")) {   //if the first character of the line is a number
               tokens = getCSVLineElements(line);          // grab the first token from the line
               if (tokens[0].matches("[0-9]{10}"))         //if it's a 10 digit number
                 usedNumberList.add(tokens[0]);            //add it to the array list
             }

            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not Found");     //couldn't find the file

        }

    }



    //Builds the sites by reading in the DIDNUMBERs.txt file
    public void buildSites() {
      String[] tokens;                          //Will use this to break each line of the file into tokens
      site newSite;                             //use this to create a new site

      try {
        Scanner scan = new Scanner(new File("DIDNUMBERS.txt"));
        while (scan.hasNextLine()) {
          String line = scan.nextLine();        //read the line in from the file
          tokens = getLineElements(line);       //break the elements of the line into tokens
          if (doesSiteExist(tokens[0]) != true) {  //if the site doesn't exist add it to the list
            newSite = new site(tokens[0]);        //create the site
            newSite.addNumberRange(tokens[1], tokens[2]);  //add numbers to the site
            siteList.add(newSite);                    // add the site to the list
            }
          else {                                   //if the site already exists
            newSite = getSiteWithName(tokens[0]);  //get the site object

            if (newSite != null) {
              newSite.addNumberRange(tokens[1], tokens[2]); //add numbers to the site
            }
               }

            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not Found");     //couldn't find the file

        }

    }

    public void checkAvailability(){
        boolean found = false;
        for (site loc : siteList) {   //iterate through the site list
            for (didNumber didNum: loc.didNumberList) //iterate through each didNumber in the site
            {
                found = false;
                for (String usedNum : usedNumberList) //iterate through each number in the used list
                  {
                   if (usedNum.equals(didNum.getNumber()))
                       found = true;

                  }
                if (found == false)
                    didNum.setAvailable();

            }

        }


    }



    //extracts the site name, beginning DID, and end DID from a line formatted as
    //ABQ 3145551000 3145551099
    //the 0th element will be ABQ, 1st will be 3145551000, 2nd 3145551099

    public String[] getLineElements(String line) {
        String[] returnString = line.split(" ");      //This is the string array we will return, space is the delimiter

        //Should be three elements in each line and the second and third elements should be ten characters long
        if ( (returnString.length != 3) || (returnString[1].length() != 10 )|| (returnString[2].length() !=10 ) ||
              (returnString[1].matches("[0-9]+") == false) ||  (returnString[2].matches("[0-9]+") == false)
           ) {
          System.out.println("Improperly formatted line for " + Arrays.toString(returnString)); // Should be 3 elements to each line
          System.exit(1);                                                //Halt the program
        }
        return returnString;
    }


    //Extracts the elements from the routeplan.csv file
    public String[] getCSVLineElements(String line) {
        String[] returnString = line.split(",");      //This is the string array we will return, space is the delimiter
        return returnString;
    }


    //Determines if a site is already in the ArrayList
    //Name is the name of the site you want to check if it exists in the List

    public boolean doesSiteExist(String Name) {
        if (siteList.size() == 0) {    //if the siteList is empty the site does not exist
            return false;
        }
        for (site loc : siteList) {   //iterate through the site list
            if (loc.getSiteName().equals(Name) == true) {
                return true;
            }
        }


        return false;    //Didn't find the Name in the List
    }

    //Returns the index of the site with a name of Name.
    //Returns null of a site with that name doesn't exist

    public site getSiteWithName(String Name) {

        if (doesSiteExist(Name) == false)
            return null;

        for (site loc : siteList) {   //iterate through the site list
            if (loc.getSiteName().equals(Name) == true) {
                return loc;
            }

        }
        return null;
    }

  //Prints out all numbers for all sites
  public void printAllSiteNumbers(){
      for (site loc : siteList) {   //iterate through the site list
          System.out.println(loc.getSiteName());
          loc.printNumbers();
          System.out.println("");
      }

  }

  //Prints out all available numbers for all sites
    public void printAllAvailableSiteNumbers(){
        for (site loc : siteList) {   //iterate through the site list
            System.out.println(loc.getSiteName());
            loc.printAvailableNumbers();
            System.out.println("");
        }

    }

    public void printUsedNumberList(){
        for (String num : usedNumberList){
            System.out.println(num);
        }

    }


}