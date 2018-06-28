package SpecificObjectActionES;

import java.io.IOException;

import CommonActions.CommonMethod;
import Resources.ReadConfigES;
import Resources.WriteConfigFile;
import Resources.WriteConfigFileES;

public class SalesManager extends CommonMethod {

String SRNumber,searchSalesSRNtxt,SalesSRNumberRecent;
	
		
	public void setSRNumber(String sRNumber) {
		SRNumber = sRNumber;
		System.out.println("we are in SRNumber " + SRNumber);
	}
	
	public void setSalesSRNumber(String sRNumber) {
		SRNumber = sRNumber;
		System.out.println("we are in SRNumber " + SRNumber);
	}
	
	public String getSearchSalesSRNtxt() {
		return searchSalesSRNtxt;
	}

	public void setSearchSalesSRNtxt(String searchSalesSRNtxt) {
		this.searchSalesSRNtxt = searchSalesSRNtxt;
	}

	public String getSalesSRNumberRecent() {
		return SalesSRNumberRecent;
	}
	public void setSalesSRNumberRecent(String salesSRNumberRecent) {
		SalesSRNumberRecent = salesSRNumberRecent;
	}

	
	public void enableSalesCPQApprovalES() throws IOException, InterruptedException
	{
		click(ReadConfigES.GetValES("SM_editSRN_link_Xp").replace("ReplaceMe",SalesSRNumberRecent));
		click(ReadConfigES.GetValES("SM_enableCPQApprovalES_btn_Xp"));
	}
	
	
	
	public void searchSalesSRNES() throws IOException, InterruptedException
	{
		String sm_search_xpath = ReadConfigES.GetValES("SM_search_txt_Xp");
		if(visibilityElement(5, sm_search_xpath))
		{
		click(sm_search_xpath);
		}
		sendKeys(sm_search_xpath,SalesSRNumberRecent);
		moveandclick(ReadConfigES.GetValES("SM_searchCM_btn_Xp"));
	}
	
	public void collectSalesManagerSRNES() throws IOException
	{
		SRNumber=getElementText(ReadConfigES.GetValES("salesManagerSRnumberES_link_Xp"));
		System.out.println(SRNumber);
		WriteConfigFileES.setPropertyInFileES("SalesManagerSRNumber", SRNumber);
	}
	
	public void readSalesManagerSRNESFromConfig() throws IOException
	{
		SalesSRNumberRecent=ReadConfigES.GetAccountFromFileES("SalesManagerSRNumber");
		System.out.println(SalesSRNumberRecent);
	}

	
}
