/*
  Created by jason on 11/30/16.
  A site contains a list of numbers and has a name

 */
import java.util.ArrayList;

public class site {

  ArrayList<didNumber> didNumberList;    //An array list of didNumber objects
  private String siteName;               //The site name ABQ,NYO,SHL etc...
  private int numCount;                          //The number DID numbers the site contains

  //Constructor
  //name is the name of the site
  public site(String name) {
    siteName = name;                              //The site name ABQ,NYO,SHL etc...
    didNumberList = new ArrayList<didNumber>();
    numCount = 0;                                 //The site starts out with zero numbers
  }

  //Add a number to the list, doesn't currently check for duplicates
  //num is the DID number to add i.e. 3145551234

  public void addNumber(String num) {
    didNumber temp = new didNumber(num);   //create a new number object
    didNumberList.add(temp);               // add it to the list of numbers
    numCount += 1;                          // increment the count of DID numbers by one
  }

  //Adds a range of numbers to the site the 0th element is the beginning of the range
  //the 1st element is the end. Any other elements are ignored.
  //firstRange = 3145551000
  //lastRange = 3145551050

  public void addNumberRange(String firstRange, String lastRange) {
    long beginRange, endRange, incrDID;                    //need to turn the strings into longs the can be incremented
    //incrDID will track which number we are adding to the site.
    if (firstRange.equals(lastRange) == true) {  // The beginning and end of the range is the same number insert
      addNumber(firstRange);                       // the number and return
      return;
    }

    beginRange = Long.parseLong(firstRange);    //convert the beginning of the range to a long;
    endRange = Long.parseLong(lastRange);      //convert the end of the range to a long;

    if (beginRange > endRange) {                 //beginning number must be smaller
      System.out.println("Invalid Range for" + siteName);
      return;
    }
    for (incrDID = beginRange; incrDID <= endRange; incrDID++) {
      addNumber(Long.toString(incrDID));                          //add the number to the Site

    }
    return;
  }
  //Returns the name of the site
  public String getSiteName(){
    return siteName;
  }


  //Calculate the number of available DID numbers the site has and return the value.
  private int calcNumAvailableNumbers(){
    int availNum = 0;                      //initialize the count of available numbers
    for (didNumber num : didNumberList){   //iterate through the list of DID numbers
      if (num.isAvailable() == true){      //if the number is available increment the number of available numbers
        availNum += 1;
      }
    }
     return availNum;                       //return the result
  }

  //Prints a report of available vs total numbers for the site.
  public void printAvailabilityReport(){
    System.out.println(siteName +" Total Numbers = " + numCount);
    System.out.println(siteName +" Available Numbers = " + calcNumAvailableNumbers());
    System.out.println(siteName +" Percentage of Numbers available = " + ((float)(float)calcNumAvailableNumbers()/(float)numCount)*100 +"%");
    System.out.println("\n");
  }



  //Prints all the numbers associated with a site
  public void printNumbers() {
    for (didNumber num : didNumberList) {         //iterate through the list
      System.out.print(num.getNumber() +" " );    //print the number
      if (num.isAvailable() == true) {            //print availablity status
        System.out.println("available");
       }
       else{
        System.out.println("unavailable");
       }

    }
  }

  //Prints all the available numbers associated with a site
  public void printAvailableNumbers() {
    for (didNumber num : didNumberList) {
      if (num.isAvailable() == true) {
        System.out.println(num.getNumber());
      }
    }
  }

  //Prints all the available numbers associated with a site
  public void printUnavailableNumbers() {
    for (didNumber num : didNumberList) {
      if (num.isAvailable() == false) {
        System.out.println(num.getNumber());
      }

    }

  }
}
