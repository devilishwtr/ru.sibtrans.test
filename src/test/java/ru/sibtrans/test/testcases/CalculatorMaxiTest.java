package ru.sibtrans.test.testcases;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.*;
import ru.sibtrans.main.Cities;
import ru.sibtrans.main.maxicalculator.CalculatorMaxiObject;
import ru.sibtrans.main.rates.sbornyeavtozhdperevozki.SbornyeAvtoZhdPerevozki;

import java.io.FileNotFoundException;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.close;
import static ru.sibtrans.main.Cities.calcResult;
import static ru.sibtrans.main.PageObjects.CostCalculateButtonClick;
import static ru.sibtrans.main.Settings.openVia;
import static ru.sibtrans.main.access.AccessPage.enterHomePage;
import static ru.sibtrans.main.maxicalculator.CalculatorMaxiObject.*;

class CalculatorMaxiTest {
    CalculatorMaxiObject maxc = new CalculatorMaxiObject();
    Cities cities = new Cities();
    SbornyeAvtoZhdPerevozki sazp = new SbornyeAvtoZhdPerevozki();

    CalculatorMaxiTest() throws FileNotFoundException {
    }

    @BeforeAll
    static void setUp() {
        openVia();
        enterHomePage();
    }
    @BeforeEach
    void setForEach(){
        CostCalculateButtonClick();
    }

    @Test
    @DisplayName("Расчет с учетом ввода городов для маршрута филиал - филиал")
    void positiveBranchBracnh() throws InterruptedException, IOException {
        maxc.CITY_FROM_BRANCH_ENTER();
        maxc.CITY_TO_BRANCH_ENTER();
        maxc.BOX_VOLUME_ENTER();
        maxc.BOX_WEIGHT_ENTER();
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.RESULT.shouldNotHave(errorMessage);
    }

    @Test
    @DisplayName("Расчет с учетом ввода городов для которых НЕТ маршрута в прейскуранте")
    void positiveRegionalRegional() throws IOException, InterruptedException {
        maxc.CITY_FROM_FIELD.val(regionalFrom).pressEnter();
        maxc.CITY_TO_FIELD.val(regionalTo).pressEnter();
        maxc.BOX_WEIGHT_ENTER();
        maxc.BOX_VOLUME_ENTER();
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.RESULT.shouldHave(zeroCalc);
    }

    @Test
    @DisplayName("Расчет без нажатия Enter после ввода данных - расчет обновляется")
    void positivePressEnterNeed() throws IOException, InterruptedException {
        maxc.CITY_FROM_BRANCH_ENTER();
        maxc.CITY_TO_BRANCH_ENTER();
        maxc.BOX_WEIGHT_ENTER();
        maxc.BOX_VOLUME_ENTER();
        maxc.SUBMIT_BUTTON_CLICK();
        String temp = maxc.RESULT.text();
        maxc.CITY_FROM_FIELD.val("das");
        maxc.CITY_TO_FIELD.val("dasdq");
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.RESULT.shouldNotHave(Condition.text(temp));
    }

    @Test
    @DisplayName("При вводе одинаковых городов - расчет не выводится")
    void positiveEnterSameCities() throws InterruptedException {
        //Given
        maxc.CITY_FROM_FIELD.setValue(branchFrom).pressEnter();
        maxc.CITY_TO_FIELD.setValue(branchFrom).pressEnter();
        maxc.BOX_VOLUME_ENTER();
        maxc.BOX_WEIGHT_ENTER();
        //When
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.RESULT.shouldHave(errorMessage);
    }

    @Test
    @DisplayName("При вводе одинаковых городов и нажать забрать у отправителя")
    void positiveEnterSameCitiesWithDeliveryOut() throws InterruptedException {
        maxc.CITY_FROM_FIELD.val(branchFrom).pressEnter();
        maxc.CITY_TO_FIELD.val(branchFrom).pressEnter();
        maxc.BOX_VOLUME_ENTER();
        maxc.BOX_WEIGHT_ENTER();
        maxc.DELIVERY_OUT_CHECKBOX.click();
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.RESULT.shouldNotHave(errorMessage);
        maxc.RESULT.shouldNotHave(zeroCalc);
    }

