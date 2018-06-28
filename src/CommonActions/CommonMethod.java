package CommonActions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.server.handler.CloseWindow;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Resources.ReadConfig;
import Resources.ReadConfigES;
import Resources.WriteConfigFile;
import Resources.WriteConfigFileES;

public class CommonMethod extends LaunchDriver{
 
	static String parentwindowHandle;

		
	public static void sendKeys( String xpathExpression, String Value)
	{
		if(Value!=null)
		{
		new Actions(driver).moveToElement(driver.findElement(By.xpath(xpathExpression))).perform(); //focus on this element
		WebElement el=driver.findElement(By.xpath(xpathExpression));
		highLighterMethod(driver,el);
		driver.findElement(By.xpath(xpathExpression)).sendKeys(Value);
		}
	}
	public static void scrollIn( String xpathExpression) throws InterruptedException
	{
		Thread.sleep(1000);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		Thread.sleep(1000);
	}
	
	/*public static void javaScriptClick(String xpathExpression) throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		js.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
	}*/
	
	
	public static void selectDropDown( String xpathExpression, String Value)
	{
		if(Value!=null)
		{
			new Actions(driver).moveToElement(driver.findElement(By.xpath(xpathExpression))).perform();
			Select s1=new Select(driver.findElement(By.xpath(xpathExpression)));
			WebElement el=driver.findElement(By.xpath(xpathExpression));
			highLighterMethod(driver,el);
			s1.selectByValue(Value);
		}
		
	}
	
	public static void selectCheckbox( String xpathExpression)
	{
		new Actions(driver).moveToElement(driver.findElement(By.xpath(xpathExpression))).perform();
		WebElement s2=driver.findElement(By.xpath(xpathExpression));
		WebElement el=driver.findElement(By.xpath(xpathExpression));
		highLighterMethod(driver,el);
		s2.click();
	}
	
	
	
	public static void selectRadiobutton( String xpathExpression)
	{
		new Actions(driver).moveToElement(driver.findElement(By.xpath(xpathExpression))).perform();
		WebElement el=driver.findElement(By.xpath(xpathExpression));
		highLighterMethod(driver,el);
		driver.findElement(By.xpath(xpathExpression)).click();
	}
	
	public static void click(String xpathExpression )
	{
		WebElement el=driver.findElement(By.xpath(xpathExpression));
		//new Actions(driver).moveToElement(el).perform();
		highLighterMethod(driver,el);
		((JavascriptExecutor) driver).executeScript("window.focus();");
		driver.findElement(By.xpath(xpathExpression)).click();
	}
	
	public static void highlightElement(String xpathExpression)
	{
		WebElement el=driver.findElement(By.xpath(xpathExpression));
		//new Actions(driver).moveToElement(el).perform();
		highLighterMethod(driver,el);
		((JavascriptExecutor) driver).executeScript("window.focus();");
	}
	
	
	public static void moveandclick(String xpathExpression)
	{
		WebElement el=driver.findElement(By.xpath(xpathExpression));
		new Actions(driver).moveToElement(el).perform();
		highLighterMethod(driver,el);
		((JavascriptExecutor) driver).executeScript("window.focus();");
		driver.findElement(By.xpath(xpathExpression)).click();
	}
	public static void moveandclickOnWebElement(WebElement we)
	{
		new Actions(driver).moveToElement(we).perform();
		highLighterMethod(driver,we);
		((JavascriptExecutor) driver).executeScript("window.focus();");
		we.click();
	}
	public static void moveToElement(String xpathExpression)
	{
		WebElement el=driver.findElement(By.xpath(xpathExpression));
		new Actions(driver).moveToElement(el).perform();
		highLighterMethod(driver,el);
		((JavascriptExecutor) driver).executeScript("window.focus();");
	}
	
	public static void pageUpButton() throws InterruptedException
	{
		driver.switchTo().activeElement().sendKeys(Keys.PAGE_UP);
		Thread.sleep(2000);
	}
	
	public static void pageDownButton() throws InterruptedException
	{
		driver.switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(2000);
	}
	
	
	public static void doubleClick(String xpathExpression)
	{
		Actions action = new Actions(driver);
		WebElement el=driver.findElement(By.xpath(xpathExpression));
		highLighterMethod(driver,el);
		action.moveToElement(driver.findElement(By.xpath(xpathExpression))).doubleClick().build().perform();
	}

	public static String selectDate()
	{
		Date date = new Date();
		String modifiedDate= new SimpleDateFormat("dd/MM/yy").format(date);
		return modifiedDate;
	}
	
