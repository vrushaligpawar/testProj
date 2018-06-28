package SpecificObjectActionES;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import CommonActions.CommonMethod;
import Resources.ReadConfigES;
import Resources.ReadExcelFile;

public class NewContactCreationES extends CommonMethod {

	String FirstName_Sal,FirstName,LastName,ContactPhone,Mobile,Gender,Email,ContactRole,uniqueID;
	
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

	public void ContactCreationInfoES() throws IOException, InterruptedException
	{
		getData();
		String ts=autoIncrement();
		Thread.sleep(10000);
		click( ReadConfigES.GetValES("newContact_btn_Xp"));
		Thread.sleep(10000);selectDropDown(ReadConfigES.GetValES("firstName_Sal_drp_Xp"),FirstName_Sal);
		sendKeys( ReadConfigES.GetValES("firstName_txt_Xp"), FirstName);
		sendKeys( ReadConfigES.GetValES("lastName_txt_Xp"), LastName);
		sendKeys( ReadConfigES.GetValES("contactPhone_txt_Xp"), ContactPhone);
		sendKeys( ReadConfigES.GetValES("mobile_txt_Xp"), Mobile);
		selectDropDown( ReadConfigES.GetValES("gender_drp_Xp"),Gender);
		sendKeys( ReadConfigES.GetValES("con_Email_txt_Xp"), ts+Email);
		selectDropDown(ReadConfigES.GetValES("contactRole_drp_Xp"), ContactRole);
		click(ReadConfigES.GetValES("contact_Save_btn_Xp"));
	}
	
	private void getData() throws IOException
	{
		ArrayList<String> list=ReadExcelFile.readExcelFileInfo("D:\\Workspace\\CPQ\\src\\TestData\\CPQ_Test_DataES.xlsx", "ContactCreationES", uniqueID);
		this.uniqueID=list.get(0);
		this.FirstName_Sal=list.get(1);
		this.FirstName=list.get(2);
		this.LastName=list.get(3);
		this.ContactPhone=list.get(4);
		this.Mobile=list.get(5);
		this.Gender=list.get(6);
		this.Email=list.get(7);
		this.ContactRole=list.get(8);
	}
}
