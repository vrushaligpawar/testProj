package SpecificObjectAction;

import java.io.IOException;
import java.util.ArrayList;

import CommonActions.CommonMethod;
import Resources.ReadConfig;
import Resources.ReadExcelFile;

public class AddFixedProductBES extends CommonMethod {

	String uniqueID,PackageName,LicenseType,ProductName,PackageAddOnName,LicenseAddOnType,ProductNameAddOn,uniqueID1;
	public String getUniqueID1() {
		return uniqueID1;
	}

	public void setUniqueID1(String uniqueID1) {
		this.uniqueID1 = uniqueID1;
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	public void addSecurityBES() throws IOException, InterruptedException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(visibilityElement(10, ReadConfig.GetVal("addSecurityFixedProduct_link_Xp")))
		click(ReadConfig.GetVal("addSecurityFixedProduct_link_Xp"));
		Thread.sleep(3000);
		if(visibilityElement(10, ReadConfig.GetVal("clickBES_link_Xp")))
		click(ReadConfig.GetVal("clickBES_link_Xp"));
		Thread.sleep(5000);
	}
	
	public void addBESPackage() throws IOException, InterruptedException
	{
		getData();
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(visibilityElement(10, ReadConfig.GetVal("packageBES_drp_Xp")))
			selectDropDown(ReadConfig.GetVal("packageBES_drp_Xp"), PackageName);
		Thread.sleep(3000);
		selectDropDown(ReadConfig.GetVal("licenseTypeBES_drp_Xp"), LicenseType);
		Thread.sleep(2000);
		selectDropDown(ReadConfig.GetVal("productNameBES_drp_Xp"), ProductName);
	}
	
	
	public void getData() throws IOException
	{
		ArrayList<String> list=ReadExcelFile.readExcelFileInfo("D:\\Workspace\\CPQ\\src\\TestData\\CPQ_Test_Data.xlsx", "BFSPackage", uniqueID);
		this.uniqueID=list.get(0);
		this.PackageName=list.get(1);
		this.LicenseType=list.get(2);
		this.ProductName=list.get(3);
	}
	
	public void addBESADDOnPackage() throws IOException, InterruptedException
	{
		getData1();
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(visibilityElement(10, ReadConfig.GetVal("packageAddOnBES_drp_Xp")))
			selectDropDown(ReadConfig.GetVal("packageAddOnBES_drp_Xp"), PackageAddOnName);
		Thread.sleep(3000);
		selectDropDown(ReadConfig.GetVal("licenseTypeAddOnBES_drp_Xp"), LicenseAddOnType);
		Thread.sleep(2000);
		selectDropDown(ReadConfig.GetVal("productNameAddOnBES_drp_Xp"), ProductNameAddOn);
	}
	
	
	public void getData1() throws IOException
	{
		ArrayList<String> list=ReadExcelFile.readExcelFileInfo("D:\\Workspace\\CPQ\\src\\TestData\\CPQ_Test_Data.xlsx", "BFSAddOn", uniqueID1);
		this.uniqueID1=list.get(0);
		this.PackageAddOnName=list.get(1);
		this.LicenseAddOnType=list.get(2);
		this.ProductNameAddOn=list.get(3);
	}
	
}
