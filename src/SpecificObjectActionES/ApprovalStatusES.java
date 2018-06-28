package SpecificObjectActionES;

import java.io.IOException;

import CommonActions.CommonMethod;
import Resources.ReadConfig;
import Resources.ReadConfigES;

public class ApprovalStatusES extends CommonMethod {

	public void clickApprovalTabES() throws IOException
	
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		click(ReadConfigES.GetValES("approvalStatusES_tab_Xp"));
		
	}
	
	public void clickApprovalTickES() throws IOException, InterruptedException
	
	{
		Thread.sleep(9000);
		frameswitchdefault();
		frameSwitch("edit_quote");
		scrollIn(ReadConfigES.GetValES("rejectionreasonES_label_Xp"));
		//pageUpButton();
		if(visibilityElement(30,ReadConfigES.GetValES("approvequoteES_tick_Xp")))
		{
			click(ReadConfigES.GetValES("approvequoteES_tick_Xp"));
		}
		
		Thread.sleep(1000);
	}
	
	public void clickConfirmApprovalES() throws IOException, InterruptedException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		//if(visibilityElement(10, ReadConfigES.GetValES("confirmApprovalES_chk_Xp")))
			Thread.sleep(9000);
			click(ReadConfigES.GetValES("confirmApprovalES_chk_Xp"));
		Thread.sleep(9000);
	}
	
	public boolean verifyApprovalPendingImageES() throws IOException{
		frameswitchdefault();
		frameSwitch("edit_quote");
		return visibilityElement(60,ReadConfigES.GetValES("approvalstatus_Pending_Xp"));
				
	}
	
	public void setApprovalReasonES() throws IOException, InterruptedException
	{
		Thread.sleep(5000);
		frameswitchdefault();
		frameSwitch("edit_quote");
		//scrollIn(ReadConfig.GetVal("approvalreason_txt_Xp"));
		sendKeys(ReadConfigES.GetValES("approvalreason_txt_Xp"),"Approved");
	}
	
	public boolean verifyApprovedImageES() throws IOException, InterruptedException{
		frameswitchdefault();
		frameSwitch("edit_quote");
		Thread.sleep(10000);
		return visibilityElement(60,ReadConfigES.GetValES("approvalstatus_Approved_Xp"));		
	}
	
	public boolean verifyApprovedOnQuoteES() throws IOException
	{
		return visibilityElement(60, ReadConfigES.GetValES("approvedQuote_verify_Xp"));
	}
}
