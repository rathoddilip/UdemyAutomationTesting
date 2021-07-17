package com.selenium.udemy.pages;

import com.selenium.udemy.base.BaseClass;
import com.selenium.udemy.utility.LogClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends BaseClass {

    //web elements are declared and FindBy annotation is used to find web elements by using locators
    @FindBy(linkText = "Log in")
    WebElement loginLink;
    @FindBy(name = "email")
    WebElement email;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(xpath = "//INPUT[@id='submit-id-submit']")
    WebElement login;
    @FindBy(xpath = "//a[@aria-label='My profile']")
    WebElement myProfile;
    @FindBy(xpath = "//div[contains(text(),'Log out')]")
    WebElement logOut;

    //parameterized constructor is used
    public Login(WebDriver driver) {
        PageFactory.initElements(driver, this); //initElements method is used to initialize web elements
    }

    public void login(String emailId, String passwd) throws InterruptedException {
        LogClass.info("Clicking on login link button ");
        loginLink.click();
        Thread.sleep(2000);
        LogClass.info("Entering email id");
        email.sendKeys(emailId);
        LogClass.info("Entering password");
        password.sendKeys(passwd);
        LogClass.info("Clicking on login button");
        login.click();
        Thread.sleep(2000);
    }
    public void applicationLogout() throws InterruptedException {
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.moveToElement(myProfile).perform();
        Thread.sleep(1000);
        actions.moveToElement(logOut).build().perform();
        Thread.sleep(1000);
        logOut.click();
        Thread.sleep(2000);
    }
}
