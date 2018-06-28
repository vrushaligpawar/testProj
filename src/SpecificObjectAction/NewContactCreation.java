package SpecificObjectAction;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import CommonActions.CommonMethod;
import Resources.ReadConfig;
import Resources.ReadExcelFile;

public class NewContactCreation extends CommonMethod {

	String FirstName_Sal,FirstName,LastName,ContactPhone,Mobile,Gender,Email,ContactRole,lawfulBasic,legitimateReason,legitimateID,uniqueID;
	
	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	
	public void setFirstName_Sal(String firstName_Sal) {
		FirstName_Sal = firstName_Sal;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public void setContactPhone(String contactPhone) {
		ContactPhone = contactPhone;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public void NewContactCreationInfo() throws IOException, InterruptedException
	{
		getData();
		String ts=autoIncrement();
		Thread.sleep(10000);
		click( ReadConfig.GetVal("newContact_btn_Xp"));
		Thread.sleep(10000);selectDropDown(ReadConfig.GetVal("firstName_Sal_drp_Xp"),FirstName_Sal);
		sendKeys( ReadConfig.GetVal("firstName_txt_Xp"), FirstName);
		sendKeys( ReadConfig.GetVal("lastName_txt_Xp"), LastName);
		sendKeys( ReadConfig.GetVal("contactPhone_txt_Xp"), ContactPhone);
		sendKeys( ReadConfig.GetVal("mobile_txt_Xp"), Mobile);
		selectDropDown( ReadConfig.GetVal("gender_drp_Xp"),Gender);
		sendKeys( ReadConfig.GetVal("con_Email_txt_Xp"), ts+Email);
		selectDropDown(ReadConfig.GetVal("contactRole_drp_Xp"), ContactRole);
		if(visibilityElement(5, ReadConfig.GetVal("lawfulBasic_drp_Xp")))
		selectDropDown(ReadConfig.GetVal("lawfulBasic_drp_Xp"),lawfulBasic);
		selectDropDown(ReadConfig.GetVal("legitimateInterestReason_drp_Xp"),legitimateReason);
		sendKeys(ReadConfig.GetVal("legitimateInterestAssessmentID_drp_Xp"),ts);
		click(ReadConfig.GetVal("contact_Save_btn_Xp"));
	}
	
	private void getData() throws IOException
	{
		ArrayList<String> list=ReadExcelFile.readExcelFileInfo("D:\\Workspace\\CPQ\\src\\TestData\\CPQ_Test_Data.xlsx", "Contact_TestData", uniqueID);
		this.uniqueID=list.get(0);
		this.FirstName_Sal=list.get(1);
		this.FirstName=list.get(2);
		this.LastName=list.get(3);
		this.ContactPhone=list.get(4);
		this.Mobile=list.get(5);
		this.Gender=list.get(6);
		this.Email=list.get(7);
		this.ContactRole=list.get(8);
		this.lawfulBasic=list.get(9);
		this.legitimateReason=list.get(10);
	}
	
	public void clickContactsTab() throws IOException
	{
		click(ReadConfig.GetVal("contactsTab_Xp"));
	}
}
