package ru.sibtrans.main.maxicalculator;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.sibtrans.main.PageObjects;;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static ru.sibtrans.main.Cities.flowBracnhesFrom;
import static ru.sibtrans.main.Cities.flowBracnhesTo;

public class CalculatorMaxiObject extends PageObjects {

    public SelenideElement CITY_FROM_FIELD = $("#city_from_List > input[type=\"text\"]");
    public SelenideElement CITY_TO_FIELD = $("#city_to_List > input[type=\"text\"]");
    public SelenideElement DELIVERY_OUT_CHECKBOX = $("#BOXDeliveryOut_Id");
    public SelenideElement DELIVERY_IN_CHECKBOX = $("#BOXDeliveryIn_Id");
    public SelenideElement BOX_WEIGHT = $("#weight");
    public SelenideElement BOX_VOLUME = $("#volume");
    public SelenideElement THERMAL = $("#MarkUp1");
    public SelenideElement OVERSIZED = $("#MarkUp2");
    public SelenideElement FRAGILE = $("#MarkUp4");
    public SelenideElement ADD_SERVICE_CITY_FROM = $("#chBoxAddServiseDelivOut_Id");
    public SelenideElement SERVICE_FROM_STRETCHPLENKA = $("#\\31 21");
    public SelenideElement SERVICE_FROM_POLI_MESHOK_SHTUK = $$("#\\31 22").find(Condition.name("chBoxServiceDelivOut"));
    public SelenideElement POLI_MESHOK_SHTUK_FIELD = $("#content_p > div > div.d2l > div > div:nth-child(9) > input");
    public SelenideElement SERVICE_FROM_PALLETIROVANIE = $$("#\\31 23").find(Condition.name("chBoxServiceDelivOut"));
    public SelenideElement SERVICE_FROM_MARKIROVKA_SHTUK = $$("#\\31 24").find(Condition.name("chBoxServiceDelivOut"));
    public SelenideElement MARKIROVKA_SHTUK_FIELD = $("#content_p > div > div.d2l > div > div:nth-child(19) > input");
    public SelenideElement SERVICE_FROM_KONSOLIDACIYA = $$("#\\31 25").find(Condition.name("chBoxServiceDelivOut"));
    public SelenideElement SERVICE_FROM_HRANENIE_DAYS = $$("#\\31 26").find(Condition.name("chBoxServiceDelivOut"));
    public SelenideElement HRANENIE_DAYS_FIELD = $("#content_p > div > div.d2l > div > div:nth-child(31) > input");
    public SelenideElement SERVICE_FROM_POGRUZ_RABOTA = $$("#\\31 28").find(Condition.name("chBoxServiceDelivOut"));
    public SelenideElement SERVICE_FROM_OBRESHETKA = $("#\\31 29");
    public SelenideElement SERVICE_FROM_DOCUMENTS_SHTUK = $$("#\\31 30").find(Condition.name("chBoxServiceDelivOut"));
    public SelenideElement DOCUMENTS_SHTUK_FIELD = $("#content_p > div > div.d2l > div > div:nth-child(50) > input");
    public SelenideElement SERVICE_FROM_SKLAD = $$("#\\31 31").find(Condition.name("chBoxServiceDelivOut"));
    public SelenideElement SERVICE_FROM_PRIEM_GRUZA = $$("#\\31 32").find(Condition.name("chBoxServiceDelivOut"));
    public SelenideElement SERVICE_FROM_RASTENTOVKA_SHTUK = $$("#\\31 36").find(Condition.name("chBoxServiceDelivOut"));
    public SelenideElement RASTENTOVKA_SHTUK_FIELD = $("#content_p > div > div.d2l > div > div:nth-child(69) > input");
    public SelenideElement SERVICE_FROM_TERMINAL_SHTUK = $$("#\\31 41").find(Condition.name("chBoxServiceDelivOut"));
    public SelenideElement TERMINAL_SHTUK_FIELD = $("#content_p > div > div.d2l > div > div:nth-child(74) > input");

