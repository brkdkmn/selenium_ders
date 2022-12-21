package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_ByClassName {
    public static void main(String[] args) throws InterruptedException {

        //amazona gidin nutella icin arama yapin
        //ilk siraya cikan urunlerin icerisinde
        //en yuksek fiyati bulun

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        List<WebElement> fiyatlarListesi=driver.findElements(By.className("a-price-whole"));

        //WebElement bir obje oldugundan direk yazdirilmaz
        System.out.println(fiyatlarListesi);

        //Bunun icin for each loop kullanarak
        // her bir webelement uzerindeki yazilari tek tek yazdirmaliyi

        for (WebElement each: fiyatlarListesi
             ) {
            System.out.println(each.getText());
        }

        // en yuksek fiyati bulabilmek icin java bilgimizi kullanmaliyiz
        //1-web elementlerden gettextile fiyati string olarak alin
        //2-string fiyati kiyaslama yapabilmek icin integer'a cevirin
        //3-en yuksek fiyati bulup yazdirin

        String fiyatStr;
        Integer fiyatInt;
        Integer enYuksekFiyat=0;
        for (WebElement each:fiyatlarListesi
             ) {
            fiyatStr= each.getText();
            fiyatInt=Integer.parseInt(fiyatStr);

            if (fiyatInt>enYuksekFiyat){
                enYuksekFiyat=fiyatInt;
            }
        }
        System.out.println("En yuksek urun fiyati : " + enYuksekFiyat);

        Thread.sleep(3000);
        driver.close();
    }
}
