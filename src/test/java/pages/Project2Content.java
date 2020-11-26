package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Project2Content extends _Parent {
    WebElement myElement;

    public Project2Content() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user_login")
    private WebElement username;

    @FindBy(id = "user_password")
    private WebElement password;

    @FindBy(css = "input[name='submit']")
    private WebElement signInBtn;

    @FindBy(css = "#pay_bills_tab")
    private WebElement payBills;

    @FindBy(xpath = "//a[text()='Add New Payee']")
    private WebElement addNewPayee;

    @FindBy(id = "np_new_payee_name")
    private WebElement payeeName;

    @FindBy(id = "np_new_payee_address")
    private WebElement payeeAddress;

    @FindBy(id = "np_new_payee_account")
    private WebElement account;

    @FindBy(id = "np_new_payee_details")
    private WebElement payeeDetails;

    @FindBy(id = "add_new_payee")
    private WebElement addBtn;

    @FindBy(xpath = "//a[text()='Purchase Foreign Currency']")
    private WebElement purchaseForeignCurrency;

    @FindBy(css="#pc_currency")
    private WebElement currencySelectMenu;

    @FindBy(css="#pc_amount")
    private WebElement amount;

    @FindBy(css="#pc_inDollars_true")
    private WebElement usdRdBtn;

    @FindBy(css="#pc_inDollars_false")
    private WebElement selectedCurrency;

    @FindBy(css="#purchase_cash")
    private WebElement puchaseBtn;

    @FindBy(css="#alert_content")
    private WebElement successMsg;

    @FindBy(xpath="(//h2[@class='board-header'])[2]")
    private WebElement errorMsg;


    public void findElementAndClickFunction(String elementName) {

        switch (elementName) {
            case "signInBtn": myElement = signInBtn; break;
            case "payBills": myElement = payBills; break;
            case "addNewPayee": myElement = addNewPayee; break;
            case "addBtn": myElement = addBtn; break;
            case "purchaseForeignCurrency": myElement = purchaseForeignCurrency; break;
            case "usdRdBtn": myElement = usdRdBtn; break;
            case "selectedCurrency": myElement = selectedCurrency; break;
            case "puchaseBtn": myElement = puchaseBtn; break;
        }
        clickFunction(myElement);
    }

    public void findElementAndSendKeysFunction(String elementName, String value) {
        switch (elementName) {
            case "username": myElement = username; break;
            case "password": myElement = password; break;
            case "payeeName": myElement = payeeName; break;
            case "payeeAddress": myElement = payeeAddress; break;
            case "account": myElement = account; break;
            case "payeeDetails": myElement = payeeDetails; break;
            case "amount": myElement = amount; break;
        }
        sendKeysFunction(myElement, value);
    }

    public void findElementAndSelectMenu(String elementName, String value){
        switch (elementName) {
            case "currencySelectMenu":myElement = currencySelectMenu;break;
        }
        selectMetodByValue(myElement, value);
    }

    public void findElementAndverifyElementContainsText(String elementName, String text){
        switch (elementName) {
            case "successMsg":myElement = successMsg;break;
        }
        //System.out.println(addNewPayee.getCssValue("color"));
        if(addNewPayee.getCssValue("color").contains("rgba(128, 128, 128, 1)")){myElement=errorMsg; text="Who are you paying?";}

        verifyElementContainsText(myElement, text);
    }



}



