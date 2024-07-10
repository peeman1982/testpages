package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import support.WordsToNumberConverter;

import static support.DriverFactory.getDriver;

public class TestPagesStepDefs {
    @Given("I open url {string}")
    public void iOpenUrl(String page) {
        getDriver().get(page);
    }

    @When("I click on element with xpath {string}")
    public void iClickOnElementWithXpath(String element) {
        getDriver().findElement(By.xpath(element)).click();
    }

    @And("I wait for {int} sec")
    public void iWaitForSec(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

    @When("I accept alert")
    public void iClickOKOnAlert() {
        getDriver().switchTo().alert().accept();
    }

    @Then("I verify that alert accepted")
    public void iVerifyThatAlertAccepted() {
        String actualResult = getDriver().findElement(By.id("confirmreturn")).getText();
        Assertions.assertThat(actualResult).isEqualTo("true");
    }

    @And("I dismiss alert")
    public void iDismissAlert() {
        getDriver().switchTo().alert().dismiss();
    }

    @Then("I verify that alert dismissed")
    public void iVerifyThatAlertDismissed() {
        String actualResult = getDriver().findElement(By.id("confirmreturn")).getText();
        Assertions.assertThat(actualResult).isEqualTo("false");
    }

    @And("I enter {string} inside alert")
    public void iEnterInsideAlert(String text) {
        getDriver().switchTo().alert().sendKeys(text);
    }

    @Then("I verify entered text")
    public void iVerifyEnteredText() {
        String actualResult = getDriver().findElement(By.id("promptreturn")).getText();
        Assertions.assertThat(actualResult).isEqualTo("Test");
    }

    @Then("I verify the numbers entered presents on the page")
    public void iVerifyTheNumbersEnteredPresentsOnThePage() {
        String actualText = getDriver().findElement(By.id("message")).getText();
        String actualText1 = WordsToNumberConverter.runConverter(actualText);
        Assertions.assertThat(actualText1).isEqualTo(numberEnteredInField);
    }

    @And("I enter {int} in the search field")
    public void iEnterInTheSearchField(int number) {
        this.numberEnteredInField = Integer.toString(number);
        getDriver().findElement(By.id("numentry")).sendKeys(numberEnteredInField);
        getDriver().findElement(By.id("submit-to-server")).click();
    }
    private String numberEnteredInField;
}
