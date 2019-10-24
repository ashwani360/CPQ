package Listeners;

import com.relevantcodes.extentreports.LogStatus;

import Driver.DriverHelper;
import Driver.DriverTestcase;
import Driver.Log;
import Driver.ScreenRecorder;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Reporter.ExtentManager;
import Reporter.ExtentTestManager;

 
public class TestListener extends DriverTestcase implements ITestListener {
 
	ScreenRecorder recordTest;
	String Filename;
	
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
    
    //Before starting all tests, below method runs.
    public void onStart(ITestContext iTestContext) {
        Log.info("I am on Start method " + iTestContext.getName());
        
        iTestContext.setAttribute("WebDriver", this.getwebdriver());
//        recordTest = new ScreenRecorder();
        System.out.println("Driver instance in Listemer"+this.getwebdriver());
    }
 
    //After ending all tests, below method runs.
    public void onFinish(ITestContext iTestContext) {
        Log.info("I am on Finish method " + iTestContext.getName());
        //Do tier down operations for extentreports reporting!
 //       recordTest.releaseRecordingResources();
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
    }
 
    public void onTestStart(ITestResult iTestResult) {
        Log.info("I am on TestStart method " +  getTestMethodName(iTestResult) + " start");
        //Start operation for extentreports.
        //ExtentTestManager.
        Log.info("I am in onStart method " + iTestResult.getTestContext().getAttribute("testname"));
        DateFormat df = new SimpleDateFormat("yyyyMMdd-HHmm");
        Filename=iTestResult.getName()+ "-" + df.format(new Date());
//        recordTest.startRecording(Filename);
        
        ExtentTestManager.startTest(iTestResult.getTestContext().getSuite().getXmlSuite().getName().toString()+"-"+iTestResult.getTestContext().getCurrentXmlTest().getName().toString()+"-"+iTestResult.getTestContext().getAttribute("testName").toString(),"");
    }
 
    public void onTestSuccess(ITestResult iTestResult) {
        Log.info("I am on TestSuccess method " +  getTestMethodName(iTestResult) + " succeed");
        //Extentreports log operation for passed tests.
      ExtentTestManager.getTest().log(LogStatus.PASS, getTestMethodName(iTestResult)+" : Test Method has been passed");
      //ExtentTestManager.endTest();
 //     recordTest.stopRecording();
      ExtentManager.getReporter().flush();
    }
 
    public void onTestFailure(ITestResult iTestResult) {
       // Log.info("I am on TestFailure method " +  getTestMethodName(iTestResult) + " failed");
        //iTestResult.setStatus(0);
        //Get driver from BaseTest and assign to local webdriver variable.
    ExtentTestManager.getTest().log(LogStatus.FAIL, getTestMethodName(iTestResult)+" : Test Method has been Failed");
        Object testClass = iTestResult.getInstance();
        //iTestResult.setStatus(arg0);
        WebDriver webDriver = ((DriverTestcase) testClass).getwebdriver();
       
        //Take base64Screenshot screenshot.
        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)getwebdriver()).
                getScreenshotAs(OutputType.BASE64);
        String Message=iTestResult.getThrowable().getMessage() != null ? iTestResult.getThrowable().getMessage().toString() :
        	iTestResult.getThrowable().getCause().toString();
      
        //====================================
       //Full page screenshot
        String screenshot ="";
        try {
        	screenshot =	DriverHelper.Capturefullscreenshot(getwebdriver());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

        //===============================================================
        
        System.out.println("Result Messages"+Message);
        //Extentreports log and screenshot operations for failed tests.
        ExtentTestManager.getTest().log(LogStatus.FAIL,Message+
               /* ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot) +*/
                ExtentTestManager.getTest().addBase64ScreenShot(screenshot));
        
 //       String as =  recordTest.getFile(Filename);
 //       recordTest.stopRecording();
 //       ExtentTestManager.getTest().log(LogStatus.INFO,"<a href='" + as + " '><span class='label info'>DownLoad Video </span> </a>");
        ExtentManager.getReporter().flush();
    }
 
    public void onTestError(ITestResult iTestResult) {
        Log.info("I am on TestSuccess method " +  getTestMethodName(iTestResult) + " errored");
        //Extentreports log operation for passed tests.
        	ExtentTestManager.getTest().log(LogStatus.ERROR, getTestMethodName(iTestResult)+" : Test Method has been errored");
            Object testClass = iTestResult.getInstance();
            //iTestResult.setStatus(arg0);
            WebDriver webDriver = ((DriverTestcase) testClass).getwebdriver();
     
            //Take base64Screenshot screenshot.
            String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)getwebdriver()).
                    getScreenshotAs(OutputType.BASE64);
  //          recordTest.stopRecording();
            ExtentManager.getReporter().flush();
            //Extentreports log and screenshot operations for failed tests.
          //  ExtentTestManager.getTest().log(LogStatus.ERROR,"Test Errored",
           //         ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
    }

    public void onTestSkipped(ITestResult iTestResult) {
        Log.info("I am in onTestSkipped method "+  getTestMethodName(iTestResult) + " skipped");
        //Extentreports log operation for skipped tests.
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
 //       recordTest.stopRecording();
        ExtentManager.getReporter().flush();
    }
 
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Log.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
 //       recordTest.stopRecording();
        ExtentManager.getReporter().flush();
    }
 
}