package SpecificObjectActionES;

import java.io.IOException;
import java.util.ArrayList;

import CommonActions.CommonMethod;
import Resources.ReadConfig;
import Resources.ReadConfigES;
import Resources.ReadExcelFile;

public class AddProductOffice365ES extends CommonMethod{
	String ProductType,Family,ProductName,Quantity,uniqueID;
	
	public String getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	public void addProductOffice365ES() throws IOException, InterruptedException
	{
		getData();
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(visibilityElement(5, ReadConfigES.GetValES("office365ProductType_drp1_Xp")))
		selectDropDown(ReadConfigES.GetValES("office365ProductType_drp1_Xp"), ProductType);
		if(visibilityElement(5, ReadConfigES.GetValES("office365Family_drp1_Xp")))
		selectDropDown(ReadConfigES.GetValES("office365Family_drp1_Xp"), Family);
		Thread.sleep(9000);
		selectDropDown(ReadConfigES.GetValES("office365ProductName_drp1_Xp"),ProductName);
		if(visibilityElement(5, ReadConfigES.GetValES("office365Quantity_txt_Xp")))
		sendKeys(ReadConfigES.GetValES("office365Quantity_txt_Xp"), Quantity);
	}
	
	public void getData() throws IOException
	{
		ArrayList<String> list=ReadExcelFile.readExcelFileInfo("D:\\Workspace\\CPQ\\src\\TestData\\CPQ_Test_DataES.xlsx", "Office365AddProduct", uniqueID);
		this.uniqueID=list.get(0);
		this.ProductType=list.get(1);
		this.Family=list.get(2);
		this.ProductName=list.get(3);
		this.Quantity=list.get(4);
	}
	
	public boolean isProductDisplayed_OnGeneralInfoPageES() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		String familyProduct=ReadConfigES.GetValES("brandPlanVerify_table_Xp").replace("ReplaceMe", Family);
		System.out.println(familyProduct);
		return visibilityElement(5, familyProduct);
	}
	
	
}
