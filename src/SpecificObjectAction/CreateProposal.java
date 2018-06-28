package SpecificObjectAction;

import java.io.IOException;

import CommonActions.CommonMethod;
import Resources.ReadConfig;

public class CreateProposal extends CommonMethod {

	public void proposalVerify() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(visibilityElement(10, ReadConfig.GetVal("createProposal_tab_Xp"))){
			click(ReadConfig.GetVal("createProposal_tab_Xp"));
		}
		click(ReadConfig.GetVal("generateProposalRTF_btn_Xp"));
		
		//need to verify whether create proposal open or not
	}
	
	public boolean verifyproposalOpen() throws IOException
	{
		return visibilityElement(60, ReadConfig.GetVal("generateProposalRTF_btn_Xp"));
	}
}
