package SpecificObjectActionES;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import CommonActions.CommonMethod;
import Resources.ReadConfigES;
import Resources.ReadExcelFile;

public class NewProductAddES extends CommonMethod {

	String Searchprod,ProductType,ProductQuantity,ProductTerm,oppInstallCharge,uniqueID;
	
	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	public void setSearchprod(String searchprod) {
		Searchprod = searchprod;
	}

	public void setProductType(String productType) {
		ProductType = productType;
	}

	public void setProductQuantity(String productQuantity) {
		ProductQuantity = productQuantity;
	}

	public void setProductTerm(String productTerm) {
		ProductTerm = productTerm;
	}

	public void setOppInstallCharge(String oppInstallCharge) {
		oppInstallCharge = oppInstallCharge;
	}

	public void productAddES() throws IOException, InterruptedException
	{
		getData();
		scrollIn(ReadConfigES.GetValES("addProduct_btn_Xp"));//to scroll in advance
		if(visibilityElement(9000, ReadConfigES.GetValES("addProduct_btn_Xp")))
		{
			Thread.sleep(1000);
			click(ReadConfigES.GetValES("addProduct_btn_Xp"));
		}
		Thread.sleep(5000);
		sendKeys(ReadConfigES.GetValES("keywordSearch_txt_Xp"), Searchprod);
		System.out.println("search box found");
		click(ReadConfigES.GetValES("addPro_search_btn_Xp"));
		Thread.sleep(9000);selectCheckbox(ReadConfigES.GetValES("addProduct_checkbox_Xp"));
		//CommonActions.CommonMethod.webTableIdentify("//*[@id='thePage:FormId:productTableBlock:productTable:j_id264:0:j_id265header:sortDiv']");   
		click(ReadConfigES.GetValES("addProductInside_btn_Xp"));
		Thread.sleep(5000);selectDropDown(ReadConfigES.GetValES("productType_drp_Xp"), ProductType);
		sendKeys(ReadConfigES.GetValES("productQuantity_txt_Xp"), ProductQuantity);
		sendKeys(ReadConfigES.GetValES("productTerm_txt_Xp"), ProductTerm);
		sendKeys(ReadConfigES.GetValES("oppInstallCharge_txt_Xp"), oppInstallCharge);
		
		Thread.sleep(2000);sendKeys(ReadConfigES.GetValES("keywordSearch_txt_Xp"), "get focus here");Thread.sleep(2000);//get out of Install Charge text box
		
		if(visibilityElement(9000, ReadConfigES.GetValES("productSave_btn_Xp")))
		{
			Thread.sleep(10000);
			click(ReadConfigES.GetValES("productSave_btn_Xp"));
			
		}
		
	}
	
	public void getData() throws IOException
	{
		ArrayList<String> list=ReadExcelFile.readExcelFileInfo("D:\\Workspace\\CPQ\\src\\TestData\\CPQ_Test_DataES.xlsx", "ProductAddES", uniqueID);
		this.uniqueID=list.get(0);
		this.Searchprod=list.get(1);
		this.ProductType=list.get(2);
		this.ProductQuantity=list.get(3);
		this.ProductTerm=list.get(4);
		this.oppInstallCharge=list.get(5);
	}
	
}
