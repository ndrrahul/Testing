package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import java.util.logging.Logger;

@CucumberOptions(
        plugin = {"pretty","html:target/HtmlReport",
        "html:target/HtmlReport",
        "pretty:target/JsonReport.json",
        "json:target/json/cucumber.json"},
        tags = {"@Test"},
        features = {"src/test/resources/features"},
        glue = {"Steps.ApiSteps"},
        strict = true,
        dryRun = false
)
public class RunnerTest extends AbstractTestNGCucumberTests {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(RunnerTest.class));
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios(){return super.scenarios();}

    @AfterSuite
    public void afterSuite(){
//        RunnerHelper.afterSuite();
    }
    @BeforeSuite
    public void beforeSuite() throws Exception{
//        RunnerHelper.beforeSuite();
//        RunnerHelper.setCucumberOptions(this.getClass(),CucumberOptions.class);
    }
}
