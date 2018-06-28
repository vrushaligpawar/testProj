package TestCases_ES;
/*package TestCases_ES;


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
import SpecificObjectActionES.SalesManager;
import SpecificObjectActionES.StateChangeES;
import SpecificObjectActionES.SubmitForApprovalES;
import SpecificObjectAction.LoginAction;
import SpecificObjectAction.NewAccountCreation;
import SpecificObjectAction.NewCPQQuote;
import SpecificObjectAction.NewCleanButton;
import SpecificObjectAction.NewContactCreation;
import SpecificObjectAction.NewOpportunityCreation;
import SpecificObjectAction.NewProductAdd;
import SpecificObjectAction.StateChange;
import SpecificObjectAction.SubmitForApproval;
import SpecificObjectAction.SubmitForApproval;

public class Spain_MobileProduct_Approval_01 {
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
	
	@BeforeSuite
	public void beforeSuite()
	{
		reports=new ExtentReports("D:\\Workspace\\CPQ\\src\\Report\\Report.html",true);
		logger=reports.startTest("Spain_MobileProduct_Approval_01");
	}
	
	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException
	{		
		CommonActions.LaunchDriver.launchbrowser();
		logger.log(LogStatus.PASS, "browser launch successfully");
	}
	
	@Test
	public void LcApproval() throws IOException, InterruptedException, AWTException
	{
		lae.setUniqueID("ES_AM");
		lae.FillLoginInfoES();	//Login
		logger.log(LogStatus.PASS, "Login successfully with Spain QaMaster");
		nace.setUniqueID("ES"); 
		nace.clickAccountTabES();
		nace.AccountCreationInfoES();//New account creation
		System.out.println(nace.getAccountName());
		logger.log(LogStatus.PASS, "Spain Account created successfully");
		ncbe.setUniqueID("Global");ncbe.cleaninfoES();	//Clean button action perform
		logger.log(LogStatus.PASS, "Clean action performed");
		cse.setUniqueID("ES1");cse.newCustomerSitesES(); //New Customer site creation
		ncce.setUniqueID("ESContact");ncce.ContactCreationInfoES();	//New Contact creation		
		logger.log(LogStatus.PASS, "Spain Contact created successfully"); 
		noce.setUniqueID("ES");noce.NewOpportunityCreationInfoES();//New Opportunity creation
		logger.log(LogStatus.PASS, "Spain Opportunity created successfully");
		npae.setUniqueID("ES");npae.productAddES();//Add New Product
		logger.log(LogStatus.PASS,"Spain Product added successfully");
		sce.setUniqueID("stageQualify");sce.statechangeQES();//Stage change
		logger.log(LogStatus.PASS, "Stage change successfully from Identify to Qualify"); 
		ncqe.addCpqQuoteES(); //click on add CPQ button 
		ncqe.navigateToOfficeAppES();
		//aploe.setUniqueID("ES1");aploe.addLinesOffice365ES(); //add product lines and discount
		apoe.setUniqueID("ES1");apoe.addProductOffice365ES(); //add product 
		ncqe.updateSaveAddProductES();
		noce.returnToOpportunityES(); 
		noce.opportunityRoadmapCreationES(); 
		sce.setUniqueID("stagePropose");sce.statechangeQES();//Stage change to propose 
		noce.editQuotelinkES();//click on Edit Quote link  
		sfae.preReqForApproval();
		sfae.submitForApprovalES();
		sfae.checkLevelApprover(); 
		ase.clickApprovalTabES();
		if(!ase.verifyApprovalPendingImageES()) {
			logger.log(LogStatus.FAIL, "Approval pending image not found");
				};
		noce.returnToOpportunityES();  
		noce.collectSalesManagerSRNES();
		CommonActions.CommonMethod.logoutAMES();// logout spain account manager 
		
		
		lae.setUniqueID("Sales_Manager");
		lae.FillLoginInfoES();	//Login
		logger.log(LogStatus.PASS, "Login successfully with Spain Sales Manager");
		noce.readSalesManagerSRNESFromConfig();
		sm.setSRNumber(noce.getSalesSRNumberRecent());  //get SRN number
		//noce.getSalesSRNumberRecent();
		caie.setSearchtxt(noce.getSalesSRNumberRecent());
		caie.searchCMES();
		sm.enableCPQApprovalES();
		ase.clickApprovalTabES();
		if(!ase.verifyApprovalPendingImageES()) {
		logger.log(LogStatus.FAIL, "Approval pending image not found");
			};
		ase.setApprovalReasonES();
		ase.clickApprovalTickES();
		if(!ase.verifyApprovedImageES()) {
			logger.log(LogStatus.FAIL, "Approved image not found");
				};
		CommonActions.CommonMethod.pageRefresh();
		noce.returnToOpportunityES();
		if(!ase.verifyApprovedOnQuoteES()){
			logger.log(LogStatus.FAIL, "Approved label on Quote not found");
				}else
				{
			logger.log(LogStatus.PASS, "Approved label on Quote found");
				}
		noce.collectScoringManagerSRNES();
		CommonActions.CommonMethod.logoutAMES();// logout spain sales manager
		
		
		
		lae.setUniqueID("Scoring Manager");
		lae.FillLoginInfoES();	//Login
		logger.log(LogStatus.PASS, "Login successfully with Spain Scoring Manager");
		sm.setSRNumber(noce.getSRNumber());  //get SRN number
		caie.setSearchtxt(noce.getSRNumber());
		caie.searchCMES();
		sm.enableCPQApprovalES();
		ase.clickApprovalTabES();
		if(!ase.verifyApprovalPendingImageES()) {
		logger.log(LogStatus.FAIL, "Approval pending image not found");
			};
		ase.setApprovalReasonES();
		ase.clickApprovalTickES();
		if(!ase.verifyApprovedImageES()) {
			logger.log(LogStatus.FAIL, "Approved image not found");
				};
		CommonActions.CommonMethod.pageRefresh();
		noce.returnToOpportunityES();
		if(!ase.verifyApprovedOnQuoteES()){
			logger.log(LogStatus.FAIL, "Approved label on Quote not found");
				}else
				{
			logger.log(LogStatus.PASS, "Approved label on Quote found");
				}
		noce.collectRegionalDirectorSRNES();
		CommonActions.CommonMethod.logoutAMES();// logout spain Scoring Manager
		
		
		
		lae.setUniqueID("Regional Director");
		lae.FillLoginInfoES();	//Login
		logger.log(LogStatus.PASS, "Login successfully with Spain Regional Director");
		sm.setSRNumber(noce.getSRNumber());  //get SRN number
		caie.setSearchtxt(noce.getSRNumber());
		caie.searchCMES();
		sm.enableCPQApprovalES();
		ase.clickApprovalTabES();
		if(!ase.verifyApprovalPendingImageES()) {
		logger.log(LogStatus.FAIL, "Approval pending image not found");
			};
		ase.setApprovalReasonES();
		ase.clickApprovalTickES();
		if(!ase.verifyApprovedImageES()) {
			logger.log(LogStatus.FAIL, "Approved image not found");
				};
		CommonActions.CommonMethod.pageRefresh();
		noce.returnToOpportunityES();
		if(!ase.verifyApprovedOnQuoteES()){
			logger.log(LogStatus.FAIL, "Approved label on Quote not found");
				}else
				{
			logger.log(LogStatus.PASS, "Approved label on Quote found");
				}
		noce.collectCommercialManagerSRNES();
		CommonActions.CommonMethod.logoutAMES();// logout spain Regional Director
		
		
		lae.setUniqueID("Commercial Manager");
		lae.FillLoginInfoES();	//Login
		logger.log(LogStatus.PASS, "Login successfully with Spain Commercial Manager");
		sm.setSRNumber(noce.getSRNumber());  //get SRN number
		caie.setSearchtxt(noce.getSRNumber());
		caie.searchCMES();
		sm.enableCPQApprovalES();
		ase.clickApprovalTabES();
		if(!ase.verifyApprovalPendingImageES()) {
		logger.log(LogStatus.FAIL, "Approval pending image not found");
			};
		ase.setApprovalReasonES();
		ase.clickApprovalTickES();
		if(!ase.verifyApprovedImageES()) {
			logger.log(LogStatus.FAIL, "Approved image not found");
				};
		CommonActions.CommonMethod.pageRefresh();
		noce.returnToOpportunityES();
		if(!ase.verifyApprovedOnQuoteES()){
			logger.log(LogStatus.FAIL, "Approved label on Quote not found");
				}else
				{
			logger.log(LogStatus.PASS, "Approved label on Quote found");
				}
		noce.collectFinanceManagerSRNES();
		CommonActions.CommonMethod.logoutAMES();// logout spain Commercial Manager
		
		
		
		lae.setUniqueID("Finance Manager");
		lae.FillLoginInfoES();	//Login
		logger.log(LogStatus.PASS, "Login successfully with Spain Finance Manager");
		sm.setSRNumber(noce.getSRNumber());  //get SRN number
		caie.setSearchtxt(noce.getSRNumber());
		caie.searchCMES();
		sm.enableCPQApprovalES();
		ase.clickApprovalTabES();
		if(!ase.verifyApprovalPendingImageES()) {
		logger.log(LogStatus.FAIL, "Approval pending image not found");
			};
		ase.setApprovalReasonES();
		ase.clickApprovalTickES();
		if(!ase.verifyApprovedImageES()) {
			logger.log(LogStatus.FAIL, "Approved image not found");
				};
			//CommonActions.CommonMethod.pageRefresh();
		noce.returnToOpportunityES();
		if(!ase.verifyApprovedOnQuoteES()){
		logger.log(LogStatus.FAIL, "Approved label on Quote not found");
			}else
			{
		logger.log(LogStatus.PASS, "Approved label on Quote found");
			}
		CommonActions.CommonMethod.logoutAMES();// logout spain Finance Manager
		
		
		
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
*/