package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/resources/features",
        glue = "stepDefinition",
        plugin = {"html:target/HTML_reportLogin.html"},
        tags = "@TDD-Positive-Negative"
)

public class runLogin {

}