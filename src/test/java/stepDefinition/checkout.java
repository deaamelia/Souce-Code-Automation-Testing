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

public class checkout {
    WebDriver driver;
    String baseURL= "https://www.saucedemo.com/";

    @Given("user open saucecode app")
    public void user_success_open_saucecode_website() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);

        String LoginPageAssert = driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
        Assert.assertEquals(LoginPageAssert, "Swag Labs");
    }

    @When("user filled (.*) as a username$")
    public void userInputUsernameAsUsername(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    @And("user filled (.*) as a password$")
    public void user_input_secret_sauce_as_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("user go to click login button")
    public void userClickButtonLogin() {
        WebElement password_form = driver.findElement(By.id("login-button"));
        password_form.isDisplayed();
        password_form.click();
    }

    @Then("user get (.*) login status$")
    public void user_verify_success_login_result(String status) {
        if (status.equals("success")) {
            String dashboard = driver.findElement(By.xpath("//div[@class='app_logo']")).getText();
            Assert.assertEquals(dashboard, "Swag Labs");
        } else {
            driver.findElement(By.xpath("//div[contains(@class, 'error')]")).isDisplayed();
        }
    }

    @When("user click product")
    public void userClickOneProduct() {
        driver.findElement(By.className("inventory_item_name")).click();


    }

    @Then("user directly to product detail")
    public void userDirectToProductDetail() {
        String detailProduct = driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).getText();
        Assert.assertEquals(detailProduct, "Back to products");

    }

    @When("user press Add to Cart Button")
    public void userClickAddToCartButton() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @Then("Cart badge will increase total product")
    public void cartSymbolWillIncreaseTotalProduct() {
        driver.findElement(By.className("shopping_cart_badge")).isDisplayed();
    }

    @When("User click Shopping cart badge")
    public void user_click_shopping_cart(){
        driver.findElement(By.xpath("//a[contains(@class, 'shopping_cart_link')]")).click();
    }

    @Then("detail checkout will display")
    public void detailCheckoutWillDisplay() {
        String cart= driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(cart, "Your Cart");
    }

    @When("user click checkout buttton")
    public void userInputCheckoutButtton() {
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
    }

    @Then("display User information")
    public void displayUserInformation() {
        String detailUser= driver.findElement(By.xpath("//*[contains(text(), 'Checkout: Your Information')]")).getText();
        Assert.assertEquals(detailUser, "Checkout: Your Information");
    }

    @And("user input (.*) as first name$")
    public void userInputFirstnameAsFirstName(String firstname) {
        driver.findElement(By.id("first-name")).sendKeys(firstname);
    }

    @And("user input (.*) as last name$")
    public void userInputLastnameAsLastName(String lastname) {
        driver.findElement(By.id("last-name")).sendKeys(lastname);
    }

    @And("user input (.*) as zip code$")
    public void userInputZipcodeAsZipCode(String zipcode) {
        driver.findElement(By.id("postal-code")).sendKeys(zipcode);
    }

    @And("user click continue button")
    public void userClickContinueButton() {
        driver.findElement(By.id("continue")).click();
    }


    @Then("directly to overview page")
    public void directlyToOverviewPage() {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        String detailUser= driver.findElement(By.xpath("//*[contains(text(), 'Checkout: Overview')]")).getText();
        Assert.assertEquals(detailUser, "Checkout: Overview");
    }

    @When("user click finish button")
    public void userClickFinishButton() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("Will display Complete order page")
    public void willDisplayCompleteOrderPage() {
        String detailUser= driver.findElement(By.xpath("//*[contains(text(), 'Checkout: Complete!')]")).getText();
        Assert.assertEquals(detailUser, "Checkout: Complete!");
        driver.close();

    }


}
