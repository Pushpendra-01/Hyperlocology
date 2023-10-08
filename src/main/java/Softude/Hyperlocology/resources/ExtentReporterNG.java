package Softude.Hyperlocology.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG {

	public static ExtentReports getExtentReportObject() {
		String path=System.getProperty("user.dir")+"//Reports//"+"index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Hyperlocolgy Report");
		reporter.config().setReportName("Hyperlocology Automation Report");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA","Pushpendra Singh");
		return extent;
	}
}
