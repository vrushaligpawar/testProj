package Resources;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteConfigFileES {

	static File file;
	static Properties table;
	
	
    static void savePropertiesES(Properties p)throws IOException
    {
            FileOutputStream fr=new FileOutputStream("D:\\Workspace\\CPQ\\src\\Resources\\WriteConfigES.properties",true);
            
            p.store(fr,"Properties");
            fr.close();
            System.out.println("After saving properties:"+p);
    }
    	
	public static void setPropertyInFileES(String propertyName, String acctName) throws IOException {
	//createFile();
		table=new Properties();
        table.setProperty(propertyName,acctName);
        System.out.println("Properties has been set in HashTable:"+table);

        savePropertiesES(table);
        
	}
	
	
}
