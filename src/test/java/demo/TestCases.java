package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;


// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    
    ChromeDriver driver;

    Wrappers wrapper;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */


    //test case to fetch the product count with rating more than 4
    @Test
    public void testCase01() throws InterruptedException{

        wrapper.navigateToSite();  //navigating to flipkart

        Thread.sleep(5000); //pausing the execution to dismiss the login pop-up manually for now in future it can also be automated

        wrapper.enterTextByXpathSubmit("//input[contains(@class, 'Pke_EE')]", "Washing Machine", true);  //searching for washing machine

        wrapper.clickElementByXpath("//div[contains(@class, 'sHCOk2')]//div[normalize-space(text()) = 'Popularity']"); //sorting by popularity

        int productCount = wrapper.getElCount("//span[contains(@id, 'productRating')]//div[number(.) > 4]"); //fetching the product count with rating more than 4

        System.out.println("Washing Machines with rating more than 4: " + productCount);

    }

    //test case to fetch the iPhone titles with discount more than 17
    @Test
    public void testCase02() throws InterruptedException{

        wrapper.navigateToSite();  //navigating to flipkart

        Thread.sleep(5000); //pausing the execution to dismiss the login pop-up manually for now in future it can also be automated

        wrapper.enterTextByXpathSubmit("//input[contains(@class, 'Pke_EE')]", "iPhone", true);  //searching for iPhone

        List<String> titles = wrapper.getTitlesFromDiscountXpath("//div[contains(@class, 'yKfJKb')]//div[contains(@class, 'UkUFwK')]", 17); //getting iphone titles with discount more than 17%

        //printing the titles if any
        if(!titles.isEmpty()){

            System.out.println("iPhone titles with dicount more than 17% : ");
           
            for(String title : titles){

                System.out.println(title);
            
            }

        }

        else{

            System.out.println("There are no iPhones with discount more than 17%.");

        }

    }

    //testcase to fetch the title and image url of top 5 coffee mugs 
    @Test
    public void testCase03() throws InterruptedException{

        wrapper.navigateToSite();  //navigating to flipkart

        Thread.sleep(5000); //pausing the execution to dismiss the login pop-up manually for now in future it can also be automated

        wrapper.enterTextByXpathSubmit("//input[contains(@class, 'Pke_EE')]", "Coffee Mug", true);  //searching for coffee mug

        List<AbstractMap.SimpleEntry<String, String>> titleImageUrls = wrapper.getTopProductsTitleImageUrl("//span[contains(@class, 'Wphh3N')]"); //getting the title and image url

        //printing the title and image url of top five mugs if any
        if(!titleImageUrls.isEmpty()){

            for(AbstractMap.SimpleEntry<String, String> titleImageUrl : titleImageUrls){

                System.out.println(titleImageUrl.getKey() + ": " + titleImageUrl.getValue());

            }

        }

        else{

            System.out.println("There are no coffee mugs.");

        }

    }

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        wrapper = new Wrappers(driver);

    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}