package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties; 


public class ReadConfigES 
{
public static Properties ReadPropertiesConfES(String FilePath) throws IOException
{
	File file=new File(FilePath);
	FileInputStream fs=new FileInputStream(file);
	Properties prop=new Properties();
	prop.load(fs);
	return prop;
}

public static String GetValES(String Propname1) throws IOException
{
	String Propname=ReadPropertiesConfES("D:\\Workspace\\CPQ\\src\\Resources\\ConfigES.properties").getProperty(Propname1);
	return Propname;
}

public static String GetAccountFromFileES(String Propname1) throws IOException
{
	String Propname=ReadPropertiesConfES("D:\\Workspace\\CPQ\\src\\Resources\\WriteConfigES.properties").getProperty(Propname1);
	return Propname;
}

}
