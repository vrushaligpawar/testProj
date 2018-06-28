package CommonActions;
//singleton class
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import Resources.ReadConfig;
import Resources.ReadConfigES;

public class LaunchDriver {

	static WebDriver driver;
	//static ChromeDriver driver;
	public static void launchbrowser() throws IOException, InterruptedException
	{
		String browser=ReadConfig.GetVal("browser");
		if(browser.equals("IE")){
			Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
			//Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			//capabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS, false);
			System.setProperty("webdriver.ie.driver","D:\\Workspace\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(2000);			
		}else if(browser.equals("chrome"))
		{
			//kill the all instances of browsers and browserdrivers before starting. this code can be kept in common class
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
		Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
			//Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
			System.setProperty("webdriver.chrome.driver","D:\\Workspace\\chromedriver.exe");

			ChromeOptions options = new ChromeOptions();
			//options.addArguments("start-maximized");
			options.setBinary("C:\\Users\\vp00498658\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
			options.addArguments("--disable-extentions");
			driver = new ChromeDriver(options);
			//System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
			//Thread.sleep(5000);
			driver.get("https://test.salesforce.com/");
			//driver.manage().window().maximize();
		}else
		{
			Exception e=new Exception();
		System.out.println(e +"browser not defined");
		}
	}
	
}
