package myrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features="src\\test\\java\\features\\login.feature",
		glue="stepdef",
		plugin = { "pretty","html:target/cucumber-reports.html"}, 
		tags = "@login", 
		monochrome=false)

public class LoginStepsRunner extends AbstractTestNGCucumberTests {

}
