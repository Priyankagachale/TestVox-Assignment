import com.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

        public class Test {
            WebDriver driver;

            @BeforeClass
            public void loadBrowser() {
                //initialization of chrome driver
                String driverpath = "C:\\Users\\user\\TestVox\\drivers\\chromedriver.exe";
                System.setProperty("webdriver.chrome.driver", driverpath);
                driver = new ChromeDriver();
                //Google verification
                driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                driver.get("https://www.google.com/");
            }

            @org.testng.annotations.Test
            public void TC001() throws Exception {
                String title = driver.getTitle();
                Assert.assertEquals("Google", title);
                //check searcg box is displayed
                WebElement searchBox = driver.findElement(By.name("q"));
                Assert.assertTrue(searchBox.isDisplayed());
                searchBox.sendKeys("Test Automation Learning" + Keys.ENTER);
                //select udemy related link
                driver.findElement(By.xpath("(//cite[text()='https://www.udemy.com'])[1]/preceding::h3[contains(text(),'Top Automation Testing')]")).click();
                title = driver.getTitle();
                Assert.assertEquals("Top Automation Testing Courses Online - Updated [March 2022] | Udemy", title);
                searchBox = driver.findElement(By.name("q"));
                //search for bdd with cucumber
//                Assert.assertTrue(searchBox.isDisplayed());
                searchBox.sendKeys("BDD with cucumber" + Keys.ENTER);
                Assert.assertTrue(driver.findElement(By.xpath("(//a[text()='Learn Cucumber BDD with Java -MasterClass Selenium Framework'])[1]")).isDisplayed());

           }

           @AfterMethod
            public void fnCloseBrowser() {
                driver.quit();
            }
        }







