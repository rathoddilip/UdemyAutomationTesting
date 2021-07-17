package com.selenium.udemy.base;

import com.selenium.udemy.utility.LogClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class BaseClass {

    public static WebDriver driver;
    URL url;
    URLConnection connection;

    //execute before test
    @BeforeTest()
    public void setUp() throws InterruptedException {

        LogClass.info("******************************* Starting test cases ****************************************");
        //handle browser level show notification pop window
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        LogClass.info("launching the Chrome browser");
        driver = new ChromeDriver(options);

        try {
            url = new URL("https://www.udemy.com/");
            connection = url.openConnection();
            connection.connect();
            LogClass.info("Internet is connected");
        } catch (IOException e) {
            e.printStackTrace();
            LogClass.info("Internet is not connected");
        }
        LogClass.info("Navigate to url udemy: https://www.udemy.com/ ");
        driver.get("https://www.udemy.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.udemy.com/";
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    //execute after test
    @AfterMethod
    public void tearDown() {
        LogClass.info("******************************* End Test Cases ****************************************");
        driver.quit();
    }
}
