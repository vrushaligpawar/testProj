package SpecificObjectActionES;

import java.io.IOException;
import java.util.ArrayList;

import com.relevantcodes.extentreports.LogStatus;

import CommonActions.CommonMethod;
import Resources.ReadConfig;
import Resources.ReadConfigES;
import Resources.ReadExcelFile;

public class CustomerSiteES extends CommonMethod{
	LoginActionES lae=new LoginActionES();
	CommonActionsInAppES caie=new CommonActionsInAppES();
	NewAccountCreationES nace=new NewAccountCreationES();
	
	String customerSiteName,customerSiteProvince,customerSiteCity,customersiteStreetType,customersiteStreetName,customersiteStreetNumber,
	customersitePostCode,customersiteLatitude,customersiteLongitude,customersiteNormalized,uniqueID;
	String accountNamerecent;
	
	

	public String getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	public void newCustomerSitesES() throws IOException, InterruptedException
	{
		getData();
		Thread.sleep(5000);
		scrollIn(ReadConfigES.GetValES("newCustomerSiteES_btn_Xp"));
		if(visibilityElement(5, ReadConfigES.GetValES("newCustomerSiteES_btn_Xp")))
		{
			click(ReadConfigES.GetValES("newCustomerSiteES_btn_Xp"));
		}
		Thread.sleep(3000);
		sendKeys(ReadConfigES.GetValES("customerSiteNameES_txt_Xp"), customerSiteName);
		Thread.sleep(5000);
		moveandclick(ReadConfigES.GetValES("countrySearchES_lookup_Xp"));
		Thread.sleep(7000);
		CommonMethod.switchchildWindow();
		Thread.sleep(9000);
		if(lae.verifyLoginPopUpPage()) {
			lae.setUniqueID("ES_AM");lae.FillloginPoPWindowES();
				}
		Thread.sleep(9000);
		CommonMethod.frameSwitch("resultsFrame");
		Thread.sleep(9000);
		//CommonMethod.highlightElement(ReadConfigES.GetValES("countryNamelabel_txt_Xp"));
		//CommonMethod.highlightElement(ReadConfigES.GetValES("countrySearchWindowES_txt_Xp"));
		//click(ReadConfigES.GetValES("countrySearchWindowES_txt_Xp"));
		if(visibilityElement(2, ReadConfigES.GetValES("countrySearchWindowES_txt_Xp")))
			Thread.sleep(5000);
		click(ReadConfigES.GetValES("countrySearchWindowES_txt_Xp"));		
		CommonMethod.switchParentWindow();
		CommonMethod.frameswitchdefault();
		sendKeys(ReadConfigES.GetValES("customersiteProvinceES_Xp"), customerSiteProvince);
		sendKeys(ReadConfigES.GetValES("customersiteCityES_txt_Xp"), customerSiteCity);
		selectDropDown(ReadConfigES.GetValES("customersiteStreetTypeES_drp_Xp"), customersiteStreetType);
		sendKeys(ReadConfigES.GetValES("customersiteStreetNameES_txt_Xp"), customersiteStreetName);
		sendKeys(ReadConfigES.GetValES("customersiteNumberES_txt_Xp"), customersiteStreetNumber);
		sendKeys(ReadConfigES.GetValES("customersitePostCodeES_txt_Xp"), customersitePostCode);
		sendKeys(ReadConfigES.GetValES("customersiteLatitudeES_txt_Xp"), customersiteLatitude);
		sendKeys(ReadConfigES.GetValES("customersiteLongitudeES_txt_Xp"), customersiteLongitude);
		selectDropDown(ReadConfigES.GetValES("customersiteNormalizedES_drp_Xp"), customersiteNormalized);
		click(ReadConfigES.GetValES("customersiteSaveES_btn_Xp"));
		System.out.println(CommonActionsInAppES.readAccountNameFromConfig());
		accountNamerecent=CommonActionsInAppES.readAccountNameFromConfig();
		String acctNmXPath=ReadConfigES.GetValES("customersiteAccountName_link_Xp").replace("ReplaceMe",accountNamerecent);
		System.out.println(acctNmXPath);
		if(visibilityElement(15, acctNmXPath)){
			moveToElement(acctNmXPath);		
			Thread.sleep(5000);
			click(acctNmXPath);
			}
	}
	
	public void getData() throws IOException
	{
		ArrayList<String> list=ReadExcelFile.readExcelFileInfo("D:\\Workspace\\CPQ\\src\\TestData\\CPQ_Test_DataES.xlsx", "ESCustomerSite", uniqueID);
		this.uniqueID=list.get(0);
		this.customerSiteName=list.get(1);
		this.customerSiteProvince=list.get(2);
		this.customerSiteCity=list.get(3);
		this.customersiteStreetType=list.get(4);
		this.customersiteStreetName=list.get(5);
		this.customersiteStreetNumber=list.get(6);
		this.customersitePostCode=list.get(7);
		this.customersiteLatitude=list.get(9);
		this.customersiteLongitude=list.get(11);
		this.customersiteNormalized=list.get(12);
		
	}
	
	
	
}
