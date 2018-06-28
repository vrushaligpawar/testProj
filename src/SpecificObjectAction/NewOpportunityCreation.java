package SpecificObjectAction;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import CommonActions.CommonMethod;
import Resources.ReadConfig;
import Resources.ReadConfigES;
import Resources.ReadExcelFile;
import Resources.WriteConfigFile;

public class NewOpportunityCreation extends CommonMethod
{

	String OpportunitiesNamerecent,OpportunitiesNameUK,OpportunitiesType,OpportunitiesCurrency,PrimaryContact,InitialOpportunityValue,Stage,Probability,Complexity;
	

	public String getOpportunitiesNameUK() {
		return OpportunitiesNameUK;
	}
	public void setOpportunitiesNameUK(String opportunitiesNameUK) {
		OpportunitiesNameUK = opportunitiesNameUK;
	}

	String uniqueID;
	String SRNumber;
	public String getSRNumber() {
		return SRNumber;
	}
	public void setSRNumber(String sRNumber) {
		SRNumber = sRNumber;
	}
	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}
	
	public void setOpportunitiesType(String opportunitiesType) {
		OpportunitiesType = opportunitiesType;
	}
	public void setOpportunitiesCurrency(String opportunitiesCurrency) {
		OpportunitiesCurrency = opportunitiesCurrency;
	}
	public void setPrimaryContact(String primaryContact) {
		PrimaryContact = primaryContact;
	}
	public void setInitialOpportunityValue(String initialOpportunityValue) {
		InitialOpportunityValue = initialOpportunityValue;
	}
	public void setStage(String stage) {
		Stage = stage;
	}
	public void setProbability(String probability) {
		Probability = probability;
	}
	public void setComplexity(String complexity) {
		Complexity = complexity;
	}
	public void NavigateToOppTab() throws IOException, InterruptedException
	{
	if(visibilityElement(20000, ReadConfig.GetVal("opportunitiesTab_Xp")))
	{
		Thread.sleep(3000);
	click(ReadConfig.GetVal("opportunitiesTab_Xp"));
	}
	}
	public void NewOpportunityCreationInfo() throws IOException, InterruptedException
	{
		getData();
		String todaydate= selectDate();
		Thread.sleep(10000);click( ReadConfig.GetVal("newOpportunity_btn_Xp"));
		Thread.sleep(10000);sendKeys( ReadConfig.GetVal("opportunitiesName_txt_Xp"), OpportunitiesNameUK);
		WriteConfigFile.setPropertyInFile("OpportunitiesNameUK",OpportunitiesNameUK);
		selectDropDown( ReadConfig.GetVal("opportunitiesType_drp_Xp"), OpportunitiesType);
		selectDropDown( ReadConfig.GetVal("opportunitiesCurrency_drp_Xp"), OpportunitiesCurrency);
		sendKeys( ReadConfig.GetVal("primaryContact_txt_Xp"), PrimaryContact);
		//sendKeys( ReadConfig.GetVal("initialOpportunityValue_txt_Xp"), InitialOpportunityValue);
		selectDropDown( ReadConfig.GetVal("stage_drp_Xp"), Stage);
		sendKeys( ReadConfig.GetVal("probability_txt_Xp"), Probability);
		selectDropDown( ReadConfig.GetVal("complexity_drp_Xp"), Complexity);
		sendKeys( ReadConfig.GetVal("closeDate_cal_Xp"),todaydate);
		click( ReadConfig.GetVal("opp_Save_btn_Xp"));
		
		}
	
	private void getData() throws IOException
	{
		ArrayList<String> list=ReadExcelFile.readExcelFileInfo("D:\\Workspace\\CPQ\\src\\TestData\\CPQ_Test_Data.xlsx", "OppCreation", uniqueID);
		this.uniqueID=list.get(0);
		this.OpportunitiesNameUK=list.get(1);
		this.InitialOpportunityValue=list.get(4);
		this.Complexity=list.get(6);
	}
	public void selectOpporunityBasedOnAccountName(String accountName) {
		click("//a[contains(text(),accountName)]/../../th/a");
	}
	
	public void collectSRN() throws IOException
	{ 
		SRNumber=getElementText(ReadConfig.GetVal("editSRN_link_Xp"));
		System.out.println(SRNumber);
		WriteConfigFile.setPropertyInFile("UKAccountManagerSRN", SRNumber);
	}
	
	public void editQuotelink() throws IOException, InterruptedException
	{
		if(visibilityElement(8000,ReadConfig.GetVal("editQuote_link_Xp")))
		{
			Thread.sleep(5000);
			click(ReadConfig.GetVal("editQuote_link_Xp"));
		}
	}
	
	public void clickOppTab() throws IOException, InterruptedException
	{
		Thread.sleep(10000);
		click(ReadConfig.GetVal("opportunitiesTab_Xp"));
		
	}
	
	
	
	public boolean isOpporunityNameDisplayed_InList() throws IOException{
		OpportunitiesNameUK="Opp_Automation_UK";
		String changedXath = ReadConfig.GetVal("opportunitiesNameInList_Xp").replace("ReplaceMe", OpportunitiesNameUK);
		System.out.println(changedXath);
		return visibilityElement(20,changedXath);		
	}
	
	public void clickOppNameList() throws IOException{
		moveandclick(ReadConfig.GetVal("opportunitiesNameInList_Xp").replace("ReplaceMe", OpportunitiesNameUK));
		System.out.println("OppName click from list");
	}
	
	public void clickOppNameForGivenAccount() throws IOException{
		String acctNmRecent=ReadConfig.GetAccountFromFile("AccountNameUK");
		moveandclick(ReadConfig.GetVal("oppNameForGivenAccountInList_Xp").replace("ReplaceMe", acctNmRecent));
		System.out.println("OppName click from list");
	}
	
	public void readOPPNameFromConfig() throws IOException
	{
		OpportunitiesNamerecent=ReadConfig.GetAccountFromFile("OpportunitiesNameUK");
		System.out.println(OpportunitiesNamerecent);
	}
	
	public void clickOnOPPNameInList() throws IOException, InterruptedException
	{
		OpportunitiesNamerecent=ReadConfig.GetAccountFromFile("OpportunitiesNameUK");
		Thread.sleep(3000);
		moveToElement(ReadConfig.GetVal("clickOPPNameFromSRN_link_Xp").replace("ReplaceMe", OpportunitiesNamerecent));
		click(ReadConfig.GetVal("clickOPPNameFromSRN_link_Xp").replace("ReplaceMe", OpportunitiesNamerecent));
		if(visibilityElement(10, ReadConfig.GetVal("clickOPPNameFromSRN_link_Xp").replace("ReplaceMe", OpportunitiesNamerecent))){
			moveToElement(ReadConfig.GetVal("clickOPPNameFromSRN_link_Xp").replace("ReplaceMe", OpportunitiesNamerecent));
		}
	}

	public void clickOnOPPNameFromConfig() throws IOException, InterruptedException
	{
		OpportunitiesNamerecent=ReadConfig.GetAccountFromFile("OpportunitiesNameUK");
		Thread.sleep(2000);
		moveToElement(ReadConfig.GetVal("clickOPPNameFromSRN_link_Xp").replace("ReplaceMe", OpportunitiesNamerecent));
		click(ReadConfig.GetVal("clickOPPNameFromSRN_link_Xp").replace("ReplaceMe", OpportunitiesNamerecent));
	}
	
}
