package TestCases_ES_FixedProduct;


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

import SpecificObjectActionES.AddProductLinesOffice365ES;
import SpecificObjectActionES.AddProductOffice365ES;
import SpecificObjectActionES.ApprovalStatusES;
import SpecificObjectActionES.CommercialManager;
import SpecificObjectActionES.CommonActionsInAppES;
import SpecificObjectActionES.CustomerSiteES;
import SpecificObjectActionES.FinanceManager;
import SpecificObjectActionES.LoginActionES;
import SpecificObjectActionES.NewAccountCreationES;
import SpecificObjectActionES.NewCPQQuoteES;
import SpecificObjectActionES.NewCleanButtonES;
import SpecificObjectActionES.NewContactCreationES;
import SpecificObjectActionES.NewOpportunityCreationES;
import SpecificObjectActionES.NewProductAddES;
import SpecificObjectActionES.RegionalManager;
import SpecificObjectActionES.SalesManager;
import SpecificObjectActionES.StateChangeES;
import SpecificObjectActionES.SubmitForApprovalES;



public class TC06_Spain_FixedProduct_ApprovalCommericalManager {
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
	CommonActionsInAppES caie=new CommonActionsInAppES();
	ApprovalStatusES ase=new ApprovalStatusES();
	RegionalManager rm=new RegionalManager();
	CommercialManager com=new CommercialManager();
	FinanceManager fm=new FinanceManager();
	
	@BeforeSuite
	public void beforeSuite()
	{
		reports=new ExtentReports("D:\\Workspace\\CPQ\\src\\Report\\Report.html",true);
		logger=reports.startTest("TC19_Spain_FixedProduct_ApprovalCommericalManager");
	}
	
	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException
	{		
		CommonActions.LaunchDriver.launchbrowser();
		logger.log(LogStatus.PASS, "browser launch successfully");
	}
	
	@Test
	public void ApprovalCommericalManager() throws IOException, InterruptedException, AWTException
	{
		
		lae.setUniqueID("Commercial_Manager");
		lae.FillLoginInfoES();	//Login
		logger.log(LogStatus.PASS, "Login successfully with Spain Commercial_Manager");
		com.readCommercialManagerSRNESFromConfig();
		logger.log(LogStatus.PASS,"Read SRN from Configfile");
		com.setSearchCommercialSRNtxt(com.getCommercialSRNumberRecent());
		com.searchCommercialSRNES();
		com.enableCommercialCPQApprovalES();
		ase.clickApprovalTabES();
		if(ase.verifyApprovalPendingImageES()) {
		logger.log(LogStatus.FAIL, "Approval pending image found");
			};
		ase.setApprovalReasonES();
		ase.clickApprovalTickES();
		if(ase.verifyApprovedImageES()) {
			logger.log(LogStatus.FAIL, "Approved image found");
				};
		CommonActions.CommonMethod.pageRefresh();
		noce.returnToOpportunityES();
		if(!ase.verifyApprovedOnQuoteES()){
			logger.log(LogStatus.FAIL, "Approved label on Quote not found");
				}else
				{
			logger.log(LogStatus.PASS, "Approved label on Quote found");
				}
		fm.collectFinanceManagerSRNES();
		logger.log(LogStatus.PASS, "Collect Finance Manager SRN");
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
