package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class logout {
    WebDriver driver;
    String baseURL= "https://www.saucedemo.com/";


    @Given("user open the saucecode website")
    public void user_success_open_saucecode_website() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        String LoginPageAssert = driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
        Assert.assertEquals(LoginPageAssert, "Swag Labs");
    }

    @When("user fill (.*) as username$")
    public void userInputUsernameAsUsername(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    @And("user fill (.*) as password$")
    public void user_input_secret_sauce_as_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("user press button login")
    public void userClickButtonLogin() {
        WebElement password_form = driver.findElement(By.id("login-button"));
        password_form.isDisplayed();
        password_form.click();
    }

    @Then("user get (.*) of login$")
    public void user_verify_success_login_result(String status) {
        if (status.equals("success")) {
            String dashboard = driver.findElement(By.xpath("//div[@class='app_logo']")).getText();
            Assert.assertEquals(dashboard, "Swag Labs");
        } else {
            driver.findElement(By.xpath("//div[contains(@class, 'error')]")).isDisplayed();
            driver.close();
        }
    }

    @When("user click menu button on above right page")
    public void userClickMenuButtonOnAboveRightPage() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @And("user click logout")
    public void userClickLogout() {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(@id, 'logout')]")).click();
    }

    @Then("user back to login page")
    public void userBackToLoginPage() {
        String LoginPageAssert= driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
        Assert.assertEquals(LoginPageAssert, "Swag Labs");
        driver.close();

    }
}
