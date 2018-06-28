package Resources;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteConfigFile {

	static File file;
	static Properties table;
	
	
    static void saveProperties(Properties p)throws IOException
    {
            FileOutputStream fr=new FileOutputStream("D:\\Workspace\\CPQ\\src\\Resources\\WriteConfig.properties",true);
            
            p.store(fr,"Properties");
            fr.close();
            System.out.println("After saving properties:"+p);
    }
    	
	public static void setPropertyInFile(String propertyName, String acctName) throws IOException {
	//createFile();
		table=new Properties();
        table.setProperty(propertyName,acctName);
        System.out.println("Properties has been set in HashTable:"+table);

        saveProperties(table);
        
	}
	
	
}
