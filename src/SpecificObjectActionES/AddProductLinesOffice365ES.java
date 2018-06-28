package SpecificObjectActionES;

import java.io.IOException;
import java.util.ArrayList;

import CommonActions.CommonMethod;
import Resources.ReadConfigES;
import Resources.ReadExcelFile;

public class AddProductLinesOffice365ES extends CommonMethod {

	String NumberOfLines,Discount,uniqueID;
	
	public String getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	public void addLinesOffice365ES() throws IOException, InterruptedException
	{
		getData();
		frameswitchdefault();
		frameSwitch("edit_quote");
		clear(ReadConfigES.GetValES("office365NumberOfLines_txt_Xp"));
		Thread.sleep(5000);
		sendKeys(ReadConfigES.GetValES("office365NumberOfLines_txt_Xp"), NumberOfLines);
		selectDropDown(ReadConfigES.GetValES("office365Discount_drp_Xp"), Discount);
	}
	
	public void getData() throws IOException
	{
		ArrayList<String> list=ReadExcelFile.readExcelFileInfo("D:\\Workspace\\CPQ\\src\\TestData\\CPQ_Test_DataES.xlsx", "Office365AddLines", uniqueID);
		this.uniqueID=list.get(0);
		this.NumberOfLines=list.get(1);
		this.Discount=list.get(2);
	}
	
}
