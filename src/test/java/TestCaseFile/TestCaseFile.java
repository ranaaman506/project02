package TestCaseFile;

import org.testng.annotations.Test;

import POMFile.WebElementAndMethod;

public class TestCaseFile extends BaseClass{
	@Test
	void Browseropen()
	{
		l1.info("Url is open");
		driver.get(Url);
		WebElementAndMethod Wb = new WebElementAndMethod(driver);
		l1.info("Enter username");
		Wb.uname("student");
		l1.info("Enter password ");
		Wb.pass("Password123");
		l1.info("click button");
		Wb.Subbutton();
	}
	
}



