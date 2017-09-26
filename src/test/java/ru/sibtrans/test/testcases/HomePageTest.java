package ru.sibtrans.test.testcases;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import static ru.sibtrans.main.PageObjects.BtkLogoClick;
import static ru.sibtrans.main.PageObjects.CostCalculateButtonClick;
import static ru.sibtrans.main.Settings.openVia;
import static ru.sibtrans.main.access.AccessPage.enterHomePage;

class HomePageTest {
    @BeforeAll
    static void setUp() {
        openVia();
        enterHomePage();
    }

    void GoBackToHomePageTest(){
        CostCalculateButtonClick();
        BtkLogoClick();
        Assertions.assertEquals("http://btk.karavaykin.ru/", WebDriverRunner.url());
    }
}