    @Test
    @DisplayName("При вводе одинаковых городов и нажать забрать у получателя")
    void positiveEnterSameCitiesWithDeliveryIn() throws InterruptedException {
        maxc.CITY_FROM_FIELD.val(branchFrom).pressEnter();
        maxc.CITY_TO_FIELD.val(branchFrom).pressEnter();
        maxc.BOX_VOLUME_ENTER();
        maxc.BOX_WEIGHT_ENTER();
        maxc.DELIVERY_IN_CHECKBOX.click();
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.RESULT.shouldNotHave(errorMessage);
        maxc.RESULT.shouldNotHave(zeroCalc);
    }
                                        //Грузоотправители
    @Test
    @DisplayName("Расчет с учетом активации 'забрать груз у отправителя'")
    void positiveClickDeliveryOut() throws InterruptedException, IOException {
        maxc.CITY_FROM_BRANCH_ENTER();
        maxc.CITY_TO_BRANCH_ENTER();
        maxc.BOX_VOLUME_ENTER();
        maxc.BOX_WEIGHT_ENTER();
        maxc.DELIVERY_OUT_CHECKBOX.click();
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.RESULT.shouldNotHave(errorMessage);
    }

    @Test
    @DisplayName("Расчет с учетом активации 'доставить груз получателю'")
    void positiveClickDeliveryIn() throws InterruptedException, IOException {
        maxc.CITY_FROM_BRANCH_ENTER();
        maxc.CITY_TO_BRANCH_ENTER();
        maxc.BOX_VOLUME_ENTER();
        maxc.BOX_WEIGHT_ENTER();
        maxc.DELIVERY_IN_CHECKBOX.click();
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.RESULT.shouldNotHave(errorMessage);
    }

    @Test
    @DisplayName("Расчет с учетом активации 'забрать груз' и 'оставить груз получателю' '")
    void positiveClickDeliveryOutIn() throws InterruptedException, IOException {
        maxc.CITY_FROM_BRANCH_ENTER();
        maxc.CITY_TO_BRANCH_ENTER();
        maxc.BOX_WEIGHT_ENTER();
        maxc.BOX_VOLUME_ENTER();
        maxc.DELIVERY_IN_CHECKBOX.click();
        maxc.DELIVERY_OUT_CHECKBOX.click();
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.RESULT.shouldNotHave(errorMessage);
    }


    @Test
    @DisplayName("Расчет с учетом тепловых условий перевозки")
    void positiveClickThermal() throws InterruptedException, IOException {
        maxc.CITY_FROM_BRANCH_ENTER();
        maxc.CITY_TO_BRANCH_ENTER();
        maxc.BOX_WEIGHT_ENTER();
        maxc.BOX_VOLUME_ENTER();
        maxc.DELIVERY_OUT_CHECKBOX.click();
        maxc.DELIVERY_IN_CHECKBOX.click();
        maxc.THERMAL.click();
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.RESULT.shouldNotHave(errorMessage);
        }

    @Test
    @DisplayName("Расчет с учетом перевозки негабаритного груза")
    void positiveClickOversize() throws InterruptedException, IOException {
        maxc.CITY_FROM_BRANCH_ENTER();
        maxc.CITY_TO_BRANCH_ENTER();
        maxc.BOX_WEIGHT_ENTER();
        maxc.BOX_VOLUME_ENTER();
        maxc.DELIVERY_OUT_CHECKBOX.click();
        maxc.DELIVERY_IN_CHECKBOX.click();
        maxc.OVERSIZED.click();
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.RESULT.shouldNotHave(errorMessage);
    }
    @Test
    @DisplayName("Расчет с учетом перевозки хрупкого груза")
    void positiveClickFragile() throws InterruptedException, IOException {
        maxc.CITY_FROM_BRANCH_ENTER();
        maxc.CITY_TO_BRANCH_ENTER();
        maxc.BOX_WEIGHT_ENTER();
        maxc.BOX_VOLUME_ENTER();
        maxc.DELIVERY_OUT_CHECKBOX.click();
        maxc.DELIVERY_IN_CHECKBOX.click();
        maxc.FRAGILE.click();
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.RESULT.shouldNotHave(errorMessage);
    }
    //TODO Не работают нормально сервисы
//
    @Test
    @DisplayName("При дезактивации чекбокса в пункте отправления внутренние чекбоксы отключаются и расчет обновляется")
    void positiveAddServiceFromDeactivate() throws IOException, InterruptedException {
        maxc.CITY_FROM_FIELD.val("Москва");
        maxc.CITY_TO_BRANCH_ENTER();
        maxc.BOX_WEIGHT_ENTER();
        maxc.BOX_VOLUME_ENTER();
        maxc.DELIVERY_IN_CHECKBOX.click();
        maxc.SUBMIT_BUTTON_CLICK();
        String temp = maxc.RESULT.text();
        maxc.ADD_SERVICE_CITY_FROM.click();
        maxc.SERVICE_FROM_DOCUMENTS_SHTUK.click();
        maxc.DOCUMENTS_SHTUK_FIELD.val("25");
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.ADD_SERVICE_CITY_FROM.click();
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.RESULT.shouldHave(Condition.exactText(temp));
    }

