package SpecificObjectAction;

import java.io.IOException;
import java.util.ArrayList;

import CommonActions.CommonMethod;
import Resources.ReadConfig;
import Resources.ReadExcelFile;

public class ContractManagerUser extends CommonMethod {
	String uniqueID,dataEntryPSN;
	public String getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	public boolean GenerateContractPDF() throws IOException{
		//click(ReadConfig.GetVal("CTM_edit_link_Xp"));
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(visibilityElement(10, ReadConfig.GetVal("CTM_GenerateContractPDF_btn_Xp"))){
			click(ReadConfig.GetVal("CTM_GenerateContractPDF_btn_Xp"));
		}
		return visibilityElement(2, ReadConfig.GetVal("CTM_GenerateContractPDF_btn_Xp"));
	}
	
	public boolean GenerateContractRTF() throws IOException
	{
		//click(ReadConfig.GetVal("CTM_edit_link_Xp"));
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(visibilityElement(10, ReadConfig.GetVal("CTM_GenerateContractRTF_btn_Xp"))){
			click(ReadConfig.GetVal("CTM_GenerateContractRTF_btn_Xp"));
		}
		return visibilityElement(2, ReadConfig.GetVal("CTM_GenerateContractRTF_btn_Xp"));
	}
	

	public void dataEntryPSNContract() throws IOException, InterruptedException
	{
		Thread.sleep(5000);
		getData();
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(visibilityElement(5, ReadConfig.GetVal("requestApproval_tab_Xp")))
		click(ReadConfig.GetVal("requestApproval_tab_Xp"));
		if(visibilityElement(5, ReadConfig.GetVal("dataEntry_PublicSector_txt_Xp"))){
			sendKeys(ReadConfig.GetVal("dataEntry_PublicSector_txt_Xp"), dataEntryPSN);
		}
			
	}
	
	public void getData() throws IOException
	{
		
		ArrayList<String> list=ReadExcelFile.readExcelFileInfo("D:\\Workspace\\CPQ\\src\\TestData\\CPQ_Test_Data.xlsx", "PSNDataEntry", uniqueID);
	    this.uniqueID=list.get(0);
	    this.dataEntryPSN=list.get(1);
	}
}
