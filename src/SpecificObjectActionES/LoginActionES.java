package SpecificObjectActionES;

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
import Resources.ReadConfigES;
import Resources.ReadExcelFile;
import SpecificObjectAction.CommonErrorMsg;


public class LoginActionES extends CommonMethod
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

	String excePath= "D:\\Workspace\\CPQ\\src\\TestData\\CPQ_Test_DataES.xlsx";
	String excelsheet="SITCredentialsES";
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}
	
	public void FillLoginInfoES() throws IOException, InterruptedException 
	{
		getData();
		getUrl(url);
		sendKeys(ReadConfigES.GetValES("login_Username_Xp"),userName);
		Thread.sleep(2000);
		sendKeys( ReadConfigES.GetValES("login_Password_Xp"),password);
		click( ReadConfigES.GetValES("login_button_Xp"));
		//CommonErrorMsg.checkElement("errorMessage_GI_XP", true, "Quote not created error occured",20);
	}
	
	private void getData() throws IOException
	{
		ArrayList<String> list=ReadExcelFile.readExcelFileInfo("D:\\Workspace\\CPQ\\src\\TestData\\CPQ_Test_DataES.xlsx","SITCredentialsES",uniqueID);
		this.uniqueID=list.get(0);
		this.userName=list.get(1);
		this.password=list.get(2);
		this.url=list.get(3);
		this.browser=list.get(4);
		this.preparedBy=list.get(5);
	}
	
	public boolean isPreparedByDisplayed_OnGeneralInfoPage() throws IOException{
		String changedXath = ReadConfigES.GetValES("preparedByLable_XP").replace("ReplaceMe", preparedBy);		
		return visibilityElement(10,changedXath);		
	}
	
	public void FillloginPoPWindowES() throws IOException 
	{
		getData();
		sendKeys(ReadConfigES.GetValES("login_Username_Xp"),userName);
		sendKeys( ReadConfigES.GetValES("login_Password_Xp"),password);
		click( ReadConfigES.GetValES("login_button_Xp"));
	}
	
	public boolean verifyLoginPopUpPage() throws IOException{
		
		return visibilityElement(5,ReadConfigES.GetValES("login_Username_Xp"));
				
	}
	
	public boolean verifyCPQCloudPageInApproval() throws IOException
	{
		return visibilityElement(5, ReadConfigES.GetValES("pendingApproverList_table_Xp"));
	}
}
