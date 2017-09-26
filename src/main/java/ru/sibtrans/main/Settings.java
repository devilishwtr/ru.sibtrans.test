package ru.sibtrans.main;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

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

        public static void openVia(){
            openViaFirefox();
        }
        public static void sleep() throws InterruptedException {
            Thread.sleep(1000);
        }

}
