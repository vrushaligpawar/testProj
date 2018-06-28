package TestCases_UK;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.remote.server.handler.CloseWindow;
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
import SpecificObjectAction.CommercialUser;
import SpecificObjectAction.CommonActionsInApp;
import SpecificObjectAction.CommonErrorMsg;
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


public class TC15_LC_SelfApproval {
	ExtentReports reports;
	ExtentTest logger;
	
	LoginAction la=new LoginAction();
	NewAccountCreation nac=new NewAccountCreation();
	NewCleanButton cb=new NewCleanButton();
	NewContactCreation ncc=new NewContactCreation();
	NewOpportunityCreation noc=new NewOpportunityCreation();
	NewProductAdd npa=new NewProductAdd();
	StateChange sc=new StateChange();
	NewCPQQuote ncq=new NewCPQQuote();
	AddIntegratedMobileTraiff aimt=new AddIntegratedMobileTraiff();
	SubmitForApproval sfa=new SubmitForApproval();
	ApprovalStatus as=new ApprovalStatus();
	CommonErrorMsg cem= new CommonErrorMsg();
	CommercialUser cu=new CommercialUser();
	CommonActionsInApp cai=new CommonActionsInApp();
	
	@BeforeSuite
	public void beforeSuite()
	{
		reports=new ExtentReports("D:\\Workspace\\CPQ\\src\\Report\\Report.html",true);
		logger=reports.startTest("TC15_LC Approval");
	}
	
	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException
	{		
		CommonActions.LaunchDriver.launchbrowser();
		logger.log(LogStatus.PASS, "browser launch successfully");
	}
	
	@Test
	public void lCApproval() throws IOException, InterruptedException, AWTException
	{
		
		la.setUniqueID("UK_AM");
		la.FillLoginInfo();	//Login
		logger.log(LogStatus.PASS, "Login successfully with UK QaMaster");
		nac.clickAccountTab();
		nac.setUniqueID("UK"); nac.AccountCreationInfo();
		logger.log(LogStatus.PASS, "Account created successfully");
		cb.setUniqueID("Global");cb.cleaninfo();	//Clean button action perform
		logger.log(LogStatus.PASS, "Clean action performed");
		ncc.setUniqueID("UKContact");ncc.NewContactCreationInfo();	//New Contact creation		
		logger.log(LogStatus.PASS, "Contact created successfully");
		noc.setUniqueID("UK");noc.NewOpportunityCreationInfo();//New Opportunity creation
		logger.log(LogStatus.PASS, "Opportunity created successfully");
		npa.setUniqueID("UK");npa.productAdd();//Add New Product
		logger.log(LogStatus.PASS,"Product added successfully");
		sc.setUniqueID("stageQualify");sc.statechangeQ();//Stage change
		logger.log(LogStatus.PASS, "Stage change successfully from Identify to Qualify"); 
		ncq.clickNewCpqQuote();
		ncq.clickContinueCPQ();
		ncq.addCpqQuoteProduct(); //click on add CPQ button
		aimt.setUniqueID("UKTraiff1");aimt.addIntegratedMobileTraiff();//add integrated mobile tariff
		ncq.updateSaveAddProduct();
		//cem.checkElement("errorMessage_GI_XP", true, "Quote not created error occured",5);
		/*if(cem.checkErrorMessage()){
			logger.log(LogStatus.FAIL,"Quote not created error occured");
			org.testng.Assert.fail("Quote not created error occured");
		} else
			{logger.log(LogStatus.PASS,"Quote created successfully");}
		*/
		
		ncq.returnOpportunityPage();	
		sc.setUniqueID("stagePropose");sc.statechangeQ();//Stage change to propose
		noc.editQuotelink();//click on Edit Quote link
		sfa.selfApproval(); //Self Approval
		logger.log(LogStatus.PASS, "Self approval suceesfully completed");
		as.clickApprovalTab();
		if(!as.verifyApprovalPendingImage()) {
			logger.log(LogStatus.FAIL, "Approval pending image not found");
			};
		as.setApprovalReason();
		as.clickApprovalTick();
		if(!as.verifyApprovedImage()) {
			logger.log(LogStatus.FAIL, "Approved image not found");
			};
		ncq.returnOpportunityPage();
		if(!as.verifyApprovedOnQuote()){
			logger.log(LogStatus.FAIL, "Approved label on Quote not found");
		}else
		{
			logger.log(LogStatus.PASS, "Approved label on Quote found");
		}
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
