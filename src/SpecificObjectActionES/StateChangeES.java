package SpecificObjectActionES;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import CommonActions.CommonMethod;
import Resources.ReadConfigES;
import Resources.ReadExcelFile;
public class StateChangeES extends CommonMethod{

	String stagepopup;
	String uniqueID;
	
	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	public void setStagepopup(String stagepopup) {
		this.stagepopup = stagepopup;
	}
	
	
	public void getData() throws IOException
	{
		ArrayList<String> list=ReadExcelFile.readExcelFileInfo("D:\\Workspace\\CPQ\\src\\TestData\\CPQ_Test_DataES.xlsx", "stagechangeES", uniqueID);
		this.uniqueID=list.get(0);
		this.stagepopup=list.get(1);
	}
	
	public void statechangeQES() throws IOException, InterruptedException
	{
		if(visibilityElement(10, ReadConfigES.GetValES("stage_drp_label_Xp"))){
			scrollIn(ReadConfigES.GetValES("stage_drp_label_Xp"));
		}
		Thread.sleep(3000);
		doubleClick(ReadConfigES.GetValES("stage_mouseclick_Xp"));
		if(visibilityElement( 3000, ReadConfigES.GetValES("stagepopup_drp_Xp")))
		{
			Thread.sleep(2000);
			click(ReadConfigES.GetValES("stagepopup_drp_Xp"));
			getData();
			selectDropDown(ReadConfigES.GetValES("stagepopup_drp_Xp"),stagepopup);
			Thread.sleep(2000);
			click(ReadConfigES.GetValES("stagepopupOkES_btn_Xp"));
			Thread.sleep(5000);
			scrollIn(ReadConfigES.GetValES("stageSaveES_btn_Xp"));
			Thread.sleep(3000);
			click(ReadConfigES.GetValES("stageSaveES_btn_Xp"));
			Thread.sleep(3000);
		}
	}
	
	public void stateChangeClosedWon() throws InterruptedException, IOException
	{
		if(visibilityElement(10, ReadConfigES.GetValES("stage_drp_label_Xp")))
		{
			scrollIn(ReadConfigES.GetValES("stage_drp_label_Xp"));
		}
		Thread.sleep(3000);
		doubleClick(ReadConfigES.GetValES("stage_mouseclick_Xp"));
		if(visibilityElement( 3000, ReadConfigES.GetValES("stagepopup_drp_Xp")))
		{
			Thread.sleep(2000);
			click(ReadConfigES.GetValES("stagepopup_drp_Xp"));
			getData();
			selectDropDown(ReadConfigES.GetValES("stagepopup_drp_Xp"),stagepopup);
			Thread.sleep(2000);
			if(visibilityElement(5, ReadConfigES.GetValES("outcomereason_drp_Xp")))
			{
				click(ReadConfigES.GetValES("outcomereason_drp_Xp"));
				//moveandclick(ReadConfigES.GetValES("outcomereason_drp_Xp"));
				selectDropDown(ReadConfigES.GetValES("outcomereason_drp_Xp"), "Product Offering");
				Thread.sleep(2000);
			}
			click(ReadConfigES.GetValES("stagepopupOkES_btn_Xp"));
			Thread.sleep(5000);
			scrollIn(ReadConfigES.GetValES("stageSaveES_btn_Xp"));
			Thread.sleep(3000);
			click(ReadConfigES.GetValES("stageSaveES_btn_Xp"));
		}
	}
	

}
