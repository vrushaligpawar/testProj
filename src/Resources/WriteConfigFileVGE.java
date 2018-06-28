package Resources;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteConfigFileVGE {
	static File file;
	static Properties table;
	
	
    static void savePropertiesVGE(Properties p)throws IOException
    {
            FileOutputStream fr=new FileOutputStream("D:\\Workspace\\CPQ\\src\\Resources\\WriteConfigVGE.properties",true);
            
            p.store(fr,"Properties");
            fr.close();
            System.out.println("After saving properties:"+p);
    }
    	
	public static void setPropertyInFileVGE(String propertyName, String acctName) throws IOException {
	//createFile();
		table=new Properties();
        table.setProperty(propertyName,acctName);
        System.out.println("Properties has been set in HashTable:"+table);

        savePropertiesVGE(table);
        
	}
	
	
}
