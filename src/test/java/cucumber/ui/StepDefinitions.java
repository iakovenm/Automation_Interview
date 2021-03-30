package cucumber.ui;

import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static cucumber.ui.pageObjects.UIPage.*;

public class StepDefinitions {

    @Before
    public static void openUIpage() {
        open("file:///C:/Users/iakov/Downloads/ui/index.html");
    }

    @After
    public void tearDown() throws IOException {
        screenshot();
    }

    @After
    public void clearUserInputs() {
        if (matchChekbox.isSelected()) {
            matchChekbox.click();
        }
        searchInput.clear();
    }


    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.takeScreenShotAsFile();
        return Files.toByteArray(screenshot);
    }

    @Given("^user has filter and search applied\"([^\"]*)\",\"([^\"]*)\"$")
    public static void addedSearchCondition(String search, String filter) {
        inputSearch(search);
        clickSearchFilter();
        selectSearchFilter(filter);
    }

    @When("^user inputs search\"([^\"]*)\"$")
    public static void inputSearch(String search) {
        searchInput.setValue(search);
    }

    @When("^user checks match checkbox$")
    public static void checkMatchCheckbox() {
        if (!matchChekbox.isSelected()) {
            matchChekbox.click();
        }
    }

    @When("^user clicks on clearFilter$")
    public static void clickClearFilter() {
        clearFilterButton.click();
    }

    @When("^user clicks on search filter$")
    public static void clickSearchFilter() {
        searchDropdown.click();
    }

    @When("^user selects to filter search result by\"([^\"]*)\"$")
    public static void selectSearchFilter(String filter) {
        $(By.xpath(String.format("//option[contains(text(),'%s')]", filter))).click();
    }

    @Then("^user asserts search is empty$")
    public static void CheckEmptySearch() {
        Assert.assertEquals(searchInput.getValue(), "");
    }

    @Then("^user asserts table resume to be\"([^\"]*)\"$")
    public static void assertTableResume(String resume) {
        Assert.assertEquals(tableResume.getText(), resume);
    }

    @Then("^user asserts search table column \"([^\"]*)\" has value\"([^\"]*)\"$")
    public static void assertSearch(String searchId, String searchValue) {
        $(String.format("td.ng-binding:nth-child(%s)", searchId)).shouldHave(text(searchValue));
    }

    @Then("^user asserts search email to be \"([^\"]*)\"$")
    public static void assertSearchEmail(String searchValue) {
        email.shouldHave(text(searchValue));
    }

    @Then("^user asserts search table is empty$")
    public static void assertSearchTableEmpty() {
        emptySearch.exists();
    }
}




