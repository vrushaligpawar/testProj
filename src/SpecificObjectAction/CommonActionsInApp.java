package SpecificObjectAction;

import java.io.IOException;

import org.openqa.selenium.By;

import CommonActions.CommonMethod;
import Resources.ReadConfig;
import Resources.ReadConfigES;

public class CommonActionsInApp extends CommonMethod {
	
	
	String searchtxt,UKAccountManagerSRNRecent,UKAccountName;
	
	public String getUKAccountName() {
		return UKAccountName;
	}

	public void setUKAccountName(String uKAccountName) {
		UKAccountName = uKAccountName;
	}

	public String getUKAccountManagerSRNRecent() {
		return UKAccountManagerSRNRecent;
	}

	public void setUKAccountManagerSRNRecent(String uKAccountManagerSRNRecent) {
		UKAccountManagerSRNRecent = uKAccountManagerSRNRecent;
	}

	public String getSearchtxt() {
		return searchtxt;
	}

	public void setSearchtxt(String searchtxt) {
		this.searchtxt = searchtxt;
	}
	public void searchCM() throws IOException, InterruptedException
	{
		click(ReadConfig.GetVal("CM_search_txt_Xp"));
		sendKeys(ReadConfig.GetVal("CM_search_txt_Xp"),UKAccountManagerSRNRecent);
		moveandclick(ReadConfig.GetVal("CM_searchCM_btn_Xp"));
	}

	public void readAMSRNESFromConfig() throws IOException
	{
		UKAccountManagerSRNRecent=ReadConfig.GetAccountFromFile("UKAccountManagerSRN");
		System.out.println(UKAccountManagerSRNRecent);
	}

	public void enableCPQApproval() throws IOException, InterruptedException
	{
		
		click(ReadConfig.GetVal("CM_editSRN_link_Xp").replace("ReplaceMe",UKAccountManagerSRNRecent));
		click(ReadConfig.GetVal("CM_enableCPQApproval_btn_Xp"));
	}
	
	public void clickSRNLink() throws IOException
	{
		click(ReadConfig.GetVal("CM_editSRN_link_Xp").replace("ReplaceMe",UKAccountManagerSRNRecent));
	}
	
	public void searchSS() throws IOException
	{
		click(ReadConfig.GetVal("CM_search_txt_Xp"));
		sendKeys(ReadConfig.GetVal("CM_search_txt_Xp"),UKAccountName);
		moveandclick(ReadConfig.GetVal("CM_searchCM_btn_Xp"));
	}
	
	public String readAccountNameFromConfig() throws IOException
	{
		UKAccountName=ReadConfig.GetAccountFromFile("AccountNameUK");
		System.out.println(UKAccountName);
		return UKAccountName;
	}
	
	public void clickAccountName() throws IOException
	{
		UKAccountName=ReadConfig.GetAccountFromFile("AccountName");
		click(ReadConfig.GetVal("accountNameInList_Xp").replace("ReplaceMe", UKAccountName));
	}
	
	public void logout() throws IOException, InterruptedException
	{
		Thread.sleep(4000);
		click(ReadConfig.GetVal("managerUKAccount_logout_Xp"));
		Thread.sleep(10000);
		moveToElement(ReadConfig.GetVal("logoutAM_Xp"));
	}
}
