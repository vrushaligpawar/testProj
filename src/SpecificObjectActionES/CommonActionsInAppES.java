package SpecificObjectActionES;

import java.io.IOException;

import CommonActions.CommonMethod;
import Resources.ReadConfig;
import Resources.ReadConfigES;

public class CommonActionsInAppES extends CommonMethod {
	
	String searchtxt,SalesSRNumberRecent,SRNumber;
	
	public String getSearchtxt() {
		return searchtxt;
	}
	public void setSearchtxt(String searchtxt) {
		this.searchtxt = searchtxt;
	}
	
	public void enableCPQApprovalES() throws IOException, InterruptedException
	{
		click(ReadConfigES.GetValES("SM_editSRN_link_Xp").replace("ReplaceMe",SalesSRNumberRecent));
		click(ReadConfigES.GetValES("SM_enableCPQApprovalES_btn_Xp"));
	}
	
	public void setSRNumber(String sRNumber) {
		SRNumber = sRNumber;
		System.out.println("we are in SRNumber " + SRNumber);
	}
	
	public static String readAccountNameFromConfig() throws IOException
	{
		return ReadConfigES.GetAccountFromFileES("AccountNameSpain");
	}
	
	public void logoutES() throws IOException, InterruptedException
	{
		Thread.sleep(4000);
		click(ReadConfigES.GetValES("AccountManagerES_logout_Xp"));
		Thread.sleep(10000);
		moveToElement(ReadConfigES.GetValES("logoutAMES_Xp"));
	}
	

	
}
