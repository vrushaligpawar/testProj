package SpecificObjectActionES;

import java.io.IOException;
import java.util.ArrayList;

import CommonActions.CommonMethod;
import Resources.ReadConfig;
import Resources.ReadConfigES;
import Resources.ReadExcelFile;
import Resources.WriteConfigFile;
import Resources.WriteConfigFileES;

public class NewOpportunityCreationES extends CommonMethod{

	LoginActionES lae=new LoginActionES();
	String OpportunitiesName,OpportunitiesType,OpportunitiesCurrency,PrimaryContact,InitialOpportunityValue,Stage,Probability,Complexity,OpportunitiesNamerecent;
	String AccountManagerQuoteNumberRecent;
	public String getOpportunitiesName() {
		return OpportunitiesName;
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
	public void setOpportunitiesName(String opportunitiesName) {
		OpportunitiesName = opportunitiesName;
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
	public void NewOpportunityCreationInfoES() throws IOException, InterruptedException
	{
		getData();
		String todaydate= selectDate();
		Thread.sleep(10000);click( ReadConfigES.GetValES("newOpportunityES_btn_Xp"));
		Thread.sleep(10000);sendKeys( ReadConfigES.GetValES("opportunitiesName_txt_Xp"), OpportunitiesName);
		WriteConfigFileES.setPropertyInFileES("OpportunitiesNameSpain",OpportunitiesName);
		selectDropDown( ReadConfigES.GetValES("opportunitiesType_drp_Xp"), OpportunitiesType);
		selectDropDown( ReadConfigES.GetValES("opportunitiesCurrency_drp_Xp"), OpportunitiesCurrency);
		sendKeys( ReadConfigES.GetValES("primaryContact_txt_Xp"), PrimaryContact);
		//InitialOpportunityValue not displayed on PreProd environmnet so comment it.
		//sendKeys( ReadConfigES.GetValES("initialOpportunityValue_txt_Xp"), InitialOpportunityValue);  
		selectDropDown( ReadConfigES.GetValES("stage_drp_Xp"), Stage);
		sendKeys( ReadConfigES.GetValES("probability_txt_Xp"), Probability);
		selectDropDown( ReadConfigES.GetValES("complexity_drp_Xp"), Complexity);
		sendKeys( ReadConfigES.GetValES("closeDate_cal_Xp"),todaydate);
		click( ReadConfigES.GetValES("opp_SaveES_btn_Xp"));
		}
	
	private void getData() throws IOException
	{
		ArrayList<String> list=ReadExcelFile.readExcelFileInfo("D:\\Workspace\\CPQ\\src\\TestData\\CPQ_Test_DataES.xlsx", "OppCreationES", uniqueID);
		this.uniqueID=list.get(0);
		this.OpportunitiesName=list.get(1);
		this.InitialOpportunityValue=list.get(4);
		this.Complexity=list.get(6);
	}
	public void returnToOpportunityES() throws IOException
	{
		if(visibilityElement(5,ReadConfigES.GetValES("returnToOpportunityES_btn_Xp")))
		{
			click(ReadConfigES.GetValES("returnToOpportunityES_btn_Xp"));
		}
	}
	
	public void clickOppTabES() throws IOException, InterruptedException
	{
		Thread.sleep(10000);
		click(ReadConfigES.GetValES("opportunitiesTab_Xp"));
		Thread.sleep(5000);
		
	}
	
	public void opportunityRoadmapCreationES() throws IOException, InterruptedException
	{
		if(visibilityElement(5,ReadConfigES.GetValES("OpportunityRoadmapES_btn_Xp")))
		{
			click(ReadConfigES.GetValES("OpportunityRoadmapES_btn_Xp"));
		}
		CommonMethod.switchTab();
		if(lae.verifyLoginPopUpPage()) {
			lae.setUniqueID("ES_AM");lae.FillloginPoPWindowES();
				}
		CommonMethod.pageDownButton();
		Thread.sleep(5000);
		moveandclick(ReadConfigES.GetValES("OpportunityRoadmapSaveES_btn_Xp"));
		Thread.sleep(3000);
		CommonMethod.switchDefaultTab();
		if(visibilityElement(5, ReadConfigES.GetValES("OpportunityRoadmapName_link_Xp")))
		{
		click(ReadConfigES.GetValES("OpportunityRoadmapName_link_Xp"));
		}
	}
	
	public void editQuotelinkES() throws IOException, InterruptedException
	{
		if(visibilityElement(3000,ReadConfigES.GetValES("editQuoteES_link_Xp")))
		{
			Thread.sleep(2000);
			click(ReadConfigES.GetValES("editQuoteES_link_Xp"));
		}
	}
	
	public void collectSRNES() throws IOException
	{ 
		SRNumber=getElementText(ReadConfigES.GetValES("editSRNES_link_Xp"));
		System.out.println(SRNumber);
		WriteConfigFileES.setPropertyInFileES("SRNumber", SRNumber);
	}
	
	public void readSRNFromConfig() throws IOException
	{
		String SRNumberRecent=ReadConfigES.GetAccountFromFileES("SRNumber");
		System.out.println(SRNumberRecent);
	}
	
	public void clickQuotelinkFromConfigES() throws IOException, InterruptedException
	{
		AccountManagerQuoteNumberRecent=ReadConfigES.GetAccountFromFileES("AccountManagerQuoteNumber");
		System.out.println(AccountManagerQuoteNumberRecent);
		Thread.sleep(9000);
		if(visibilityElement(3000, ReadConfigES.GetValES("editSRNFromConfigES_link_Xp").replace("ReplaceMe", AccountManagerQuoteNumberRecent)))
		{
			Thread.sleep(2000);
		click(ReadConfigES.GetValES("editSRNFromConfigES_link_Xp").replace("ReplaceMe", AccountManagerQuoteNumberRecent));
		}
	}
	
	public void clickQuoteModificar() throws IOException
	{
	  if(visibilityElement(10, ReadConfigES.GetValES("quoteModificarES_btn_Xp")))
	  {
		  click(ReadConfigES.GetValES("quoteModificarES_btn_Xp"));
	  }
		
	}
	
	public void clickQuoteModificarOnMainPage() throws IOException
	{
	  if(visibilityElement(10, ReadConfigES.GetValES("quoteModificarOnMainPageES_btn_Xp")))
	  {
		  click(ReadConfigES.GetValES("quoteModificarOnMainPageES_btn_Xp"));
	  }
		
	}
	
	public void readAccountNameFromConfig() throws IOException
	{
		OpportunitiesNamerecent=ReadConfigES.GetAccountFromFileES("OpportunitiesNameSpain");
		System.out.println(OpportunitiesNamerecent);
	}
	
	public void clickOnOPPNameInList() throws IOException, InterruptedException
	{
		OpportunitiesNamerecent=ReadConfigES.GetAccountFromFileES("OpportunitiesNameSpain");
		Thread.sleep(3000);
		click(ReadConfigES.GetValES("opportunitiesNameInList_Xp").replace("ReplaceMe", OpportunitiesNamerecent));
	}
	
	public void clickOnOPPNameLink() throws IOException, InterruptedException
	{
		OpportunitiesNamerecent=ReadConfigES.GetAccountFromFileES("OpportunitiesNameSpain");
		Thread.sleep(3000);
		moveToElement(ReadConfigES.GetValES("clickOPPNameFromSRN_link_Xp").replace("ReplaceMe", OpportunitiesNamerecent));
		click(ReadConfigES.GetValES("clickOPPNameFromSRN_link_Xp").replace("ReplaceMe", OpportunitiesNamerecent));
		if(visibilityElement(10, ReadConfigES.GetValES("clickOPPNameFromSRN_link_Xp").replace("ReplaceMe", OpportunitiesNamerecent))){
			moveToElement(ReadConfigES.GetValES("clickOPPNameFromSRN_link_Xp").replace("ReplaceMe", OpportunitiesNamerecent));
		}
	}
	public void setPrimaryQuoteES() throws IOException, InterruptedException
	{
		if(visibilityElement(3,ReadConfigES.GetValES("selectQuoteES_chk_Xp")))
		{
			Thread.sleep(2000);
			selectCheckbox(ReadConfigES.GetValES("selectQuoteES_chk_Xp"));
		}
		click(ReadConfigES.GetValES("setPrimaryQuote_btn_Xp"));
		Thread.sleep(3000);
		click(ReadConfigES.GetValES("continue_btn_Xp"));
	}
	
	public void clickonOPPNameInQuote() throws IOException
	{
		click(ReadConfigES.GetValES("opportunitiesNameInList_Xp").replace("ReplaceMe", OpportunitiesNamerecent));
	}
	
	public void addTESUser() throws IOException
	{
		if(visibilityElement(5, ReadConfigES.GetValES("addUser_btn_Xp")))
		{
			click(ReadConfigES.GetValES("addUser_btn_Xp"));
		}
		sendKeys(ReadConfigES.GetValES("addUser_txt_xp"), "TES User");
		selectDropDown(ReadConfigES.GetValES("addUser_drp_xp"), "TES Technical Responsible");
		click(ReadConfigES.GetValES("save_btn_Xp"));
	}
}
