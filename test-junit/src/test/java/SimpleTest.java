import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleTest {

    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(SimpleTest.class);

    @Before
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

    @After
    public void setDown(){
        if (driver != null){
            driver.quit();
            logger.info("Driver is down");
        }
    }
}
