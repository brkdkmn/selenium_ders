package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_DriverNavigateMethodlari {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.amaon.com"); // get ile ayni islevi yapar

        driver.get("https://www.wisequarter.com");// navigate ile get arasinda fark yoktur

        // yeniden amazona donelim
        driver.navigate().back();

        // tekrar wisequarter.com'a istersek
        driver.navigate().forward();

        Thread.sleep(5000);
        driver.quit();
    }
}
