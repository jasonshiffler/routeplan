/**
 * Created by jason on 11/30/16.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class dialPlan {

    ArrayList<site> siteList;    //An array list of didNumber objects

    //constructor
    public dialPlan(){


    }

    //Builds the sites by reading in the DIDNUMBERs.txt file
    public void buildSites(){
      String[] tokens;                          //Will use this to break each line of the file into tokens


        try {
            Scanner scan = new Scanner(new File("DIDNUMBERS.txt"));
            while (scan.hasNextLine()) {
                String line = scan.nextLine();        //read the line in from the file
                tokens = getLineElements(line);       //break the elements of the line into tokens
                if (doesSiteExist(tokens[0]) != true){

                }

            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not Found");     //couldn't find the file

        }

    }


    //extracts the site name, beginning DID, and end DID from a line formatted as
    //ABQ 3145551000 3145551099
    //the 0th element will be ABQ, 1st will be 3145551000, 2nd 3145551099

    public String[] getLineElements(String line){
      String[] returnString = line.split(" ");                        //This is the string array we will return
      return returnString;
    }


    //Determines if a site is already in the ArrayList
    //Name is the name of the site you want to check if it exists in the List

    public boolean doesSiteExist(String Name) {
        if (siteList.size() == 0) {    //if the siteList is empty the site does not exist
            return false;
        }
          for (site loc : siteList) {   //iterate through the site list
            if (loc.siteName.equals(Name) == true) {
              return true;
             }
          }


       return false;    //Didn't find the Name in the List
    }


}
