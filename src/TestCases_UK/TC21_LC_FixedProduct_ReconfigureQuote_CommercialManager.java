package TestCases_UK;

import java.awt.AWTException;
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

import CommonActions.CommonMethod;
import SpecificObjectAction.AddDevicesBrand;
import SpecificObjectAction.AddFixedProductVSDM;
import SpecificObjectAction.AddIntegratedMobileTraiff;
import SpecificObjectAction.ApprovalStatus;
import SpecificObjectAction.CommonActionsInApp;
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

public class TC21_LC_FixedProduct_ReconfigureQuote_CommercialManager {
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
	AddFixedProductVSDM afpv=new AddFixedProductVSDM();
	CommonActionsInApp cai=new CommonActionsInApp();
	
		
	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException
	{		
		reports=new ExtentReports("D:\\Workspace\\CPQ\\src\\Report\\TC21_LC_FixedProduct_ReconfigureQuote_CommercialManager.html",true);
		logger=reports.startTest("TC21_LC_FixedProduct_ReconfigureQuote_CommercialManager");
		CommonActions.LaunchDriver.launchbrowser();
		logger.log(LogStatus.PASS, "browser launch successfully");
	}
	
	@Test
	public void reconfigureQuoteCommercialManager() throws IOException, InterruptedException, AWTException
	{
		la.setUniqueID("UK_AM");
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
		ncq.clickNewCpqQuote();
		ncq.clickContinueCPQ();
		ncq.addCpqQuoteProduct(); //click on add CPQ button
		afpv.setUniqueID("UKTraiff1");afpv.addSecurityVSDM();
		afpv.addVSDMPackage(); //add Fixed VSDM product
		ncq.updateSaveAddProduct();
		if(cem.checkErrorMessage()){
			logger.log(LogStatus.FAIL,"Quote not created error occured");
			org.testng.Assert.fail("Quote not created error occured");
		} else
			{logger.log(LogStatus.PASS,"Quote created successfully");}
		/*if(!nac.isAccountDisplayed_OnGeneralInfoPage()){
			logger.log(LogStatus.FAIL, "Account Name not found");
			};*/
		if(!la.isPreparedByDisplayed_OnGeneralInfoPage()){
				logger.log(LogStatus.FAIL,"Prepared By not found");
			};
		ncq.returnOpportunityPage();
		Thread.sleep(9000);
		cai.logout();
		la.setUniqueID("UK_CM");   
		la.FillLoginInfo();	//Login
		logger.log(LogStatus.PASS, "Login successfully with Commercial Manager ");
		cai.readAccountNameFromConfig();
		cai.setSearchtxt(cai.readAccountNameFromConfig());
		cai.searchSS();   
		nac.clickOnAccountNameInList();
		noc.clickOnOPPNameFromConfig();
		noc.editQuotelink();
		if(cem.checkErrorMessage()){
			logger.log(LogStatus.FAIL,"Quote not created error occured");
			org.testng.Assert.fail("Quote not created error occured");
		} else
			{logger.log(LogStatus.PASS,"Quote created successfully");}
		ncq.reconfigureQuote(); //reconfigure product
		afpv.modifySetUpCost();
		ncq.saveUpdateReconfigureQuote();
		if(afpv.isPackageNameDisplayed_OnGeneralInfoPage()){
			logger.log(LogStatus.PASS, "reconfigure product displayed on GeneralInfo page");
		}else
		{
			logger.log(LogStatus.FAIL, "reconfigure product not getting displayed on GeneralInfo page ");
		}
		if(afpv.isAddOnDisplayed_OnGeneralInfoPage()){
			logger.log(LogStatus.PASS, "AddOn displayed on GeneralInfo page");
		}else
		{
			logger.log(LogStatus.FAIL, "AddOn not getting displayed on GeneralInfo page ");
		}
		ncq.returnOpportunityPage();
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
