package Testbase;

import java.io.File;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import resources.Utils;

public class Baseclass {

	public static ExtentReports report;
	public static ExtentTest logger;
	public static ExtentHtmlReporter extent;
	
	@BeforeSuite
	public void setupSuite()
	{
	    extent = new ExtentHtmlReporter(new File("D:\\PetStoreAPIFramework\\Report\\"
	    		+ "petstore"+Utils.getCurrentDateTime()+".html"));
	    
	    
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	@AfterMethod
	public void getResult(ITestResult result)
	{
			if(result.getStatus()==ITestResult.FAILURE)
			{
				logger.fail(MarkupHelper.createLabel(result.getName()+"Test Case Failed", ExtentColor.RED));
				logger.fail(result.getThrowable());
			}
			else if (result.getStatus()==ITestResult.SUCCESS) 
			{
				logger.pass(MarkupHelper.createLabel(result.getName()+"Test Case Passed", ExtentColor.GREEN));
			}
			else if(result.getStatus()==ITestResult.SKIP) 
			{
				logger.skip(MarkupHelper.createLabel(result.getName()+"Test Case skipped", ExtentColor.YELLOW));
			}
	}
	
	@AfterSuite
	public void teardown()
	{
		report.flush();
	}
}