    @Test
    @DisplayName("При дезактивации чекбокса в пункте назначения внутренние чекбоксы отключаются и расчет обновляется")
    void positiveAddServiceToDeactivate() throws IOException, InterruptedException {
        maxc.CITY_FROM_FIELD.val("Новосибирск");
        maxc.CITY_TO_FIELD.val("Москва");
        maxc.BOX_WEIGHT_ENTER();
        maxc.BOX_VOLUME_ENTER();
        maxc.DELIVERY_IN_CHECKBOX.click();
        maxc.SUBMIT_BUTTON_CLICK();
        String temp = maxc.RESULT.text();
        maxc.ADD_SERVICE_CITY_TO.click();
        maxc.SERVICE_TO_DOCUMENTS_SHTUK.click();
        maxc.DOCUMENTS_SHTUK_FIELD_TO.val("25");
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.ADD_SERVICE_CITY_TO.click();
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.RESULT.shouldHave(Condition.exactText(temp));
    }

    @Test
    @DisplayName("Расчет с учетом активации чекбоксов 'сервисы в пункте отправления'")
    void positiveActivateServiceFromCheckbox() throws IOException, InterruptedException {
        maxc.CITY_FROM_FIELD.val("Москва");
        maxc.CITY_TO_BRANCH_ENTER();
        maxc.BOX_VOLUME_ENTER();
        maxc.BOX_WEIGHT_ENTER();
        maxc.ADD_SERVICE_CITY_FROM.click();
        maxc.SERVICE_FROM_DOCUMENTS_SHTUK.click();
        maxc.SERVICE_FROM_OBRESHETKA.click();
        maxc.SERVICE_FROM_HRANENIE_DAYS.click();
        maxc.SERVICE_FROM_KONSOLIDACIYA.click();
        maxc.SERVICE_FROM_PALLETIROVANIE.click();
        maxc.SERVICE_FROM_POGRUZ_RABOTA.click();
        maxc.SERVICE_FROM_SKLAD.click();
        maxc.SERVICE_FROM_MARKIROVKA_SHTUK.click();
        maxc.DOCUMENTS_SHTUK_FIELD.val("25");
        maxc.HRANENIE_DAYS_FIELD.val("26");
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.RESULT.shouldHave(errorMessage);
    }

    @Test
    @DisplayName("Расчет с учетом проверки активации чекбоксов 'сервисы в пункте назначения'")
    void positiveAddServiceToCheckbox() throws IOException, InterruptedException {
        maxc.CITY_FROM_BRANCH_ENTER();
        maxc.CITY_TO_FIELD.val("Москва");
        maxc.BOX_VOLUME_ENTER();
        maxc.BOX_WEIGHT_ENTER();
        maxc.THERMAL.click();
        maxc.ADD_SERVICE_CITY_TO.click();
        maxc.SERVICE_TO_RASTENTOVKA_SHTUK.click();
        maxc.RASTENTOVKA_SHTUK_FIELD_TO.val("99");
        maxc.SERVICE_TO_OBRESHETKA.click();
        maxc.SERVICE_TO_STRETCHPLENKA.click();
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.RESULT.shouldNotHave(errorMessage);
    }

    @AfterAll
    static void terDown(){
        close();
    }
}

class ValidationCalculation {
    CalculatorMaxiObject maxc = new CalculatorMaxiObject();

    @BeforeAll
    static void setUp() {
        openVia();
        enterHomePage();
    }

    @BeforeEach
    void setForEach(){
        CostCalculateButtonClick();
    }

