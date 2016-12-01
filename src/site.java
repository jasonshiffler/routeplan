/*
  Created by jason on 11/30/16.
  A site contains a list of numbers and has a name

 */
import java.util.ArrayList

public class site {

  ArrayList didNumbers;    //An array list of didNumber objects
  String siteName;         //The site name ABQ,NYO,SHL etc...

    //Constructor
    public site(String name){
        siteName = name;
        didNumbers = new ArrayList();

    }

    //Add a number to the list, doesn't currently check for duplicates
    public void addNumber(String num){
        didNumber temp = new didNumber(num);
        didNumbers.add(temp);

    }


}
