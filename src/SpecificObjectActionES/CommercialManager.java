package SpecificObjectActionES;

import java.io.IOException;

import CommonActions.CommonMethod;
import Resources.ReadConfigES;
import Resources.WriteConfigFile;
import Resources.WriteConfigFileES;

public class CommercialManager extends CommonMethod {

String SRNumber,searchCommercialSRNtxt,CommercialSRNumberRecent;
	
	
	public String getSearchCommercialSRNtxt() {
	return searchCommercialSRNtxt;
}


public void setSearchCommercialSRNtxt(String searchCommercialSRNtxt) {
	this.searchCommercialSRNtxt = searchCommercialSRNtxt;
}


public String getCommercialSRNumberRecent() {
	return CommercialSRNumberRecent;
}


public void setCommercialSRNumberRecent(String commercialSRNumberRecent) {
	CommercialSRNumberRecent = commercialSRNumberRecent;
}


	public String getSRNumber() {
	return SRNumber;
}


public void setSRNumber(String sRNumber) {
	SRNumber = sRNumber;
}



	public void enableCommercialCPQApprovalES() throws IOException, InterruptedException
	{
		click(ReadConfigES.GetValES("SM_editSRN_link_Xp").replace("ReplaceMe",CommercialSRNumberRecent));
		click(ReadConfigES.GetValES("SM_enableCPQApprovalES_btn_Xp"));
	}
	
	
	public void searchCommercialSRNES() throws IOException, InterruptedException
	{
		String sm_search_xpath = ReadConfigES.GetValES("SM_search_txt_Xp");
		if(visibilityElement(5, sm_search_xpath))
		{
		click(sm_search_xpath);
		}
		sendKeys(sm_search_xpath,CommercialSRNumberRecent);
		moveandclick(ReadConfigES.GetValES("SM_searchCM_btn_Xp"));
	}
	
	public void collectCommercialManagerSRNES() throws IOException
	{
		SRNumber=getElementText(ReadConfigES.GetValES("commercialManagerSRnumberES_link_Xp"));
		System.out.println(SRNumber);
		WriteConfigFileES.setPropertyInFileES("CommercialManagerSRNumber", SRNumber);
	}
	
	
	public void readCommercialManagerSRNESFromConfig() throws IOException
	{
		CommercialSRNumberRecent=ReadConfigES.GetAccountFromFileES("CommercialManagerSRNumber");
		System.out.println(CommercialSRNumberRecent);
	}
	
}
