package TestCases_ES;

import java.io.IOException;

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
import SpecificObjectActionES.GeneralInfoPageES;
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

public class TC09_Spain_ProposalGenerate {

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
	GeneralInfoPageES gipe=new GeneralInfoPageES();
	
	public static ExtentReports reports;
	public static ExtentTest logger;
	@BeforeSuite
	public void beforeSuite()
	{
		reports=new ExtentReports("D:\\Workspace\\CPQ\\src\\Report\\Report.html",true);
		logger=reports.startTest("TC09_Spain_ProposalGenerate");
	}
	
	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException
	{		
		CommonActions.LaunchDriver.launchbrowser();
		logger.log(LogStatus.PASS, "browser launch successfully");
	}
	@Test
	public void generateContract() throws IOException, InterruptedException
	{
		lae.setUniqueID("ES_AM");
		lae.FillLoginInfoES();	//Login
		logger.log(LogStatus.PASS, "Login successfully with UK QaMaster");
		ncqe.readQuoteNumberFromConfig();
		ncqe.setSearchAccountManagerQuotetxt(ncqe.getAccountManagerQuoteNumberRecent());
		ncqe.searchAccountManagerQuoteES();
		logger.log(LogStatus.PASS, "Quote number search successfully");
		ncqe.clickOnQuoteLinkES();
		noce.clickQuoteModificar();
		if(gipe.ClickCreateProposalTab())
		{
			logger.log(LogStatus.PASS, "ProposalTab Click successfully");
		}else
		{
			logger.log(LogStatus.FAIL, "ProposalTab not click");
		}
		gipe.clickGenerateProposal();
		logger.log(LogStatus.PASS, "Proposal generate successfully");
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		reports.endTest(logger);
		//CommonActions.CommonMethod.closeBrowser();
	}
	
	@AfterSuite
	public void afterSuite()
	{
		reports.close();
	}
}
