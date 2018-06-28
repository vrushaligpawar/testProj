package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties; 


public class ReadConfigVGE
{
	public static Properties ReadPropertiesConfVGE(String FilePath) throws IOException
	{
		File file=new File(FilePath);
		FileInputStream fs=new FileInputStream(file);
		Properties prop=new Properties();
		prop.load(fs);
		return prop;
	}

	public static String GetValVGE(String Propname1) throws IOException
	{
		String Propname=ReadPropertiesConfVGE("D:\\Workspace\\CPQ\\src\\Resources\\ConfigVGE.properties").getProperty(Propname1);
		return Propname;
	}

	public static String GetAccountFromFileVGE(String Propname1) throws IOException
	{
		String Propname=ReadPropertiesConfVGE("D:\\Workspace\\CPQ\\src\\Resources\\WriteConfigVGE.properties").getProperty(Propname1);
		return Propname;
	}

}
