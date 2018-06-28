package TestCases_ES;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import CommonActions.CommonMethod;
import SpecificObjectActionES.AddProductLinesOffice365ES;
import SpecificObjectActionES.AddProductOffice365ES;
import SpecificObjectActionES.ApprovalStatusES;
import SpecificObjectActionES.CommonActionsInAppES;
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
import SpecificObjectActionES.ScoringManager;
import SpecificObjectActionES.StateChangeES;
import SpecificObjectActionES.SubmitForApprovalES;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC18_Spain_PLVisibility_wholesaleAM {

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
	GeneralInfoPageES gipe=new GeneralInfoPageES();
	
	public static ExtentReports reports;
	public static ExtentTest logger;
	
	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException
	{		
		reports=new ExtentReports("D:\\Workspace\\CPQ\\src\\Report\\Report.html",true);
		logger=reports.startTest("TC15_Spain_PLVisibility_AM");
		CommonActions.LaunchDriver.launchbrowser();
		logger.log(LogStatus.PASS, "browser launch successfully");
	}
	
	@Test
	public void PLVisibilityAM() throws IOException, InterruptedException, AWTException
	{
		lae.setUniqueID("WS_AM"); lae.FillLoginInfoES();	//Login
		logger.log(LogStatus.PASS, "Login successfully with Spain QaMaster");
		nace.setUniqueID("ES"); nace.clickAccountTabES();nace.AccountCreationInfoES();//New account creation
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
		ncqe.clickNewCPQ();
		ncqe.clickContinueCPQ();
		ncqe.addCpqQuoteProductES();
		ncqe.navigateToOfficeAppES();
		//aploe.setUniqueID("ES1");aploe.addLinesOffice365ES(); //add product lines and discount
		apoe.setUniqueID("ES1");apoe.addProductOffice365ES(); //add product 
		ncqe.updateSaveAddProductES();
		ncqe.collectQuoteNumberES();
		noce.returnToOpportunityES(); 
		noce.opportunityRoadmapCreationES(); 
		sce.setUniqueID("stagePropose");sce.statechangeQES();//Stage change to propose 
		noce.editQuotelinkES();//click on Edit Quote link 
		if(gipe.verifyPLResumenTab())
		{
			logger.log(LogStatus.FAIL, "PLResumenTab displayed to AM");
		}else
		{
			logger.log(LogStatus.PASS, "PLResumenTab not get displayed to AM");	
		}
		if(gipe.verifyPLAmpliadaTab())
		{
			logger.log(LogStatus.FAIL, "PLAmpliadaTab displayed to AM");
		}else
		{
			logger.log(LogStatus.PASS, "PLAmpliadaTab not get displayed to AM");	
		}
		if(gipe.verifyPLGlobalTab())
		{
			logger.log(LogStatus.FAIL, "PLGlobalTab displayed to AM");
		}else
		{
			logger.log(LogStatus.PASS, "PLGlobalTab not get displayed to AM");	
		}
		gipe.clickPLResumenTab();
		if(gipe.verifyMobileRevenueTotalValuesPLResumenTab())
		{
			logger.log(LogStatus.PASS, "MobileRevenueTotalValues displayed to table");
		}else
		{
			logger.log(LogStatus.FAIL, "MobileRevenueTotalValues not get displayed to table");	
		}
		if(gipe.verifyMobileTCVValuesPLResumenTab())
		{
			logger.log(LogStatus.PASS, "MobileTCV displayed to table");
		}else
		{
			logger.log(LogStatus.FAIL, "MobileTCV not get displayed to table");	
		}
		if(gipe.verifyMobileRevenueCashTotalValuesPLResumenTab())
		{
			logger.log(LogStatus.PASS, "MobileRevenueCashTotal displayed to table");
		}else
		{
			logger.log(LogStatus.FAIL, "MobileRevenueCashTotal not get displayed to table");	
		}
		if(gipe.verifyDataServicesValuesPLResumenTab())
		{
			logger.log(LogStatus.PASS, "DataServices displayed to table");
		}else
		{
			logger.log(LogStatus.FAIL, "DataServices not get displayed to table");	
		}
		if(gipe.verifyDataCPEValuesPLResumenTab())
		{
			logger.log(LogStatus.PASS, "DataCPEValues displayed to table");
		}else
		{
			logger.log(LogStatus.FAIL, "DataCPEValues not get displayed to table");	
		}
		if(gipe.verifyFixedRevenueTotalPLResumenTab())
		{
			logger.log(LogStatus.PASS, "FixedRevenueTotal displayed to table");
		}else
		{
			logger.log(LogStatus.FAIL, "FixedRevenueTotal not get displayed to table");	
		}
		if(gipe.verifyFixedTCVPLResumenTab())
		{
			logger.log(LogStatus.PASS, "FixedTCV displayed to table");
		}else
		{
			logger.log(LogStatus.FAIL, "FixedTCV not get displayed to table");	
		}
		if(gipe.verifyFixedRevenueCashTotalPLResumenTab())
		{
			logger.log(LogStatus.PASS, "FixedRevenueCashTotal displayed to table");
		}else
		{
			logger.log(LogStatus.FAIL, "FixedRevenueCashTotal not get displayed to table");	
		}
		gipe.clickPLAmpliadaTab();
		gipe.clickUpdateExpandedPLView();
		if(gipe.verifyValueAddedServicePLAmpliadaTab())
		{
			logger.log(LogStatus.PASS, "ValueAddedServiceFromPLAmpliada displayed to table");
		}else
		{
			logger.log(LogStatus.FAIL, "ValueAddedServiceFromPLAmpliada not get displayed to table");	
		}
		if(gipe.verifyMobileRevenueTotalPLAmpliadaTab())
		{
			logger.log(LogStatus.PASS, "MobileRevenueTotalFromPLAmpliada displayed to table");
		}else
		{
			logger.log(LogStatus.FAIL, "MobileRevenueTotalFromPLAmpliada not get displayed to table");
		}
		if(gipe.verifyMobileRevenueCashTotalPLAmpliadaTab())
		{
			logger.log(LogStatus.PASS, "MobileRevenueCashTotalFromPLAmpliada displayed to table");
		}else
		{
			logger.log(LogStatus.FAIL, "MobileRevenueCashTotalFromPLAmpliada not get displayed to table");
		}
		gipe.clickPLGlobalTab();
		if(gipe.verifyTotalServiceRevenuePLGlobalTab())  
		{
			logger.log(LogStatus.PASS, "TotalServiceRevenueFromPLGlobalTab displayed to table");
		}else
		{
			logger.log(LogStatus.FAIL, "TotalServiceRevenueFromPLGlobalTab not get displayed to table");
		}
		noce.returnToOpportunityES(); 
		caie.logoutES();
	
		
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
	
	

