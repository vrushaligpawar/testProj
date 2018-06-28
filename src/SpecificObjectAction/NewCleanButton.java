package SpecificObjectAction;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import CommonActions.CommonMethod;
import Resources.ReadConfig;
import Resources.ReadConfigES;
import Resources.ReadExcelFile;

public class NewCleanButton extends CommonMethod{

	String localValSource,otherValSource,uniqueID;
	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}
	public void setLocalValSource(String localValSource) {
		this.localValSource = localValSource;
	}
	public void setOtherValSource(String otherValSource) {
		this.otherValSource = otherValSource;
	}
	
	public void cleaninfo() throws IOException, InterruptedException
	{
	    getData();	
		if (visibilityElement(10000,ReadConfig.GetVal("clean_btn_Xp")))
		{
		click( ReadConfig.GetVal("clean_btn_Xp"));
		}
		if (visibilityElement(10000,ReadConfig.GetVal("locallyValidate_btn_Xp")))
		{
			Thread.sleep(3000);	
		click( ReadConfig.GetVal("locallyValidate_btn_Xp"));
		}
		Thread.sleep(3000);
		selectDropDown( ReadConfig.GetVal("localValSource_drp_Xp"), localValSource);
		sendKeys( ReadConfig.GetVal("otherValSource_txt_Xp"), otherValSource);
		click( ReadConfig.GetVal("cleanSave_btn_Xp"));
	}
	
	public void getData() throws IOException
	{
		ArrayList<String> list=ReadExcelFile.readExcelFileInfo("D:\\Workspace\\CPQ\\src\\TestData\\CPQ_Test_Data.xlsx", "Cleanbutton", uniqueID);
		this.uniqueID=list.get(0);
		this.localValSource=list.get(1);
		this.otherValSource=list.get(2);
	}
	
	public void cleaninfoES() throws IOException, InterruptedException
	{
	    getData();	
		if (visibilityElement(10000,ReadConfig.GetVal("clean_btn_Xp")))
		{
		click( ReadConfig.GetVal("clean_btn_Xp"));
		}
		if (visibilityElement(10000,ReadConfig.GetVal("locallyValidate_btn_Xp")))
		{
			Thread.sleep(3000);	
		click( ReadConfig.GetVal("locallyValidate_btn_Xp"));
		}
		Thread.sleep(3000);
		selectDropDown( ReadConfig.GetVal("localValSource_drp_Xp"), localValSource);
		sendKeys( ReadConfig.GetVal("otherValSource_txt_Xp"), otherValSource);
		click( ReadConfigES.GetValES("cleanSaveES_btn_Xp"));
	}
	
}
