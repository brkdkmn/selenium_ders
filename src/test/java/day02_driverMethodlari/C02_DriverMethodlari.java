package day02_driverMethodlari;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethodlari {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com");

        driver.manage().window().maximize();
        System.out.println("maximize window boyutlari: " + driver.manage().window().getSize());
        System.out.println("maximize window pozisyonu: " + driver.manage().window().getPosition());

        Thread.sleep(3000);

        driver.manage().window().fullscreen();
        System.out.println("fullscreen window boyutlari : " + driver.manage().window().getSize());
        System.out.println("fullscreen window pozisyonu: " + driver.manage().window().getPosition());

        // Browser'i istedigimiz konuma ve boyuta getirelim

        driver.manage().window().setSize(new Dimension(1000,600));
        driver.manage().window().setPosition(new Point(100,200));

        Thread.sleep(3000);
        driver.close();


    }
}
