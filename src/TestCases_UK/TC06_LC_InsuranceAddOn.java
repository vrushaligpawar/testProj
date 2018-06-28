package TestCases_UK;

import java.awt.AWTException;
import java.io.IOException;

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

import Resources.ReadConfig;
import SpecificObjectAction.AddDevicesAddOns;
import SpecificObjectAction.AddDevicesBrand;
import SpecificObjectAction.AddIntegratedMobileTraiff;
import SpecificObjectAction.ApprovalStatus;
import SpecificObjectAction.CommonErrorMsg;
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

public class TC06_LC_InsuranceAddOn {
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
	AddDevicesBrand adb=new AddDevicesBrand();
	AddDevicesAddOns adao=new AddDevicesAddOns();
	
	
	
	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException
	{		
		reports=new ExtentReports("D:\\Workspace\\CPQ\\src\\Report\\Report.html",true);
		logger=reports.startTest("TC06_LC_InsuranceAddOn");
		CommonActions.LaunchDriver.launchbrowser();
		logger.log(LogStatus.PASS, "browser launch successfully");
	}
	
	@Test
	public void InsuranceAddOn() throws IOException, InterruptedException, AWTException
	{
		la.setUniqueID("UK_AM");
		la.FillLoginInfo();	//Login
		logger.log(LogStatus.PASS, "Login successfully with UK QaMaster");
		nac.clickAccountTab();
		nac.setUniqueID("UK"); 
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
		ncq.clickNewCpqQuote();
		ncq.clickContinueCPQ();
		ncq.addCpqQuoteProduct(); //click on add CPQ button
		aimt.setUniqueID("UKTraiff1");
		aimt.addIntegratedMobileTraiff();//add integrated mobile tariff
        aimt.selectTraiffType(); 
		//adb.setUniqueID("UKBrand1"); 
		adb.addDevicesBrand();//add Brand devices
		//adao.setUniqueID("UKAddOn1");
		adao.addDevicesAddOns();//add Addons devices
		ncq.updateSaveAddProduct();
		if(cem.checkErrorMessage()){
			logger.log(LogStatus.FAIL,"Quote not created error occured");
			org.testng.Assert.fail("Quote not created error occured");
		} else
			{logger.log(LogStatus.PASS,"Quote created successfully");}
		/*if(!nac.isAccountDisplayed_OnGeneralInfoPage()){
			logger.log(LogStatus.FAIL, "Account Name not found");
			};
		if(!la.isPreparedByDisplayed_OnGeneralInfoPage()){
				logger.log(LogStatus.FAIL,"Prepared By not found");
			};*/
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
		/*if(adao.isAddOnsDisplayed_OnGeneralInfoPage()){
				logger.log(LogStatus.PASS, "Selected AddOns displayed on GeneralInfoPage");
			}else{
				logger.log(LogStatus.PASS, "Selected AddOns not getting displayed on GeneralInfoPage");
			}*/
		ncq.browsefile();
		ncq.returnOpportunityPage();	
		sc.setUniqueID("stagePropose");sc.statechangeQ();//Stage change to propose
		noc.editQuotelink();//click on Edit Quote link
		sfa.selfApproval(); //Self Approval
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
		ncq.returnOpportunityPage();
		if(!as.verifyApprovedOnQuote()){
			logger.log(LogStatus.FAIL, "Approved label on Quote not found");
		}else
		{
			logger.log(LogStatus.PASS, "Approved label on Quote found");
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
