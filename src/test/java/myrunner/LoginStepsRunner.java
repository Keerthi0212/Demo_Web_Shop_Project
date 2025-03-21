package myrunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features=".\\src\\test\\java\\features\\login.feature",
		glue="stepdef",plugin= {"pretty"},monochrome=true)

public class LoginStepsRunner extends AbstractTestNGCucumberTests {

}
