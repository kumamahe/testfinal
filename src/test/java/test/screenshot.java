package test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import freemarker.core.OutputFormat;

public class screenshot {
	
	public void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://maven.apache.org/surefire/maven-surefire-plugin/examples/testng.html");
		TakesScreenshot screensht=(TakesScreenshot)driver;
		File srcfile=screensht.getScreenshotAs(OutputType.FILE);
		Date d=new Date();
		String path=System.getProperty("user.dir")+"//reports//"+d.toString().replace(":", "-")+".png";
		File destfile=new File(path);
		try {
			FileUtils.copyFile(srcfile, destfile);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
