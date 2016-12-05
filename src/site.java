/*
  Created by jason on 11/30/16.
  A site contains a list of numbers and has a name

 */
import java.util.ArrayList;

public class site {

  ArrayList<didNumber> didNumberList;    //An array list of didNumber objects
  private String siteName;         //The site name ABQ,NYO,SHL etc...

  //Constructor
  //name is the name of the site
  public site(String name) {
    siteName = name;                              //The site name ABQ,NYO,SHL etc...
    didNumberList = new ArrayList<didNumber>();
  }

  //Add a number to the list, doesn't currently check for duplicates
  //num is the DID number to add i.e. 3145551234

  public void addNumber(String num) {
    didNumber temp = new didNumber(num);
    didNumberList.add(temp);
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

  public String getSiteName(){
    return siteName;
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
