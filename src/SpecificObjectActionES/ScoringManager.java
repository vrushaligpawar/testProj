package SpecificObjectActionES;

import java.io.IOException;

import CommonActions.CommonMethod;
import Resources.ReadConfigES;
import Resources.WriteConfigFile;
import Resources.WriteConfigFileES;

public class ScoringManager extends CommonMethod {

	String SRNumber,searchScoringSRNtxt,ScoringSRNumberRecent;
	
	public String getSearchScoringSRNtxt() {
		return searchScoringSRNtxt;
	}

	public void setSearchScoringSRNtxt(String searchScoringSRNtxt) {
		this.searchScoringSRNtxt = searchScoringSRNtxt;
	}

	public String getScoringSRNumberRecent() {
		return ScoringSRNumberRecent;
	}

	public void setScoringSRNumberRecent(String scoringSRNumberRecent) {
		ScoringSRNumberRecent = scoringSRNumberRecent;
	}

	public String getSRNumber() {
		return SRNumber;
	}
	
	public void setSRNumber(String sRNumber) {
		SRNumber = sRNumber;
		System.out.println("we are in SRNumber " + SRNumber);
	}
	
	public void enableScoringCPQApprovalES() throws IOException, InterruptedException
	{
		
		click(ReadConfigES.GetValES("SM_editSRN_link_Xp").replace("ReplaceMe",ScoringSRNumberRecent));
		click(ReadConfigES.GetValES("SM_enableCPQApprovalES_btn_Xp"));
	}

	public void searchScoringSRNES() throws IOException, InterruptedException
	{
		String sm_search_xpath = ReadConfigES.GetValES("SM_search_txt_Xp");
		if(visibilityElement(5, sm_search_xpath))
		{
		click(sm_search_xpath);
		}
		sendKeys(sm_search_xpath,ScoringSRNumberRecent);
		moveandclick(ReadConfigES.GetValES("SM_searchCM_btn_Xp"));
	}
	
	public void collectScoringManagerSRNES() throws IOException
	{
		SRNumber=getElementText(ReadConfigES.GetValES("scoringManagerSRnumberES_link_Xp"));
		System.out.println(SRNumber);
		WriteConfigFileES.setPropertyInFileES("ScoringManagerSRNumber", SRNumber);
	}
	
	public void readScoringManagerSRNESFromConfig() throws IOException
	{
		ScoringSRNumberRecent=ReadConfigES.GetAccountFromFileES("ScoringManagerSRNumber");
		System.out.println(ScoringSRNumberRecent);
	}
	
	
	
	
	
	
	
	
}
