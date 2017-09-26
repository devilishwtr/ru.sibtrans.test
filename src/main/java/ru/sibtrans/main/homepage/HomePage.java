package ru.sibtrans.main.homepage;

import org.openqa.selenium.By;
import ru.sibtrans.main.PageObjects;

public class HomePage extends PageObjects {

    public final By VEHICLE_SHELUDE_BUTTON = By.className("uh-button graph");
    public final By DELIVERY_TIME_BUTTON = By.className("uh-button sr-dost");
    public final By RATES_BUTTON = By.className("uh-button tarifs");
    public final By SHARES_BUTTON1 = By.cssSelector("#shares > img:nth-child(2)");
    public final By SHARES_BUTTON2= By.cssSelector("#shares > img:nth-child(3)");
    public final By SHARES_BUTTON3 = By.cssSelector("#shares > img:nth-child(4)");
    public final By SHARES_BUTTON4 = By.cssSelector("#shares > img:nth-child(5)");
    public final By SHARES_BUTTON5 = By.cssSelector("#shares > img:nth-child(6)");
    public final By WINDOW_POPUP = By.className("popup-window-container");
    public final By WINDOW_PUPUP_CLOSE_BUTTON = By.cssSelector("popup-window-close");
}
