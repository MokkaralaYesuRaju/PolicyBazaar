package Testcases;
import java.io.IOException;


import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Pageobjects.Health_Inusrance05;
import Pageobjects.HomePage;
import testbase.baseclass;
import utilities.Screenshots;
//import utilities.Screenshots;
//@Listeners(ExtentReportManager.ExtentReport.class)

public class TC_003_Health_Insurance extends baseclass{
 HomePage hp;
 Health_Inusrance05 HealthInsurance;
 public static String path;
 Logger logger;

 @Test(groups= {"sanity","master"})
 public void main() throws InterruptedException, IOException {
	 logger = baseclass.logger;
	 logger.info("*****Starting  TC_003_Health_Insurance *****");
	 try {
	 hp = new HomePage(baseclass.driver);
	 HealthInsurance=new  Health_Inusrance05(baseclass.driver);
	 logger = baseclass.logger;
	 HealthInsurance.Health_Inusrance05();
	 System.out.println("----------------------------------------------------------------------");
	 }catch(Exception e)
	 {
		 Assert.fail();
	 }
	
	path=Screenshots.screenShots(driver,"HEALTH INSURANCE");
	logger.info("*****Finished  TC_003_Health_Insurance*****");
 }
 
 
 
 
}
