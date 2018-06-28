package TestCases_Debug;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import SpecificObjectAction.LoginAction;
import SpecificObjectAction.NewAccountCreation;
import SpecificObjectAction.NewCleanButton;
import SpecificObjectAction.NewContactCreation;
import SpecificObjectAction.NewOpportunityCreation;
import SpecificObjectAction.NewProductAdd;
import SpecificObjectAction.StateChange;


public class TestCaseDebug 
{
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		//kill the all instances of browsers and browserdrivers before starting. this code can be kept in common class
		//Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
		//Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
		//Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
		//Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
		//Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
		Thread.sleep(2000);
		
				
		//System.setProperty("webdriver.gecko.driver","D:\\Workspace\\geckodriver.exe");
		//System.setProperty("webdriver.chrome.driver","D:/Workspace/chromedriver.exe");
		//System.setProperty("webdriver.chrome.logfile", "D:/Workspace/chromedriver.log");
		
		//WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
	/*	
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		System.setProperty("webdriver.ie.driver","D:\\Workspace\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		Thread.sleep(2000);
		driver.get("https://test.salesforce.com/");
		driver.manage().window().maximize();*/
		
		//
		CommonActions.LaunchDriver.launchbrowser();
		
		//Login
		LoginAction la=new LoginAction();
		la.setUserName("account_manager_uk@vfglobalorg.com.qamaster");   //take username from TestCase1.properties file or Excel file
		la.setPassword("Vodafone_TechM19");  //take username from TestCase1.properties file or Excel file
		la.FillLoginInfo();
		
		
		//New Account creation
		NewAccountCreation nac=new NewAccountCreation();
		nac.setAccountName("7201_UK_LC"); //duplicate not possible, ts variable assigned for this
		nac.setMailingStreet("Oxford Road");
		nac.setMailingStreet("Oxford Road");
		nac.setMailingCity("Aylesbury");
		nac.setMailingState("Buckinghamshire");
		nac.setMailingCountry("United Kingdom");
		nac.setMailingZip("HP19 3EQ");
		nac.setCompanyPhone("+447466003009");
		nac.setEmail("UKAccount@xyz.com");
		nac.setEmployees("500");
		nac.setMainSalesChannel("London");
		nac.setNationalIdeNum("NID1657201"); //duplicate not possible  ts variable assigned for this
		nac.setvATNum("VAT120447201");  //duplicate not possible  ts variable assigned for this
		nac.AccountCreationInfo();
		
		//Clean button
		
		NewCleanButton cb=new NewCleanButton();
		cb.setLocalValSource("Other-Self Sourced");
		cb.setOtherValSource("aa");
		cb.cleaninfo();
		
		//New Contact Creation
		NewContactCreation ncc=new NewContactCreation();
		ncc.setFirstName_Sal("Mr.");
		ncc.setFirstName("David");
		ncc.setLastName("Schwimmer");
		ncc.setContactPhone("447466763009");
		ncc.setEmail("ross_geller3@voda.com");//duplicate data not possible
		ncc.setGender("Male");
		ncc.setMobile("+447466763009");
		ncc.NewContactCreationInfo();
		
		
		//New Opportunity creation
		NewOpportunityCreation noc=new NewOpportunityCreation();
		noc.setOpportunitiesNameUK("Opp_Automation_UK");
		//noc.setOpportunitiesType(");
		//noc.setOpportunitiesCurrency(");
		noc.setInitialOpportunityValue("2000");
		//noc.setProbability("11");
		noc.setComplexity("Simple");
		//noc.setStage("");
		noc.NewOpportunityCreationInfo();
		
		
		/*
		//New Product creation
		NewProductAdd npa=new NewProductAdd();
		npa.setSearchprod("Sharer Tariffs");
		npa.setProductType("New");
		npa.setProductQuantity("1");
		npa.setProductTerm("12");
		npa.setOppInstallCharge("10");
		npa.productAdd();*/
				
		//change stage from dropdown
		//StateChange sc=new StateChange();
		//sc.setStage("");
	
	}

	/*noc.NavigateToOppTab();
	Thread.sleep(5000);
	npa.setUniqueID("UK");npa.productAdd();//Add New Product
	System.out.println("save button clicked");
	logger.log(LogStatus.PASS,"Product added successfully");
	sc.statechangeQ();
	logger.log(LogStatus.PASS, "Stage change successfully from Identify to Qualify");
	noc.NavigateToOppTab();
	nac.setAccountName("UK43051225012018");//set for testng purpose
	noc.selectOpporunityBasedOnAccountName(nac.getAccountName());
	ncq.cpqQuote();
	logger.log(LogStatus.PASS, "CPQ Quote successfully verified");
	if(!nac.isAccountDisplayed_OnGeneralInfoPage()){
		logger.log(LogStatus.FAIL, "Account Name not found");
		};
	if(!la.isAccountDisplayed_OnGeneralInfoPage()){
			logger.log(LogStatus.FAIL,"Prepared By not found");
		};
	ncq.returnOpportunityPage();
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

}*/


	
}
