//package ExtentReportManager;
// 
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//import java.text.SimpleDateFormat;
//import java.util.Date;
// 
//import com.aventstack.extentreports.*;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//
//import Testcases.TC_001_travel_Insurance;
//import Testcases.TC_002_Car_Insurance;
//import Testcases.TC_003_Health_Insurance;
//import Testcases.TC_004_Health_insurance_products;
// 
//
//public class ExtentReport implements ITestListener
//{
//	public ExtentSparkReporter sparkreporter;
//	public ExtentReport extent;
//	public ExtentTest test;
//
// 
//	public void onStart(ITestContext context)
//	{
//	/*	SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
//		Date dt=new Date();
//		String currentdatetimestamp=df.format(dt);*/
//		
//		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//		String myReport="Test-Report01-"+timestamp+".html";
//		sparkreporter =new ExtentSparkReporter("C:\\Users\\2303956\\eclipse-workspace\\HackathonProject\\reports\\"+myReport);
//		//sparkreporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/myReport.html");
//		sparkreporter.config().setDocumentTitle("Automation Report");
//		sparkreporter.config().setReportName("Functional Testing");
//		sparkreporter.config().setTheme(Theme.STANDARD);
//		extent=new ExtentReport();
//		extent.attachReporter(sparkreporter);
//		extent.setSystemInfo("Computer Name","localhost");
//		extent.setSystemInfo("Environment","QA");
//		extent.setSystemInfo("Tester Name","Raju Mokkarala");
//		extent.setSystemInfo("OS","Windows10");
//		extent.setSystemInfo("Browser name","Chrome,Firefox,Edge");
//	}
//	public void onTestStart(ITestResult result)
//	{ 
//		System.out.println("On Test Started.....");
//	}
//	public void onTestSuccess(ITestResult result)
//	{
//		String path;
//		      if(result.getName().equals("TravelInsuranceforStudents")) {
//			  path=TC_001_travel_Insurance.path;
//			  test=extent.createTest(result.getName()).addScreenCaptureFromPath(result.getName());
//			  }
//			  else if(result.getName().equals("travelinsurance")) 
//			  {
//			  path=TC_002_Car_Insurance.path;
//			  test=extent.createTest(result.getName()).addScreenCaptureFromPath( path,result.getName()); 
//			  }
//			  else if(result.getName().equals("carinsurance")) 
//			  {
//			  path=TC_003_Health_Insurance.path;
//			  test=extent.createTest(result.getName()).addScreenCaptureFromPath( path,result.getName());			  
//			  } 
//			  else if(result.getName().equals("healthinsurance")) 
//			  {
//			  path=TC_004_Health_insurance_products.path;
//			  test=extent.createTest(result.getName()).addScreenCaptureFromPath( path,result.getName());			  
//			  } 
//			  
//		test=extent.createTest(result.getName());
//		test.log(Status.PASS, "Test case Passed is:"+result.getName());
//	}
//	public void onTestFailure(ITestResult result)
//	{
//		test=extent.createTest(result.getName());
//		test.log(Status.FAIL, "Test case FAILED is:"+result.getName());
//		test.log(Status.FAIL, "Test casec FAILED CAUSE is:"+result.getThrowable());
// 
//	}
//	public void onTestSkipped(ITestResult result)
//	{
//		test=extent.createTest(result.getName());
//		test.log(Status.SKIP, "Test case SKIPPED is:"+result.getName());
//	}
//	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
//	{
//		System.out.println("onTestFailedButWithinSuccessPercentage...........");
//	}
//	public void onFinish(ITestContext context)
//	{
//		extent.flush();
//	}
// 
//}