package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class _Parent {

    WebDriver driver;
    WebDriverWait wait;

    public _Parent(){
        /**
         * Bu dosya diğer bütün page ler için ortak click ve sendkeys
         * için nekleme, scroll ve clear gibi bütün işleleri tek yereden
         * yapabilmek için eklendi.Bu class diğer pageler tarafından exten edilerek
         * kullanılacak.Böylece tüm pagelerdeki elemanların click ve sendkeys özelliği
         * hem bekleme hem scroll hem de clear özelliği kazanmış olacak.
         */

        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, 20);
    }

    public void waitUntilClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void waiting(int ms)
    {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<WebElement> waitVisibleListAllElement(List<WebElement> elementList){
        wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
        return elementList;
    }

    public void clickFunction(WebElement element){
        waitUntilVisible(element);
        waitUntilClickable(element);// eleman clickable olana kadar bekle
        //scrollToElement(element);// elemana kadar scroll yap
        element.click();// click yap
    }

    public void sendKeysFunction(WebElement element, String value){
        waitUntilVisible(element);// eleman gorunuzr olana kadar bekle
        //scrollToElement(element);// elemana kadar scroll yap
        element.clear();// elemani clear yap
        element.sendKeys(value);// value yi gonder
    }

    public void verifyElementContainsText(WebElement element, String expectedText){
        waitUntilVisible(element);
        //wait.until(ExpectedConditions.textToBePresentInElement(element,expectedText));
        scrollToElement(element);
        String actualText = element.getText();
        System.out.println(expectedText);
        System.out.println(actualText);
        Assert.assertTrue(actualText.toLowerCase().contains(expectedText.toLowerCase()));
    }

    public void selectMetod(WebElement myElement, String text){
        if(text.isEmpty()) text="-- Choose --";
        Select select = new Select(myElement);
        select.selectByVisibleText(text);
    }

    public void selectMetodByIndex(WebElement myElement, int index){
        Select select = new Select(myElement);
        select.selectByIndex(index);
    }

    public void selectMetodByValue(WebElement myElement, String value){
        Select select = new Select(myElement);
        select.selectByValue(value);
    }

    public double stringToDouble(WebElement myElement){
        return Double.parseDouble(myElement.getText().replaceAll("[^0-9.]", ""));
    }

    public List<String> elementListToTextList(List<WebElement> elementList){
        List<String> textList = new ArrayList<>();
        for (WebElement el : elementList) {
            textList.add(el.getText());
        }
        return textList;
    }


}
