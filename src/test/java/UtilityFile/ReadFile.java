package UtilityFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadFile {
	Properties pro;
	FileInputStream fn;
	String path = "C:\\Users\\admin\\eclipse-workspace\\TestNGProject002\\ConfigurationFile.1\\ConfigurationFile011";
	public ReadFile()
	{
	pro= new Properties();
	try {
		fn = new FileInputStream(path);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      try {
		pro.load(fn);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public String Geturl()
{   String s1 =pro.getProperty("url");
if(s1!= null)
{
	return s1;
}
else
{
	throw new RuntimeException("url not found");
}}

public String GetBrowser() {
String s2 = pro.getProperty("Browser");

if(s2!= null)
{
	return s2;
}

else
{
	throw new RuntimeException("browser not found");
}
}}
	
	
