package SpecificObjectActionES;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import CommonActions.CommonMethod;
import Resources.ReadConfig;
import Resources.ReadConfigES;

public class SubmitForApprovalES extends CommonMethod {
	LoginActionES lae=new LoginActionES();
	CommonErrorMsgES ceme=new CommonErrorMsgES();
	CommonActionsInAppES caie=new CommonActionsInAppES();
	NewCPQQuoteES ncqe=new NewCPQQuoteES();
	NewOpportunityCreationES noce=new NewOpportunityCreationES();
	String ApprovalName,Approval_1;
	public String getApprovalName() {
		return ApprovalName;
	}

	public void setApprovalName(String approvalName) {
		ApprovalName = approvalName;
	}

	public void clicksaveAndPriceES() throws IOException
	{
		if(visibilityElement(5, ReadConfigES.GetValES("SavePriceES_btn_Xp")))
		{
			click(ReadConfigES.GetValES("SavePriceES_btn_Xp"));
		}
		
	}
	
	public void preReqForApproval() throws IOException, InterruptedException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
	    //scrollIn(ReadConfigES.GetValES("offerInfoES_tab_Xp"));
		//pageUpButton();
		if(visibilityElement(5, ReadConfigES.GetValES("offerInfoES_tab_Xp")))
		{
			click(ReadConfigES.GetValES("offerInfoES_tab_Xp"));
		}
	    Thread.sleep(5000);
	    scrollIn(ReadConfigES.GetValES("offerInfoES_tab_Xp"));
	    if(visibilityElement(5, ReadConfigES.GetValES("officeInfoES_Movillistoparafacturación_drp_Xp"))){
		 click(ReadConfigES.GetValES("officeInfoES_Movillistoparafacturación_drp_Xp"));
	    }
	    selectDropDown(ReadConfigES.GetValES("officeInfoES_Movillistoparafacturación_drp_Xp"),"immediate");
		Thread.sleep(5000);
	    //pageUpButton();
		scrollIn(ReadConfigES.GetValES("datosGeneralesES_label_Xp"));
		if(visibilityElement(5, ReadConfigES.GetValES("multiCIFES_tab_Xp")))
		{
			click(ReadConfigES.GetValES("multiCIFES_tab_Xp"));
		}
		selectCheckbox(ReadConfigES.GetValES("multiCIFES_chk_Xp"));
		Thread.sleep(7000);
	}
	
	public void submitForApprovalES() throws InterruptedException, IOException
	{
		Thread.sleep(5000);
		frameswitchdefault();
		frameSwitch("edit_quote");
		pageUpButton();
		if(visibilityElement(5, ReadConfigES.GetValES("requestApprovalES_tab_Xp")))
		{
			click(ReadConfigES.GetValES("requestApprovalES_tab_Xp"));
		}
		sendKeys(ReadConfigES.GetValES("solicitaraprobacionES_Numbercontrato_txt_Xp"), "11");
		if(visibilityElement(5, ReadConfigES.GetValES("submitforApprovalES_btn_Xp")))
		click(ReadConfigES.GetValES("submitforApprovalES_btn_Xp"));
		sendKeys(ReadConfigES.GetValES("approval_txtcomment_XP"), "Please approve");
		if(visibilityElement(10,ReadConfigES.GetValES("approvalverifytxtES_Xp")))
		{
			//click on submit
			click(ReadConfigES.GetValES("approvalwindowSubmit_btn_Xp"));
		}
		else
		{
			//click on cancel
			click(ReadConfigES.GetValES("approvalwindowCancel_btn_Xp"));
		}
		Thread.sleep(9000);
	}
	
	public void checkLevelApproverES() throws InterruptedException, IOException
	{
		Thread.sleep(5000);
		frameswitchdefault();
		frameSwitch("edit_quote");
		click(ReadConfigES.GetValES("checkLevelApprover_btn_Xp"));
		switchchildWindow();
		Thread.sleep(2000);
		if(!lae.verifyCPQCloudPageInApproval()) {
			Thread.sleep(3000);
			switchParentWindow();
			caie.logoutES();
			lae.setUniqueID("ES_AM");
			lae.FillLoginInfoES();	//Login
			ncqe.readQuoteNumberFromConfig();
			ncqe.setSearchAccountManagerQuotetxt(ncqe.getAccountManagerQuoteNumberRecent());
			ncqe.searchAccountManagerQuoteES();
			//ncqe.clickOnQuoteLinkES();
			//noce.clickQuoteModificarOnMainPage();
			Thread.sleep(5000);
			frameswitchdefault();
			frameSwitch("edit_quote");
			pageUpButton();
			if(visibilityElement(5, ReadConfigES.GetValES("requestApprovalES_tab_Xp")))
			{
				click(ReadConfigES.GetValES("requestApprovalES_tab_Xp"));
			}
			Thread.sleep(5000);
			frameswitchdefault();
			frameSwitch("edit_quote");
			click(ReadConfigES.GetValES("checkLevelApprover_btn_Xp"));
			switchchildWindow();
		}
		Thread.sleep(4000);
		getApprovalsFromTable(ReadConfigES.GetValES("pendingApproverList_table_Xp"));
		Thread.sleep(5000);
		switchParentWindow();
	}
	
	public void getApprovalNameConfigFile() throws IOException{
		
		
		String acctNmRecent=ReadConfigES.GetAccountFromFileES("Approval_1");
		moveandclick(ReadConfig.GetVal("oppNameForGivenAccountInList_Xp").replace("ReplaceMe", acctNmRecent));
		System.out.println("OppName click from list");
	}

	
	public void verifyApprover() throws IOException
	{
		
		click(ReadConfigES.GetValES("ownerName_link_Xp").replace("ReplaceMe", ApprovalName));
		System.out.println("ApprovalName" +ApprovalName);
		String Approval1=ReadConfigES.GetAccountFromFileES(Approval_1);
		
		
			
				
		
	}

	public String getApproval_1() {
		return Approval_1;
	}

	public void setApproval_1(String approval_1) {
		Approval_1 = approval_1;
	}
}
