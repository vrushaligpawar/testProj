package TestCases_UK;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

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
import SpecificObjectAction.QuoteSummary;
import SpecificObjectAction.StateChange;
import SpecificObjectAction.SubmitForApproval;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC16_PS_QuoteSummaryGenerate {

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
	QuoteSummary qs=new QuoteSummary();
	
	
	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException
	{		
		reports=new ExtentReports("D:\\Workspace\\CPQ\\src\\Report\\TC16_PS_QuoteSummaryGenerate.html",true);
		logger=reports.startTest("TC16_PS_QuoteSummaryGenerate");
		CommonActions.LaunchDriver.launchbrowser();
		logger.log(LogStatus.PASS, "browser launch successfully");
	}
	
	@Test
	public void quoteSummaryGenerate() throws IOException, InterruptedException, AWTException
	{
		
		la.setUniqueID("UK_AM");
		la.FillLoginInfo();	//Login
		logger.log(LogStatus.PASS, "Login successfully with UK QaMaster");
		nac.setUniqueID("UK"); 
		nac.clickAccountTab();
		nac.publicSectorAccountCreation();//New account creation	
		System.out.println(nac.getAccountName());
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
		Thread.sleep(10000);
		ncq.clickNewCpqQuote();
		ncq.clickContinueCPQ();
		ncq.addCpqQuoteProduct(); //click on add CPQ button
		aimt.setUniqueID("UKTraiff1");aimt.addIntegratedMobileTraiff();
		aimt.editOfferPriceIntegratedMobileTraiff();//Quote creation(offer price edit)
		ncq.updateSaveAddProduct();
		if(cem.checkErrorMessage()){
			logger.log(LogStatus.FAIL,"Quote not created error occured");
			org.testng.Assert.fail("Quote not created error occured");
		} else
			{logger.log(LogStatus.PASS,"Quote created successfully");}
		/*if(!nac.isAccountDisplayed_OnGeneralInfoPage()){
			logger.log(LogStatus.FAIL, "Account Name not found");
			};*/
		if(!la.isPreparedByDisplayed_OnGeneralInfoPage()){
				logger.log(LogStatus.FAIL,"Prepared By not found");
			};
		ncq.browsefile();	
		ncq.returnOpportunityPage();
		sc.setUniqueID("stagePropose");sc.statechangeQ();//Stage change to propose
		noc.editQuotelink();//click on Edit Quote link
		sfa.commericalApproval(); //Self Approval
		logger.log(LogStatus.PASS, "Quote submitted for Commerical approval");
		Thread.sleep(30000);
		ncq.returnOpportunityPage();
		noc.collectSRN();//capture SRN from Opp page 
		Thread.sleep(9000);
		cai.logout();
		la.setUniqueID("UK_CM");   
		la.FillLoginInfo();	//Login
		logger.log(LogStatus.PASS, "Login successfully with CM");
		cai.readAMSRNESFromConfig();
		logger.log(LogStatus.PASS,"Read SRN from Configfile");
		cai.setSearchtxt(cai.getUKAccountManagerSRNRecent());
		cai.searchCM();             //search SR number
		cai.enableCPQApproval();
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
		noc.editQuotelink();
		qs.quoteSummaryVerify();
		if(qs.verifySummaryOpen()){
			logger.log(LogStatus.PASS, "QuoteSummary generated successfully");
		}else
		{
			logger.log(LogStatus.FAIL, "QuoteSummary not generated");
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
