package SpecificObjectActionES;


import org.openqa.selenium.support.Color;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import CommonActions.CommonMethod;
import Resources.ReadConfigES;
import Resources.ReadExcelFile;

public class FixedProductFeasibilityES extends CommonMethod {

	String selectProduct,uniqueID,service,mainBandwidth,backupServic,backupBandwidth;
	
	public String getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	public void clickProductSolutionTabES() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(visibilityElement(5, ReadConfigES.GetValES("productosysolucionesES_tab_Xp")));
		{
			click(ReadConfigES.GetValES("productosysolucionesES_tab_Xp"));
		}
	}
	
	public void addFixedProductES() throws IOException, InterruptedException
	{
		getData();
		frameswitchdefault();
		frameSwitch("edit_quote");
		pageUpButton();
		click(ReadConfigES.GetValES("seleccionarproductoES_drp_Xp"));
		Thread.sleep(3000);
		selectDropDown(ReadConfigES.GetValES("seleccionarproductoES_drp_Xp"),selectProduct);
		Thread.sleep(5000);
		click(ReadConfigES.GetValES("servicioES_drp_Xp"));
		selectDropDown(ReadConfigES.GetValES("servicioES_drp_Xp"), service);
		pageUpButton();
		//scrollIn(ReadConfigES.GetValES("AnchodebandaprincipalES_drp_Xp"));
		if(visibilityElement(10, ReadConfigES.GetValES("AnchodebandaprincipalES_drp_Xp")));
		click(ReadConfigES.GetValES("AnchodebandaprincipalES_drp_Xp"));
		selectDropDown(ReadConfigES.GetValES("AnchodebandaprincipalES_drp_Xp"), mainBandwidth);
		Thread.sleep(2000);
		if(visibilityElement(10, ReadConfigES.GetValES("serviciodeBackupES_drp_Xp")));
		click(ReadConfigES.GetValES("serviciodeBackupES_drp_Xp"));
		selectDropDown(ReadConfigES.GetValES("serviciodeBackupES_drp_Xp"), backupServic);
		Thread.sleep(2000);
		if(visibilityElement(10, ReadConfigES.GetValES("CaudaldeBackupES_drp_Xp")));
		click(ReadConfigES.GetValES("CaudaldeBackupES_drp_Xp"));
		selectDropDown(ReadConfigES.GetValES("CaudaldeBackupES_drp_Xp"), backupBandwidth);
	}
	
	public void getData() throws IOException
	{
		ArrayList<String> list=ReadExcelFile.readExcelFileInfo("D:\\Workspace\\CPQ\\src\\TestData\\CPQ_Test_DataES.xlsx","FixedProductADD", uniqueID);
		this.uniqueID=list.get(0);
		this.selectProduct=list.get(1);
		this.service=list.get(2);
		this.mainBandwidth=list.get(3);
		this.backupServic=list.get(4);
		this.backupBandwidth=list.get(5);
		
	}
	public boolean clickcargarSedesES() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(visibilityElement(10, ReadConfigES.GetValES("cargarsedesES_btn_Xp"))){
			
			click(ReadConfigES.GetValES("cargarsedesES_btn_Xp"));
		}
		return (visibilityElement(10, ReadConfigES.GetValES("cargarsedesES_btn_Xp")));
	}
	
	public void selectSiteES() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		selectCheckbox(ReadConfigES.GetValES("autoCustomerSiteES_chk_Xp"));
		click(ReadConfigES.GetValES("solicitarsedesparaviabilidadES_btn_Xp"));
	}
	
	public void selectCFTPetitionES() throws IOException, InterruptedException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		scrollIn(ReadConfigES.GetValES("solicitudCFTLegacy_txt_Xp"));
		if(visibilityElement(5, ReadConfigES.GetValES("firstcheckboxCFTtableES_chk_Xp")))
		selectCheckbox(ReadConfigES.GetValES("firstcheckboxCFTtableES_chk_Xp"));
		Thread.sleep(3000);
		selectCheckbox(ReadConfigES.GetValES("secondcheckboxCFTtableES_chk_Xp"));
		click(ReadConfigES.GetValES("ejecutarviabilidadES_btn_Xp"));
	}
	

	
	public void uncheckLegacyAndIPVPNES() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		selectCheckbox(ReadConfigES.GetValES("legacyProduct_chk_Xp"));
		selectCheckbox(ReadConfigES.GetValES("IPVPN_chk_Xp"));
	}
	
	public void waitAndClickFeasiblityRefreshES() throws IOException, InterruptedException
	{
		if(visibilityElement(5, ReadConfigES.GetValES("refreshQuoteMessageES_txt_Xp")))
		{
			Thread.sleep(180000);
		}
		click(ReadConfigES.GetValES("refreshQuoteES_link_Xp"));
	}
	
	
	
	public void verifyTable() throws IOException, InterruptedException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(CommonActions.CommonMethod.verifyValuesFromTable(ReadConfigES.GetValES("tableCFTES_Xp"), "Feasibility Requested", 4)){
			System.out.println("Feasibility Requested status displayed in table");
		}else
		{
			System.out.println("Feasibility Requested status not displayed in table");
			Thread.sleep(5000);
			selectCFTPetitionES();
			Thread.sleep(9000);
			click(ReadConfigES.GetValES("refreshQuoteES_link_Xp"));
		}
	}
	
	/*public void verifyAccess1ExistInTable() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(CommonActions.CommonMethod.verifyValuesFromTable(ReadConfigES.GetValES("accessExist_table_Xp"), "iacceso xDSL+ 12M/1M", 2)){
			System.out.println("Access1 attribute displayed in table");
		}else
		{
			System.out.println("Access1 attribute not getting displayed in table");
		}
	}
	
	public void verifyAccess2ExistInTable() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(CommonActions.CommonMethod.verifyValuesFromTable(ReadConfigES.GetValES("accessExist_table_Xp"), "Tarifa 4G Datos 60G AMDOCS", 2)){
			System.out.println("Access2 attribute displayed in table");
		}else
		{
			System.out.println("Access2 attribute not getting displayed in table");
		}
	}
	
	public void verifyAddressingExistInTable() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(CommonActions.CommonMethod.verifyValuesFromTable(ReadConfigES.GetValES("accessExist_table_Xp"), "iopciones IP 1 dirección", 1)){
			System.out.println("Addressing attribute displayed in table");
		}else
		{
			System.out.println("Addressing attribute not getting displayed in table");
		}
	}
	
	public void verifyCPE1ExistInTable() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(CommonActions.CommonMethod.verifyValuesFromTable(ReadConfigES.GetValES("accessExist_table_Xp"), "ihw router CISCO 887 (HR-887VA-K9-a)", 1)){
			System.out.println("CPE1 attribute displayed in table");
		}else
		{
			System.out.println("CPE1 attribute not getting displayed in table");
		}
	}
	
	public void verifyCPE2ExistInTable() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(CommonActions.CommonMethod.verifyValuesFromTable(ReadConfigES.GetValES("accessExist_table_Xp"), "ihw router Huawei AR129C (alquiler)", 1)){
			System.out.println("CPE2 attribute displayed in table");
		}else
		{
			System.out.println("CPE2 attribute not getting displayed in table");
		}
	}*/
	
	public boolean verifyAccess1ExistTable() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		return CommonActions.CommonMethod.verifyValuesFromAccessExistTable(ReadConfigES.GetValES("accessExist_table_Xp"),1, "iacceso xDSL+ 12M/1M", 1, "€100,00000", 4, "€30,00000", 5, "€0,00000", 6);
			//System.out.println("Access1 product details present in table ");
	}
	
	public boolean verifyAccess2ExistTable() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		return CommonActions.CommonMethod.verifyValuesFromAccessExistTable(ReadConfigES.GetValES("accessExist_table_Xp"),2 ,"Tarifa 4G Datos 60G AMDOCS", 1, "€0,00000", 4, "€10,00000", 5, "€0,00000", 6);
			
	}
	
	public boolean verifyAddressingExistTable() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		return CommonActions.CommonMethod.verifyValuesFromAccessExistTable(ReadConfigES.GetValES("accessExist_table_Xp"),3, "iopciones IP 1 dirección", 1, "€0,00000", 4, "€12,00000", 5, "€0,00000", 6);
			//System.out.println("Addressing product details present in table ");
		//}
	}
	
	public boolean verifyCPE1ExistTable() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		return CommonActions.CommonMethod.verifyValuesFromAccessExistTable(ReadConfigES.GetValES("accessExist_table_Xp"),4, "ihw router CISCO 887 (HR-887VA-K9-a)", 1, "€150,00000", 4, "€42,80839", 5, "€0,00000", 6);
			//System.out.println("CPE1 product details present in table ");
		//}
	}
	
	public boolean verifyCPE2ExistTable() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		return CommonActions.CommonMethod.verifyValuesFromAccessExistTable(ReadConfigES.GetValES("accessExist_table_Xp"),5, "ihw router Huawei AR129C (alquiler)", 1, "€150,00000", 4, "€14,06458", 5, "€0,00000", 6);
			//System.out.println("CPE2 product details present in table ");
		//}
	}
	
	public void selectSLAFromDropDown() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		selectDropDown(ReadConfigES.GetValES("sLA_drp_Xp"), "Medium");
	}
	
	public void clickActualizar() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(visibilityElement(5, ReadConfigES.GetValES("actualizar_btn_Xp"))){
			click(ReadConfigES.GetValES("actualizar_btn_Xp"));
		}
	}
	public void clickAgregarPresupuesto() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(visibilityElement(5, ReadConfigES.GetValES("agregarPresupuesto_btn_Xp"))){
			click(ReadConfigES.GetValES("agregarPresupuesto_btn_Xp"));
		}
	}
	
	/*public void verifyAccess1ExistINProductTable() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(CommonActions.CommonMethod.verifyValuesFromAccessExistTable(ReadConfigES.GetValES("accessExist_table_Xp"), "iacceso xDSL+ 12M/1M", 16, "€100,00000", 4, "€30,00000", 5, "€0,00000", 6)){
			System.out.println("Access1 product details present in table ");
		}
	}
	public void verifyAccess2ExistINProductTable() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(CommonActions.CommonMethod.verifyValuesFromAccessExistTable(ReadConfigES.GetValES("accessExist_table_Xp"), "Tarifa 4G Datos 60G AMDOCS", 1, "€0,00000", 4, "€10,00000", 5, "€0,00000", 6)){
			System.out.println("Access2 product details present in table ");
		}
	}*/
	/*public String convertRGBTOHEX() throws IOException
	{
		//you can also try converting rgb into hex and verify...

		// Color RGB  
		String color;
		String xpathExpression=ReadConfigES.GetValES("bRAGType_column_Xp");
		 color = getWebElement(xpathExpression).getCssValue("color").trim();    
		 System.out.println("RGB_Color: " + color);  

		 //  RGB to HEX   
		 String color_hex[];  
		 color_hex = color.replace("rgba(", "").split(",");       
		 String actual_hex = String.format("#%02x%02x%02x", Integer.parseInt(color_hex[0].trim()), Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));  

		// further can verify with Actual hex value with Expected hex value  
		Assert.assertEquals("actual_hex should equal to: ", "#808080", actual_hex);
		return actual_hex;
	}*/
	
	/*public int verifyFeasibilityResponseFromTable(String expectedCellText, String expectedColor) throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		String xpathExpressionForTable = ReadConfigES.GetValES("feasibilityResponseVerify_table_Xp");
		String xpathExpressionForTable_tbody = ReadConfigES.GetValES("feasibilityResponseVerify_table_Xp_tbody");
		
		for (int i=0;i<10;i++)
			
		{
		//	System.out.println("col_16 "+ .findElement(By.xpath("//td[25]")).getText());
			
		}
		
		
		WebElement Table=getWebElement(xpathExpressionForTable);
		List<WebElement> rows_table=Table.findElements(By.tagName("tr"));
		System.out.println(rows_table.size());
		int row_count=rows_table.size();
		int rows_checkMarked = 0;
		for(int row=0;row<row_count;row++)
		{
			WebElement column_AnalysisType = rows_table.get(row).findElement(By.xpath(ReadConfigES.GetValES("analysisType_column_Xp")));
			String actualCellText=column_AnalysisType.getText();
			if(actualCellText.equals(expectedCellText))
			{ 
				System.out.println("col_16 "+ rows_table.get(row).findElement(By.xpath("//td[25]")).getText());
				System.out.println("col_17 "+ rows_table.get(row).findElement(By.xpath("//td[17]")).getText());
				System.out.println("col_17 "+ rows_table.get(row).findElement(By.xpath("//td[@class='primaryAccess']")).getText());
				System.out.println("col_18 "+ rows_table.get(row).findElement(By.xpath("//td[18]")).getText());
				System.out.println("col_18 "+ rows_table.get(2).findElement(By.xpath("//td[@class='primaryRAG']")).getText());
				String column_18 = rows_table.get(row).findElement(By.xpath("//td[18]")).getText();
				String color_hex[];
				//String column_RGBType = rows_table.get(row).findElement(By.xpath(ReadConfigES.GetValES("bRAGType_column_Xp"))).getCssValue("background-color");
				//System.out.println(column_RGBType);
				//color_hex=column_RGBType.replace("rgba(", "").split(",");
				//String actual_hex = String.format("#%02x%02x%02x", Integer.parseInt(color_hex[0].trim()), Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));  
				//String hex = Color.fromString(column_RGBType).asHex();
				System.out.println(column_18);
				//String actualColor=actual_hex;
				if(column_18.equals(expectedColor))
				{
					WebElement column_Select = rows_table.get(row).findElement(By.xpath("//td[0]/input"));
					moveandclickOnWebElement(column_Select);
					rows_checkMarked++;
				}
				else
				{
					System.out.println("cell color in row: " + row + " Expected color: " + expectedColor +" NOT FOUND. Actual is color "+ column_18);
				}
				
			}
			else
			{
					System.out.println("TableValues in row: " + row + " Expected: " + expectedCellText +" NOT FOUND. Actual is "+ actualCellText);  
				
			}
		}
		return rows_checkMarked;
		
	}
	*/
	public void clickConfigurarSites() throws IOException, InterruptedException
	{
		//frameswitchdefault();
		//frameSwitch("edit_quote");
		scrollIn(ReadConfigES.GetValES("FiltroRespuestafactibilidad_txt_Xp"));
		click(ReadConfigES.GetValES("configurarSedes_btn_Xp"));
		Thread.sleep(5000);
		if(visibilityElement(10, ReadConfigES.GetValES("configurarSedes_btn_Xp")))
			
		{
			moveandclick(ReadConfigES.GetValES("configurarSedes_btn_Xp"));
			
			Thread.sleep(9000);
		}
	}
}
