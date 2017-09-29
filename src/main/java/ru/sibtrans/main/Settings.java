package ru.sibtrans.main;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import static com.codeborne.selenide.Selenide.open;


public class Settings {
        public static void openViaChrome() {

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            WebDriver driver = new ChromeDriver(chromeOptions);
            WebDriverRunner.setWebDriver(driver);
            open("http://btk.karavaykin.ru");
        }

        public static void openViaFirefox() {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--start-maximized");
            WebDriver driver = new FirefoxDriver(firefoxOptions);
            WebDriverRunner.setWebDriver(driver);
            open("http://btk.karavaykin.ru");
        }

    public static void openViaIE() {
        InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
        WebDriver driver = new InternetExplorerDriver();
        WebDriverRunner.setWebDriver(driver);
        open("http://btk.karavaykin.ru");
    }

        public static void openVia(){
            openViaIE();
        }
        public static void sleep() throws InterruptedException {
            Thread.sleep(1000);
        }

}
