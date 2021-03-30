package cucumber.ui.pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class UIPage {

    public static SelenideElement searchInput = $("#search-input");
    public static SelenideElement matchChekbox = $("#match-case");
    public static SelenideElement searchDropdown = $("#search-column");
    public static SelenideElement clearFilterButton = $("#clear-button");
    public static SelenideElement email = $("td:nth-child(3) > a.ng-binding");
    public static SelenideElement tableResume = $("#table-resume");
    public static SelenideElement emptySearch = $(By.xpath("//tbody[count(*)=0]"));


}
