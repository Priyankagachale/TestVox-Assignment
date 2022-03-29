import com.Constants;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

    public class EasySel {
        WebDriver driver;


        @BeforeClass
        public void loadBrowser() {
            String driverpath = "C:\\Users\\user\\TestVox\\drivers\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", driverpath);
            driver = new ChromeDriver();
        }

        @org.testng.annotations.Test
        public void TC001() {
            //Google verification
            driver.manage().timeouts().implicitlyWait(430, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("https://www.google.com/");
            String title = driver.getTitle();
            Assert.assertEquals("Google", title);
        }
        @org.testng.annotations.Test
        public void TC002() throws InterruptedException {
                     //search keyword easy selenium
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("easy selenium learning" + Keys.ENTER);
            String title = driver.getTitle();
            System.out.println(title);
            Assert.assertEquals("easy selenium learning - Google Search", title);
            Thread.sleep(5000);
        }

        @org.testng.annotations.Test
        public void TC003() throws InterruptedException {
            //open website
            driver.get("\n" + "https://www.seleniumeasy.com/\n");
            String title = driver.getTitle();
            System.out.println(title);
            Assert.assertEquals("Learn Selenium with Best Practices and Examples | Selenium Easy", title);

            driver.quit();
        }



        }








