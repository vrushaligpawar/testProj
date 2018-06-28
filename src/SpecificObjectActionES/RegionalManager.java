package SpecificObjectActionES;

import java.io.IOException;

import CommonActions.CommonMethod;
import Resources.ReadConfigES;
import Resources.WriteConfigFile;
import Resources.WriteConfigFileES;

public class RegionalManager extends CommonMethod {

String SRNumber,searchRegionalSRNtxt,RegionalSRNumberRecent;
	
	
	public String getSRNumber() {
	return SRNumber;
}


public void setSRNumber(String sRNumber) {
	SRNumber = sRNumber;
}


public String getSearchRegionalSRNtxt() {
	return searchRegionalSRNtxt;
}


public void setSearchRegionalSRNtxt(String searchRegionalSRNtxt) {
	this.searchRegionalSRNtxt = searchRegionalSRNtxt;
}


public String getRegionalSRNumberRecent() {
	return RegionalSRNumberRecent;
}


public void setRegionalSRNumberRecent(String regionalSRNumberRecent) {
	RegionalSRNumberRecent = regionalSRNumberRecent;
}


	public void enableRegionalCPQApprovalES() throws IOException, InterruptedException
	{
		click(ReadConfigES.GetValES("SM_editSRN_link_Xp").replace("ReplaceMe",RegionalSRNumberRecent));
		click(ReadConfigES.GetValES("SM_enableCPQApprovalES_btn_Xp"));
	}
	
	
	public void searchRegionalSRNES() throws IOException, InterruptedException
	{
		String sm_search_xpath = ReadConfigES.GetValES("SM_search_txt_Xp");
		if(visibilityElement(5, sm_search_xpath))
		{
		click(sm_search_xpath);
		}
		sendKeys(sm_search_xpath,RegionalSRNumberRecent);
		moveandclick(ReadConfigES.GetValES("SM_searchCM_btn_Xp"));
	}
	

	public void collectRegionalDirectorSRNES() throws IOException
	{
		SRNumber=getElementText(ReadConfigES.GetValES("regionalDirectorSRnumberES_link_Xp"));
		System.out.println(SRNumber);
		WriteConfigFileES.setPropertyInFileES("RegionalManagerSRNumber", SRNumber);
	}
	
	
	public void readRegionalManagerSRNESFromConfig() throws IOException
	{
		RegionalSRNumberRecent=ReadConfigES.GetAccountFromFileES("RegionalManagerSRNumber");
		System.out.println(RegionalSRNumberRecent);
	}
	
}
