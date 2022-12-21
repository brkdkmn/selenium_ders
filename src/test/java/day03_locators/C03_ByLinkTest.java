package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ByLinkTest {
    public static void main(String[] args) throws InterruptedException {

        //amazon anasayfaya gidin
        //gift cards linkini tiklayin
        // gift cards sayfasina gittigini test edin

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
        //WebElement giftCardLink=driver.findElement(By.linkText("Gift Cards"));

        Thread.sleep(6000);
        WebElement giftCardLink=driver.findElement(By.partialLinkText("Gift"));
        giftCardLink.click();

        //istenen sayfaya gittigini test etmek icin
        //tittle'in Gift Card icerdigini test edebiliriz

        String expectedKelime="Gift Cards";
        String actualTitle=driver.getTitle();

        if (actualTitle.contains(expectedKelime)){
            System.out.println("gift cards testi PASSED");
        }else {
            System.out.println("gift cards testi FAILED");
        }

        driver.close();
    }
}
