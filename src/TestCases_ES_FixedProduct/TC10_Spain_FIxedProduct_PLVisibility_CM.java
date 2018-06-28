package TestCases_ES_FixedProduct;

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

public class TC10_Spain_FIxedProduct_PLVisibility_CM {

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
		reports=new ExtentReports("D:\\Report\\TC16_Spain_PLVisibility_CM.html",true);
		logger=reports.startTest("TC10_Spain_FIxedProduct_PLVisibility_CM");
		CommonActions.LaunchDriver.launchbrowser();
		logger.log(LogStatus.PASS, "browser launch successfully");
	}
	
	@Test
	public void PLVisibilityCM() throws IOException, InterruptedException, AWTException
	{
		lae.setUniqueID("Commercial_Manager"); lae.FillLoginInfoES();	//Login
		logger.log(LogStatus.PASS, "Login successfully with Spain Commercial_Manager");
		ncqe.readQuoteNumberFromConfig();
		ncqe.setSearchAccountManagerQuotetxt(ncqe.getAccountManagerQuoteNumberRecent());
		ncqe.searchAccountManagerQuoteES();
		logger.log(LogStatus.PASS, "Quote number search successfully");
		ncqe.clickOnQuoteLinkES();
		noce.clickQuoteModificar();
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
		//need to validate column in below method
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
	
	

