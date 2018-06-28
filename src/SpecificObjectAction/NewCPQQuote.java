package SpecificObjectAction;
import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebElement;

import Resources.ReadConfig;
import Resources.ReadConfigES;
import Resources.ReadExcelFile;
import CommonActions.CommonMethod;
import CommonActions.LaunchDriver;

public class NewCPQQuote extends CommonMethod {
	CommonErrorMsg cem= new CommonErrorMsg();
	String browse,QuoteNumber;
	String uniqueID;
	
	
	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	public String getUniqueID() {
		return uniqueID;
	}
	public String getQuoteNumber() {
		return QuoteNumber;
	}
	public void setQuoteNumber(String quoteNumber) {
		QuoteNumber = quoteNumber;
	}

	public void clickNewCpqQuote() throws IOException, InterruptedException
	{
		if(visibilityElement(3000,ReadConfig.GetVal("newCPQ_btn_Xp")))
		{
			Thread.sleep(5000);
			click(ReadConfig.GetVal("newCPQ_btn_Xp"));
		}
		Thread.sleep(5000);
	}
	
	public void clickContinueCPQ() throws IOException, InterruptedException
	{
		if(visibilityElement(5, ReadConfig.GetVal("continue_btn_Xp")))
		{
		click(ReadConfig.GetVal("continue_btn_Xp"));
		}
		Thread.sleep(10000);
	}
	
	public void addCpqQuoteProduct() throws IOException, InterruptedException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(visibilityElement(9000,ReadConfig.GetVal("cpqAddProd_btn_Xp")))
		{
			Thread.sleep(2000);
			click(ReadConfig.GetVal("cpqAddProd_btn_Xp"));
		}
		Thread.sleep(5000);
	}
		
		
	
	public void updateSaveAddProduct() throws IOException, InterruptedException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(visibilityElement(15,ReadConfig.GetVal("update_btn_Xp")))
		{
			Thread.sleep(2000);
			click(ReadConfig.GetVal("update_btn_Xp"));
		}
		Thread.sleep(6000);
		click(ReadConfig.GetVal("saveChanges_btn_Xp"));
		System.out.println("savechanges successfully");
		if(visibilityElement(15, ReadConfig.GetVal("SavePrice_btn_Xp")))
		{
			click(ReadConfig.GetVal("SavePrice_btn_Xp"));
		}
		Thread.sleep(10000);
	}
	
	public void returnOpportunityPage() throws IOException
	{
		if(visibilityElement(15,ReadConfig.GetVal("returnToOpportunity-btn_Xp")))
		{
			click(ReadConfig.GetVal("returnToOpportunity-btn_Xp"));
		}
	}
	
	public void returnQuoteInfoTab() throws IOException
	{
		click(ReadConfig.GetVal("quoteInfo_tab_Xp"));
	}
	
	public void collectQuoteNumber() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		QuoteNumber=getElementText(ReadConfig.GetVal("quoteNumberLable_Xp"));
		System.out.println(QuoteNumber);
	}
	
	
	public void browsefile() throws IOException, InterruptedException, AWTException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		Thread.sleep(6000);
		if(visibilityElement(15, ReadConfig.GetVal("quotedescription_txt_Xp")))
		sendKeys(ReadConfig.GetVal("quotedescription_txt_Xp"), "aaa");
		if(visibilityElement(15,ReadConfig.GetVal("browse_btn_Xp"))){
			moveandclick(ReadConfig.GetVal("browse_btn_Xp"));
		}
		CommonMethod.uploadFile("D:\\Workspace\\TestFile\\csvBritishAirways.csv");
		if(visibilityElement(15, ReadConfig.GetVal("SavePrice_btn_Xp")))
		{
			click(ReadConfig.GetVal("SavePrice_btn_Xp"));
		}
		Thread.sleep(10000);
		if(!cem.checkUploadFile()){
			System.out.println("File not uploaded sucessfully");
		}
		Thread.sleep(5000);
	}
	
	public void reconfigureQuote() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		selectCheckbox(ReadConfig.GetVal("generalInfoProduct_chk_Xp"));
		if(visibilityElement(10, ReadConfig.GetVal("reconfigure_btn_Xp"))){
			click(ReadConfig.GetVal("reconfigure_btn_Xp"));
		}
	}
	
	public void saveUpdateReconfigureQuote() throws IOException, InterruptedException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(visibilityElement(15,ReadConfig.GetVal("update_btn_Xp")))
		{
			Thread.sleep(2000);
			click(ReadConfig.GetVal("update_btn_Xp"));
		}
		Thread.sleep(6000);
		if(visibilityElement(15, ReadConfig.GetVal("reconfigureSave_btn_Xp"))){
			click(ReadConfig.GetVal("reconfigureSave_btn_Xp"));
		}
	}
	
	
}


