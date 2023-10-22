package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class login {
    WebDriver driver;
    String baseURL= "https://www.saucedemo.com/";

    @Given("user open saucecode website")
    public void userOpenSourcecodeWebsite() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);

        String LoginPageAssert= driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
        Assert.assertEquals(LoginPageAssert, "Swag Labs");
    }

    @When("user input email")
    public void inputEmail() {
        WebElement email_form= driver.findElement(By.id("user-name"));
        email_form.isDisplayed();
        email_form.click();
        email_form.sendKeys("standard_user");
    }

    @And("user input password")
    public void userInputPassword() {
        WebElement password_form= driver.findElement(By.id("password"));
        password_form.isDisplayed();
        password_form.click();
        password_form.sendKeys("secret_sauce");
    }

    @And("user click button login")
    public void userClickButtonLogin() {
        WebElement password_form= driver.findElement(By.id("login-button"));
        password_form.isDisplayed();
        password_form.click();
    }

    @Then("user directly to dashboard")
    public void userDirectlyToDashboard()  {
    String dashboard= driver.findElement(By.xpath("//div[@class='app_logo']")).getText();
    Assert.assertEquals(dashboard, "Swag Labs");

    }

    @When("user input invalid email")
    public void userInputInvalidEmail() {
        WebElement email_form= driver.findElement(By.id("user-name"));
        email_form.isDisplayed();
        email_form.click();
        email_form.sendKeys("emailsalah");
    }

    @And("user input invalid password")
    public void userInputInvalidPassword() {
        WebElement password_form= driver.findElement(By.id("password"));
        password_form.isDisplayed();
        password_form.click();
        password_form.sendKeys("salahpassword");
    }

    @Then("user get error message")
    public void userGetErrorMessage() {
        String dashboard= driver.findElement(By.xpath("//div[contains(@class, 'error')]")).getText();
        Assert.assertEquals(dashboard,
                "Epic sadface: Username and password do not match any user in this service");


    }

    @When("user input (.*) as username$")
    public void userInputUsernameAsUsername(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    @And("user input (.*) as password$")
    public void user_input_secret_sauce_as_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Then("user verify (.*) login result$")
    public void user_verify_success_login_result(String status) {
        if(status.equals("success")){
            String dashboard= driver.findElement(By.xpath("//div[@class='app_logo']")).getText();
            Assert.assertEquals(dashboard, "Swag Labs");
        } else if(status.equals("failed")) {
            String dashboard= driver.findElement(By.xpath("//div[contains(@class, 'error')]")).getText();
            Assert.assertEquals(dashboard,
                    "Epic sadface: Username and password do not match any user in this service");

        } else
            if(status.equals("blankemail")){
                String dashboard= driver.findElement(By.xpath("//div[contains(@class, 'error')]")).getText();
                Assert.assertEquals(dashboard,
                        "Epic sadface: Username is required");

            } else
                if(status.equals("blankpw")){
                    String dashboard= driver.findElement(By.xpath("//div[contains(@class, 'error')]")).getText();
                    Assert.assertEquals(dashboard,
                            "Epic sadface: Password is required");
                }

                driver.close();
    }



}
