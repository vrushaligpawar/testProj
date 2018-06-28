package SpecificObjectActionES;

import java.io.IOException;

import CommonActions.CommonMethod;
import Resources.ReadConfig;
import Resources.ReadConfigES;

public class CommonErrorMsgES extends CommonMethod{

	public boolean checkErrorMessageES() throws IOException
	{
			return visibilityElement(5, ReadConfigES.GetValES("errorMessage_GI_XP"));
	}
	
	public static void checkElementES(String xPath, boolean expected, String message, int waitTimeInSeconds) throws IOException
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
	
	public boolean checkErrorMessageStageClosedWonES() throws IOException
	{
			return visibilityElement(5, ReadConfigES.GetValES("errorMessageStageClosedWon_XP"));
	}
}
