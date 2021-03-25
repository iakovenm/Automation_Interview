package ui.selenide;

import org.junit.Test;

import static ui.selenide.pageObjects.UIPage.*;

public class UITests extends BaseTest {


    @Test
    public void testSearchWithoutMatch() {
        assertTableResume("Showing 3 of 3 customers");
        clickAndSelectSearchFilter("Id");
        inputSearch("1");
        assertSearch("1", "1");
        clickAndSelectSearchFilter("Name");
        inputSearch("alabaster");
        assertSearch("2", "Alabaster");
        clickAndSelectSearchFilter("City");
        inputSearch("melbourne");
        assertSearch("4", "Melbourne");
        clickAndSelectSearchFilter("Email");
        inputSearch("Conatact@postimex.pl");
        assertSearchEmail("conatact@postimex.pl");
        assertTableResume("Showing 1 of 3 customers");
    }

    @Test
    public void testSearchWithMatch() {
        checkMatchCheckbox();
        clickAndSelectSearchFilter("Id");
        inputSearch("3");
        assertSearch("1", "3");
        clickAndSelectSearchFilter("Name");
        inputSearch("Alabaster");
        assertSearch("2", "Alabaster");
        clickAndSelectSearchFilter("City");
        inputSearch("Melbourne");
        assertSearch("4", "Melbourne");
        clickAndSelectSearchFilter("Email");
        inputSearch("info@bond.ir");
        assertSearchEmail("info@bond.ir");
        assertTableResume("Showing 1 of 3 customers");
        clickAndCheckClearFilter();
        assertTableResume("Showing 3 of 3 customers");
    }

    @Test
    public void testNoSearchOutput() {
        assertTableResume("Showing 3 of 3 customers");
        clickAndSelectSearchFilter("Id");
        inputSearch("12");
        assertTableResume("Showing 0 of 3 customers");
        checkMatchCheckbox();
        clickAndSelectSearchFilter("City");
        inputSearch("melbourne");
        assertTableResume("Showing 0 of 3 customers");

    }


}

