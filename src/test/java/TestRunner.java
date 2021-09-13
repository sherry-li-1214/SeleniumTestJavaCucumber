import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        monochrome = true,
        features = "src/test/resources/features",
        glue = {"utils.hooks", "steps"},
        plugin = {"pretty","json:target/cucumber.json", "html:target/cucumber-html-report"}
 )

public class TestRunner extends AbstractTestNGCucumberTests {

}