    //Дополнительный сервис для пункта назначения
    public SelenideElement ADD_SERVICE_CITY_TO = $("#chBoxAddServiseDelivIn_Id");
    public SelenideElement SERVICE_TO_STRETCHPLENKA = $$("#\\31 21").find(Condition.name("chBoxServiceDelivIn"));
    public SelenideElement SERVICE_TO_POLI_MESHOK_SHTUK = $$("#\\31 22").find(Condition.name("chBoxServiceDelivIn"));
    public SelenideElement POLI_MESHOK_SHTUK_FIELD_TO = $("#content_p > div > div.d2r > div > div:nth-child(9) > input");
    public SelenideElement SERVICE_TO_PALLETIROVANIE = $$("#\\31 23").find(Condition.name("chBoxServiceDelivIn"));
    public SelenideElement SERVICE_TO_MARKIROVKA_SHTUK = $$("#\\31 24").find(Condition.name("chBoxServiceDelivIn"));
    public SelenideElement MARKIROVKA_SHTUK_FIELD_TO = $("#content_p > div > div.d2r > div > div:nth-child(19) > input");
    public SelenideElement SERVICE_TO_KONSOLIDACIYA = $$("#\\31 25").find(Condition.name("chBoxServiceDelivIn"));
    public SelenideElement SERVICE_TO_HRANENIE_DAYS = $$("#\\31 26").find(Condition.name("chBoxServiceDelivIn"));
    public SelenideElement HRANENIE_SHTUK_FIELD_TO = $("#content_p > div > div.d2r > div > div:nth-child(31) > input");
    public SelenideElement SERVICE_TO_POGRUZ_RABOTA = $$("#\\31 28").find(Condition.name("chBoxServiceDelivIn"));
    public SelenideElement SERVICE_TO_OBRESHETKA = $$("#\\31 29").find(Condition.name("chBoxServiceDelivIn"));
    public SelenideElement SERVICE_TO_DOCUMENTS_SHTUK = $$("#\\31 30").find(Condition.name("chBoxServiceDelivIn"));
    public SelenideElement DOCUMENTS_SHTUK_FIELD_TO = $("#content_p > div > div.d2r > div > div:nth-child(50) > input");
    public SelenideElement SERVICE_TO_SKLAD = $$("#\\31 31").find(Condition.name("chBoxServiceDelivIn"));
    public SelenideElement SERVICE_TO_PRIEM_GRUZA = $$("#\\31 32").find(Condition.name("chBoxServiceDelivIn"));
    public SelenideElement SERVICE_TO_RASTENTOVKA_SHTUK = $("#\\31 36");
    public SelenideElement RASTENTOVKA_SHTUK_FIELD_TO = $("#content_p > div > div.d2r > div > div:nth-child(69) > input");
    public SelenideElement SERVICE_TO_TERMINAL_SHTUK = $$("#\\31 41").find(Condition.name("chBoxServiceDelivIn"));
    public SelenideElement TERMINAL_SHTUK_FIELD_TO = $("#content_p > div > div.d2r > div > div:nth-child(74) > input");
    public SelenideElement COST = $("#content_cal > tr > td:nth-child(3)");
    public SelenideElement SUBMIT_BUTTON = $("#form-calk > div:nth-child(12) > button");
    public SelenideElement RESULT = $("#content_cal");

    public CalculatorMaxiObject() {
    }

    public void PRESS_ENTER() {
        RESULT.pressEnter();
    }

    public void SUBMIT_BUTTON_CLICK() throws InterruptedException {
        SUBMIT_BUTTON.click();
        Thread.sleep(1000);
    }

    //Сообщение об ощибке
    public static Condition errorMessage = Condition.exactText("");

    //Города - филиалы
    public static String branchFrom = "Омск";
    public static String branchTo = "Кемерово";
    // TODO: 9/25/2017 доделать выборку городов
    //

    //Города - рег.пункты
    public static String regionalFrom = "Абакан";
    public static String regionalTo = "Большеречье";

    //Выбор города
    public void CITY_FROM_BRANCH_ENTER() throws IOException {
        CITY_FROM_FIELD.val(flowBracnhesFrom()).pressEnter();
    }

    public void CITY_TO_BRANCH_ENTER() throws IOException {
        CITY_TO_FIELD.val(flowBracnhesTo()).pressEnter();
    }

    //Ввод ВОХ
    public void BOX_WEIGHT_ENTER() {
        BOX_WEIGHT.val(String.valueOf(kgRnd()));
    }

    public void BOX_VOLUME_ENTER() {
        BOX_VOLUME.val(String.valueOf(m3Rnd()));
    }


    //Рандомные числа в допустимом диапозоне
    private static double m3Rnd() {
        final double min = 0.1; // Минимальное число для диапазона
        final double max = 40; // Максимальное число для диапазона
        final double rnd = rndDouble(min, max);
        return rnd;
    }

    private static int kgRnd() {
        final int min = 1; // Минимальное число для диапазона
        final int max = 10000; // Максимальное число для диапазона
        final int rnd = rndInt(min, max);
        return rnd;
    }

    public static int flowFrom() {
        final int min = 0; // Минимальное число для диапазона
        final int max = 1; // Максимальное число для диапазона
        final int rnd = rndInt(min, max);
        return rnd;
    }

    public static int flowTo() {
        final int min = 0; // Минимальное число для диапазона
        final int max = 15; // Максимальное число для диапазона
        final int rnd = rndInt(min, max);
        return rnd;
    }

    private static int rndInt(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    private static double rndDouble(double min, double max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}