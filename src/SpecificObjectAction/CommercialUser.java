package SpecificObjectAction;

import java.io.IOException;

import Resources.ReadConfig;
import CommonActions.CommonMethod;
import CommonActions.LaunchDriver;


public class CommercialUser extends CommonMethod {
	String SRNumber;
	
	
	
	
	public void setSRNumber(String sRNumber) {
		SRNumber = sRNumber;
	}
	
	public void clickEditQuote() throws IOException
	{
		click(ReadConfig.GetVal("CM_edit_link_Xp"));
	}
}
