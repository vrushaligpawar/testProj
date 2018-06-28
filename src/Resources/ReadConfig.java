package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties; 


public class ReadConfig 
{
public static Properties ReadPropertiesConf(String FilePath) throws IOException
{
	File file=new File(FilePath);
	FileInputStream fs=new FileInputStream(file);
	Properties prop=new Properties();
	prop.load(fs);
	return prop;
}

public static String GetVal(String Propname1) throws IOException
{
	String Propname=ReadPropertiesConf("D:\\Workspace\\CPQ\\src\\Resources\\Config.properties").getProperty(Propname1);
	return Propname;
}

public static String GetAccountFromFile(String Propname1) throws IOException
{
	String Propname=ReadPropertiesConf("D:\\Workspace\\CPQ\\src\\Resources\\WriteConfig.properties").getProperty(Propname1);
	return Propname;
}

}
