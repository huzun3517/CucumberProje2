package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver(){

        if(driver==null){
            WebDriverManager.chromedriver().setup(); // SystemProperty nin karsiligi
            driver=new ChromeDriver();

//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();

//            WebDriverManager.edgedriver().setup();
//            driver = new EdgeDriver();
        }
        return driver;
    }

    public static void quitDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }

    }
}