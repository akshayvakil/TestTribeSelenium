package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class UrlOpenRetryListner {


	public WebDriver driver;
	public String baseUrl = "https://qa-.netlify.app/bugs-form.html"; //url deliberately changed

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        // Set the path to the chromedriver executable
     //   System.setProperty("webdriver.chrome.driver", "D:\\Users\\AKSHAY\\new-eclipse-workspace\\TestAkshaySeleniumProject\\driver\\chromedriver_win32\\chromedriver.exe");

        // Initialize ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("@BeforeMethod");
    }

   
    @Test(groups = {"Smoke"})
    public void openUrlTest() throws InterruptedException {
        // Open the URL
        driver.get(baseUrl);
Thread.sleep(5000);
        // Check if the page title contains the expected text
        String expectedTitle = "QA Practice | Learn with RV";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        System.out.println("TC1");
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Page title does not match.");

        // You can add more assertions or actions as needed for your specific scenario
    }

    @Test(groups = {"Sanity"})
    public void checkTitle() throws InterruptedException {
        // Open the URL
        driver.get(baseUrl);
Thread.sleep(5000);
        // Check if the page title contains the expected text
        String expectedTitle = "QA Practice | Learn with RV";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        System.out.println("TC2 Sanity Group");
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Page title does not match.");

        // You can add more assertions or actions as needed for your specific scenario
    }
    
    @Test(groups = {"Sanity"})
    public void testTestNG() {
    	
    	System.out.println("NEw method to check tesng groups");
    }
    
    @AfterMethod (alwaysRun = true)
    public void tearDown() {
        // Close the browser
    	 System.out.println("@AfterMethod");
        if (driver != null) {
            driver.quit();
        }
    }
}