	public static String autoIncrement()
	{
		/*double result = Math.incrementExact(3051);
		//System.out.println("Use of incrementExact() : " + result1);
		return result;*/
		String timeStamp = new SimpleDateFormat("ssmmHHddMMyy").format(Calendar.getInstance().getTime());
		return timeStamp;
	}
	
	
	public void getUrl(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	
	
	public static void rightclick(String xpathExpression) 
	{
		Actions oAction = new Actions(driver);
		oAction.moveToElement(driver.findElement(By.xpath(xpathExpression)));
		oAction.contextClick().build().perform();  /* this will perform right click */
		//WebElement elementOpen = driver.findElement(By.xpath(xpathExpression)); /*This will select menu after right click */
		//elementOpen.click();
	}
	
	public static boolean isAlertPresent() {
	    try {
	        driver.switchTo().alert().dismiss();
	        return true;
	    } // try
	    catch (Exception e) {
	        return false;
	    } // catch
	    	}

	
	public void javaScriptPermission()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("Qos.isEnabled = false;");
		
	}
	public static boolean isElementFound(String xpathExpression) 
	{
		if(driver.findElement(By.xpath(xpathExpression)) != null){
			return  true;
		}else
		{
			return false;
		}
	}
	
	public static void frameSwitch(String iframe)
	{
		driver.switchTo().frame(iframe);
		System.out.println("Switched to frame - " + iframe);
	}
	
	public static void frameswitchdefault()
	{
		driver.switchTo().defaultContent();
	}
	
