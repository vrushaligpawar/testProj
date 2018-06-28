package TestCases_ES_FixedProduct;

import java.awt.AWTException;
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
import SpecificObjectActionES.CustomerSiteES;
import SpecificObjectActionES.LoginActionES;
import SpecificObjectActionES.NewAccountCreationES;
import SpecificObjectActionES.NewCPQQuoteES;
import SpecificObjectActionES.NewCleanButtonES;
import SpecificObjectActionES.NewContactCreationES;
import SpecificObjectActionES.NewOpportunityCreationES;
import SpecificObjectActionES.NewProductAddES;
import SpecificObjectActionES.SalesManager;
import SpecificObjectActionES.ScoringManager;
import SpecificObjectActionES.StateChangeES;
import SpecificObjectActionES.SubmitForApprovalES;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC03_Spain_FixedProduct_ApprovalSalesManager {

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
	CommonActionsInAppES caie=new CommonActionsInAppES();
	ApprovalStatusES ase=new ApprovalStatusES();
	ScoringManager scm=new ScoringManager();
	
	public static ExtentReports reports;
	public static ExtentTest logger;
	
	@BeforeSuite
	public void beforeSuite()
	{
		reports=new ExtentReports("D:\\Workspace\\CPQ\\src\\Report\\Report.html",true);
		logger=reports.startTest("TC03_Spain_FixedProduct_ApprovalSalesManager");
	}
	
	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException
	{		
		CommonActions.LaunchDriver.launchbrowser();
		logger.log(LogStatus.PASS, "browser launch successfully");
	}
	
	@Test
	public void salesManagerApproval() throws IOException, InterruptedException, AWTException
	{
		lae.setUniqueID("Sales_Manager");
		lae.FillLoginInfoES();	//Login
		sm.readSalesManagerSRNESFromConfig();
		logger.log(LogStatus.PASS,"Read SRN from Configfile");
		sm.setSearchSalesSRNtxt(sm.getSalesSRNumberRecent());
		sm.searchSalesSRNES();
		sm.enableSalesCPQApprovalES();
		ase.clickApprovalTabES();
		if(ase.verifyApprovalPendingImageES()) {
		logger.log(LogStatus.PASS, "Approval pending image found");
			}else
			{
				logger.log(LogStatus.FAIL, "Approval pending image not found");
			}
		ase.setApprovalReasonES();
		ase.clickConfirmApprovalES();
		ase.clickApprovalTickES();
		if(ase.verifyApprovedImageES()) {
			logger.log(LogStatus.PASS, "Approved image found");
				}else
			{
			 logger.log(LogStatus.FAIL, "Approved image not found");		
				}
		CommonActions.CommonMethod.pageRefresh();
		noce.returnToOpportunityES();
		if(!ase.verifyApprovedOnQuoteES()){
			logger.log(LogStatus.FAIL, "Approved label on Quote not found");
				}else
				{
			logger.log(LogStatus.PASS, "Approved label on Quote found");
				}
		scm.collectScoringManagerSRNES();
		logger.log(LogStatus.PASS, "Collect Scoring Manager SRN");
		//caie.logoutES();
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
	
	

