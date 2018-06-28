package TestCases_UK;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.remote.server.handler.CloseWindow;
import org.testng.ITestResult;
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
import SpecificObjectAction.ContractManagerUser;
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


public class TC07_LC_ContractGenerate {
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
	ContractManagerUser cmu=new ContractManagerUser();
	
	
	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException
	{		
		reports=new ExtentReports("D:\\Workspace\\CPQ\\src\\Report\\TC7_LC_ContractGenerate.html",true);
		logger=reports.startTest("TC7_LC_ContractGenerate");
		CommonActions.LaunchDriver.launchbrowser();
		logger.log(LogStatus.PASS, "browser launch successfully");
	}
	
	@Test
	public void contractGenerate() throws IOException, InterruptedException, AWTException
	{
		//if Quote is already present then no need to execute commented code
		/*la.setUniqueID("UK_AM");
		la.FillLoginInfo();	//Login
		logger.log(LogStatus.PASS, "Login successfully with UK QaMaster");
		nac.setUniqueID("UK"); 
		nac.clickAccountTab();
		nac.AccountCreationInfo();//New account creation	
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
		ncq.addCpqQuote();
		aimt.setUniqueID("UKTraiff1");aimt.addIntegratedMobileTraiff();
		aimt.editOfferPriceIntegratedMobileTraiff();//Quote creation(offer price edit)
		ncq.updateSaveAddProduct();
		if(cem.checkErrorMessage()){
			logger.log(LogStatus.FAIL,"Quote not created error occured");
			org.testng.Assert.fail("Quote not created error occured");
		} else
			{logger.log(LogStatus.PASS,"Quote created successfully");}
		if(!nac.isAccountDisplayed_OnGeneralInfoPage()){
			logger.log(LogStatus.FAIL, "Account Name not found");
			};
		if(!la.isPreparedByDisplayed_OnGeneralInfoPage()){
				logger.log(LogStatus.FAIL,"Prepared By not found");
			};
		ncq.collectQuoteNumber(); //capture Quote number on GeneralInfo page
		//ncq.browsefile();
		ncq.returnOpportunityPage();
		sc.setUniqueID("stagePropose");sc.statechangeQ();//Stage change to propose
		noc.editQuotelink();//click on Edit Quote link
		sfa.commericalApproval(); //commerical Approval
		logger.log(LogStatus.PASS, "Quote submitted for Commerical approval");
		Thread.sleep(30000);
		ncq.returnOpportunityPage();
		noc.collectSRN();//capture SRN from Opp page 
		Thread.sleep(9000);
		cai.logout();
		la.setUniqueID("UK_CM");   
		la.FillLoginInfo();	//Login
		logger.log(LogStatus.PASS, "Login successfully with Commerical Manager");
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
		ncq.returnQuoteInfoTab();
		ncq.returnOpportunityPage();
		if(!as.verifyApprovedOnQuote()){
		logger.log(LogStatus.FAIL, "Approved label on Quote not found");
			}else
			{
		logger.log(LogStatus.PASS, "Approved label on Quote found");
			}
		ncq.returnOpportunityPage();*/
		
		la.setUniqueID("UK_CM");   
		la.FillLoginInfo();	//Login
		logger.log(LogStatus.PASS, "Login successfully with Commerical Manager");
		cai.readAMSRNESFromConfig();
		logger.log(LogStatus.PASS,"Read SRN from Configfile");
		cai.setSearchtxt(cai.getUKAccountManagerSRNRecent());
		cai.searchCM();             //search SR number
		cai.clickSRNLink();
		noc.readOPPNameFromConfig();
		noc.clickOnOPPNameInList();
		sc.setUniqueID("stageNegotiate");sc.statechangeQ();//Stage change to Negotiate
		cai.logout();
		la.setUniqueID("UK_CTM"); la.FillLoginInfo(); //Login as Contract Manager
		logger.log(LogStatus.PASS, "Login successfully with Contract Manager");
		//cai.setSearchtxt(ncq.getQuoteNumber());  //assign quote number to search text field
		//cai.searchCM();//search Quote number
		cai.readAMSRNESFromConfig();
		logger.log(LogStatus.PASS,"Read SRN from Configfile");
		cai.setSearchtxt(cai.getUKAccountManagerSRNRecent());
		cai.searchCM();             //search SR number
		cai.clickSRNLink();
		noc.readOPPNameFromConfig();
		noc.clickOnOPPNameInList();
		noc.editQuotelink();
		if(cem.checkErrorMessage()){
			logger.log(LogStatus.FAIL,"Quote not created error occured");
			org.testng.Assert.fail("Quote not created error occured");
		} else
			{logger.log(LogStatus.PASS,"Quote created successfully");}
		cmu.setUniqueID("UKPSNDataEntry");cmu.dataEntryPSNContract();
		if(cmu.GenerateContractPDF())
		{
			logger.log(LogStatus.PASS, "Contract PDF open");
		}else
		{
			logger.log(LogStatus.FAIL, "Contract PDF not get open");
		}
		//need to call generate report from contract manager
		
		
		
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
