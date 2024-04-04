package TestCaseFile;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import UtilityFile.ReadFile;


public class BaseClass {
	
	public static WebDriver driver;
	public static Logger l1;
    ReadFile rf = new ReadFile();
   String Url= rf.Geturl();
   String bro=rf.GetBrowser();    
    
    @BeforeClass
    void browserlaunch()
    {
    	switch(bro.toLowerCase())
    	{
    	case "chrome":
    		driver = new ChromeDriver();
    		break;
    	case "MsEdge":
    	
    		driver = new EdgeDriver();
    		break;
    	case "FireFox":
    		driver= new FirefoxDriver();
    		break;
    	default :
    		driver = null;
    }
    	l1= LogManager.getLogger("TestNGProject002");
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
}
    
    public void Screenshot() throws IOException
    {
    	TakesScreenshot tc = (TakesScreenshot)driver;
    	       File Source= tc.getScreenshotAs(OutputType.FILE);
    	       File Dest = new File("C:\\Users\\admin\\eclipse-workspace\\TestNGProject002\\ScreenShot\\hello.png");
    	       FileUtils.copyFile(Source, Dest);
    }
    @AfterClass
    public void closeup() {
	
    	driver.close();
    	driver.quit();
    }
}
	

