package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import object_repositories.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

public class SeleniumHelpers {

    private WebDriver driver;
    private WebDriverWait wait;

    //Constructor
    public SeleniumHelpers(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Method untuk akses URL
    public void navigateToPage(String url){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);
        System.out.println("Title of the page is: " + driver.getTitle());
    }

    public void inputField(By locator, String text){
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        field.clear();
        field.sendKeys(text);
    }

    public void clickButton(By locator){
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(locator));
        btn.click();
    }

    public String getText(By locator){
        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return text.getText();
    }

    public void verifyTextEqual(String text1, String text2){
        assertEquals(text1, text2);
    }
}
