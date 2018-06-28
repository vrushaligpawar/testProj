package TestCases_UK_Pre;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import SpecificObjectAction.CommonActionsInApp;
import SpecificObjectAction.LoginAction;
import SpecificObjectAction.NewAccountCreation;
import SpecificObjectAction.NewCleanButton;
import SpecificObjectAction.NewContactCreation;
import SpecificObjectAction.NewOpportunityCreation;
import SpecificObjectAction.NewProductAdd;
import SpecificObjectAction.StateChange;
import Resources.WriteConfigFile;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Perequisite_CreateAccount {
	LoginAction la=new LoginAction();
	NewAccountCreation nac=new NewAccountCreation();
	NewCleanButton cb=new NewCleanButton();
	NewContactCreation ncc=new NewContactCreation();
	NewOpportunityCreation noc=new NewOpportunityCreation();
	NewProductAdd npa=new NewProductAdd();
	StateChange sc=new StateChange();
	CommonActionsInApp cai=new CommonActionsInApp();
	public static ExtentReports reports;
	public static ExtentTest logger;
	

	@BeforeTest
	public void beforeTest() throws IOException, InterruptedException
	{
		System.out.println("this is before test");
	}
	
	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException
	{		
		/*reports=new ExtentReports("D:\\Workspace\\CPQ\\src\\Report.html",true);
		logger=reports.startTest("Perequisite_CreateAccount");
		CommonActions.LaunchDriver.launchbrowser();
		logger.log(LogStatus.PASS, "browser launch successfully");*/
		System.out.println("this is before method");
	}
	
	@Test(priority=1)
	public void createAccount() throws IOException, InterruptedException
	{
		/*la.setUniqueID("UK_AM");
		la.FillLoginInfo();	//Login
		logger.log(LogStatus.PASS, "Login successfully with UK QaMaster");
		nac.setUniqueID("UK"); 
		nac.clickAccountTab();
		nac.AccountCreationInfo();//New account creation	
		logger.log(LogStatus.PASS, "Account created successfully");
		cb.setUniqueID("Global");cb.cleaninfo();	//Clean button action perform
		logger.log(LogStatus.PASS, "Clean action performed");	
		CommonActions.CommonMethod.closeBrowser();*/
		System.out.println("this is Test1 ");
	}
	
	@Test(priority=2)
	public void createAccount2() throws IOException, InterruptedException
	{
		/*la.setUniqueID("UK_CM");
		la.FillLoginInfo();	//Login
		logger.log(LogStatus.PASS, "Login successfully with UK CMQaMaster");
		nac.setUniqueID("UK"); 
		nac.clickAccountTab();
		nac.AccountCreationInfo();//New account creation	
		logger.log(LogStatus.PASS, "Account created successfully");
		cb.setUniqueID("Global");cb.cleaninfo();	//Clean button action perform
		logger.log(LogStatus.PASS, "Clean action performed");	*/
		System.out.println("this is Test2 ");
	}
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException
	{
		/*reports.close();
		reports.endTest(logger);
		CommonActions.CommonMethod.closeBrowser();*/
		System.out.println("this is after method ");
		//Thread.sleep(9000);
	}
	
	@AfterTest
	public void afterTest() throws InterruptedException
	{
		/*reports.close();
		reports.endTest(logger);
		Thread.sleep(5000);*/
		System.out.println("this is after Test ");
	}
}
