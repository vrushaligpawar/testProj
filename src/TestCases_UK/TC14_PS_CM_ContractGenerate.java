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

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC14_PS_CM_ContractGenerate {

	public static ExtentReports reports;
	public static ExtentTest logger;
	
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
	CommonActionsInApp cai=new CommonActionsInApp();
	ContractManagerUser cmu=new ContractManagerUser();
	

	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException
	{		
		reports=new ExtentReports("D:\\Workspace\\CPQ\\src\\Report\\TC14_PS_CM_ContractGenerate.html",true);
		logger=reports.startTest("TC14_PS_CM_ContractGenerate");
		CommonActions.LaunchDriver.launchbrowser();
		logger.log(LogStatus.PASS, "browser launch successfully");
	}
	
	@Test
	public void contractGenerateCM() throws IOException, InterruptedException, AWTException
	{
		/*la.setUniqueID("UK_AM");
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
		ncq.addCpqQuote(); //click on add CPQ button
		aimt.setUniqueID("UKTraiff1");aimt.addIntegratedMobileTraiff();//add integrated mobile tariff
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
		ncq.browsefile();	
		ncq.returnOpportunityPage();	
		sc.setUniqueID("stagePropose");sc.statechangeQ();//Stage change to propose
		noc.editQuotelink();//click on Edit Quote link
		sfa.commericalApproval(); //CM Approval
		logger.log(LogStatus.PASS, "Self approval suceesfully completed");
		Thread.sleep(30000);
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
		ncq.returnOpportunityPage();
		sc.setUniqueID("stageNegotiate");sc.statechangeQ();//Stage change to Negotiate
		CommonActions.CommonMethod.logout();*/
		la.setUniqueID("UK_CTM"); la.FillLoginInfo(); //Login as Contract Manager
		logger.log(LogStatus.PASS, "Login successfully with Contract Manager");
		//cai.setSearchtxt(ncq.getQuoteNumber());  //assign quote number to search text field
		//cai.searchCM();//search Quote number
		//cmu.GenerateContractPDF();
		cmu.GenerateContractRTF();
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
