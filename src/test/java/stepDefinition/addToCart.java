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

public class addToCart {

    WebDriver driver;
    String baseURL = "https://www.saucedemo.com/";

    @Given("user success open saucecode website")
    public void user_success_open_saucecode_website() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);

        String LoginPageAssert = driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
        Assert.assertEquals(LoginPageAssert, "Swag Labs");
    }

    @When("user input (.*) as a username$")
    public void userInputUsernameAsUsername(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    @And("user input (.*) as a password$")
    public void user_input_secret_sauce_as_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("user click login button")
    public void userClickButtonLogin() {
        WebElement password_form = driver.findElement(By.id("login-button"));
        password_form.isDisplayed();
        password_form.click();
    }

    @Then("user get (.*) login result$")
    public void user_verify_success_login_result(String status) {
        if (status.equals("success")) {
            String dashboard = driver.findElement(By.xpath("//div[@class='app_logo']")).getText();
            Assert.assertEquals(dashboard, "Swag Labs");
        } else {
            driver.findElement(By.xpath("//div[contains(@class, 'error')]")).isDisplayed();
        }
    }

    @When("user click one product")
    public void userClickOneProduct() {
        driver.findElement(By.className("inventory_item_name")).click();


    }

    @Then("user direct to product detail")
    public void userDirectToProductDetail() {
        String detailProduct = driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).getText();
        Assert.assertEquals(detailProduct, "Back to products");

    }

    @When("user click Add to Cart Button")
    public void userClickAddToCartButton() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @Then("Cart Symbol will increase total product")
    public void cartSymbolWillIncreaseTotalProduct() {
        driver.findElement(By.className("shopping_cart_badge")).isDisplayed();
    }

    @When("User click Remove button")
    public void userClickRemoveButton() {
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
    }

    @Then("Cart Symbol will deacres total product")
    public void cartSymbolWillDeacresTotalProduct() {
        try {
            WebElement total = driver.findElement(By.className("shopping_cart_badge"));
            boolean displayTotal = total.isDisplayed();
            if (displayTotal) {
                Assert.assertTrue(false);

            }

        } catch (Exception e) {
                    Assert.assertFalse(false);

        }
        driver.close();


    }
}
