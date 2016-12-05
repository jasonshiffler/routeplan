/**
 * Created by jason on 12/3/16.
 */




public class routeplan {

    public static void main(String... args) {
      dialPlan dp = new dialPlan();
      dp.buildSites();
      dp.buildUsedNumbers();
      dp.checkAvailability();
      dp.printAllSiteNumbers();




    }
}