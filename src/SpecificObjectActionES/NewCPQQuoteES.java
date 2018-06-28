package SpecificObjectActionES;

import java.io.IOException;
import java.util.ArrayList;

import CommonActions.CommonMethod;
import Resources.ReadConfig;
import Resources.ReadConfigES;
import Resources.ReadExcelFile;
import Resources.WriteConfigFile;
import Resources.WriteConfigFileES;

public class NewCPQQuoteES extends CommonMethod {

	String ProductType,Family,ProductName,Quantity,QuoteNumber,AccountManagerQuoteNumberRecent,searchAccountManagerQuotetxt;
	
	
	public String getSearchAccountManagerQuotetxt() {
		return searchAccountManagerQuotetxt;
	}

	public void setSearchAccountManagerQuotetxt(String searchAccountManagerQuotetxt) {
		this.searchAccountManagerQuotetxt = searchAccountManagerQuotetxt;
	}

	public String getAccountManagerQuoteNumberRecent() {
		return AccountManagerQuoteNumberRecent;
	}

	public void setAccountManagerQuoteNumberRecent(
			String accountManagerQuoteNumberRecent) {
		AccountManagerQuoteNumberRecent = accountManagerQuoteNumberRecent;
	}

	public String getQuoteNumber() {
		return QuoteNumber;
	}

	public void setQuoteNumber(String quoteNumber) {
		QuoteNumber = quoteNumber;
	}

	public void clickNewCPQ() throws IOException, InterruptedException
	{
		if(visibilityElement(3000,ReadConfigES.GetValES("newCPQ_btn_Xp")))
		{
			Thread.sleep(2000);
			click(ReadConfigES.GetValES("newCPQ_btn_Xp"));
		}
	}
	
	public void clickContinueCPQ() throws IOException, InterruptedException
	{
		if(visibilityElement(5, ReadConfigES.GetValES("continue_btn_Xp")))
		{
		click(ReadConfigES.GetValES("continue_btn_Xp"));
		}
		Thread.sleep(5000);
	}
	
	public void addCpqQuoteProductES() throws IOException, InterruptedException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(visibilityElement(5,ReadConfigES.GetValES("cpqAddProdES_btn_Xp")))
		{
			Thread.sleep(2000);
			click(ReadConfigES.GetValES("cpqAddProdES_btn_Xp"));
		}
		Thread.sleep(5000);
	}
	
	
	public void navigateToOfficeAppES() throws IOException, InterruptedException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		click(ReadConfigES.GetValES("applicationCloud_tab_Xp"));
		Thread.sleep(5000);
		click(ReadConfigES.GetValES("EnterpriseApplication_link_Xp"));
		Thread.sleep(5000);
		click(ReadConfigES.GetValES("officeApplication_link_Xp"));
	}
	
	
	
	
	
	public void updateSaveAddProductES() throws IOException, InterruptedException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(visibilityElement(15,ReadConfigES.GetValES("updateES_btn_Xp")))
		{
			Thread.sleep(2000);
			click(ReadConfigES.GetValES("updateES_btn_Xp"));
		}
		Thread.sleep(9000);
		click(ReadConfigES.GetValES("saveChangesES_btn_Xp"));
		System.out.println("savechanges successfully");
		if(visibilityElement(15, ReadConfigES.GetValES("SavePriceES_btn_Xp")))
		{
			click(ReadConfigES.GetValES("SavePriceES_btn_Xp"));
		}
	}
	
	public void clickSaveAndPriceES() throws IOException, InterruptedException
	{
		if(visibilityElement(15, ReadConfigES.GetValES("SavePriceES_btn_Xp")))
		{
			click(ReadConfigES.GetValES("SavePriceES_btn_Xp"));
		}
		Thread.sleep(9000);
	}
	
	
	public void reconfigureQuoteES() throws IOException, InterruptedException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		selectCheckbox(ReadConfigES.GetValES("generalInfoProduct_chk_Xp"));
		Thread.sleep(5000);
		moveandclick(ReadConfigES.GetValES("reconfigure_btn_Xp"));
		Thread.sleep(3000);
		if(visibilityElement(5, ReadConfigES.GetValES("reconfigure_btn_Xp")))
			{
				moveandclick(ReadConfigES.GetValES("reconfigure_btn_Xp"));
				Thread.sleep(9000);
				//click(ReadConfigES.GetValES("reconfigure_btn_Xp"));
			}
	}
	
	public void selectProductFromGeneralInfo() throws IOException, InterruptedException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		selectCheckbox(ReadConfigES.GetValES("generalInfoProduct_chk_Xp"));
		Thread.sleep(5000);
	}
	
	public void saveUpdateReconfigureQuoteES() throws IOException, InterruptedException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(visibilityElement(15,ReadConfigES.GetValES("updateES_btn_Xp")))
		{
			Thread.sleep(2000);
			click(ReadConfigES.GetValES("updateES_btn_Xp"));
		}
		Thread.sleep(6000);
		if(visibilityElement(15, ReadConfigES.GetValES("reconfigureSave_btn_Xp"))){
			click(ReadConfigES.GetValES("reconfigureSave_btn_Xp"));
		}
	}
	
	public void collectQuoteNumberES() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		QuoteNumber=getElementText(ReadConfigES.GetValES("quoteNumberLable_Xp"));
		System.out.println(QuoteNumber);
		WriteConfigFileES.setPropertyInFileES("AccountManagerQuoteNumber", QuoteNumber);
	}
	
	public void readQuoteNumberFromConfig() throws IOException
	{
		AccountManagerQuoteNumberRecent=ReadConfigES.GetAccountFromFileES("AccountManagerQuoteNumber");
		System.out.println(AccountManagerQuoteNumberRecent);
	}
	
	public void searchAccountManagerQuoteES() throws IOException, InterruptedException
	{
		String sm_search_xpath = ReadConfigES.GetValES("SM_search_txt_Xp");
		if(visibilityElement(5, sm_search_xpath))
		{
		click(sm_search_xpath);
		}
		sendKeys(sm_search_xpath,AccountManagerQuoteNumberRecent);
		moveandclick(ReadConfigES.GetValES("SM_searchCM_btn_Xp"));
	}
	
	public void clickOnQuoteLinkES() throws IOException, InterruptedException
	{
		click(ReadConfigES.GetValES("SM_editSRN_link_Xp").replace("ReplaceMe",AccountManagerQuoteNumberRecent));
	}
	
	public void clickOnCloneCPQQuote() throws IOException, InterruptedException
	{
		click(ReadConfigES.GetValES("cloneCPQ_btn_Xp"));
		Thread.sleep(10000);
	}
	
	public void selectQuoteStatusAndClone() throws IOException, InterruptedException
	{
		if(visibilityElement(5, ReadConfigES.GetValES("quoteSelection_drp_Xp")))
		{
			click(ReadConfigES.GetValES("quoteSelection_drp_Xp"));
			selectDropDown(ReadConfigES.GetValES("quoteSelection_drp_Xp"), "00B9E000001Kqo0");
			if(visibilityElement(2, ReadConfigES.GetValES("selectQuoteToClone_chk_Xp")))
			selectCheckbox(ReadConfigES.GetValES("selectQuoteToClone_chk_Xp"));
			Thread.sleep(3000);
			click(ReadConfigES.GetValES("clickClone_btn_Xp"));
			Thread.sleep(10000);
		}
	}
}
