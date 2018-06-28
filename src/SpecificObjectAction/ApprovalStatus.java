package SpecificObjectAction;

import java.io.IOException;

import CommonActions.CommonMethod;
import Resources.ReadConfig;

public class ApprovalStatus extends CommonMethod {

	public void clickApprovalTab() throws IOException
	
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		click(ReadConfig.GetVal("approvalStatus_tab_Xp"));
		
	}
	
	public void clickApprovalTick() throws IOException, InterruptedException
	
	{
		Thread.sleep(5000);
		frameswitchdefault();
		frameSwitch("edit_quote");
		scrollIn(ReadConfig.GetVal("rejectionreason_label_Xp"));
		pageUpButton();
		if(visibilityElement(20,ReadConfig.GetVal("approvequote_tick_Xp")))
		{
			click(ReadConfig.GetVal("approvequote_tick_Xp"));
		}
		
		
	}
	
	public boolean verifyApprovalPendingImage() throws IOException{
		frameswitchdefault();
		frameSwitch("edit_quote");
		return visibilityElement(60,ReadConfig.GetVal("approvalstatus_Pending_Xp"));
				
	}
	
	public void setApprovalReason() throws IOException, InterruptedException
	{
		Thread.sleep(5000);
		frameswitchdefault();
		frameSwitch("edit_quote");
		//scrollIn(ReadConfig.GetVal("approvalreason_txt_Xp"));
		sendKeys(ReadConfig.GetVal("approvalreason_txt_Xp"),"Approved");
	}
	
	public boolean verifyApprovedImage() throws IOException, InterruptedException{
		frameswitchdefault();
		frameSwitch("edit_quote");
		Thread.sleep(10000);
		return visibilityElement(60,ReadConfig.GetVal("approvalstatus_Approved_Xp"));		
	}
	
	public boolean verifyApprovedOnQuote() throws IOException
	{
		return visibilityElement(60, ReadConfig.GetVal("approvedQuote_verify_Xp"));
	}
}
