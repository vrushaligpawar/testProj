package SpecificObjectAction;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;

import CommonActions.CommonMethod;
import Resources.ReadConfig;
import Resources.ReadConfigES;
import Resources.ReadExcelFile;
import Resources.WriteConfigFile;

public class NewAccountCreation extends CommonMethod 
{
	String accountNameUK;
	String mainSalesChannel;
	String accountType;
	String mailingStreet;
	String mailingCity;
	String mailingState;
	String mailingZip;
	String mailingCountry;
	String companyPhone;
	String email;
	String employees;
	String nationalIdeNum;
	String vATNum;
	String region;
	String microsegment;
	String uniqueID;
	String excePath= "D:\\Workspace\\CPQ\\src\\TestData\\CPQ_Test_Data.xlsx";
	String excelsheet="AccountCreationInfo";
	String accountNamerecent;

	public String AccountCreationInfo() throws IOException, InterruptedException
	{
		try
		{
		getData();
		String ts=autoIncrement();
		Thread.sleep(9000);click(ReadConfig.GetVal("account_New_btn_Xp"));
		Thread.sleep(3000);
		accountNameUK=accountNameUK+ts; //need to add autogenerate code
		WriteConfigFile.setPropertyInFile("AccountNameUK",accountNameUK);
		Thread.sleep(2000);
		sendKeys(ReadConfig.GetVal("accountName_txt_Xp"), accountNameUK); 
		selectDropDown(ReadConfig.GetVal("accountType_drp_Xp"),accountType);
		Thread.sleep(2000);
		sendKeys( ReadConfig.GetVal("mailingStreet_txt_Xp"), mailingStreet); 
		sendKeys( ReadConfig.GetVal("mailingCity_txt_Xp"), mailingCity);
		sendKeys( ReadConfig.GetVal("mailingZip_txt_Xp"), mailingZip);
		sendKeys( ReadConfig.GetVal("mailingState_txt_Xp"), mailingState);
		sendKeys( ReadConfig.GetVal("mailingCountry_txt_Xp"), mailingCountry);
		sendKeys( ReadConfig.GetVal("companyPhone_txt_Xp"), companyPhone);
		sendKeys( ReadConfig.GetVal("email_txt_Xp"), ts+email);
		sendKeys( ReadConfig.GetVal("employees_txt_Xp"), employees);
		Thread.sleep(3000);
		scrollIn(ReadConfig.GetVal("copyMail_link_Xp"));//to scroll in advance
		click( ReadConfig.GetVal("copyMail_link_Xp")); //need to verify xpath
		selectDropDown(ReadConfig.GetVal("mainSalesChannel_drp_Xp"),mainSalesChannel);
		selectDropDown(ReadConfig.GetVal("microseg_drp_Xp"), microsegment);
		selectDropDown(ReadConfig.GetVal("region_drp_Xp"), region);
		sendKeys( ReadConfig.GetVal("nationalIdeNum_txt_Xp"),"NID"+ts); //need to add autogenerate code
		sendKeys( ReadConfig.GetVal("vATNum_txt_Xp"),"VAT"+ts); //need to add autogenerate code
		click( ReadConfig.GetVal("save_btn_Xp"));
		return "Pass";
		} catch(Exception e){
		return e.getMessage();
	
	}
	}
	
	public String publicSectorAccountCreation()throws IOException, InterruptedException
	{
		try
		{
		getData();
		String ts=autoIncrement();
		Thread.sleep(9000);click(ReadConfig.GetVal("account_New_btn_Xp"));
		Thread.sleep(3000);
		accountNameUK=accountNameUK+ts; //need to add autogenerate code
		WriteConfigFile.setPropertyInFile("AccountName",accountNameUK);
		Thread.sleep(2000);
		sendKeys(ReadConfig.GetVal("accountName_txt_Xp"), accountNameUK); 		
		selectDropDown(ReadConfig.GetVal("accountType_drp_Xp"),accountType);
		Thread.sleep(2000);
		sendKeys( ReadConfig.GetVal("mailingStreet_txt_Xp"), mailingStreet); 
		sendKeys( ReadConfig.GetVal("mailingCity_txt_Xp"), mailingCity);
		sendKeys( ReadConfig.GetVal("mailingZip_txt_Xp"), mailingZip);
		sendKeys( ReadConfig.GetVal("mailingState_txt_Xp"), mailingState);
		sendKeys( ReadConfig.GetVal("mailingCountry_txt_Xp"), mailingCountry);
		sendKeys( ReadConfig.GetVal("companyPhone_txt_Xp"), companyPhone);
		sendKeys( ReadConfig.GetVal("email_txt_Xp"), email);
		sendKeys( ReadConfig.GetVal("employees_txt_Xp"), employees);
		Thread.sleep(3000);
		scrollIn(ReadConfig.GetVal("copyMail_link_Xp"));//to scroll in advance
		click( ReadConfig.GetVal("copyMail_link_Xp")); //need to verify xpath
		selectDropDown(ReadConfig.GetVal("mainSalesChannel_drp_Xp"),mainSalesChannel);
		selectDropDown(ReadConfig.GetVal("microseg_drp_Xp"), microsegment);
		selectDropDown(ReadConfig.GetVal("region_drp_Xp"), region);
		selectCheckbox(ReadConfig.GetVal("publicSector_chk_Xp"));
		sendKeys( ReadConfig.GetVal("nationalIdeNum_txt_Xp"),"NID"+ts); //need to add autogenerate code
		sendKeys( ReadConfig.GetVal("vATNum_txt_Xp"),"VAT"+ts); //need to add autogenerate code
		click( ReadConfig.GetVal("save_btn_Xp"));
		return "Pass";
		} catch(Exception e){
		return e.getMessage();
	
	}
	}

