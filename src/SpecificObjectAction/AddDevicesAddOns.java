package SpecificObjectAction;

import java.io.IOException;
import java.util.ArrayList;

import CommonActions.CommonMethod;
import Resources.ReadConfig;
import Resources.ReadExcelFile;

public class AddDevicesAddOns extends CommonMethod{

	String uniqueID,AddOnType,AddOns,addonQuantity,addOnsTechFund,addOnStartMonth,addOnEndMonth,addOnOfferPrice,addOnConnectionType,addOnPriceType,addOnCashBonus;
	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	public String getAddOns() {
		return AddOns;
	}

	public void setAddOns(String addOns) {
		AddOns = addOns;
	}

	public void addDevicesAddOns() throws IOException, InterruptedException
	{
		//getData();
		frameswitchdefault();
		frameSwitch("edit_quote");
		//javaScriptPermission();
		if(visibilityElement(10, ReadConfig.GetVal("devicesAddOnType_drp_Xp")))
		{
			selectDropDown(ReadConfig.GetVal("devicesAddOnType_drp_Xp"), "Business Advance Add-ons");
		}
		Thread.sleep(7000);
			selectDropDown(ReadConfig.GetVal("devicesAddOns_drp_Xp"),"100 international text msgs"); 
			/*sendKeys(ReadConfig.GetVal("devicesAddOnsQuantity_txt_Xp"), addonQuantity);
			sendKeys(ReadConfig.GetVal("devicesAddOnsTechFund_txt_Xp"), addOnsTechFund);
			selectDropDown(ReadConfig.GetVal("devicesAddOnStartMonth_drp_Xp"), addOnStartMonth);
			selectDropDown(ReadConfig.GetVal("devicesAddOnEndMonth_drp_Xp"), addOnEndMonth);
			sendKeys(ReadConfig.GetVal("devicesAddOnOfferPrice_txt_Xp"), addOnOfferPrice);
			selectDropDown(ReadConfig.GetVal("devicesAddOnConnectionType_drp_Xp"), addOnConnectionType);
			selectDropDown(ReadConfig.GetVal("devicesAddOnPriceType_drp_Xp"), addOnPriceType);
			sendKeys(ReadConfig.GetVal("devicesAddOnCashBonus_txt_Xp"), addOnCashBonus);*/
		}
	
	
	public void getData() throws IOException
	{
		ArrayList<String> list=ReadExcelFile.readExcelFileInfo("D:\\Workspace\\CPQ\\src\\TestData\\CPQ_Test_Data.xlsx", "DevicesAddOn", uniqueID);
	    this.uniqueID=list.get(0);
	    this.AddOnType=list.get(1);
	    this.AddOns=list.get(2);
	    this.addonQuantity=list.get(3);
	    this.addOnsTechFund=list.get(4);
	    this.addOnStartMonth=list.get(5);
	    this.addOnEndMonth=list.get(6);
	    this.addOnOfferPrice=list.get(7);
	    this.addOnConnectionType=list.get(8);
	    this.addOnPriceType=list.get(9);
	    this.addOnCashBonus=list.get(10);
	}
	
	public boolean isAddOnsDisplayed_OnGeneralInfoPage() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		String addon=ReadConfig.GetVal("addOnsVerify_table_Xp").replace("ReplaceMe", AddOns);
		System.out.println(addon);
		return visibilityElement(5, addon);
	}
}
