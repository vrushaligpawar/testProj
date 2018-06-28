package SpecificObjectAction;

import java.io.IOException;

import CommonActions.CommonMethod;
import Resources.ReadConfig;

public class QuoteSummary extends CommonMethod {

	
	public void quoteSummaryVerify() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		click(ReadConfig.GetVal("quoteSummary_btn_Xp"));
	}
	
	public boolean verifySummaryOpen() throws IOException
	{
		return visibilityElement(60, ReadConfig.GetVal("quoteSummary_btn_Xp"));
	}
}
