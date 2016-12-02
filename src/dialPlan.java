import java.util.ArrayList;

/**
 * Created by jason on 11/30/16.
 */
public class dialPlan {

    ArrayList<site> siteList;    //An array list of didNumber objects

    //constructor
    public dialPlan(){


    }

    //Builds the sites by reading in the DIDNUMBERs.txt file
    public void buildSites(){



    }

    //Determines if a site is already in the ArrayList
    //Name is the name of the site you want to check if it exists in the List

    public boolean doesSiteExist(String Name) {
        if (siteList.size() == 0) {    //if the siteList is empty the site does not exist
            return false;

          for (site loc : siteList) {   //iterate through the site list
            if (loc.siteName.equals(Name) == true) {
              return true;
             }
          }

        }
       return false;    //Didn't find the Name in the List
    }




}
