package ui.selenide.pageObjects;


import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class UIPage {

    public static SelenideElement searchInput = $("#search-input");
    public static SelenideElement matchChekbox = $("#match-case");
    public static SelenideElement searchDropdown = $("#search-column");
    public static SelenideElement clearFilterButton = $("#clear-button");
    public static SelenideElement email = $("td:nth-child(3) > a.ng-binding");
    public static SelenideElement tableResume = $("#table-resume");


    public static void clickAndCheckClearFilter() {
        clearFilterButton.click();
        Assert.assertEquals(searchInput.getValue(), "");
    }

    public static void checkMatchCheckbox() {
        if (!matchChekbox.isSelected()) {
            matchChekbox.click();
        }
    }

    public static void assertTableResume(String resume) {
        Assert.assertEquals(tableResume.getText(), resume);
    }


    public static void inputSearch(String search) {
        searchInput.setValue(search);
    }

    public static void clickAndSelectSearchFilter(String filter) {
        searchDropdown.click();
        $(By.xpath(String.format("//option[contains(text(),'%s')]", filter))).click();

    }

    public static void assertSearch(String searchId, String searchValue) {
        $(String.format("td.ng-binding:nth-child(%s)", searchId)).shouldHave(text(searchValue));
    }

    public static void assertSearchEmail(String searchValue) {
        email.shouldHave(text(searchValue));
    }
}
