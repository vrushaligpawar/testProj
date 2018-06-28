package TestCases_ES;

import java.io.IOException;

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

public class TC11_Spain_ReconfigQuote {
	public static ExtentReports reports;
	public static ExtentTest logger;
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
	
	
	@BeforeSuite
	public void beforeSuite()
	{
		reports=new ExtentReports("D:\\Workspace\\CPQ\\src\\Report\\Report.html",true);
		logger=reports.startTest("TC11_Spain_ReconfigQuote");
	}
	
	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException
	{		
		CommonActions.LaunchDriver.launchbrowser();
		logger.log(LogStatus.PASS, "browser launch successfully");
	}
	
	@Test
	public void opportunityCreation() throws IOException, InterruptedException
	{
		lae.setUniqueID("ES_AM");
		lae.FillLoginInfoES();	//Login
		noce.clickOppTabES();
		noce.clickOnOPPNameInList();
		//noce.setUniqueID("ES");noce.NewOpportunityCreationInfoES();//New Opportunity creation
		//npae.setUniqueID("ES");npae.productAddES();//Add New Product
		sce.setUniqueID("stageQualify");sce.statechangeQES();//Stage change
		ncqe.clickNewCPQ();
		ncqe.clickContinueCPQ();
		ncqe.addCpqQuoteProductES();
		ncqe.navigateToOfficeAppES();
		apoe.setUniqueID("ES1");apoe.addProductOffice365ES(); //add product 
		logger.log(LogStatus.PASS, "Office 365 product added successfully");
		ncqe.updateSaveAddProductES();
		if(ceme.checkErrorMessageES()){
			logger.log(LogStatus.FAIL,"Quote not created error occured");
			org.testng.Assert.fail("Quote not created error occured");
		} else
			{logger.log(LogStatus.PASS,"Quote created successfully");}
		/*if(!nace.isAccountDisplayed_OnGeneralInfoPageES()){
			logger.log(LogStatus.FAIL, "Account Name not found");
			};*/
		noce.returnToOpportunityES(); 
		//noce.opportunityRoadmapCreationES(); 
		sce.setUniqueID("stagePropose");sce.statechangeQES();//Stage change to propose 
		noce.editQuotelinkES();//click on Edit Quote link  
		ncqe.reconfigureQuoteES(); //reconfigure product
		apoe.setUniqueID("ES2");apoe.addProductOffice365ES(); //modify product 
		ncqe.saveUpdateReconfigureQuoteES();
		if(apoe.isProductDisplayed_OnGeneralInfoPageES()){
			logger.log(LogStatus.PASS, "reconfigure product displayed on GeneralInfo page");
		}else
		{
			logger.log(LogStatus.FAIL, "reconfigure product not getting displayed on GeneralInfo page ");
		}
		sfae.preReqForApproval();
		sfae.clicksaveAndPriceES();
		sfae.submitForApprovalES();
		sfae.checkLevelApproverES(); 
		ase.clickApprovalTabES();
		if(!ase.verifyApprovalPendingImageES()) {
			logger.log(LogStatus.FAIL, "Approval pending image not found");
				}else
				{
					logger.log(LogStatus.FAIL, "Approval pending image found");
				}
		noce.returnToOpportunityES();  
		sm.collectSalesManagerSRNES();
		Thread.sleep(5000);
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