    @Test
    @DisplayName("Валидация расчета при вводе ПО, ПН, ВОХ")
    void validationTest1 () throws InterruptedException, IOException {
        maxc.BASE_ENTER();
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.RESULT.shouldHave(Condition.matchText(calcResult(0)));
    }

    @Test
    @DisplayName("Валидация - Отправитель\tТепловой\tВПО_БЕЗ_ШТУК, ")
    void validationTest2 () throws InterruptedException, IOException {
        maxc.BASE_ENTER();
        maxc.DELIVERY_OUT_CHECKBOX.click();
        maxc.THERMAL.click();
        maxc.ADD_SERVICE_CITY_FROM.click();
        maxc.SERVICE_FROM_POGRUZ_RABOTA.click();
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.RESULT.shouldHave(Condition.matchText(calcResult(1)));
    }

    @Test
    @DisplayName("Валидация - Получатель\tНегабарит\tВПН_СО_ШТУКАМИ")
    void validationTest3() throws InterruptedException, IOException {
        maxc.BASE_ENTER();
        maxc.DELIVERY_IN_CHECKBOX.click();
        maxc.OVERSIZED.click();
        maxc.ADD_SERVICE_CITY_TO.click();
        maxc.SERVICE_TO_DOCUMENTS_SHTUK.click();
        maxc.DOCUMENTS_SHTUK_FIELD_TO.val("25");
        maxc.SERVICE_TO_POGRUZ_RABOTA.click();
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.RESULT.shouldHave(Condition.exactText(calcResult(2)));
    }

    @Test
    @DisplayName("Валидация - Вместе\tХрупкий\tВПО_ВПН_СО_ШТУКАМИ_ИБЕЗ")
    void validationTest4() throws InterruptedException, IOException {
        maxc.BASE_ENTER();
        maxc.FRAGILE.click();
        maxc.DELIVERY_OUT_CHECKBOX.click();
        maxc.DELIVERY_IN_CHECKBOX.click();
        maxc.ADD_SERVICE_CITY_FROM.click();
        maxc.SERVICE_FROM_DOCUMENTS_SHTUK.click();
        maxc.DOCUMENTS_SHTUK_FIELD.val("25");
        maxc.ADD_SERVICE_CITY_TO.click();
        maxc.SERVICE_TO_PALLETIROVANIE.click();
        maxc.SERVICE_TO_DOCUMENTS_SHTUK.click();
        maxc.DOCUMENTS_SHTUK_FIELD_TO.val("25");
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.RESULT.shouldHave(Condition.exactText(calcResult(3)));
    }

    @Test
    @DisplayName("Валидация - Отправитель\tНегабарит\tВПО_ВПН_СО_ШТУКАМИ_ИБЕЗ")
    void validationTest5() throws InterruptedException, IOException {
        maxc.BASE_ENTER();
        maxc.DELIVERY_OUT_CHECKBOX.click();
        maxc.OVERSIZED.click();
        maxc.ADD_SERVICE_CITY_FROM.click();
        maxc.ADD_SERVICE_CITY_TO.click();
        maxc.SERVICE_FROM_POGRUZ_RABOTA.click();
        maxc.SERVICE_FROM_DOCUMENTS_SHTUK.click();
        maxc.DOCUMENTS_SHTUK_FIELD.val("30");
        maxc.SERVICE_TO_STRETCHPLENKA.click();
        maxc.SERVICE_TO_PALLETIROVANIE.click();
        maxc.SERVICE_TO_DOCUMENTS_SHTUK.click();
        maxc.DOCUMENTS_SHTUK_FIELD_TO.val("25");
        maxc.SERVICE_TO_HRANENIE_DAYS.click();
        maxc.HRANENIE_DAYS_FIELD_TO.val("10");
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.RESULT.shouldHave(Condition.exactText(calcResult(4)));
    }

    @Test
    @DisplayName("Валидация - Получатель\tХрупкий\tВПО_БЕЗ_ШТУК")
    void validationTest6() throws InterruptedException, IOException {
        maxc.BASE_ENTER();
        maxc.DELIVERY_OUT_CHECKBOX.click();
        maxc.FRAGILE.click();
        maxc.ADD_SERVICE_CITY_FROM.click();
        maxc.SERVICE_FROM_POGRUZ_RABOTA.click();
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.RESULT.shouldHave(Condition.exactText(calcResult(5)));
    }

