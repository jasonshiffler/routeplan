/*
  Created by jason on 11/30/16.
  A site contains a list of numbers and has a name

 */
import java.util.ArrayList;

public class site {

  ArrayList<didNumber> didNumberList;    //An array list of didNumber objects
  String siteName;         //The site name ABQ,NYO,SHL etc...

  //Constructor
  public site(String name) {
    siteName = name;
    didNumberList = new ArrayList<didNumber>();
  }

  //Add a number to the list, doesn't currently check for duplicates
  public void addNumber(String num) {
    didNumber temp = new didNumber(num);
    didNumberList.add(temp);
  }

  //Prints all the numbers associated with a site
  public void printNumbers() {
    for (didNumber num : didNumberList) {
      System.out.println(num.number);
    }
  }

  //Prints all the available numbers associated with a site
  public void printAvailableNumbers() {
    for (didNumber num : didNumberList) {
      if (num.isAvailable() == true) {
        System.out.println(num.number);
      }
    }
  }


  //Prints all the available numbers associated with a site
  public void printUnavailableNumbers() {
    for (didNumber num : didNumberList) {
      if (num.isAvailable() == false) {
        System.out.println(num.number);
      }

    }

  }
}