	public void clickAccountTab() throws IOException, InterruptedException
	
	{
		if(visibilityElement(20000, ReadConfig.GetVal("accountTab_Xp")))
		{
			Thread.sleep(3000);
		click(ReadConfig.GetVal("accountTab_Xp"));
		}
		
	}
	
	public String getData() throws IOException
	{
		
		ArrayList<String> list=ReadExcelFile.readExcelFileInfo("D:\\Workspace\\CPQ\\src\\TestData\\CPQ_Test_Data.xlsx", "AccountCreationInfo", uniqueID);
		//this.accountName=list.get(0+"UK"+ts);
		this.uniqueID=list.get(0);
		accountNameUK=list.get(1);
		this.mailingStreet=list.get(2);
		this.mailingCity=list.get(3);
		this.mailingState=list.get(4);
		this.mailingZip=list.get(5);
		this.mailingCountry=list.get(6);
		this.companyPhone=list.get(7);
		this.email=list.get(8);
		this.employees=list.get(9);
		this.vATNum=list.get(10);
		this.nationalIdeNum=list.get(11);
		this.mainSalesChannel=list.get(12);
		this.microsegment=list.get(14);
		return this.region=list.get(15);
	}
	
	public void setAccountName(String accountNm) {
		accountNameUK = accountNm;
	}

	public String getAccountName() {
		return accountNameUK;
	}
	
	public String getAccountNameFromFile() throws IOException {
		return ReadConfig.GetAccountFromFile("accountNameUK");
	}

	public void setMainSalesChannel(String mainSalesChannel) {
		this.mainSalesChannel = mainSalesChannel;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setMailingStreet(String mailingStreet) {
		this.mailingStreet = mailingStreet;
	}

	public void setMailingCity(String mailingCity) {
		this.mailingCity = mailingCity;
	}

	public void setMailingState(String mailingState) {
		this.mailingState = mailingState;
	}

	public void setMailingZip(String mailingZip) {
		this.mailingZip = mailingZip;
	}

	public void setMailingCountry(String mailingCountry) {
		this.mailingCountry = mailingCountry;
	}

	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEmployees(String employees) {
		this.employees = employees;
	}

	public void setNationalIdeNum(String nationalIdeNum) {
		this.nationalIdeNum = nationalIdeNum;
	}

	public void setvATNum(String vATNum) {
		this.vATNum = vATNum;
	}
	
	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}
	
	
	public boolean isAccountDisplayed_OnGeneralInfoPage() throws IOException{
		frameswitchdefault();
		frameSwitch("edit_quote");
		System.out.println(readAccountNameFromConfig());
		accountNamerecent=readAccountNameFromConfig();
		String changedXath = ReadConfig.GetVal("accountNameLable_Xp").replace("ReplaceMe", accountNamerecent);
		System.out.println(changedXath);
		return visibilityElement(20,changedXath);	
	}
	
	public static String readAccountNameFromConfig() throws IOException
	{
		return ReadConfig.GetAccountFromFile("accountNameUK");
	}
	
	public boolean isAccountDisplayed_OnTop() throws IOException{
		
		String changedXath = ReadConfig.GetVal("topAccountName_lbl_Xp").replace("ReplaceMe", accountNameUK);
		System.out.println(changedXath);
		return visibilityElement(20,changedXath);		
	}
	
	public boolean isAccountDisplayed_InList() throws IOException{
		
		String changedXath = ReadConfig.GetVal("accountNameInList_Xp").replace("ReplaceMe", accountNameUK);
		System.out.println(changedXath);
		return visibilityElement(20,changedXath);		
	}
	
	public void clickOnAccountNameInList() throws IOException
	{
		accountNameUK=ReadConfig.GetAccountFromFile("AccountNameUK");
		click(ReadConfig.GetVal("accountNameInList_Xp").replace("ReplaceMe", accountNameUK));
	}
	
	
	}
	
	
	


