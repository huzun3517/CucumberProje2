package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import pages.Project2Content;

import java.util.List;

public class NewPayeeSteps {

Project2Content project2Content = new Project2Content();

     @Then("^Click on the element in the Project content$")
    public void clickOnTheElementInTheProjectContent(DataTable elements) {

         List<String> elementsToClick = elements.asList(String.class);

         for (int i = 0; i < elementsToClick.size(); i++) {
             project2Content.findElementAndClickFunction(elementsToClick.get(i));
         }
    }

    @Then("^User sends the keys in the Project content class$")
    public void userSendsTheKeysInTheProjectContentClass(DataTable elements) {

        List<List<String>> elementsNameAndValue = elements.asLists(String.class);
        for (int i = 0; i < elementsNameAndValue.size(); i++) {
            project2Content.findElementAndSendKeysFunction(elementsNameAndValue.get(i).get(0), elementsNameAndValue.get(i).get(1));
        }
    }

    @Then("^Success message should be displayed \"([^\"]*)\"$")
    public void successMessageShouldBeDisplayed(String text)  {

        project2Content.findElementAndverifyElementContainsText("successMsg",text);
    }

}
