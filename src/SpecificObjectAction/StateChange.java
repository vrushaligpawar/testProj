package SpecificObjectAction;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import CommonActions.CommonMethod;
import Resources.ReadConfig;
import Resources.ReadConfigES;
import Resources.ReadExcelFile;
public class StateChange extends CommonMethod{

	String stagepopup;
	String uniqueID;
	
	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	public void setStagepopup(String stagepopup) {
		this.stagepopup = stagepopup;
	}
	
	public void statechangeQ() throws IOException, InterruptedException
	{
		if(visibilityElement(10, ReadConfig.GetVal("stage_drp_label_Xp"))){
			scrollIn(ReadConfig.GetVal("stage_drp_label_Xp"));
		}
		Thread.sleep(3000);
		doubleClick(ReadConfig.GetVal("stage_mouseclick_Xp"));
		if(visibilityElement( 3000, ReadConfig.GetVal("stagepopup_drp_Xp")))
		{
			Thread.sleep(2000);
			click(ReadConfig.GetVal("stagepopup_drp_Xp"));
			getData();
			selectDropDown(ReadConfig.GetVal("stagepopup_drp_Xp"),stagepopup);
			Thread.sleep(2000);
			click(ReadConfig.GetVal("stagepopupOk_btn_Xp"));
			Thread.sleep(5000);
			scrollIn(ReadConfig.GetVal("stageSave_btn_Xp"));
			Thread.sleep(3000);
			click(ReadConfig.GetVal("stageSave_btn_Xp"));
			Thread.sleep(5000);
		}
	}
	
	public void getData() throws IOException
	{
		ArrayList<String> list=ReadExcelFile.readExcelFileInfo("D:\\Workspace\\CPQ\\src\\TestData\\CPQ_Test_Data.xlsx", "stagechange", uniqueID);
		this.uniqueID=list.get(0);
		this.stagepopup=list.get(1);
	}
	
	public void statechangeQES() throws IOException, InterruptedException
	{
		if(visibilityElement(10, ReadConfig.GetVal("stage_drp_label_Xp"))){
			scrollIn(ReadConfig.GetVal("stage_drp_label_Xp"));
		}
		Thread.sleep(3000);
		doubleClick(ReadConfig.GetVal("stage_mouseclick_Xp"));
		if(visibilityElement( 3000, ReadConfig.GetVal("stagepopup_drp_Xp")))
		{
			Thread.sleep(2000);
			click(ReadConfig.GetVal("stagepopup_drp_Xp"));
			getData();
			selectDropDown(ReadConfig.GetVal("stagepopup_drp_Xp"),stagepopup);
			Thread.sleep(2000);
			click(ReadConfigES.GetValES("stagepopupOkES_btn_Xp"));
			Thread.sleep(5000);
			scrollIn(ReadConfigES.GetValES("stageSaveES_btn_Xp"));
			Thread.sleep(3000);
			click(ReadConfigES.GetValES("stageSaveES_btn_Xp"));
		}
	}
}