    @Test
    @DisplayName("Валидация - \tВместе\tТепловой\tВПН_СО_ШТУКАМИ")
    void validationTest7() throws InterruptedException, IOException {
        maxc.BASE_ENTER();
        maxc.DELIVERY_OUT_CHECKBOX.click();
        maxc.DELIVERY_IN_CHECKBOX.click();
        maxc.THERMAL.click();
        maxc.ADD_SERVICE_CITY_TO.click();
        maxc.SERVICE_TO_HRANENIE_DAYS.click();
        maxc.HRANENIE_DAYS_FIELD_TO.val("25");
        maxc.SERVICE_TO_DOCUMENTS_SHTUK.click();
        maxc.DOCUMENTS_SHTUK_FIELD_TO.val("25");
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.RESULT.shouldHave(Condition.exactText(calcResult(6)));
    }

    @Test
    @DisplayName("Валидация - Отправитель\tХрупкий\tВПН_СО_ШТУКАМИ")
    void validationTest8() throws InterruptedException, IOException {
        maxc.BASE_ENTER();
        maxc.DELIVERY_IN_CHECKBOX.click();
        maxc.FRAGILE.click();
        maxc.ADD_SERVICE_CITY_TO.click();
        maxc.SERVICE_TO_POLI_MESHOK_SHTUK.click();
        maxc.POLI_MESHOK_SHTUK_FIELD_TO.val("25");
        maxc.SERVICE_TO_HRANENIE_DAYS.click();
        maxc.HRANENIE_DAYS_FIELD_TO.val("25");
        maxc.SERVICE_TO_DOCUMENTS_SHTUK.click();
        maxc.DOCUMENTS_SHTUK_FIELD_TO.val("25");
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.RESULT.shouldHave(Condition.exactText(calcResult(7)));
    }

    @Test
    @DisplayName("Валидация - \tПолучатель\tВсе условия\tВПО_ВПН_СО_ШТУКАМИ_ИБЕЗ\t")
    void validationTest9() throws InterruptedException, IOException {
        maxc.BASE_ENTER();
        maxc.DELIVERY_OUT_CHECKBOX.click();
        maxc.THERMAL.click();
        maxc.FRAGILE.click();
        maxc.OVERSIZED.click();
        maxc.ADD_SERVICE_CITY_TO.click();
        maxc.SERVICE_TO_POLI_MESHOK_SHTUK.click();
        maxc.POLI_MESHOK_SHTUK_FIELD_TO.val("25");
        maxc.SERVICE_TO_HRANENIE_DAYS.click();
        maxc.HRANENIE_DAYS_FIELD_TO.val("25");
        maxc.SERVICE_TO_DOCUMENTS_SHTUK.click();
        maxc.DOCUMENTS_SHTUK_FIELD_TO.val("25");
        maxc.ADD_SERVICE_CITY_FROM.click();
        maxc.SERVICE_FROM_POGRUZ_RABOTA.click();
        maxc.SERVICE_FROM_DOCUMENTS_SHTUK.click();
        maxc.DOCUMENTS_SHTUK_FIELD.val("30");
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.RESULT.shouldHave(Condition.exactText(calcResult(8)));
    }

    @Test
    @DisplayName("Валидация - \tВместе\tНегабарит\tВПО_БЕЗ_ШТУК")
    void validationTest10() throws InterruptedException, IOException {
        maxc.BASE_ENTER();
        maxc.DELIVERY_OUT_CHECKBOX.click();
        maxc.DELIVERY_IN_CHECKBOX.click();
        maxc.OVERSIZED.click();
        maxc.ADD_SERVICE_CITY_FROM.click();
        maxc.SERVICE_FROM_POGRUZ_RABOTA.click();
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.RESULT.shouldHave(Condition.exactText(calcResult(9)));
    }

