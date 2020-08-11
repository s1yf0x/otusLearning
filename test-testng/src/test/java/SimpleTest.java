import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SimpleTest {

    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(SimpleTest.class);

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Driver is set upped");
        driver.manage().window().maximize();
        logger.info("Window was maximized");
    }

    @Test
    public void openPage(){
        driver.get("https://otus.ru");
        logger.info("Page is opened");
        String expectedTitle = "Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям";
        String actualTitle = driver.getTitle();
        logger.info("Actual title grabbed");
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @AfterMethod
    public void setDown(){
        if (driver != null){
            driver.quit();
            logger.info("Driver is down");
        }
    }
}
