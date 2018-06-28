package SpecificObjectAction;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;

import CommonActions.CommonMethod;
import Resources.ReadConfig;
import Resources.ReadExcelFile;

public class PSAddIntegratedMobileTraiff extends CommonMethod{

	String uniqueID,SelectTariffPlanPS,MaximumCTNsPS,NumberofimplementationphasesPS;
	public String getSelectTariffPlanPS() {
		return SelectTariffPlanPS;
	}

	public void setSelectTariffPlanPS(String selectTariffPlanPS) {
		SelectTariffPlanPS = selectTariffPlanPS;
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	CommonErrorMsg cem= new CommonErrorMsg();
	public void addIntegratedMobileTraiffPS() throws IOException, InterruptedException, AWTException
	{
		getData();
		frameswitchdefault();
		frameSwitch("edit_quote");
		click(ReadConfig.GetVal("integratedVoiceandDataMobile_link_Xp"));
		Thread.sleep(3000);
		click(ReadConfig.GetVal("integratedMobileTariff_link_Xp"));
		Thread.sleep(5000);
		selectCheckbox(ReadConfig.GetVal("innovationFund_chk_Xp"));
		selectCheckbox(ReadConfig.GetVal("techFund_chk_Xp"));
		selectRadiobutton(ReadConfig.GetVal("applyTechfund_rd_Xp"));
		selectCheckbox(ReadConfig.GetVal("cashBonud_chk_Xp"));
		selectRadiobutton(ReadConfig.GetVal("applyCashbonus_rd_Xp"));
		click(ReadConfig.GetVal("traiffPlanNPF2_PS_Xp"));
		if(visibilityElement(9000,ReadConfig.GetVal("selectTraiffPlan_drp_Xp")))
		{
			Thread.sleep(2000);
			selectDropDown(ReadConfig.GetVal("selectTraiffPlan_drp_Xp"), SelectTariffPlanPS);
			sendKeys(ReadConfig.GetVal("maximumCTN_txt_Xp"), MaximumCTNsPS);
			sendKeys(ReadConfig.GetVal("numberImplPhase_txt_Xp"), NumberofimplementationphasesPS);
		}
		Thread.sleep(5000);
	}
	
	public void getData() throws IOException
	{
		ArrayList<String> list=ReadExcelFile.readExcelFileInfo("D:\\Workspace\\CPQ\\src\\TestData\\CPQ_Test_Data.xlsx", "TraiffPlanPS", uniqueID);
		this.uniqueID=list.get(0);
		this.SelectTariffPlanPS=list.get(1);
		this.MaximumCTNsPS=list.get(2);
		this.NumberofimplementationphasesPS=list.get(3);
	}
	
}
