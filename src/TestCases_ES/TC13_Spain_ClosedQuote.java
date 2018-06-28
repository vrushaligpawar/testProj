package TestCases_ES;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import SpecificObjectActionES.AddProductLinesOffice365ES;
import SpecificObjectActionES.AddProductOffice365ES;
import SpecificObjectActionES.ApprovalStatusES;
import SpecificObjectActionES.CommonActionsInAppES;
import SpecificObjectActionES.CommonErrorMsgES;
import SpecificObjectActionES.LoginActionES;
import SpecificObjectActionES.NewAccountCreationES;
import SpecificObjectActionES.NewCPQQuoteES;
import SpecificObjectActionES.NewOpportunityCreationES;
import SpecificObjectActionES.NewProductAddES;
import SpecificObjectActionES.SalesManager;
import SpecificObjectActionES.StateChangeES;
import SpecificObjectActionES.SubmitForApprovalES;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC13_Spain_ClosedQuote {

	LoginActionES lae=new LoginActionES();
	NewAccountCreationES nace=new NewAccountCreationES();
	NewOpportunityCreationES noce=new NewOpportunityCreationES();
	NewProductAddES npae=new NewProductAddES();
	StateChangeES sce=new StateChangeES();
	NewCPQQuoteES ncqe=new NewCPQQuoteES();
	AddProductLinesOffice365ES aploe=new AddProductLinesOffice365ES();
	AddProductOffice365ES apoe=new AddProductOffice365ES(); 
	SubmitForApprovalES sfae=new SubmitForApprovalES();
	SalesManager sm=new SalesManager();
	CommonActionsInAppES caie=new CommonActionsInAppES();
	ApprovalStatusES ase=new ApprovalStatusES();
	CommonErrorMsgES ceme=new CommonErrorMsgES();
	
	public static ExtentReports reports;
	public static ExtentTest logger;
		
	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException
	{		
		reports=new ExtentReports("D:\\Workspace\\CPQ\\src\\Report\\Report.html",true);
		logger=reports.startTest("TC13_Spain_ClosedQuote");
		CommonActions.LaunchDriver.launchbrowser();
		logger.log(LogStatus.PASS, "browser launch successfully");
	}
	@Test
	public void closedQuote() throws IOException, InterruptedException
	{
		lae.setUniqueID("ES_AM");
		lae.FillLoginInfoES();	//Login
		logger.log(LogStatus.PASS, "Login successfully with UK QaMaster");
		ncqe.readQuoteNumberFromConfig();
		ncqe.setSearchAccountManagerQuotetxt(ncqe.getAccountManagerQuoteNumberRecent());
		ncqe.searchAccountManagerQuoteES();
		ncqe.clickOnQuoteLinkES();
		noce.clickOnOPPNameLink();
		sce.setUniqueID("stageNegotiate");sce.statechangeQES();//Stage change to Negotiate
		logger.log(LogStatus.PASS, "State change to Negotiate");
		Thread.sleep(5000);
		sce.setUniqueID("stageClosedWon");sce.stateChangeClosedWon();//Stage change to ClosedWon
		if(ceme.checkErrorMessageStageClosedWonES())
		{
			logger.log(LogStatus.FAIL, "Error occoured while change Stage to ClosedWon");
		}else
		{
			logger.log(LogStatus.PASS, "Stage change to ClosedWon Successfully");
		}
	}
	
	@AfterMethod
	public void screencapture(ITestResult result)
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
		try 
		{
			CommonActions.CommonMethod.captureScreenMethod();
			System.out.println("Screenshot taken");
		}catch (Exception e)
		{
			System.out.println("Exception while taking screenshot "+e.getMessage());
		}
		}
		reports.endTest(logger);
		reports.close();
		//CommonActions.CommonMethod.closeBrowser();
	}
	
}
