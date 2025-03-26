package base;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.google.common.io.Files;
import utility.ExtentReport;

public class BaseClass {
	protected static WebDriver driver;
	static String url;
	public static void invokeBrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();	
		}else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}else {
			System.out.println("Invalid browser....");
		}
	}
	
	public static void screenshot() throws IOException {
		File src=null;
		src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File("./screenshot/"+"page-"+System.currentTimeMillis()+".png"));
	}
	
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
	
	@BeforeSuite
    public void clearAllureResults() {
    	String[] allurePaths = {"allure-results", "/allure-results/"};

        for (String path : allurePaths) {
            File allureResults = new File(path);
            if (allureResults.exists() && allureResults.isDirectory()) {
                for (File file : allureResults.listFiles()) {
                    file.delete();
                }
            }
        }
    }

    // Generate Allure Report after test execution (Runs in Background)
    @AfterSuite
    public void generateAllureReport() 
    {
        ExtentReport.getInstance().flush();; // Ensure Extent Reports are saved first
        
        try 
        {
            ProcessBuilder reportBuilder = new ProcessBuilder("cmd.exe", "/c", "mvn allure:report");
            reportBuilder.redirectErrorStream(true);
            Process reportProcess = reportBuilder.start();
            reportProcess.waitFor(); // Wait until report is generated

            String reportPath = System.getProperty("user.dir") + "/allure-results/";
            File reportDir = new File(reportPath);

            if (reportDir.exists() && reportDir.isDirectory()) 
            {
                System.out.println("Allure Report generated successfully in: " + reportPath);
            } 
            else 
            {
                System.out.println("Allure Report generation failed. Check Maven logs.");
            }

        } 
        catch (IOException | InterruptedException e) 
        {
            e.printStackTrace();
        }
    }

}
