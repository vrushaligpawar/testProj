package SpecificObjectActionES;

import java.io.IOException;

import CommonActions.CommonMethod;
import Resources.ReadConfigES;
import Resources.WriteConfigFile;
import Resources.WriteConfigFileES;

public class FinanceManager extends CommonMethod {

String SRNumber,searchFinanceSRNtxt,FinanceSRNumberRecent;
	
	
public String getSearchFinanceSRNtxt() {
	return searchFinanceSRNtxt;
}


public void setSearchFinanceSRNtxt(String searchFinanceSRNtxt) {
	this.searchFinanceSRNtxt = searchFinanceSRNtxt;
}


public String getFinanceSRNumberRecent() {
	return FinanceSRNumberRecent;
}


public void setFinanceSRNumberRecent(String financeSRNumberRecent) {
	FinanceSRNumberRecent = financeSRNumberRecent;
}


public String getSRNumber() {
	return SRNumber;
}


public void setSRNumber(String sRNumber) {
	SRNumber = sRNumber;
}



	public void enableFinanceCPQApprovalES() throws IOException, InterruptedException
	{
		click(ReadConfigES.GetValES("SM_editSRN_link_Xp").replace("ReplaceMe",FinanceSRNumberRecent));
		click(ReadConfigES.GetValES("SM_enableCPQApprovalES_btn_Xp"));
	}
	
	
	public void searchFinanceSRNES() throws IOException, InterruptedException
	{
		String sm_search_xpath = ReadConfigES.GetValES("SM_search_txt_Xp");
		if(visibilityElement(5, sm_search_xpath))
		{
		click(sm_search_xpath);
		}
		sendKeys(sm_search_xpath,FinanceSRNumberRecent);
		moveandclick(ReadConfigES.GetValES("SM_searchCM_btn_Xp"));
	}
	
	public void collectFinanceManagerSRNES() throws IOException
	{
		SRNumber=getElementText(ReadConfigES.GetValES("financeManagerSRnumberES_link_Xp"));
		System.out.println(SRNumber);
		WriteConfigFileES.setPropertyInFileES("FinanceManagerSRNumber", SRNumber);
	}
	
	
	public void readFinanceManagerSRNESFromConfig() throws IOException
	{
		FinanceSRNumberRecent=ReadConfigES.GetAccountFromFileES("FinanceManagerSRNumber");
		System.out.println(FinanceSRNumberRecent);
	}
	
	
}
