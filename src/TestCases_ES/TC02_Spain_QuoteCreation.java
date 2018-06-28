package TestCases_ES;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

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

public class TC02_Spain_QuoteCreation {

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
		logger=reports.startTest("TC02_Spain_QuoteCreation");
		CommonActions.LaunchDriver.launchbrowser();
		logger.log(LogStatus.PASS, "browser launch successfully");
	}
	
	@Test
	public void quoteCreation() throws IOException, InterruptedException
	{
		lae.setUniqueID("ES_AM");
		lae.FillLoginInfoES();	//Login
		noce.clickOppTabES();
		noce.clickOnOPPNameInList();
		logger.log(LogStatus.PASS, "Opportunity name selected from list");
		ncqe.clickNewCPQ();
		ncqe.clickContinueCPQ();
		ncqe.addCpqQuoteProductES();
		ncqe.navigateToOfficeAppES();
		//aploe.setUniqueID("ES1");aploe.addLinesOffice365ES(); //add product lines and discount
		apoe.setUniqueID("ES1");apoe.addProductOffice365ES(); //add product
		logger.log(LogStatus.PASS, "Office 365 product added successfully");
		ncqe.updateSaveAddProductES();
		if(ceme.checkErrorMessageES()){
			logger.log(LogStatus.FAIL,"Quote not created error occured");
			org.testng.Assert.fail("Quote not created error occured");
		} else
			{logger.log(LogStatus.PASS,"Quote created successfully");}
		if(!nace.isAccountDisplayed_OnGeneralInfoPageES()){
			logger.log(LogStatus.FAIL, "Account Name not found");
			};
		ncqe.collectQuoteNumberES(); //capture Quote number on GeneralInfo page
		noce.returnToOpportunityES(); 
		sce.setUniqueID("stagePropose");sce.statechangeQES();//Stage change to propose
		logger.log(LogStatus.PASS, "Status change to Propose");
		noce.editQuotelinkES();//click on Edit Quote link  
		CommonActions.CommonMethod.pageRefresh();
		sfae.preReqForApproval();
		sfae.submitForApprovalES(); 
		sfae.checkLevelApproverES(); 
		ase.clickApprovalTabES();
		if(ase.verifyApprovalPendingImageES()) {
			logger.log(LogStatus.PASS, "Approval pending image found");
			};
		noce.returnToOpportunityES();  
		sm.collectSalesManagerSRNES();
		logger.log(LogStatus.PASS, "collect sales manager SRN");
		noce.setPrimaryQuoteES();
		logger.log(LogStatus.PASS, "Quote set as Primary");
		Thread.sleep(5000);
		//CommonActions.CommonMethod.logoutAMES();// logout spain sales manager
		 
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
		//CommonActions.CommonMethod.closeBrowser();
	}
	
}