    @Test
    @DisplayName("Вместе\tВсе условия\tВПО_ВПН_БЕЗ_ШТУК\tСнять доп сервис")
    void validationTest11() throws InterruptedException, IOException {
        maxc.BASE_ENTER();
        maxc.FRAGILE.click();
        maxc.OVERSIZED.click();
        maxc.THERMAL.click();
        maxc.DELIVERY_OUT_CHECKBOX.click();
        maxc.DELIVERY_IN_CHECKBOX.click();
        maxc.ADD_SERVICE_CITY_FROM.click();
        maxc.ADD_SERVICE_CITY_TO.click();
        maxc.SERVICE_TO_POGRUZ_RABOTA.click();
        maxc.SERVICE_TO_STRETCHPLENKA.click();
        maxc.SERVICE_TO_KONSOLIDACIYA.click();
        maxc.SERVICE_TO_PALLETIROVANIE.click();
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.ADD_SERVICE_CITY_TO.click();
        maxc.ADD_SERVICE_CITY_FROM.click();
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.RESULT.shouldHave(Condition.exactText(calcResult(10)));
    }

    @AfterAll
    static void terDown(){
        close();
    }
}

class CalculatorMaxiTestNegative {
    private CalculatorMaxiObject maxc = new CalculatorMaxiObject();

    @BeforeAll
    static void setUp() {
        openVia();
        enterHomePage();
    }
    @BeforeEach
    void setForEach(){
        CostCalculateButtonClick();
    }

    @Test
    @DisplayName("При вводе некоректных данных в поля городов - расчет не производится")
    void negativeEnterIncorrectCities() throws InterruptedException {
        maxc.CITY_FROM_FIELD.setValue("Sdds2(?%№шож59ЛЫ3").pressEnter();
        maxc.CITY_TO_FIELD.setValue("()()?*Г)_ЖДKJDFEIJL::L").pressEnter();
        maxc.BOX_WEIGHT_ENTER();
        maxc.BOX_VOLUME_ENTER();
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.RESULT.shouldHave(errorMessage);
    }
    @Test
    @DisplayName("Ввод некоректных данных в поля городов - отоброжаются только символы [а-яА-Я, причем знак '-' только один]")
    void negativeEnterIncorrectDataCities() throws IOException {
        maxc.CITY_FROM_FIELD.val("sdokjdoas90&*(_)+выф--s<>?,mnbn!=-вфы-dsa_'\"");
        maxc.CITY_TO_FIELD.val("sdokjdoas90&*(_)+выф--s<>?,mnbn!=-вфы-dsa_'\"");
        maxc.CITY_FROM_FIELD.shouldHave(Condition.value("выф-вфы"));
        maxc.CITY_TO_FIELD.shouldHave(Condition.value("выф-вфы"));
    }

    @Test
    @DisplayName("При пустом значении BOX Вес")
    void negativeEnterNullWeight() throws InterruptedException, IOException {
        maxc.CITY_FROM_BRANCH_ENTER();
        maxc.CITY_TO_BRANCH_ENTER();
        maxc.BOX_VOLUME_ENTER();
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.RESULT.shouldBe(errorMessage);
    }

    @Test
    @DisplayName("Ввод граничных значений BOX Вес - 0")  //уточнить
    void NegativeEnterBoundaryWeight1() throws InterruptedException, IOException {
        maxc.CITY_FROM_BRANCH_ENTER();
        maxc.CITY_TO_BRANCH_ENTER();
        maxc.BOX_WEIGHT.val("0");
        maxc.BOX_VOLUME_ENTER();
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.RESULT.shouldNotHave(errorMessage);
    }
    @Test
    @DisplayName("Ввод граничных значений BOX Вес - 1000")
    void NegativeEnterBoundaryWeight2() throws InterruptedException, IOException {
        maxc.CITY_FROM_BRANCH_ENTER();
        maxc.CITY_TO_BRANCH_ENTER();
        maxc.BOX_WEIGHT.val("10000");
        maxc.BOX_VOLUME_ENTER();
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.RESULT.shouldNotHave(errorMessage);
    }
    @Test
    @DisplayName("Ввод граничных значений BOX Вес - 10001")
    void NegativeEnterBoundaryWeight3() throws InterruptedException, IOException {
        maxc.CITY_FROM_BRANCH_ENTER();
        maxc.CITY_TO_BRANCH_ENTER();
        maxc.BOX_WEIGHT.val("10001");
        maxc.BOX_VOLUME_ENTER();
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.RESULT.shouldHave(zeroCalc);
    }

