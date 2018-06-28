package SpecificObjectAction;

import java.io.IOException;
import java.util.ArrayList;

import CommonActions.CommonMethod;
import Resources.ReadConfig;
import Resources.ReadExcelFile;

public class AddDevicesBrand extends CommonMethod {

	String uniqueID,brandName,brdevice,brquantity,brstartMonth,brdiscountPercentage,brdiscountPound;
	public String getBrdevice() {
		return brdevice;
	}

	public void setBrdevice(String brdevice) {
		this.brdevice = brdevice;
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	public void addDevicesBrand() throws IOException, InterruptedException
	{
		//getData();
		frameswitchdefault();
		frameSwitch("edit_quote");
		//javaScriptPermission();
		if(visibilityElement(5, ReadConfig.GetVal("devicesAddOns_tab_Xp")))
			{
			pageUpButton();
			//javaScriptClick(ReadConfig.GetVal("devicesAddOns_tab_Xp"));
			moveandclick(ReadConfig.GetVal("devicesAddOns_tab_Xp"));
			}
		if(visibilityElement(5, ReadConfig.GetVal("devicesBrand_drp_Xp")))
		{
		selectDropDown(ReadConfig.GetVal("devicesBrand_drp_Xp"), "Sony");
		}
		//selectDropDown(ReadConfig.GetVal("devices_drp_Xp"), "SONY XZ COMPACT");
		/*clear(ReadConfig.GetVal("devicesbrandQuantity_txt_Xp"));
		sendKeys(ReadConfig.GetVal("devicesbrandQuantity_txt_Xp"),brquantity);
		selectDropDown(ReadConfig.GetVal("devicesbrandStartMonth_drp_Xp"), brstartMonth);
		sendKeys(ReadConfig.GetVal("devicesbrandDiscountPer_txt_Xp"), brdiscountPercentage);
		sendKeys(ReadConfig.GetVal("devicesbrandDiscountPound_txt_Xp"), brdiscountPound);*/
		
	}
	
	public void getData() throws IOException
	{
		ArrayList<String> list=ReadExcelFile.readExcelFileInfo("D:\\Workspace\\CPQ\\src\\TestData\\CPQ_Test_Data.xlsx", "DevicesBrand", uniqueID);
		this.uniqueID=list.get(0);
		this.brandName=list.get(1);
		this.brdevice=list.get(2);
		this.brquantity=list.get(3);
		this.brstartMonth=list.get(4);
		this.brdiscountPercentage=list.get(5);
		this.brdiscountPound=list.get(6);
	}
	
	public boolean isBrandDisplayed_OnGeneralInfoPage() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		String device=ReadConfig.GetVal("brandPlanVerify_table_Xp").replace("ReplaceMe", "100 international text msgs");
		System.out.println(device);
		return visibilityElement(5, device);
	}
	
}
