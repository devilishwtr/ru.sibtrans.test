package ru.sibtrans.main.access;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public final class AccessPage {

    public static final By FIELD_LOGIN = By.name("USER_LOGIN");
    private static final By FIELD_PASSWORD = By.name("USER_PASSWORD");
    private static final By BUTTON_ENTER = By.name("Login");

    public static void enterLogin() {
        $(FIELD_LOGIN).setValue("kochmarevk");
    }

    public static void enterPassword() {
        $(FIELD_PASSWORD).setValue("Ahsu9k");
    }

    public static void clickLogIn() {
        $(BUTTON_ENTER).click();
    }

    public static void pressEnter() {
        $(BUTTON_ENTER).pressEnter();
    }

    public static void enterIncorrectLogin() {
        $(FIELD_LOGIN).setValue("sdsds12312");
    }

    public static void enterIncorrectPassword() {
        $(FIELD_PASSWORD).setValue("sdsadsa112@@!#");
    }

    public static void enterHomePage() {
        enterLogin();
        enterPassword();
        pressEnter();
    }
}
