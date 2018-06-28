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

public class TC11_Spain_FixedProduct_PLVisibility_TES {

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
		reports=new ExtentReports("D:\\Report\\TC11_Spain_FixedProduct_PLVisibility_TES.html",true);
		logger=reports.startTest("TC11_Spain_FixedProduct_PLVisibility_TES");
		CommonActions.LaunchDriver.launchbrowser();
		logger.log(LogStatus.PASS, "browser launch successfully");
	}
	
	@Test
	public void PLVisibilityTES() throws IOException, InterruptedException, AWTException
	{
		lae.setUniqueID("TES"); lae.FillLoginInfoES();	//Login
		logger.log(LogStatus.PASS, "Login successfully with Spain TES");
		ncqe.readQuoteNumberFromConfig();
		ncqe.setSearchAccountManagerQuotetxt(ncqe.getAccountManagerQuoteNumberRecent());
		ncqe.searchAccountManagerQuoteES();
		logger.log(LogStatus.PASS, "Quote number search successfully");
		ncqe.clickOnQuoteLinkES();
		noce.clickQuoteModificar();
		gipe.clickPLResumenTab();
		if(!nace.isAccountDisplayed_OnGeneralInfoPageES())
		{
			CommonMethod.pageRefresh();
		}
		if(gipe.verifyPLResumenTab())
		{
			logger.log(LogStatus.PASS, "PLResumenTab displayed to TES");
		}else
		{
			logger.log(LogStatus.FAIL, "PLResumenTab not get displayed to TES");	
		}
		if(gipe.verifyPLAmpliadaTab())
		{
			logger.log(LogStatus.FAIL, "PLAmpliadaTab displayed to TES");
		}else
		{
			logger.log(LogStatus.PASS, "PLAmpliadaTab not get displayed to TES");	
		}
		if(gipe.verifyPLGlobalTab())
		{
			logger.log(LogStatus.PASS, "PLGlobalTab displayed to TES");
		}else
		{
			logger.log(LogStatus.FAIL, "PLGlobalTab not get displayed to TES");	
		}
		gipe.clickproyectosTESTab();
		gipe.childQuoteCreate();
		if(gipe.verifyPLAmpliadaTab())
		{
			logger.log(LogStatus.PASS, "PLAmpliadaTab displayed to TES");
		}else
		{
			logger.log(LogStatus.FAIL, "PLAmpliadaTab not get displayed to TES");	
		}
		
		if(gipe.verifyMobileRevenueTotalValuesPLResumenTabTESUser())
		{
			logger.log(LogStatus.PASS, "MobileRevenueTotalValues displayed as 0");
		}else
		{
			logger.log(LogStatus.FAIL, "MobileRevenueTotalValues not get displayed as 0");
		}
		
		if(gipe.verifyMobileTCVValuesPLResumenTabTESUser())
		{
			logger.log(LogStatus.PASS, "MobileTCVValues displayed as 0");
		}else
		{
			logger.log(LogStatus.FAIL, "MobileTCVValues not get displayed as 0");
		}
		if(gipe.verifyMobileRevenueCashTotalValuesPLResumenTabTESUser())
		{
			logger.log(LogStatus.PASS, "MobileRevenueCashTotalValues displayed as 0");
		}else
		{
			logger.log(LogStatus.FAIL, "MobileRevenueCashTotalValues not get displayed as 0");
		}
		
		if(gipe.verifyPLAmpliadaTab())
		{
			logger.log(LogStatus.PASS, "PLAmpliadaTab displayed to TES");
		}else
		{
			logger.log(LogStatus.FAIL, "PLAmpliadaTab not get displayed to TES");	
		}
		if(gipe.verifyValueAddedServicePLAmpliadaTabTESUser())
		{
			logger.log(LogStatus.PASS, "ValueAddedService displayed as 0");
		}else
		{
			logger.log(LogStatus.FAIL, "ValueAddedService not get displayed as 0");	
		}
		if(gipe.verifyMobileRevenueTotalPLAmpliadaTabTESUser())
		{
			logger.log(LogStatus.PASS, "MobileRevenueTotal displayed as 0");
		}else
		{
			logger.log(LogStatus.FAIL, "MobileRevenueTotal not get displayed as 0");	
		}
		if(gipe.verifyMobileRevenueCashTotalPLAmpliadaTabTESUser())
		{
			logger.log(LogStatus.PASS, "MobileRevenueCashTotal displayed as 0");
		}else
		{
			logger.log(LogStatus.FAIL, "MobileRevenueCashTotal not get displayed as 0");	
		}
		
		if(gipe.verifyPLGlobalTab())
		{
			logger.log(LogStatus.PASS, "PLGlobalTab displayed to TES");
		}else
		{
			logger.log(LogStatus.FAIL, "PLGlobalTab not get displayed to TES");	
		}
		if(gipe.verifyTotalServiceRevenuePLGlobalTabTESUser())
		{
			logger.log(LogStatus.PASS, "TotalServiceRevenue displayed as 0");
		}else
		{
			logger.log(LogStatus.FAIL, "TotalServiceRevenue not get displayed as 0");	
		}
		ncqe.addCpqQuoteProductES();
		ncqe.navigateToOfficeAppES();
		//aploe.setUniqueID("ES1");aploe.addLinesOffice365ES(); //add product lines and discount
		apoe.setUniqueID("ES1");apoe.addProductOffice365ES(); //add product 
		ncqe.updateSaveAddProductES();
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
	
	

