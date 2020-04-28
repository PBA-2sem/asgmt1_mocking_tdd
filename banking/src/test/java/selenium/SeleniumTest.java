package selenium;

import java.io.File;
import java.nio.file.Paths;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class SeleniumTest {

    static WebDriver driver = null;

    /**
     * Setup method executed once before running all tests. Depending on the OS,
     * it selects the corresponding Chrome WebDriver.
     */
    @BeforeClass
    public static void setup() {
        String os = System.getProperty("os.name");
        String os_driver = "chromedriver"; //mac
        if (os.startsWith("Windows")) {
            os_driver = "chromedriver.exe"; //PC
        }
        String pathToWebdriver = Paths.get(".." + File.separator + "assets" + File.separator + "chromedriver" + File.separator + os_driver).toAbsolutePath().normalize().toString();
        System.setProperty("webdriver.chrome.driver", pathToWebdriver);
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }

    @Test
    public void testDefaultRestApiPage() throws InterruptedException {
        System.out.println("DefaultRestApiPage");
        driver.get("http://localhost:8084/banking/");
        String expected = "TODO write content";
        String result = driver.findElement(By.cssSelector("body > div")).getText();
        assertEquals(expected, result);
    }

}
