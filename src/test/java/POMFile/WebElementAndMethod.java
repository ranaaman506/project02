package POMFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebElementAndMethod {
	WebDriver driver;
	public WebElementAndMethod(WebDriver ldriver)
	{
		driver=ldriver;
		PageFactory.initElements(driver,this);
	}
     @FindBy(id = "username")
	  WebElement Username;
	@FindBy(id="password")
	WebElement Password;
	@FindBy(id = "submit")
	WebElement Submit;
	
	public void uname(String user) {
	Username.sendKeys(user);
	}
	public void pass(String pas ) {
		Password.sendKeys(pas);
	}
	public void Subbutton()
	{
		Submit.click();
	}
	
}
