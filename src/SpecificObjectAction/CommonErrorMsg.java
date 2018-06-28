package SpecificObjectAction;

import java.io.IOException;

import CommonActions.CommonMethod;
import Resources.ReadConfig;

public class CommonErrorMsg extends CommonMethod{

	public boolean checkErrorMessage() throws IOException
	{
			return visibilityElement(5, ReadConfig.GetVal("errorMessage_GI_XP"));
	}
	
	public static void checkElement(String xPath, boolean expected, String message, int waitTimeInSeconds) throws IOException
	{
			
			boolean actual= visibilityElement(waitTimeInSeconds, ReadConfig.GetVal(xPath));
			org.testng.Assert.assertEquals(actual, expected, message);
	}
	
	public boolean CheckErrorCommerical() throws IOException
	{
		return visibilityElement(5, ReadConfig.GetVal("errorMessage_CommericalApproval_Xp"));
	}
	
	public boolean checkUploadFile() throws IOException
	{
		return visibilityElement(5, ReadConfig.GetVal("remove_lable_Xp"));
	}
}
