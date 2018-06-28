package TestCases_VGE_Dummy;

import java.io.IOException;

import org.openqa.selenium.By;

import CommonActions.CommonMethod;
import Resources.ReadConfigES;
import Resources.ReadExcelFile;

public class VGE extends CommonMethod
{
	public void clickAssign() throws IOException, InterruptedException
	{
		click(ReadConfigES.GetValES("assignVGE_Xp"));
	}
		 
}
