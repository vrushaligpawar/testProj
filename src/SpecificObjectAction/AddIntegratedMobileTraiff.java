package SpecificObjectAction;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;

import CommonActions.CommonMethod;
import Resources.ReadConfig;
import Resources.ReadExcelFile;

public class AddIntegratedMobileTraiff extends CommonMethod {
 
	String uniqueID,SelectTariffPlan,MaximumCTNs,Numberofimplementationphases;
	public String getSelectTariffPlan() {
		return SelectTariffPlan;
	}

	public void setSelectTariffPlan(String selectTariffPlan) {
		SelectTariffPlan = selectTariffPlan;
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	CommonErrorMsg cem= new CommonErrorMsg();
	public void addIntegratedMobileTraiff() throws IOException, InterruptedException, AWTException
	{
		getData();
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(visibilityElement(5, ReadConfig.GetVal("integratedVoiceandDataMobile_link_Xp")));
		click(ReadConfig.GetVal("integratedVoiceandDataMobile_link_Xp"));
		Thread.sleep(3000);
		if(visibilityElement(5, ReadConfig.GetVal("integratedMobileTariff_link_Xp")));
		click(ReadConfig.GetVal("integratedMobileTariff_link_Xp"));
		Thread.sleep(9000);
		if(visibilityElement(5, ReadConfig.GetVal("businessAdvanceExtra_link_Xp")));
		Thread.sleep(2000);
		click(ReadConfig.GetVal("businessAdvanceExtra_link_Xp"));
		Thread.sleep(5000);
		if(visibilityElement(9000,ReadConfig.GetVal("selectTraiffPlan_drp_Xp")))
		{
			Thread.sleep(2000);
			selectDropDown(ReadConfig.GetVal("selectTraiffPlan_drp_Xp"), SelectTariffPlan);
			sendKeys(ReadConfig.GetVal("maximumCTN_txt_Xp"), MaximumCTNs);
			sendKeys(ReadConfig.GetVal("numberImplPhase_txt_Xp"), Numberofimplementationphases);
		}
		Thread.sleep(5000);
	}
	
	public void selectTraiffType() throws IOException, InterruptedException
	{
		Thread.sleep(3000);
		frameswitchdefault();
		frameSwitch("edit_quote");
		pageUpButton();
		visibilityElement(5, ReadConfig.GetVal("innovationFund_chk_Xp"));
		selectCheckbox(ReadConfig.GetVal("innovationFund_chk_Xp"));
		selectCheckbox(ReadConfig.GetVal("techFund_chk_Xp"));
		selectRadiobutton(ReadConfig.GetVal("applyTechfund_rd_Xp"));
		selectCheckbox(ReadConfig.GetVal("cashBonud_chk_Xp"));
		selectRadiobutton(ReadConfig.GetVal("applyCashbonus_rd_Xp"));
	}
	
	public void editOfferPriceIntegratedMobileTraiff() throws IOException, InterruptedException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		click(ReadConfig.GetVal("editOfferPrice_txt_Xp"));
		clear(ReadConfig.GetVal("editOfferPrice_txt_Xp"));
		sendKeys(ReadConfig.GetVal("editOfferPrice_txt_Xp"), "15");
		if(visibilityElement(15,ReadConfig.GetVal("update_btn_Xp")))
		{
			Thread.sleep(2000);
			click(ReadConfig.GetVal("update_btn_Xp"));
		}
		Thread.sleep(6000);
		if(cem.CheckErrorCommerical()){
			System.out.println("Commerical approval required message displayed");
		}else
		{
			System.out.println("Commerical approval required message not getting displayed");
		}
		
	}
	
	
	
	public void getData() throws IOException
	{
		ArrayList<String> list=ReadExcelFile.readExcelFileInfo("D:\\Workspace\\CPQ\\src\\TestData\\CPQ_Test_Data.xlsx", "TraiffPlan", uniqueID);
		this.uniqueID=list.get(0);
		this.SelectTariffPlan=list.get(1);
		this.MaximumCTNs=list.get(2);
		this.Numberofimplementationphases=list.get(3);
	}
	
	public boolean isTraiffPlanDisplayed_OnGeneralInfoPage() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		String traiffplan=ReadConfig.GetVal("traiffPlanVerify_table_Xp").replace("ReplaceMe", SelectTariffPlan);
		System.out.println(traiffplan);
		return visibilityElement(5, traiffplan);
	}
}
