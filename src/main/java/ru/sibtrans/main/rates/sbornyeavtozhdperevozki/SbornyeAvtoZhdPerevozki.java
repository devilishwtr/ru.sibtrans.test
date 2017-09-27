package ru.sibtrans.main.rates.sbornyeavtozhdperevozki;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SbornyeAvtoZhdPerevozki {
    public SelenideElement CITY_FROM_FIELD = $("#city_from_List > input");
    public SelenideElement CITY_TO_FIELD = $("#city_to_List > input");
    public SelenideElement SUBMIT_BUTTON = $("#preiskurant > tbody > tr:nth-child(2) > td:nth-child(5) > button");
    public SelenideElement DELIVERY_OUT_CHECKBOX = $("#GorodFrom_Id");
    public SelenideElement MAIN_PRICE = $("#preskurant > tbody > tr:nth-child(2)");
}
