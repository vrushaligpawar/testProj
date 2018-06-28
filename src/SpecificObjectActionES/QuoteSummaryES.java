package SpecificObjectActionES;

import java.io.IOException;

import CommonActions.CommonMethod;
import Resources.ReadConfig;

public class QuoteSummaryES extends CommonMethod {

	
	public void quoteSummaryVerifyES() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		click(ReadConfig.GetVal("quoteSummary_btn_Xp"));
	}
}
