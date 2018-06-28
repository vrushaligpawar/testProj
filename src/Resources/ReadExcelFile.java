package Resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	
	public static ArrayList<String> readExcelFileInfo(String filePath,String sheetName, String uniqueID) throws IOException
	{
		FileInputStream file=new FileInputStream(filePath);
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet(sheetName);
		
		
		ArrayList<String> list=new ArrayList<String>();
		int rowcount=sheet.getLastRowNum();
		for(int i=0;i<rowcount+1;i++){
			XSSFRow rowal=sheet.getRow(i);
			XSSFCell celltest=rowal.getCell(0);
			if(celltest.getStringCellValue().equals(uniqueID)){
				for(int j=0;j<rowal.getLastCellNum();j++){
					
					String cellValue=rowal.getCell(j).getStringCellValue();
					list.add(cellValue);
					System.out.println(cellValue);
				}break;
			}
		}return list;
	}
	    
	
	

	    }


	
