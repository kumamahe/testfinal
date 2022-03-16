package test;

import java.io.File;
import java.util.Base64.Encoder;
import java.util.Date;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.ScreenCapture;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.annotations.VisibleForTesting;

public class report {
	
	@Test
	public static void learnreports(){
		
		ExtentReports report=new ExtentReports();
		Date d=new Date();
		String path=System.getProperty("user.dir")+"//reports//"+ d.toString().replace(" ", "").replace(":", "_")+"//screenshots";
		File f=new File(path);
		f.mkdirs();		
		String reportpath=System.getProperty("user.dir") + "//reports//";
		System.out.println(path);
		//System.out.println(System.getProperty("user.dir"));
		ExtentSparkReporter reporter=new ExtentSparkReporter(reportpath+d.toString().replace(" ", "").replace(":", "_"));
		reporter.config().setReportName("LearnTest");
		reporter.config().setDocumentTitle("Test");
		reporter.config().setEncoding("utf-8");
		reporter.config().setTheme(Theme.DARK);
		report.attachReporter(reporter);
		
		ExtentTest test= report.createTest("Test1");
		test.log(Status.INFO, "Learning reports");
		test.log(Status.FAIL, "report failed");
		//System.out.println(screenshot.path);
		test.log(Status.INFO, "Screenshot"+ test.addScreenCaptureFromPath(reportpath+"Sat Mar 12 18-44-13 IST 2022.png"));
		
		report.flush();
	}

}
