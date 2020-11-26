package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.Project2Content;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class LoginSteps {

    WebDriver driver;

    Project2Content project2Content= new Project2Content();


    @Given("^Navigate to zero\\.webappsecurity$")
    public void navigateToZeroWebappsecurity() {
        driver = Driver.getDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS );
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS );

        driver.get("http://zero.webappsecurity.com/login.html");

        driver.manage().deleteAllCookies();

    }

    @When("^Enter username and password and click Sign in button$")
    public void enterUsernameAndPasswordAndClickSignInButton() {
        project2Content.findElementAndSendKeysFunction("username", "username");
        project2Content.findElementAndSendKeysFunction("password", "password");
        project2Content.findElementAndClickFunction("signInBtn");
    }
}
