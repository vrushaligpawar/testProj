package SpecificObjectAction;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import CommonActions.CommonMethod;
import Resources.ReadConfig;
import Resources.ReadExcelFile;


public class LoginAction extends CommonMethod
{
	String uniqueID;
	String userName;
	String password;
	String url;
	String browser;
	String preparedBy;
	public String getPreparedBy() {
		return preparedBy;
	}

	public void setPreparedBy(String preparedBy) {
		this.preparedBy = preparedBy;
	}

	String excePath= "D:\\Workspace\\CPQ\\src\\CPQ_Test_Data";
	String excelsheet="SITCredentials";
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}
	
	
	
	public void FillLoginInfo() throws IOException 
	{
		getData();
		
		getUrl(url);
		
		sendKeys(ReadConfig.GetVal("login_Username_Xp"),userName);
		sendKeys( ReadConfig.GetVal("login_Password_Xp"),password);
		click( ReadConfig.GetVal("login_button_Xp"));
	}
	
	private void getData() throws IOException
	{
		ArrayList<String> list=ReadExcelFile.readExcelFileInfo("D:\\Workspace\\CPQ\\src\\TestData\\CPQ_Test_Data.xlsx","SITCredentials",uniqueID);
		this.uniqueID=list.get(0);
		this.userName=list.get(1);
		this.password=list.get(2);
		this.url=list.get(3);
		this.browser=list.get(4);
		this.preparedBy=list.get(5);
	}
	
	public boolean isPreparedByDisplayed_OnGeneralInfoPage() throws IOException{
		String changedXath = ReadConfig.GetVal("preparedByLable_XP").replace("ReplaceMe", preparedBy);		
		return visibilityElement(10,changedXath);		
	}
	
}
