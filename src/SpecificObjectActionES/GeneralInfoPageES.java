package SpecificObjectActionES;

import java.io.IOException;

import CommonActions.CommonMethod;
import Resources.ReadConfigES;
import Resources.WriteConfigFileES;

public class GeneralInfoPageES extends CommonMethod {

	CommonErrorMsgES ceme=new CommonErrorMsgES();
	public boolean clickContractTab() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(visibilityElement(10, ReadConfigES.GetValES("contractES_tab_Xp")))
		{
			click(ReadConfigES.GetValES("contractES_tab_Xp"));
		}
		return visibilityElement(5, ReadConfigES.GetValES("contractES_tab_Xp"));
	}
	
	public void selectExpectedSignDate() throws IOException, InterruptedException
	{
		String todaydate= selectDate();
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(visibilityElement(5, ReadConfigES.GetValES("dateperiod_text_Xp")))
		click(ReadConfigES.GetValES("dateperiod_text_Xp"));
		Thread.sleep(5000);
		if(!visibilityElement(5, ReadConfigES.GetValES("expectedSignDate_datepicker_Xp")))
		{
		click(ReadConfigES.GetValES("dateperiod_text_Xp"));
		}
		click(ReadConfigES.GetValES("expectedSignDate_datepicker_Xp"));
		Thread.sleep(3000);
		click(ReadConfigES.GetValES("clickHoy_datepicker_Xp"));
		//sendKeys(ReadConfigES.GetValES("expectedSignDate_datepicker_Xp"), todaydate);
	}
	
	public void clickGenerateContract() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		click(ReadConfigES.GetValES("createContractES_btn_Xp"));
	}
	
	public boolean ClickCreateProposalTab() throws IOException
	{

		frameswitchdefault();
		frameSwitch("edit_quote");
		if(visibilityElement(10, ReadConfigES.GetValES("createProposalES_tab_Xp")))
		{
			click(ReadConfigES.GetValES("createProposalES_tab_Xp"));
		}
		return visibilityElement(10, ReadConfigES.GetValES("createProposalES_tab_Xp"));
	}
	
	public void clickGenerateProposal() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		click(ReadConfigES.GetValES("generateProposalES_btn_Xp"));
	}
	
	public void clickQuoteSummaryGenerate() throws IOException, InterruptedException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(visibilityElement(10, ReadConfigES.GetValES("quoteSummaryGenerate_btn_Xp")))
		{
			click(ReadConfigES.GetValES("quoteSummaryGenerate_btn_Xp"));
		}
		 Thread.sleep(6000);
	}
	
	public boolean verifyCloneQuote() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		String childQuote=getElementText(ReadConfigES.GetValES("verifyCloneQuote_txt_Xp"));
		return visibilityElement(20, ReadConfigES.GetValES("verifyCloneQuote_txt_Xp").replace("ReplaceMe", childQuote));
	}
	
	public void selectQuoteTypeRenovación() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(visibilityElement(5, ReadConfigES.GetValES("quoteTypeES_drp_Xp")))
			click(ReadConfigES.GetValES("quoteTypeES_drp_Xp"));
		selectDropDown(ReadConfigES.GetValES("quoteTypeES_drp_Xp"), "Renewal");
	}
	
	public boolean verifyQuoteTypeRenovacion() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		return CommonActions.CommonMethod.verifyConnectionTypeFromTable(ReadConfigES.GetValES("connectionTypeColumnVerify_Xp"), "Renovación", 15);	
	}
	
	public void selectQuoteTypeModificacion() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(visibilityElement(5, ReadConfigES.GetValES("quoteTypeES_drp_Xp")))
			click(ReadConfigES.GetValES("quoteTypeES_drp_Xp"));
		selectDropDown(ReadConfigES.GetValES("quoteTypeES_drp_Xp"), "Modificación");
	}
	
	public boolean verifyQuoteTypeModificacion() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		System.out.println(CommonMethod.verifyValuesFromTable(ReadConfigES.GetValES("connectionTypeColumnVerify_Xp"), "Modificación", 15));
		return CommonMethod.verifyValuesFromTable(ReadConfigES.GetValES("connectionTypeColumnVerify_Xp"), "Modificación", 15);	
	}
	
	public boolean verifyQuoteTypeOnReconfigure() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		System.out.println(CommonMethod.verifyValuesFromTable(ReadConfigES.GetValES("reconfigureProduct_table_Xp"), "Modificación", 7));
		return CommonMethod.verifyValuesFromTable(ReadConfigES.GetValES("reconfigureProduct_table_Xp"), "Modificación", 7);	
	}
	
	public boolean verifyPLResumenTab() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		return (visibilityElement(5, ReadConfigES.GetValES("pLresumen_tab_Xp")));
		
	}
	public boolean verifyPLAmpliadaTab() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		return (visibilityElement(5, ReadConfigES.GetValES("pLampliada_tab_Xp")));
		
	}
	public boolean verifyPLGlobalTab() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		return (visibilityElement(5, ReadConfigES.GetValES("globalP&L_tab_Xp")));
		
	}
	
	public void clickPLResumenTab() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		if(visibilityElement(5, ReadConfigES.GetValES("pLresumen_tab_Xp")))
		{
			click(ReadConfigES.GetValES("pLresumen_tab_Xp"));
		}
		
	}
	
	public boolean verifyMobileRevenueTotalValuesPLResumenTab() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		//System.out.println(CommonMethod.verifyValuesFromPLTable(ReadConfigES.GetValES("pLView_table_Xp"),"€309,600",19));
		return (CommonMethod.verifyValuesFromPLTable(ReadConfigES.GetValES("pLView_table_Xp"),"€309,600",19));
	}
			
	public boolean verifyMobileTCVValuesPLResumenTab() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		return (CommonMethod.verifyValuesFromPLTable(ReadConfigES.GetValES("pLView_table_Xp"),"€309,600",20));
	}
	
	public boolean verifyMobileRevenueCashTotalValuesPLResumenTab() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		return (CommonMethod.verifyValuesFromPLTable(ReadConfigES.GetValES("pLView_table_Xp"),"€309,600",21));
	}		
	
	public boolean verifyDataServicesValuesPLResumenTab() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		return (CommonMethod.verifyValuesFromPLTable(ReadConfigES.GetValES("pLView_table_Xp"),"€0,000",28));
	}
	
	public boolean verifyDataCPEValuesPLResumenTab() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		return (CommonMethod.verifyValuesFromPLTable(ReadConfigES.GetValES("pLView_table_Xp"),"€0,000",29));
	}
	
	public boolean verifyFixedRevenueTotalPLResumenTab() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		return (CommonMethod.verifyValuesFromPLTable(ReadConfigES.GetValES("pLView_table_Xp"),"€0,000",41));
	}
	
	public boolean verifyFixedTCVPLResumenTab() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		return (CommonMethod.verifyValuesFromPLTable(ReadConfigES.GetValES("pLView_table_Xp"),"€0,000",42));
	}
	
	public boolean verifyFixedRevenueCashTotalPLResumenTab() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		return (CommonMethod.verifyValuesFromPLTable(ReadConfigES.GetValES("pLView_table_Xp"),"€0,000",43));
	}
	
	public boolean verifyTotalRevenuePLResumenTab() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		return (CommonMethod.verifyValuesFromPLTable(ReadConfigES.GetValES("pLView_table_Xp"),"€309,600",45));
	}
	
	public void clickPLAmpliadaTab() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		if (visibilityElement(5, ReadConfigES.GetValES("pLampliada_tab_Xp")))
		{
			click(ReadConfigES.GetValES("pLampliada_tab_Xp"));
		}

	}
	
	public void clickUpdateExpandedPLView() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		click(ReadConfigES.GetValES("updateExpandedPLView_btn_Xp"));
	}
	
	public boolean verifyValueAddedServicePLAmpliadaTab() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		return (CommonMethod.verifyValuesFromPLTable(ReadConfigES.GetValES("expandedPLView_table_Xp"),"€3.405,600",10));
	}
	
	public boolean verifyMobileRevenueTotalPLAmpliadaTab() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		return (CommonMethod.verifyValuesFromPLTable(ReadConfigES.GetValES("expandedPLView_table_Xp"),"€3.405,600",19));
	}
	
	public boolean verifyMobileRevenueCashTotalPLAmpliadaTab() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		return (CommonMethod.verifyValuesFromPLTable(ReadConfigES.GetValES("expandedPLView_table_Xp"),"€3.405,600",21));
	}
	
	public void clickPLGlobalTab() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		if (visibilityElement(5, ReadConfigES.GetValES("globalP&L_tab_Xp")))
		 {
			 click(ReadConfigES.GetValES("globalP&L_tab_Xp"));
		 }
	}
	
	public boolean verifyTotalServiceRevenuePLGlobalTab() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		return (CommonMethod.verifyValuesFromPLTable(ReadConfigES.GetValES("globalPLView_table_Xp"),"€3.405,600",10));
	}
	
	public void clickproyectosTESTab() throws IOException
	{
		if(visibilityElement(5, ReadConfigES.GetValES("proyectosTES_tab_Xp")))
		{
			click(ReadConfigES.GetValES("proyectosTES_tab_Xp"));
		}
	}
	
	public void childQuoteCreate() throws IOException
	{
		if(visibilityElement(5, ReadConfigES.GetValES("createChildQuote_btn_Xp")))
		{
			click(ReadConfigES.GetValES("createChildQuote_btn_Xp"));
		}
		sendKeys(ReadConfigES.GetValES("childQuoteDescription_txt_Xp"), "Automation_ChildQuote");
		if(visibilityElement(5, ReadConfigES.GetValES("saveChildQuote_btn_Xp")))
		{
			click(ReadConfigES.GetValES("saveChildQuote_btn_Xp"));
		}
		if(ceme.checkErrorMessageES())
		{
			click(ReadConfigES.GetValES("saveChildQuote_btn_Xp"));
		}
	}
	
	public void saveChileQuote() throws IOException
	{
		String childQuote=getElementText(ReadConfigES.GetValES("saveChildQuote_num_Xp"));
		System.out.println(childQuote);
		WriteConfigFileES.setPropertyInFileES("ChildQuote", childQuote);
	}
	
	public void readChildQuoteFromConfig() throws IOException
	{
		String ChildQuote=ReadConfigES.GetAccountFromFileES("ChildQuote");
		System.out.println(ChildQuote);
	}
	
	public boolean verifyMobileRevenueTotalValuesPLResumenTabTESUser() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		System.out.println(CommonMethod.verifyValuesFromPLTable(ReadConfigES.GetValES("pLView_table_Xp"),"€0,000",19));
		return (CommonMethod.verifyValuesFromPLTable(ReadConfigES.GetValES("pLView_table_Xp"),"€0,000",19));
	}
			
	public boolean verifyMobileTCVValuesPLResumenTabTESUser() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		return (CommonMethod.verifyValuesFromPLTable(ReadConfigES.GetValES("pLView_table_Xp"),"€0,000",20));
	}
	
	public boolean verifyMobileRevenueCashTotalValuesPLResumenTabTESUser() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		return (CommonMethod.verifyValuesFromPLTable(ReadConfigES.GetValES("pLView_table_Xp"),"€0,000",21));
	}		
	
	public boolean verifyValueAddedServicePLAmpliadaTabTESUser() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		return (CommonMethod.verifyValuesFromPLTable(ReadConfigES.GetValES("expandedPLView_table_Xp"),"€0,000",10));
	}
	
	public boolean verifyMobileRevenueTotalPLAmpliadaTabTESUser() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		return (CommonMethod.verifyValuesFromPLTable(ReadConfigES.GetValES("expandedPLView_table_Xp"),"€0,000",19));
	}
	
	public boolean verifyMobileRevenueCashTotalPLAmpliadaTabTESUser() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		return (CommonMethod.verifyValuesFromPLTable(ReadConfigES.GetValES("expandedPLView_table_Xp"),"€0,000",21));
	}
	
	public boolean verifyTotalServiceRevenuePLGlobalTabTESUser() throws IOException
	{
		frameswitchdefault();
		frameSwitch("edit_quote");
		return (CommonMethod.verifyValuesFromPLTable(ReadConfigES.GetValES("globalPLView_table_Xp"),"€0,000",10));
	}
}
