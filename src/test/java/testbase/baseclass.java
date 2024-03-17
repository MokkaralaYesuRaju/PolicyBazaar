package testbase;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
public class baseclass{
	//public ResourceBundle rb;//to read config.properties file
	//static String url="https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx"
	public static WebDriver driver;
		public static String browserType;
		public static Logger logger;
		
		public static Properties p;
		//JavascriptExecutor js =(JavascriptExecutor) driver;
		
		@BeforeClass(groups= {"sanity","regression","master"})
		@Parameters({"os", "browser"})
		public  void getWebDriver(String os,String browser) throws IOException
		{
			logger=LogManager.getLogger(this.getClass());
			FileReader file = new FileReader(".//src/test/resources/config.properties");
			p = new Properties();
			p.load(file);
			if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
				DesiredCapabilities capabalities = new DesiredCapabilities();
				if(os.equalsIgnoreCase("windows")) {
					capabalities.setPlatform(Platform.WIN11);
				}
				else if (os.equalsIgnoreCase("mac")) {
					capabalities.setPlatform(Platform.MAC);
				}
				else {
					System.out.println("no matching os .....");
					return;
				}
				if(browser.equalsIgnoreCase("chrome")) {
					ChromeOptions option = new ChromeOptions();
					option.addArguments("--disable-blink-features=AutomationControlled");
					option.addArguments("--disable-notifications");
					capabalities.setBrowserName("chrome");
					capabalities.setCapability(ChromeOptions.CAPABILITY, option);				
				}
				else if(browser.equalsIgnoreCase("edge")) {
					EdgeOptions options = new EdgeOptions();
					options.addArguments("--disable-blink-features=AutomationControlled");
					options.addArguments("--disable-notifications");
					capabalities.setBrowserName("MicrosoftEdge");
					capabalities.setCapability(EdgeOptions.CAPABILITY, options);
				}
				else {
					System.out.println("no matching browser .....");
					return;
				}
				 driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub") , capabalities);
			}
			else if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
				if(browser.equalsIgnoreCase("chrome")) {
					ChromeOptions option = new ChromeOptions();
					option.addArguments("--disable-blink-features=AutomationControlled");
					option.addArguments("--disable-notifications");
					driver = new ChromeDriver(option);
					logger.info("Chrome browser opened successfully");
				}
				else if(browser.equalsIgnoreCase("edge")){
					EdgeOptions options = new EdgeOptions();
					options.addArguments("--disable-blink-features=AutomationControlled");
					options.addArguments("--disable-notifications");
					driver = new EdgeDriver(options);
					logger.info("Edge browser opened successfully");
				}
				else {
					System.out.println("no matching browser......");
					logger.info("no matching browser......");
					return;
				}
			}
//			ChromeOptions option = new ChromeOptions();
//			   option.addArguments("--disable-blink-features=AutomationControlled");
//			   option.addArguments("--disable-notifications");
//			   driver = new ChromeDriver(option);
			//driver = new ChromeDriver();
			//driver.get("https://www.policybazaar.com/");
					  // driver.get("https://www.policybazaar.com/");
			  // driver.manage().window().maximize();
			  // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(p.getProperty("AppUrl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 
		}

		@AfterClass(groups= {"sanity","regression","master"})
		public void closeBowser() {
			driver.quit();
		 }
		public static Properties getProperties() throws IOException {
			FileReader file = new FileReader(".//src/test/resources/config.properties");
			p = new Properties();
			p.load(file);
			return p;
		}
		public static String captureScreenshot(String tname) {
			
			String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			TakesScreenshot tc = (TakesScreenshot) driver;
			File src = tc.getScreenshotAs(OutputType.FILE);
			String name = System.getProperty("user.dir")+"\\reports\\"+tname+"_"+timeStamp+".png";
			File tgt = new File(name);
			src.renameTo(tgt);
			return name;
			
		}

	 
	 
	
}
	


