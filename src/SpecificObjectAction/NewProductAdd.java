package SpecificObjectAction;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import CommonActions.CommonMethod;
import Resources.ReadConfig;
import Resources.ReadExcelFile;

public class NewProductAdd extends CommonMethod {

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

	public void productAdd() throws IOException, InterruptedException
	{
		getData();
		//scrollIn(ReadConfig.GetVal("addProduct_btn_Xp"));//to scroll in advance
		if(visibilityElement(9000, ReadConfig.GetVal("addProduct_btn_Xp")))
		{
			Thread.sleep(1000);
			click(ReadConfig.GetVal("addProduct_btn_Xp"));
		}
		Thread.sleep(5000);
		sendKeys(ReadConfig.GetVal("keywordSearch_txt_Xp"), Searchprod);
		System.out.println("search box found");
		click(ReadConfig.GetVal("addPro_search_btn_Xp"));
		Thread.sleep(15000);selectCheckbox(ReadConfig.GetVal("addProduct_checkbox_Xp"));
		//CommonActions.CommonMethod.webTableIdentify("//*[@id='thePage:FormId:productTableBlock:productTable:j_id264:0:j_id265header:sortDiv']");   
		click(ReadConfig.GetVal("addProductInside_btn_Xp"));
		Thread.sleep(5000);selectDropDown(ReadConfig.GetVal("productType_drp_Xp"), ProductType);
		sendKeys(ReadConfig.GetVal("productQuantity_txt_Xp"), ProductQuantity);
		sendKeys(ReadConfig.GetVal("productTerm_txt_Xp"), ProductTerm);
		sendKeys(ReadConfig.GetVal("oppInstallCharge_txt_Xp"), oppInstallCharge);
		
		Thread.sleep(2000);sendKeys(ReadConfig.GetVal("keywordSearch_txt_Xp"), "get focus here");Thread.sleep(2000);//get out of Install Charge text box
		
		if(visibilityElement(9000, ReadConfig.GetVal("productSave_btn_Xp")))
		{
			Thread.sleep(10000);
			click(ReadConfig.GetVal("productSave_btn_Xp"));
			
		}
		
	}
	
	public void getData() throws IOException
	{
		ArrayList<String> list=ReadExcelFile.readExcelFileInfo("D:\\Workspace\\CPQ\\src\\TestData\\CPQ_Test_Data.xlsx", "ProductAdd", uniqueID);
		this.uniqueID=list.get(0);
		this.Searchprod=list.get(1);
		this.ProductType=list.get(2);
		this.ProductQuantity=list.get(3);
		this.ProductTerm=list.get(4);
		this.oppInstallCharge=list.get(5);
	}
	
}
