package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features= "src/test/resources/",
        glue =  {"org.stepDefinations","hooks"},
        plugin = {"pretty"},
        tags="@Registration")
public class CukeTest {
}
