package hooks;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utility.ExtentReport;

public class Hook extends BaseClass{
	
	 @Before
	    public void setUp() 
	    {
	        ExtentReport.getInstance();  // Initialize Extent Report
	        invokeBrowser("chrome");     // Launch Browser
	    }

	    @After
	    public void tearDown() throws InterruptedException 
	    {
	        closeBrowser();      // Close Browser
	        ExtentReport.getInstance().flush(); // Flush Extent Report
	    }

}
