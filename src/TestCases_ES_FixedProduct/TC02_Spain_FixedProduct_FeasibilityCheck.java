package TestCases_ES_FixedProduct;

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

import SpecificObjectActionES.AddProductLinesOffice365ES;
import SpecificObjectActionES.AddProductOffice365ES;
import SpecificObjectActionES.ApprovalStatusES;
import SpecificObjectActionES.CommonActionsInAppES;
import SpecificObjectActionES.CommonErrorMsgES;
import SpecificObjectActionES.FixedProductFeasibilityES;
import SpecificObjectActionES.LoginActionES;
import SpecificObjectActionES.NewAccountCreationES;
import SpecificObjectActionES.NewCPQQuoteES;
import SpecificObjectActionES.NewOpportunityCreationES;
import SpecificObjectActionES.NewProductAddES;
import SpecificObjectActionES.SalesManager;
import SpecificObjectActionES.StateChangeES;
import SpecificObjectActionES.SubmitForApprovalES;

public class TC02_Spain_FixedProduct_FeasibilityCheck {

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
	FixedProductFeasibilityES fpfe=new FixedProductFeasibilityES();
	
	public static ExtentReports reports;
	public static ExtentTest logger;
	@BeforeSuite
	public void beforeSuite()
	{
		reports=new ExtentReports("D:\\Workspace\\CPQ\\src\\Report\\Report.html",true);
		logger=reports.startTest("TC02_Spain_FixedProduct_FeasibilityCheck");
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
		logger.log(LogStatus.PASS, "Opportunity name selected from list");
		ncqe.clickNewCPQ();
		ncqe.clickContinueCPQ();
		fpfe.clickProductSolutionTabES(); 
		fpfe.setUniqueID("ES1");fpfe.addFixedProductES();
		logger.log(LogStatus.PASS, "configuration is selected");
		if(fpfe.clickcargarSedesES()){
		logger.log(LogStatus.PASS, "cargarsedes button is visible");
		}else
		{
			logger.log(LogStatus.FAIL, "cargarsedes button is not visible");
		}
		fpfe.selectSiteES(); 
		logger.log(LogStatus.PASS, "Site is configured");
		fpfe.selectCFTPetitionES();
		fpfe.waitAndClickFeasiblityRefreshES();
		sfae.clicksaveAndPriceES();
		fpfe.clickProductSolutionTabES(); 
		fpfe.verifyTable();
		logger.log(LogStatus.PASS, "Feasibility Requested status displayed in table");
		fpfe.uncheckLegacyAndIPVPNES(); 
		CommonActions.CommonMethod.testTable("Main","VF xDSL","BLUE");
		Thread.sleep(5000);
		CommonActions.CommonMethod.testTable("Backup","VF 3G","GREEN");
		Thread.sleep(9000);
		fpfe.clickConfigurarSites();
		if(fpfe.verifyAccess1ExistTable()){
			logger.log(LogStatus.PASS, "Access1xDSL product details present in table");
		}else
		{
			logger.log(LogStatus.FAIL, "Access1xDSL product details not present in table");
		}
		if(fpfe.verifyAccess2ExistTable()){
			logger.log(LogStatus.PASS, "Access2 Tarifa 4G product details present in table");
		}else
		{
			logger.log(LogStatus.FAIL, "Access2 Tarifa 4G product details not present in table");
		}
		if(fpfe.verifyAddressingExistTable()){
			logger.log(LogStatus.PASS, "Addressing iopciones IP1 details present in table");
		}else
		{
			logger.log(LogStatus.FAIL, "Addressing iopciones IP1 details not present in table");
		}
		if(fpfe.verifyCPE1ExistTable()){
			logger.log(LogStatus.PASS, "CPE1 ihw router CISCO 887 details present in table");
		}else
		{
			logger.log(LogStatus.FAIL, "CPE1 ihw router CISCO 887 details not present in table");
		}
		if(fpfe.verifyCPE2ExistTable()){
			logger.log(LogStatus.PASS, "CPE2 ihw router Huawei AR129C details present in table");
		}else
		{
			logger.log(LogStatus.FAIL, "CPE2 ihw router Huawei AR129C details not present in table");
		}
		fpfe.selectSLAFromDropDown();
		fpfe.clickActualizar();
		fpfe.clickAgregarPresupuesto();
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
		noce.opportunityRoadmapCreationES(); 
		logger.log(LogStatus.PASS, "Opportunity roadmap created sucessfully");
		sce.setUniqueID("stagePropose");sce.statechangeQES();//Stage change to propose
		logger.log(LogStatus.PASS, "Status change to Propose");
		noce.editQuotelinkES();//click on Edit Quote link  
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
