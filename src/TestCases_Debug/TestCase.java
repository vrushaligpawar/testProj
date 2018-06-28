package TestCases_Debug;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import CommonActions.CommonMethod;
import SpecificObjectAction.AddDevicesAddOns;
import SpecificObjectAction.AddDevicesBrand;
import SpecificObjectAction.AddIntegratedMobileTraiff;
import SpecificObjectAction.CommonActionsInApp;
import SpecificObjectAction.LoginAction;
import SpecificObjectAction.NewAccountCreation;
import SpecificObjectAction.NewCPQQuote;
import SpecificObjectAction.NewOpportunityCreation;
import SpecificObjectAction.QuoteSummary;

public class TestCase {
	public static ExtentReports reports;
	public static ExtentTest logger;
	
	LoginAction la=new LoginAction();
	NewAccountCreation nac=new NewAccountCreation();
	NewCPQQuote ncq=new NewCPQQuote();
	AddIntegratedMobileTraiff aimt=new AddIntegratedMobileTraiff();
	AddDevicesBrand adb=new AddDevicesBrand();
	AddDevicesAddOns adao=new AddDevicesAddOns();
	CommonActionsInApp cai=new CommonActionsInApp();
	NewOpportunityCreation noc=new NewOpportunityCreation();
	
	QuoteSummary qs=new QuoteSummary();
	@BeforeSuite
	public void beforeSuite()
	{
		reports=new ExtentReports("D:\\Workspace\\CPQ\\src\\Report.html",true);
		logger=reports.startTest("TC1_LC Approval");
	}
	
	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException
	{		
		CommonActions.LaunchDriver.launchbrowser();
		logger.log(LogStatus.PASS, "browser launch successfully");
	}
	
	@Test
	public void LcApproval() throws IOException, InterruptedException, AWTException
	{
		//Login
		la.setUniqueID("UK_AM");
		la.FillLoginInfo();	
		
		logger.log(LogStatus.PASS, "Login successfully with UK QaMaster");
		cai.logout();
		CommonActions.CommonMethod.closeBrowser();
		
		/*noc.clickOppTab();
		if(noc.isOpporunityNameDisplayed_InList())
			noc.clickOppNameList();
			//System.out.println(noc.getOpportunitiesName());
*/		
			
		
		/*if (!nac.isAccountDisplayed_InList())
			nac.AccountCreationInfo();//New account creation	
		System.out.println(nac.getAccountName());*/
		
		/*ncq.addCpqQuote();
		aimt.setUniqueID("UKTraiff1");aimt.addIntegratedMobileTraiff();//add integrated mobile tariff
		ncq.updateSaveAddProduct();
		ncq.collectQuoteNumber();
		//ncq.setQuoteNumber(ncq.getQuoteNumber());
		cai.setSearchtxt(ncq.getQuoteNumber());*/
		
		
		/*Verify added product in Genral information page
		aimt.setSelectTariffPlan(aimt.getSelectTariffPlan());
		if(aimt.isTraiffPlanDisplayed_OnGeneralInfoPage()){
			logger.log(LogStatus.PASS, "Selected Traiff displayed on GeneralInfoPage");
		}else
		{
			logger.log(LogStatus.FAIL, "Selected Traiff not getting displayed on GeneralInfoPage");
		}
		adb.setBrdevice(adb.getBrdevice());
		if(adb.isBrandDisplayed_OnGeneralInfoPage()){
			logger.log(LogStatus.PASS, "Selected brand device displayed on GeneralInfoPage");
		}else{
			logger.log(LogStatus.FAIL, "Selected brand device not getting displayed on GeneralInfoPage");
		}
		adao.setAddOns(adao.getAddOns());
		if(adao.isAddOnsDisplayed_OnGeneralInfoPage()){
			logger.log(LogStatus.PASS, "Selected AddOns displayed on GeneralInfoPage");
		}else{
			logger.log(LogStatus.PASS, "Selected AddOns not getting displayed on GeneralInfoPage");
		}
		//ncq.browsefile();
		*/
//		Thread.sleep(20000);
	//	CommonActions.CommonMethod.enablePopupsIE();
	//	qs.quoteSummaryVerify();
		}
	
	
	/*@Test
	public void LcApproval_Spain() throws IOException, InterruptedException
	{
		//Login
				la.setUniqueID("ES_AM");
				la.FillLoginInfo();	
				logger.log(LogStatus.PASS, "Login successfully with UK QaMaster");
				Thread.sleep(9000);
				CommonActions.CommonMethod.logout();
	}
	*/
	
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
