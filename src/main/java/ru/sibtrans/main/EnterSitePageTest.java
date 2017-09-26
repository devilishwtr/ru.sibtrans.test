package ru.sibtrans.main;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selenide.$;
import static ru.sibtrans.main.PageObjects.BTK_LOGO;
import static ru.sibtrans.main.access.AccessPage.*;

@DisplayName("Вход на сайт")
class EnterSitePageTest {

    @DisplayName("Войти, кликнув кнопку 'Войти'")
    void enterDataClickLogIn(){
        enterLogin();
        enterPassword();
        clickLogIn();
        $(FIELD_LOGIN).shouldNotBe(Condition.visible);
    }


    @DisplayName("Войти, нажав на 'ENTER' ")
    void enterDataPressEnter(){
        enterLogin();
        enterPassword();
        pressEnter();
        $(FIELD_LOGIN).shouldNotBe(Condition.visible);
    }

    @DisplayName("Войти, указав некоректные логин")
    void enterIncorrectLoginClickLogIn() {
        enterIncorrectLogin();
        enterIncorrectPassword();
        clickLogIn();
        $(BTK_LOGO).shouldNotHave();
    }

    @DisplayName("Вход, указав некорентый пароль")
    void enterIncorrectPasswordPressEnter() {
        enterLogin();
        enterIncorrectPassword();
        pressEnter();
        $(FIELD_LOGIN).shouldBe(Condition.visible);
    }

    @DisplayName("Вход, указав некоректные данные")
    void enterIncorrectPassAndLoginPressEnter() {
        enterIncorrectLogin();
        enterIncorrectPassword();
        pressEnter();
        $(FIELD_LOGIN).shouldBe(Condition.visible);
    }

}