	public static void uploadFile(String FilePath) throws AWTException, InterruptedException
	{
		
		Robot robot=new Robot();
		StringSelection stringselection=new StringSelection(FilePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
	}
	
	public static void robotClick(String xpathExpression) throws AWTException
	{
		WebElement un = driver.findElement(By.xpath(xpathExpression));
		int xaxis = un.getLocation().x;
		 
		int yaxis=un.getLocation().y;
		 
		int width = un.getSize().width;
		int height= un.getSize().height;
		 
		Robot r=new Robot();
		r.mouseMove(xaxis+width/2, yaxis+height/2+70);
		r.mousePress(KeyEvent.BUTTON1_MASK);//click function
		r.mouseRelease(KeyEvent.BUTTON1_MASK);

	}
	
	
	
	public static void getApprovalsFromTable(String xpathExpression) throws IOException
	{
		
		WebElement Table = driver.findElement(By.xpath(xpathExpression));//identify table
		//locate rows of table
		List<WebElement> rows_table=Table.findElements(By.tagName("tr"));
		List<String> value = new ArrayList<String>();
	    System.out.println(rows_table.size());
		//Calculate the no of rows in table
		int rows_count=rows_table.size();
		//loop will execute rows till last row of table
		for(int row=0;row<1;row++)
		{
			//To locate the column of specific row
			List<WebElement> columns_row=rows_table.get(row).findElements(By.tagName("td"));
			int columns_count=columns_row.size();
			//loop will execute last cell of the specific row
			for (int column=0;column<columns_count;column++)
			{
				//To retrieve the specific cell
				String celtext=columns_row.get(column).getText();
				WriteConfigFileES.setPropertyInFileES("Approver_"+column, celtext.trim());
				System.out.println("Approver_"+column +"  "+ celtext.trim());   
			}
			WriteConfigFileES.setPropertyInFileES("NoOfApprover", Integer.toString(columns_count));
			System.out.println("NoOfApprover"+"  "+ columns_count); 
			}
		
		 }
	
	public static boolean verifyValuesFromTable(String xpathExpressionForTable, String expectedCellText, int column)
	{
		boolean isFound = false;
		WebElement Table=driver.findElement(By.xpath(xpathExpressionForTable));
		List<WebElement> rows_table=Table.findElements(By.tagName("tr"));
		//List<String> value = new ArrayList<String>();
	    System.out.println(rows_table.size());
	    int rows_count=rows_table.size();
	    for(int row=1;row<rows_count;row++)
	    {
	    	List<WebElement> columns_row=rows_table.get(row).findElements(By.tagName("td"));
	    	int columns_count =columns_row.size();
	    	//for (int column=1;column<columns_count;column++)
			//{
				String actualCellText=columns_row.get(column).getText();
				if(!actualCellText.equals(expectedCellText))
				{
					isFound = false;
					System.out.println("TableValues in row: " + row + " Expected: " + expectedCellText +" NOT FOUND. Actual is "+ actualCellText.trim());  
					break;
				}
				else	
				{
		            isFound = true;
		            //System.out.println("TableValues"+column +"  "+ celtext.trim());   
		            //break;
		        }
			//}
	    }
	    return isFound;
	    }
	
	
	public static boolean verifyConnectionTypeFromTable(String xpathExpressionForTable, String expectedCellText, int column)
	{
		boolean isFound = false;
		highlightElement(xpathExpressionForTable);
		WebElement Table=driver.findElement(By.xpath(xpathExpressionForTable+"/tbody/tr"));
		List<WebElement> rows_table=Table.findElements(By.xpath(xpathExpressionForTable+"/tbody/tr"));
		//List<String> value = new ArrayList<String>();
	    System.out.println(rows_table.size());
	    int rows_count=rows_table.size();
	    for(int row=2;row<=rows_count;row++)
	    {
	 	   	String col_ConnectionType_xp = xpathExpressionForTable+"/tbody/tr["+row+"]/td[17]/div/div/span";
	    	String actualCellText="";
	    	if (isElementFound(col_ConnectionType_xp)){
	    		actualCellText = Table.findElement(By.xpath(col_ConnectionType_xp)).getText();
	    		highlightElement(xpathExpressionForTable+"/tbody/tr["+row+"]/td[17]");
	    	}
	 		if(!actualCellText.equals("")){
				if(actualCellText.equals(expectedCellText)) 
				{
					isFound = true;
					System.out.println("TableValues in row: " +  " Expected: " + expectedCellText +"  FOUND. Actual is "+ actualCellText.trim());  
					//break;
				}
				else	
				{
		            isFound = false;
		            System.out.println("TableValues in row: " +  " Expected: " + expectedCellText +"  Not FOUND. Actual is "+ actualCellText.trim());
		            //System.out.println("TableValues"+column +"  "+ celtext.trim());   
		            
		        }
	 		}
	 		}	
	    
	    return isFound;
	    }
	
	
	
	public static boolean verifyValuesFromPLTable(String xpathExpressionForTable, String expectedCellText, int row)
	{
		boolean isFound = false;
		WebElement Table=driver.findElement(By.xpath(xpathExpressionForTable));
		highlightElement(xpathExpressionForTable);
		List<WebElement> rows_table=Table.findElements(By.tagName("tr"));
		//List<String> value = new ArrayList<String>();
	    System.out.println(rows_table.size());
	    int rows_count=rows_table.size();
	    /*for(row=1;row<rows_count;row++)
	    {*/
	    	List<WebElement> columns_row=rows_table.get(row).findElements(By.xpath("//div[@id='readonly_1_pLViewNew_quote']/table/tbody/tr/td[2]"));
	    	int columns_count =columns_row.size();
				String actualCellText=columns_row.get(row).getText();
				//highlightElement(actualCellText);
			/*List<WebElement> columns_row1=rows_table.get(row).findElements(By.xpath("//div[@id='readonly_1_pLViewNew_quote']/table/tbody/tr[20]/td[1]"));
		    	//int columns_count1 =columns_row1.size();
					String actualCellText1=columns_row1.get(row).getText();
					//highlightElement(actualCellText);
*/				if(!actualCellText.equals(expectedCellText))
				{
					isFound = false;
					System.out.println("TableValues in row: " + row + " Expected: " + expectedCellText +" NOT FOUND. Actual is "+ actualCellText.trim());  
					//break;
				}
				else	
				{
		            isFound = true;
		            //System.out.println("TableValues"+column +"  "+ celtext.trim());   
		            //break;
		        }
			//}
	   // }
	    return isFound;
	    }
	
	
	public static boolean verifyValuesFromAccessExistTable(String xpathExpressionForTable,int row,String expectedCellText1, int column1, String expectedCellText2, int column2, String expectedCellText3, int column3, String expectedCellText4, int column4)
	{
		boolean isFound = false;
		WebElement Table=driver.findElement(By.xpath(xpathExpressionForTable));
		List<WebElement> rows_table=Table.findElements(By.tagName("tr"));
		//List<String> value = new ArrayList<String>();
	    System.out.println(rows_table.size());
	    int rows_count=rows_table.size();
	   // for(int row=1;row<rows_count;row++)
	    //{
	    	List<WebElement> columns_row=rows_table.get(row).findElements(By.tagName("td"));
	    	int columns_count =columns_row.size();
	    	//for (int column=1;column<columns_count;column++)
			//{
				String actualCellText1=columns_row.get(column1).getText();
				String actualCellText2=columns_row.get(column2).getText();
				String actualCellText3=columns_row.get(column3).getText();
				String actualCellText4=columns_row.get(column4).getText();
				if(!actualCellText1.equals(expectedCellText1))
				{
					isFound = false;
					System.out.println("TableValues in row: " + row + " Expected: " + expectedCellText1 +" NOT FOUND. Actual is "+ actualCellText1.trim());  
					//break;
				}
				else	
				{
		            isFound = true;
		         }
				if(!actualCellText2.equals(expectedCellText2))
				{
					isFound = false;
					System.out.println("TableValues in row: " + row + " Expected: " + expectedCellText2 +" NOT FOUND. Actual is "+ actualCellText2.trim());  
					//break;
				}
				else	
				{
		            isFound = true;
		         }
				if(!actualCellText3.equals(expectedCellText3))
				{
					isFound = false;
					System.out.println("TableValues in row: " + row + " Expected: " + expectedCellText3 +" NOT FOUND. Actual is "+ actualCellText3.trim());  
					//break;
				}
				else	
				{
		            isFound = true;
		         }
				if(!actualCellText4.equals(expectedCellText4))
				{
					isFound = false;
					System.out.println("TableValues in row: " + row + " Expected: " + expectedCellText4 +" NOT FOUND. Actual is "+ actualCellText4.trim());  
					
				}
				else	
				{
		            isFound = true;
		            //break;
		         }
	    //}
	    return isFound;
	    }
	
	
	
	public static WebElement getWebElement(String xpathExpression)
	{
		return driver.findElement(By.xpath(xpathExpression));
		
	}
	
	
	
	public static void pageRefresh() throws InterruptedException
	{
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.F5).perform();
        Thread.sleep(9000);
	}
	
