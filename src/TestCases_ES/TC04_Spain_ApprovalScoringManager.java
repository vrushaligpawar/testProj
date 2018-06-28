package TestCases_ES;


import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import CommonActions.CommonMethod;
import Resources.ReadConfig;
import SpecificObjectAction.AddIntegratedMobileTraiff;
import SpecificObjectAction.ApprovalStatus;
import SpecificObjectAction.CommonErrorMsg;
import SpecificObjectActionES.AddProductLinesOffice365ES;
import SpecificObjectActionES.AddProductOffice365ES;
import SpecificObjectActionES.ApprovalStatusES;
import SpecificObjectActionES.CommonActionsInAppES;
import SpecificObjectActionES.CustomerSiteES;
import SpecificObjectActionES.LoginActionES;
import SpecificObjectActionES.NewAccountCreationES;
import SpecificObjectActionES.NewCPQQuoteES;
import SpecificObjectActionES.NewCleanButtonES;
import SpecificObjectActionES.NewContactCreationES;
import SpecificObjectActionES.NewOpportunityCreationES;
import SpecificObjectActionES.NewProductAddES;
import SpecificObjectActionES.RegionalManager;
import SpecificObjectActionES.SalesManager;
import SpecificObjectActionES.ScoringManager;
import SpecificObjectActionES.StateChangeES;
import SpecificObjectActionES.SubmitForApprovalES;


public class TC04_Spain_ApprovalScoringManager {
	public static ExtentReports reports;
	public static ExtentTest logger;
	
	LoginActionES lae=new LoginActionES();
	NewAccountCreationES nace=new NewAccountCreationES();
	NewCleanButtonES ncbe=new NewCleanButtonES();
	NewContactCreationES ncce=new NewContactCreationES();
	CustomerSiteES cse=new CustomerSiteES();
	NewOpportunityCreationES noce=new NewOpportunityCreationES();
	NewProductAddES npae=new NewProductAddES();
	StateChangeES sce=new StateChangeES();
	NewCPQQuoteES ncqe=new NewCPQQuoteES();
	AddProductLinesOffice365ES aploe=new AddProductLinesOffice365ES();
	AddProductOffice365ES apoe=new AddProductOffice365ES(); 
	SubmitForApprovalES sfae=new SubmitForApprovalES();
	SalesManager sm=new SalesManager();
	ScoringManager scm=new ScoringManager();
	CommonActionsInAppES caie=new CommonActionsInAppES();
	ApprovalStatusES ase=new ApprovalStatusES();
	RegionalManager rm=new RegionalManager();
	
	@BeforeSuite
	public void beforeSuite()
	{
		reports=new ExtentReports("D:\\Workspace\\CPQ\\src\\Report\\Report.html",true);
		logger=reports.startTest("TC04_Spain_ApprovalScoringManager");
	}
	
	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException
	{		
		CommonActions.LaunchDriver.launchbrowser();
		logger.log(LogStatus.PASS, "browser launch successfully");
	}
	
	@Test
	public void scoringManagerApproval() throws IOException, InterruptedException, AWTException
	{
		
		lae.setUniqueID("Scoring_Manager");
		lae.FillLoginInfoES();	//Login
		logger.log(LogStatus.PASS, "Login successfully with Spain Scoring Manager");
		scm.readScoringManagerSRNESFromConfig();
		logger.log(LogStatus.PASS,"Read SRN from Configfile");
		scm.setSearchScoringSRNtxt(sm.getSalesSRNumberRecent());
		scm.searchScoringSRNES();
		scm.enableScoringCPQApprovalES();
		ase.clickApprovalTabES();
		if(ase.verifyApprovalPendingImageES()) {
		logger.log(LogStatus.PASS, "Approval pending image found");
			};
		ase.setApprovalReasonES();
		ase.clickConfirmApprovalES();
		ase.clickApprovalTickES();
		if(ase.verifyApprovedImageES()) {
			logger.log(LogStatus.PASS, "Approved image not found");
				};
		//CommonActions.CommonMethod.pageRefresh();
		noce.returnToOpportunityES();
		if(!ase.verifyApprovedOnQuoteES()){
			logger.log(LogStatus.FAIL, "Approved label on Quote found");
				}else
				{
			logger.log(LogStatus.PASS, "Approved label on Quote not found");
				}
		rm.collectRegionalDirectorSRNES();
		logger.log(LogStatus.PASS, "Collect Regional Manager SRN");
		caie.logoutES();
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
	}

		
}
