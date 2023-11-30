package com.SCM.GenericUtils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListImplClass implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		//ExtentTest test = report.createTest(MethodName); declare globally
		test = report.createTest(MethodName);
		
		Reporter.log(MethodName+"--- Testscript execution starts Here ----");
	}

	public void onTestSuccess(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"--> PASSED");
		
		Reporter.log(MethodName+"---Testscript executed sucessfully");
	}

	public void onTestFailure(ITestResult result) {
		
		String FS = result.getMethod().getMethodName();
		String FScript=FS+new JavaUtils().systemDateInFormat();
		test.addScreenCaptureFromPath(FScript);
		
//		try {
//			WebDriverUtils.getscreenShot(BaseClass.sdriver, FS);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		test.log(Status.FAIL, result.getThrowable());
//		test.log(Status.FAIL, FScript+"---> Failed");
//		Reporter.log(FScript+"--> TestScript execution failed");
	}

	public void onTestSkipped(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"--> Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(MethodName+"--> TestScript execution skipped");
	}

	public void onStart(ITestContext context) 
	{
		ExtentSparkReporter htmlReport= new ExtentSparkReporter("./ExtentReport/report.html");
		htmlReport.config().setDocumentTitle("Procure SCM");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Admin");
		
		//ExtentReports report = new ExtentReports(); declare globally
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Browser", "Chrome");
		report.setSystemInfo("Url", "Htto://rmgtestingserver.com");
		report.setSystemInfo("Reporter Name", "Prasad");
		
	}

	public void onFinish(ITestContext context) 
	{
		report.flush();
	}

	
}
