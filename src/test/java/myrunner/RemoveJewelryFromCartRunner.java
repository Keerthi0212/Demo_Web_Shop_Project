package myrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src\\test\\java\\features\\remove.feature",
		glue={"stepdef","hooks"},
		plugin = { "pretty","html:target/cucumber-reports.html"}, 
		tags = "@remove", 
		monochrome=false)

public class RemoveJewelryFromCartRunner extends AbstractTestNGCucumberTests{
	

}
