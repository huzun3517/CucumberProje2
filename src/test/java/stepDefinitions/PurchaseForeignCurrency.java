package stepDefinitions;

import cucumber.api.java.en.Then;
import pages.Project2Content;

public class PurchaseForeignCurrency {
    Project2Content project2Content = new Project2Content();

    @Then("^User select \"([^\"]*)\"$")
    public void userSelect(String currency)  {
        project2Content.findElementAndSelectMenu("currencySelectMenu", currency);
    }

    @Then("^Success message should be displayed$")
    public void successMessageShouldBeDisplayed() {
        project2Content.findElementAndverifyElementContainsText("successMsg", "successfully");
    }


}
