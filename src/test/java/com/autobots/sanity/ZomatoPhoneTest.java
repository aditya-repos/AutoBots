package com.autobots.sanity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class ZomatoPhoneTest {
    private WebDriver driver;

    @BeforeMethod
    public void createDriver(){
        System.setProperty("webdriver.chrome.driver","/Users/agaurav/IdeaProjects/AutoBots/src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void capturePhoneNumber(){
        String host = "https://www.zomato.com/hyderabad";
        driver.get(host);
        driver.findElement(By.xpath("//a[contains(@class,'column')]/div[text()='Delivery']")).click();
        System.out.println("Delivery clicked");
        System.out.println("Phone");
        try{
            Thread.sleep(5000);
            driver.findElement(By.xpath("(//a[contains(@class,'item res-snippet-ph-info')])[1]/span")).click();
        }catch (NoSuchElementException | InterruptedException ex){
            System.out.println("Exception occurred");
            driver.findElement(By.xpath("(//a[contains(@class,'item res-snippet-ph-info')])[1]/span")).click();
        }
        String number = driver.findElement(By.xpath("//div[@id='modal-container']/div[@class='content']/div/div/span")).getAttribute("innerHTML");
        System.out.println(number);
    }

    @AfterMethod
    public void tearDown(){

    }
}
