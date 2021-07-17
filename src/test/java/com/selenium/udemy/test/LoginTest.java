package com.selenium.udemy.test;

import com.selenium.udemy.base.BaseClass;
import com.selenium.udemy.pages.Login;
import com.selenium.udemy.utility.UdemyCustomListener;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Feature("Login to application")
@Listeners(UdemyCustomListener.class)
public class LoginTest extends BaseClass {

    public String email="diliprathod32@gmail.com";
    public String password="30Login@123";

    @Severity(SeverityLevel.CRITICAL)
    @Description("Login to application with valid credentials")
    @Story("Test login account ")
    @Test
    public void LoginToUdemyApplication() throws InterruptedException {
        Login login=new Login(driver);
        login.login(email,password);
        String expectedEmail="diliprathod32@gmail.com";
        Assert.assertEquals(email,expectedEmail);
    }

    @Test
    public void LogoutFromUdemyApplication() throws InterruptedException {
        Login login=new Login(driver);
        login.login(email,password);
        login.applicationLogout();

    }
}