	public static void clear(String xpathExpression)
	{
		driver.findElement(By.xpath(xpathExpression)).clear();
	}
	
	public static boolean visibilityElement( int timeout, String xpathExpression){
    	try{
    	        WebDriverWait wait = new WebDriverWait(driver, timeout);
    	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathExpression)));
    	        System.out.println(xpathExpression+"--found");
    	        WebElement el=driver.findElement(By.xpath(xpathExpression));
    			//highLighterMethod(driver,el);
    	        return true;
    	}catch(Exception e){
    		 System.out.println(xpathExpression+"--not found");
    	    return false;
    	}
}
		{
    }
	
	public static void highLighterMethod(WebDriver driver, WebElement element){
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		}
		
		public static void javascriptmousemove(String xpathExpression)
		{
			WebElement element = driver.findElement(By.xpath(xpathExpression));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		}
	
	public static String getElementText(String xpathExpression)
	{
		//return driver.findElement(By.xpath(xpathExpression)).getAttribute("innerHTML");
		return driver.findElement(By.xpath(xpathExpression)).getText();
	}
		
	public static void enablePopupsIE()
	{
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability("browserstack.ie.enablePopups", "true");
	}
		
	
	
	public static void switchParentWindow()
	{
		driver.switchTo().window(parentwindowHandle);
	}
	
	public static void switchchildWindow() throws InterruptedException
	{
		 parentwindowHandle=driver.getWindowHandle(); //instance of parent window
		 System.out.println("parent window handle: "+ parentwindowHandle);
		 //driver.findElement(By.xpath(xpathExpression)).click();
		Set<String> childwindow=driver.getWindowHandles();
		for(String s: childwindow)
		{
			driver.switchTo().window(s);
			System.out.println("Switched to window: "+ s);
		}
		Thread.sleep(3000);
	}
	
	public static void switchTab() throws InterruptedException
	{
		//String Tab1=driver.getWindowHandle();
		ArrayList<String> availableWindows=new ArrayList<String>(driver.getWindowHandles());
		if(!availableWindows.isEmpty()){
			driver.switchTo().window(availableWindows.get(1));		
			Thread.sleep(2000);
		}
	}
	
	public static void switchDefaultTab()
	{
		driver.switchTo().defaultContent();
	}
	
	public static void closeBrowser()
	{
		driver.quit();
	}
	
	
	
	

		public static void captureScreenMethod() throws Exception{
			String timeStamp;
			File screenShotName;
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//The below method will save the screen shot in d drive with name "screenshot.png"
			timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
			screenShotName = new File("D:\\MyTest\\Screenshots\\"+timeStamp+".png");
			FileUtils.copyFile(scrFile, screenShotName);
			 
			//String filePath = screenShotName.toString();
			//String path "<img src="\"file://"" alt="\"\"/" />";

			//Reporter.log(path);

			
	               /* System.setProperty("webdriver.gecko.driver","D://Selenium Environment//Drivers//geckodriver.exe");
					driver.manage().window().maximize();
		        try{
		            //driver.get("https://www.softwaretestingmaterial.com");
			    //driver.navigate().refresh();
			    //driver.findElement(By.xpath("//*[@id='cse-search-box']/div/input[4]")).sendKeys("agile"); //Statement with correct Xpath
			    driver.findElement(By.xpath("//*[@id='cse']")).sendKeys("agile"); //Statement with incorrect Xpath	
	                }catch(Exception e){
		            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		            screenShotName = new File("D:\\MyTest\\Screenshots\\"+timeStamp+".png");
		            FileUtils.copyFile(scrFile, screenShotName);

			    FileUtils.copyFile(screenshotFile, new File("D:\\SoftwareTestingMaterial.png"));
			}
	        driver.close();
		driver.quit();		*/
		}
		
		
		public  static int testTable(String expectedCellText,String expectedAccessTech,String expectedColorText) throws IOException, InterruptedException
		{
			frameswitchdefault();
			frameSwitch("edit_quote");
			String xpathExpressionForTable_tbody = ReadConfigES.GetValES("feasibilityResponseVerify_table_Xp_tbody");
			WebElement Table=driver.findElement(By.xpath(ReadConfigES.GetValES("feasibilityResponseVerify_table_Xp_tbody")));
			List<WebElement> rows_table=Table.findElements(By.tagName("tr"));
			System.out.println(rows_table.size());
			int row_count=rows_table.size();
			int rows_checkMarked = 0;
			for (int i=1;i<row_count;i++)
				//div[@id='readonly_1_siteDetailsForConfiguration_quote']/div[@id='dwrapper']/div[@class='ft_container']/div[@class='ft_rel_container']/div[@class='ft_scroller']/table[@id='fixed_hdr2']/tbody/tr[@id='row1']/td[19]
			{
				//String x1 = xpathExpressionForTable_tbody + "/tr[@id='row" + i + "']/td[17]" ;
				String x1 = xpathExpressionForTable_tbody + "/tr[" + i + "]/td[17]" ;
				String actualCellText=driver.findElement(By.xpath(x1)).getText();
				System.out.println("col_16 "+ driver.findElement(By.xpath(x1)).getText());
				if(actualCellText.equals(expectedCellText))
				{ 
				//String x3 = xpathExpressionForTable_tbody + "/tr[@id='row" + i + "']/td[19]" ;
					String x2 = xpathExpressionForTable_tbody + "/tr[" + i + "]/td[18]" ;					
					String actualAccessTech=driver.findElement(By.xpath(x2)).getText();
					System.out.println("col_17 "+ driver.findElement(By.xpath(x2)).getText());
				String x3 = xpathExpressionForTable_tbody + "/tr[" + i + "]/td[19]" ;					
				String actualColorText=driver.findElement(By.xpath(x3)).getText();
				System.out.println("col_18 "+ driver.findElement(By.xpath(x3)).getText());
				if(actualAccessTech.equals(expectedAccessTech) && actualColorText.equals(expectedColorText))
				{
					Thread.sleep(2000);
					int j = i-2;
					if (j > 4){
					scrollIn(xpathExpressionForTable_tbody + "/tr[" + j + "]");}
					//String x0=xpathExpressionForTable_tbody + "/tr[@id='row" + i + "']/td[1]/input";
					String x0=xpathExpressionForTable_tbody + "/tr[" + i + "]/td[1]/input";
					Thread.sleep(3000);
					//driver.findElement(By.xpath(x0)).click();
					moveandclick(x0);
					Thread.sleep(2000);
					//WebElement column_Select = rows_table.get(i).findElement(By.xpath("//td[0]/input"));
					//moveandclickOnWebElement(column_Select);
					rows_checkMarked++;
					break;
				}
				
				else
				{
					System.out.println("cell color in row: " + i + " Expected color: " + expectedColorText +" NOT FOUND. Actual is color "+ actualColorText);
				}
				
			}
			else
			{
					System.out.println("TableValues in row: " + i + " Expected: " + expectedCellText +" NOT FOUND. Actual is "+ actualCellText);  
				
			}
				
		}
			
		return rows_checkMarked;
		
		
	}
	
	
}
