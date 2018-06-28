package SpecificObjectAction;

import java.io.IOException;

import org.openqa.selenium.remote.server.handler.SwitchToFrame;

import Resources.ReadConfig;
import CommonActions.CommonMethod;
import Resources.ReadExcelFile;

public class SubmitForApproval extends CommonMethod  {

	
	public void selfApproval() throws IOException, InterruptedException
	{
		
		Thread.sleep(5000);
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(visibilityElement(5, ReadConfig.GetVal("requestApproval_tab_Xp")))
		click(ReadConfig.GetVal("requestApproval_tab_Xp"));
		click(ReadConfig.GetVal("submitforApproval_btn_Xp"));
		Thread.sleep(5000);
		sendKeys(ReadConfig.GetVal("approval_txtcomment_XP"), "Please approve");
		if(visibilityElement(10,ReadConfig.GetVal("approvalverifytxt_Xp")))
		{
			//click on submit
			click(ReadConfig.GetVal("approvalwindowSubmit_btn_Xp"));
		}
		else
		{
			//click on cancel
			click(ReadConfig.GetVal("approvalwindowCancel_btn_Xp"));
		}
		Thread.sleep(9000);
	}
	
	public void commericalApproval() throws InterruptedException, IOException
	{
		Thread.sleep(5000);
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(visibilityElement(5, ReadConfig.GetVal("requestApproval_tab_Xp")));
		click(ReadConfig.GetVal("requestApproval_tab_Xp"));
		click(ReadConfig.GetVal("submitforApproval_btn_Xp"));
		sendKeys(ReadConfig.GetVal("approval_txtcomment_XP"), "Please approve");
		if(visibilityElement(10,ReadConfig.GetVal("cmapprovalVerifytxt_Xp")))
		{
			//click on submit
			click(ReadConfig.GetVal("approvalwindowSubmit_btn_Xp"));
		}
		else
		{
			//click on cancel
			click(ReadConfig.GetVal("approvalwindowCancel_btn_Xp"));
		}
	}
	
	
	
}
