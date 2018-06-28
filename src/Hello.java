import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Hello {
	public WebDriver driver;
	public static void main(String[] args) throws IOException 
	{
		/*//Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
		Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
		System.out.println("browser launching successfully");*/
		
		
DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
System.setProperty("webdriver.ie.driver","D:\\Workspace\\IEDriverServer.exe");
/*System.setProperty("webdriver.firefox.marionette","D:\\Workspace\\geckodriver.exe");
System.setProperty("webdriver.gecko.driver","D:\\Workspace\\geckodriver.exe");
System.setProperty("webdriver.chrome.driver","D:/Workspace/chromedriver.exe");
System.setProperty("webdriver.chrome.logfile", "D:/Workspace/chromedriver.log");
WebDriver driver = new ChromeDriver();*/
WebDriver driver = new InternetExplorerDriver();
//WebDriver driver = new FirefoxDriver();
driver.get("https://google.com");
//Date date = Calendar.getInstance().getTime();

/*// Display a date in day, month, year format
DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
String today = formatter.format(date);
System.out.println(today);*/

//int result = Math.incrementExact(3051);
//System.out.println("Use of incrementExact() : " + result);
//System.out.println("");

//double result=Math.floor(Math.random() * 5) + 1;
//System.out.println(result);

//String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
//System.out.println(timeStamp);
	}

}
