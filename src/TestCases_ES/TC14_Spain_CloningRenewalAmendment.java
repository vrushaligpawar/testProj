package TestCases_ES;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SpecificObjectActionES.AddProductLinesOffice365ES;
import SpecificObjectActionES.AddProductOffice365ES;
import SpecificObjectActionES.ApprovalStatusES;
import SpecificObjectActionES.CommonActionsInAppES;
import SpecificObjectActionES.CommonErrorMsgES;
import SpecificObjectActionES.CustomerSiteES;
import SpecificObjectActionES.GeneralInfoPageES;
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

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC14_Spain_CloningRenewalAmendment {


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
	NewCleanButtonES ncbe=new NewCleanButtonES();
	NewContactCreationES ncce=new NewContactCreationES();
	CustomerSiteES cse=new CustomerSiteES();
	
	
	public static ExtentReports reports;
	public static ExtentTest logger;
		
	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException
	{		
		reports=new ExtentReports("D:\\Workspace\\CPQ\\src\\Report\\Report.html",true);
		logger=reports.startTest("TC14_Spain_CloningRenewalAmendment");
		CommonActions.LaunchDriver.launchbrowser();
		logger.log(LogStatus.PASS, "browser launch successfully");
	}
	@Test
	public void cloningRenewalAmendment() throws IOException, InterruptedException
	{
	
		lae.setUniqueID("ES_AM");
		lae.FillLoginInfoES();	//Login
		logger.log(LogStatus.PASS, "Login successfully with Spain QaMaster");
		/*Reporter.log("Login successfully with Spain QaMaster");
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
		ncqe.clickOnCloneCPQQuote();
		ncqe.selectQuoteStatusAndClone();
		gipe.selectQuoteTypeRenovación();
		ncqe.clickSaveAndPriceES(); */
		if(gipe.verifyQuoteTypeRenovacion())
		{
			logger.log(LogStatus.PASS, "Connection Type Renovación updated in list");
		}else
		{
			logger.log(LogStatus.FAIL, "Connection Type Renovación not updated in list");
		}
		gipe.selectQuoteTypeModificacion();
		ncqe.clickSaveAndPriceES(); 
		if(gipe.verifyQuoteTypeModificacion())
		{
			logger.log(LogStatus.PASS, "Connection Type Modificación updated in list");
		}else
		{
			logger.log(LogStatus.FAIL, "Connection Type Modificación not updated in list");
		}
		ncqe.reconfigureQuoteES();
		if(gipe.verifyQuoteTypeOnReconfigure())
		{
			logger.log(LogStatus.PASS, "Connection Type Modificación updated in Reconfigure grid");
		}else
		{
			logger.log(LogStatus.FAIL, "Connection Type Modificación not updated in Reconfigure grid");
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
