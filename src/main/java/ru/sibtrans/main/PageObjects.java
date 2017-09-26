package ru.sibtrans.main;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public abstract class PageObjects {
    public static final By BTK_LOGO = By.className("link-logo");
    public static final By PHONE_NUMBER = By.className("phone");
    public static final By CALL_BACK = By.cssSelector("body > header > div.line2 > div > div.c > div.comm > p:nth-child(2) > a");
    public static final By FEEDBACK = By.cssSelector("body > header > div.line2 > div > div.c > div.comm > p:nth-child(3) > a");
    public static final By CITY_FA_CARET_DOWN = By.cssSelector("#s_city > i");
    public static final By MAIN_CITY = By.cssSelector("#s_city");
    public static final By ADDRESS_OF_TERMINALS = By.cssSelector("#term_ad_link");
    public static final By NUMBER_OF_TERMINALS = By.cssSelector("#term_ad_link > span");
    public static final By OUR_NEWS = By.cssSelector("#news_link > a");
    public static final By SERVICES = By.cssSelector("body > header > div.line2 > div > div.r > a:nth-child(1) > img");
    public static final By COST_CALCULATE = By.cssSelector("body > header > div.line2 > div > div.r > a:nth-child(2) > img");
    public static final By SEND_REQUEST = By.cssSelector("body > header > div.line2 > div > div.r > a:nth-child(3) > img");
    public static final By PERSONAL_ACCAUNT = By.cssSelector("#lch");
    public static final By CURRENCY_USD = By.className("currency_usd");
    public static final By CURRENCY_EUR = By.className("currency_eur");
    public static final By CURRENCY_CNY = By.className("currency_cny");

    public static void BtkLogoClick() {
        $(BTK_LOGO).click();
    }

    public static void CallBackLinkClick() {
        $(CALL_BACK).click();
    }

    public static void FeedbackLinkClick() {
        $(FEEDBACK).click();
    }

    public static void ServicesButtonClick() {
        $(SERVICES).click();
    }

    public static void CostCalculateButtonClick() {
        $(COST_CALCULATE).click();
    }

    public static void SendRequestClick() {

    }


}
