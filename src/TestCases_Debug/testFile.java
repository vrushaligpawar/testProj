package TestCases_Debug;

import java.io.IOException;

import CommonActions.CommonMethod;
import Resources.ReadConfig;
import Resources.ReadConfigES;
import SpecificObjectAction.LoginAction;

public class testFile extends CommonMethod{
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		/*// TODO Auto-generated method stub

		WriteConfigFile.setPropertyInFile("AccountName" ,"UK1");
		WriteConfigFile.setPropertyInFile("Opp" ,"UK2");
		WriteConfigFile.setPropertyInFile("test" ,"UK3");
		//WriteConfigFile.setOppNameInFile("Opp_Automation_UK111");
		
		//click(ReadConfigES.GetValES("accountES_New_btn_Xp"));
		//System.out.println(nac.getAccountName());
		System.out.println("Latest account name "+ReadConfig.GetAccountFromFile("AccountName"));*/
		int p = 0;
		 for( int i=1; i<=5; i++ ){
		 for( int k=1; k<=5-i; k++ ){
		 System.out.print (" ");
		 }
		 for( int j=1; j<=i+p; j++ ){
		 System.out.print ("*");
		 }
		 System.out.println ();
		 p=p+1;
		 }
	}
}
