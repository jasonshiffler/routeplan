/**
 * Created by jason on 11/30/16.
   A did number contains a string representing the number and is either available or unavailable

 */


public class didNumber {
  boolean available;  //is the number used
  String number;      //a string representing the number


    //Constructor
    public didNumber(String num) {
        number = num;
        available = false;
    }

    public void setAvailable(){
        available = true;
    }

    public void setunAvailable(){
        available = false;
    }

    public boolean isAvailable() {
        return available;
    }
}
