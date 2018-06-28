import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import SpecificObjectAction.LoginAction;


public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		System.setProperty("webdriver.ie.driver","D:\\Workspace\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
driver.navigate().to("https://test.salesforce.com/");
		
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("account_manager_uk@vfglobalorg.com.qamaster");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Vodafone_TechM19");
		driver.findElement(By.xpath("//*[@id='Login']")).click();
		boolean isElementdisplayed=driver.findElement(By.xpath("//*[@id='Account_Tab']")).isEnabled();
		if(isElementdisplayed=true){
			System.out.println("element present");
		}else
		{
			System.out.println("element not visiable");
		}
		
		
		
	}

}
