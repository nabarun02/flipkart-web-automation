package demo.wrappers;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
    public void navigateToSite(){

        if(!driver.getCurrentUrl().equals(siteUrl)){
            
            driver.get(siteUrl);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // waiting max 10 seconds for the page to load. 
            wait.until(d -> ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete")); 

        }

    }

    // method for entering text by xpath
    public void enterTextByXpathSubmit(String xPath, String text, boolean hitEnter){

        try{

            WebElement textArea = driver.findElement(By.xpath(xPath));
            
            textArea.click();

            Thread.sleep(300); // for the element to come in focus
            
            textArea.clear();
            textArea.sendKeys(text);

            //Hit enter if submit is needed
            if(hitEnter){                          
                textArea.sendKeys(Keys.ENTER); 
            }
    
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

    //method to get element count
    public int getElCount(String xPath){

        try{
            
            List<WebElement> els = driver.findElements(By.xpath(xPath));

            return els.size();

        }

        catch(Exception e){

            System.out.println("Failed to fetch the elements count: " + e.getMessage());
            
            return -1;

        }

    }

    //method to get element titles with discount above the given discount
    public List<String> getTitlesFromDiscountXpath(String xPath, int discount){

        try{

            List<WebElement> discountEls = driver.findElements(By.xpath(xPath));
            List<String> titles = new ArrayList<>();

            WebElement titleEl;
            String titleText = "";

            //traversing all the dicounts
            for(WebElement discountEl : discountEls){

                String discountValue = discountEl.getText().trim().replaceAll("[^0-9]",""); //removing the extra characters from the text
                int discountValueInt = Integer.parseInt(discountValue);

                if(discountValueInt > discount){

                    titleEl = discountEl.findElement(By.xpath("./ancestor::div[contains(@class, 'yKfJKb')]//div[contains(@class, 'KzDlHZ')]"));
                    titleText = titleEl.getText().trim();

                    titles.add(titleText);

                }

            }

            return titles;

        }

        catch(Exception e){
            
            System.out.println("Failed to fetch the titles: " + e.getMessage());

            return new ArrayList<>();

        }

    }

    //method to get the title and image url of top 5 products
    public List<AbstractMap.SimpleEntry<String, String>> getTopProductsTitleImageUrl(String xPath){

        try{

            List<WebElement> views = driver.findElements(By.xpath(xPath)); //getting the view Element

            Set<Integer> viewSet = new HashSet<>();
            
            Map<Integer, WebElement> viewMap = new HashMap<>();

            String viewCountText = "";

            int i, viewCount;

            //mapping the view count with the element 
            for(WebElement view : views){

                viewCountText = view.getText().trim().replaceAll("[^0-9]", "");
                viewCount = Integer.parseInt(viewCountText);

                viewSet.add(viewCount); //adding in set to remove duplicates

                viewMap.put(viewCount, view);  //mapping view count and the element

            }

            List<Integer> viewList = new ArrayList<>(viewSet);

            Collections.sort(viewList, Collections.reverseOrder());

            WebElement viewEl, titleEl, imageUrlEl;

            List<AbstractMap.SimpleEntry<String, String>> titleImageUrl = new ArrayList<>();   //used to store the final result i.e., title and image url

            //get the details of top 5 products
            for(i = 0; i < 5; i++){

                viewEl = viewMap.get(viewList.get(i));

                imageUrlEl = viewEl.findElement(By.xpath("./ancestor::div[contains(@class, 'slAVV4')]//img[contains(@class, 'DByuf4')]"));

                titleEl = viewEl.findElement(By.xpath("./ancestor::div[contains(@class, 'slAVV4')]//a[contains(@class, 'wjcEIp')]"));

                titleImageUrl.add(new AbstractMap.SimpleEntry<>(titleEl.getText().trim(), imageUrlEl.getAttribute("src")));
                
            }

            return titleImageUrl;

        }

        catch(Exception e){

            System.out.println("Failed to fetch titles and image urls: " + e.getMessage());

            return new ArrayList<>();

        }

        
    } 
    
}
