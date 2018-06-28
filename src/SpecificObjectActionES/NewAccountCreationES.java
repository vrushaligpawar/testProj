package SpecificObjectActionES;

import java.io.IOException;
import java.util.ArrayList;

import CommonActions.CommonMethod;

import Resources.ReadConfigES;
import Resources.ReadExcelFile;
import Resources.WriteConfigFileES;

public class NewAccountCreationES extends CommonMethod {
	String accountName,accountNamerecent;;
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
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
	public String getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}
	String excePath= "D:\\Workspace\\CPQ\\src\\TestData\\CPQ_Test_DataES.xlsx";
	String excelsheet="AccountCreationES";
	
public void clickAccountTabES() throws IOException, InterruptedException
	
	{
		if(visibilityElement(2000, ReadConfigES.GetValES("accountTabES_Xp")))
		{
			Thread.sleep(3000);
		click(ReadConfigES.GetValES("accountTabES_Xp"));
		}
		
	}
	
	public String AccountCreationInfoES() throws IOException, InterruptedException
	{
		try
		{
		getData();
		String ts=autoIncrement();
		Thread.sleep(3000);click(ReadConfigES.GetValES("accountES_New_btn_Xp"));
		Thread.sleep(3000);
		accountName=ts+accountName; //need to add autogenerate code
		WriteConfigFileES.setPropertyInFileES("AccountNameSpain",accountName);
		Thread.sleep(2000);
		sendKeys(ReadConfigES.GetValES("accountName_txt_Xp"), accountName); 
		selectDropDown(ReadConfigES.GetValES("accountType_drp_Xp"),accountType);
		Thread.sleep(2000);
		sendKeys( ReadConfigES.GetValES("mailingStreet_txt_Xp"), mailingStreet); 
		sendKeys( ReadConfigES.GetValES("mailingCity_txt_Xp"), mailingCity);
		sendKeys( ReadConfigES.GetValES("mailingZip_txt_Xp"), mailingZip);
		sendKeys( ReadConfigES.GetValES("mailingState_txt_Xp"), mailingState);
		sendKeys( ReadConfigES.GetValES("mailingCountry_txt_Xp"), mailingCountry);
		sendKeys( ReadConfigES.GetValES("companyPhone_txt_Xp"), ts+companyPhone);
		sendKeys( ReadConfigES.GetValES("email_txt_Xp"), ts+email);
		sendKeys( ReadConfigES.GetValES("employees_txt_Xp"), employees);
		Thread.sleep(3000);
		scrollIn(ReadConfigES.GetValES("copyMailES_link_Xp"));//to scroll in advance
		click( ReadConfigES.GetValES("copyMailES_link_Xp")); //need to verify xpath
		selectDropDown(ReadConfigES.GetValES("mainSalesChannel_drp_Xp"),mainSalesChannel);
		selectDropDown(ReadConfigES.GetValES("microseg_drp_Xp"), microsegment);
		selectDropDown(ReadConfigES.GetValES("region_drp_Xp"), region);
		sendKeys( ReadConfigES.GetValES("nationalIdeNum_txt_Xp"),ts+"NID"); //need to add autogenerate code
		sendKeys( ReadConfigES.GetValES("vATNum_txt_Xp"),ts+"VAT"); //need to add autogenerate code
		click( ReadConfigES.GetValES("save_btn_Xp"));
		return "Pass";
		} catch(Exception e){
		return e.getMessage();
	
	}
	}
		public String getData() throws IOException
		{
			
			ArrayList<String> list=ReadExcelFile.readExcelFileInfo("D:\\Workspace\\CPQ\\src\\TestData\\CPQ_Test_DataES.xlsx", "AccountCreationES", uniqueID);
			//this.accountName=list.get(0+"UK"+ts);
			this.uniqueID=list.get(0);
			accountName=list.get(1);
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
		
		
		public void clickOnAccountNameInListES() throws IOException
		{
			System.out.println(CommonActionsInAppES.readAccountNameFromConfig());
			accountNamerecent=CommonActionsInAppES.readAccountNameFromConfig();
			click(ReadConfigES.GetValES("accountNameInList_Xp").replace("ReplaceMe", accountNamerecent));
		}
		
		public boolean isAccountDisplayed_OnGeneralInfoPageES() throws IOException{
			frameswitchdefault();
			frameSwitch("edit_quote");
			System.out.println(CommonActionsInAppES.readAccountNameFromConfig());
			accountNamerecent=CommonActionsInAppES.readAccountNameFromConfig();
			String changedXath = ReadConfigES.GetValES("accountNameLable_Xp").replace("ReplaceMe", accountNamerecent);
			System.out.println(changedXath);
			return visibilityElement(20,changedXath);		
		}
}