    @Test
    @DisplayName("Ввод некоректных значений BOX Вес [а-Яa-Z_symbols]")
    void NegativeEnterIncorrectWeight1() throws InterruptedException {
        maxc.BOX_WEIGHT.setValue("ывйввфывфыпафыипфчзтзшйетЯЯВФЫВФйADSADASV67FASasdabnpohfjdeoisd@#@!%@!*@&(%()_");
        maxc.BOX_VOLUME_ENTER();
        maxc.BOX_WEIGHT.shouldBe(Condition.value("67"));
    }
    @Test
    @DisplayName("Ввод некоректных значений BOX Вес ['500'}")
    void NegativeEnterIncorrectWeight2() throws InterruptedException {
        maxc.BOX_WEIGHT.setValue("'500'");
        maxc.BOX_VOLUME_ENTER();
        maxc.BOX_WEIGHT.shouldBe(Condition.value("500"));
    }
    @Test
    @DisplayName("Ввод некоректных значений BOX Вес [\"500\"]")
    void NegativeEnterIncorrectWeight3() throws InterruptedException {
        maxc.BOX_WEIGHT.setValue("\"500\"");
        maxc.BOX_VOLUME_ENTER();
        maxc.BOX_WEIGHT.shouldHave(Condition.value("500"));
    }

    @Test
    @DisplayName("При пустом значении ВОХ Объем")
    void negativeEnterNullVolume() throws InterruptedException, IOException {
        maxc.CITY_FROM_BRANCH_ENTER();
        maxc.CITY_FROM_BRANCH_ENTER();
        maxc.BOX_WEIGHT_ENTER();
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.RESULT.shouldBe(errorMessage);
    }

    @Test
    @DisplayName("Ввод граничных значений BOX Объем - 0")
    void negativeEnterBoundaryVolume1() throws InterruptedException, IOException {
        maxc.CITY_FROM_BRANCH_ENTER();
        maxc.CITY_TO_BRANCH_ENTER();
        maxc.BOX_WEIGHT_ENTER();
        maxc.BOX_VOLUME.val("0");
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.RESULT.shouldNotHave(errorMessage);
    }

    @Test
    @DisplayName("Ввод граничных значений BOX Объем - 40")
    void negativeEnterBoundaryVolume2() throws InterruptedException, IOException {
        maxc.CITY_FROM_BRANCH_ENTER();
        maxc.CITY_TO_BRANCH_ENTER();
        maxc.BOX_WEIGHT.val("1500");
        maxc.BOX_VOLUME.val("40");
        maxc.SUBMIT_BUTTON_CLICK();
        maxc.RESULT.shouldNotHave(errorMessage);
    }

    @Test
    @DisplayName("Ввод некоректных значений BOX Объем - [а-яА-Яa-zA-Z_symbols]")
    void negativeEnterIncorrectVolume1() {
        maxc.BOX_VOLUME.val("ывйввфывфыпафыипфчзтзшйетЯЯВФЫВФйADSADASVFASasdabnpohfjdeoisd@#@!%@!*)+_;'@&(%()_");
        maxc.BOX_WEIGHT_ENTER();
        maxc.BOX_VOLUME.shouldBe(Condition.empty);
    }

    @Test
    @DisplayName("Ввод некорктных значений в поля штук доп.сервиса")
    void negativeEnterIncorrectAddService() throws IOException {
        maxc.ADD_SERVICE_CITY_FROM.click();
        maxc.SERVICE_FROM_MARKIROVKA_SHTUK.click();
        maxc.MARKIROVKA_SHTUK_FIELD.val("ads42ывыюб.б23ж(*&^^#@'\"-)+_((*&^^#$@*!><ML:MKJDNBHIFGBIEUJNFOWIMЛАЩШОУЩШГТРАЩЦШТ");
        maxc.SERVICE_FROM_HRANENIE_DAYS.click();
        maxc.HRANENIE_DAYS_FIELD.val("<<M><M>NLJNOIJIOR@J)($U@(*HT@(KnmLц22KJfdkljdipofjjлвыоа%?:*()_25LKLKHJIYGUYIU(@$*@)");
        maxc.MARKIROVKA_SHTUK_FIELD.shouldHave(Condition.value("4223"));
        maxc.HRANENIE_DAYS_FIELD.shouldHave(Condition.value("2225"));
    }




    @AfterAll
    static void terDown() throws InterruptedException {
        close();
    }
}
