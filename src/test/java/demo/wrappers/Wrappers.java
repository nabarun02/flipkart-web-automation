package demo.wrappers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wrappers {

    ChromeDriver driver;

    String siteUrl = "https://www.flipkart.com/";

    public Wrappers(ChromeDriver driver){
        this.driver = driver;
    }

    // method for navigating to the flipkart site
    public void navigateToForm(){

        if(!driver.getCurrentUrl().equals(siteUrl)){
            
            driver.get(siteUrl);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // waiting max 10 seconds for the page to load. 
            wait.until(d -> ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete")); 

        }

    }

    // method for entering text by xpath
    public void enterTextByXpath(String xPath, String text){

        try{

            WebElement textArea = driver.findElement(By.xpath(xPath));
            
            textArea.click();

            Thread.sleep(300); // for the element to come in focus
            
            textArea.clear();
            textArea.sendKeys(text);
    
        }

        catch(Exception e){
            System.out.println("Failed to enter text: " + e.getMessage());
        }

    }

    // method for clicking on a particular element by xpath
    public void clickElementByXpath(String xPath){

        try{
            driver.findElement(By.xpath(xPath)).click();
        }

        catch(Exception e){
            System.out.println("Failed to click on element: "+ e.getMessage());
        }

    }
    
}
