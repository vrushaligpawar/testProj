package SpecificObjectActionES;

import java.io.IOException;

import CommonActions.CommonMethod;
import Resources.ReadConfig;

public class CreateProposalES extends CommonMethod {

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
}
