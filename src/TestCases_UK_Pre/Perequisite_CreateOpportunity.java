package TestCases_UK_Pre;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Resources.ReadConfig;
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

public class Perequisite_CreateOpportunity {
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
	
	@BeforeSuite
	public void beforeSuite()
	{
		reports=new ExtentReports("D:\\Workspace\\CPQ\\src\\Report.html",true);
		logger=reports.startTest("Perequisite_CreateOpportunity");
	}
	
	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException
	{		
		CommonActions.LaunchDriver.launchbrowser();
		logger.log(LogStatus.PASS, "browser launch successfully");
	}
	@Test (priority=3)
	public void createOpportunity() throws IOException, InterruptedException
	{
		la.setUniqueID("UK_AM");
		la.FillLoginInfo();	//Login
		logger.log(LogStatus.PASS, "Login successfully with UK QaMaster");
		nac.setUniqueID("UK"); 
		nac.clickAccountTab();
		nac.AccountCreationInfo();//New account creation	
		logger.log(LogStatus.PASS, "Account created successfully");
		cb.setUniqueID("Global");cb.cleaninfo();	//Clean button action perform
		logger.log(LogStatus.PASS, "Clean action performed");
		ncc.setUniqueID("UKContact");ncc.NewContactCreationInfo();	//New Contact creation		
		logger.log(LogStatus.PASS, "Contact created successfully");
		
		cai.logout();
		
	
	}
	@AfterMethod
	public void closeBrowser()
	{
		
		reports.endTest(logger);
	}
	
	@AfterSuite
	public void afterSuite()
	{
		reports.close();
		CommonActions.CommonMethod.closeBrowser();
	}
}
