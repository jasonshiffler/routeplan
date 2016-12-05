/**
 * Created by jason on 11/30/16.
   A did number contains a string representing the number and is either available or unavailable

 */


public class didNumber {

  private boolean available;  //is the number used
  private String number;      //a string representing the number


    //Object Constructor
    public didNumber(String num) {
        number = num;
        available = false;
    }

    //Returns a String representation of the number
    public String getNumber() {
        return number;
    }

    //Set the number to be available
    public void setAvailable(){
        available = true;
    }

    //Set the number to be unavailable
    public void setUnAvailable(){
        available = false;
    }

    //Returns true if available, false if unavailable
    public boolean isAvailable(){
        return available;
    }
}
