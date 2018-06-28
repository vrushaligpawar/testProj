package SpecificObjectAction;

import java.io.IOException;
import java.util.ArrayList;

import CommonActions.CommonMethod;
import Resources.ReadConfig;
import Resources.ReadExcelFile;

public class AddFixedProductVSDM extends CommonMethod {

	String uniqueID,PackageName;
	public String getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	public void addSecurityVSDM() throws IOException, InterruptedException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(visibilityElement(10, ReadConfig.GetVal("addSecurityFixedProduct_link_Xp")))
		click(ReadConfig.GetVal("addSecurityFixedProduct_link_Xp"));
		Thread.sleep(3000);
		if(visibilityElement(10, ReadConfig.GetVal("clickVSDM_link_Xp")))
		click(ReadConfig.GetVal("clickVSDM_link_Xp"));
		Thread.sleep(5000);
	}
	
	public void addVSDMPackage() throws IOException, InterruptedException
	{
		getData();
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(visibilityElement(10, ReadConfig.GetVal("packageVSDM_drp_Xp")))
			selectDropDown(ReadConfig.GetVal("packageVSDM_drp_Xp"), PackageName);
		Thread.sleep(3000);
	}
	
	
	public void getData() throws IOException
	{
		ArrayList<String> list=ReadExcelFile.readExcelFileInfo("D:\\Workspace\\CPQ\\src\\TestData\\CPQ_Test_Data.xlsx", "VSDMPackage", uniqueID);
		this.uniqueID=list.get(0);
		this.PackageName=list.get(1);
	}
	
	public boolean isPackageNameDisplayed_OnGeneralInfoPage() throws IOException, InterruptedException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		Thread.sleep(9000);
		String varpackageName=ReadConfig.GetVal("packageNameFixedProductVerify_table_Xp").replace("ReplaceMe", "VSDM Green Bundle");
		System.out.println(varpackageName);
		return visibilityElement(5, varpackageName);
	}
	public boolean isAddOnDisplayed_OnGeneralInfoPage() throws IOException, InterruptedException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		Thread.sleep(9000);
		String varpackageName=ReadConfig.GetVal("packageNameFixedProductVerify_table_Xp").replace("ReplaceMe", "Setup cost");
		System.out.println(varpackageName);
		return visibilityElement(5, varpackageName);
	}
	
	public void modifySetUpCost() throws IOException, InterruptedException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(visibilityElement(10, ReadConfig.GetVal("setUpCost_txt_Xp")))
		{
			clear(ReadConfig.GetVal("setUpCost_txt_Xp"));
			Thread.sleep(3000);
			sendKeys(ReadConfig.GetVal("setUpCost_txt_Xp"), "1000");
		}
	}
	
	/*public boolean verifySetUpCostGeneralPage() throws IOException
	{
		boolean verifySetUpCost=CommonMethod.verifyValuesFromTable(ReadConfig.GetVal("verifySetUpCostGeneralPage_table_Xp"), "Setup cost", 7);
		System.out.println(verifySetUpCost);
		return verifySetUpCost;
	}*/
}
