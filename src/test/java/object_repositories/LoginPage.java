package object_repositories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public By fieldUsername = By.xpath("//input[@name=\"username\"]");
    public By fieldPassword = By.xpath("//input[@name=\"password\"]");
    public By buttonLogin = By.xpath("//button[@type='submit']");

    public By textDashboardTile = By.xpath("//h6[contains(@class,'oxd-text oxd-text--h6')]");

    public LoginPage(WebElement webElement){

    }
}
