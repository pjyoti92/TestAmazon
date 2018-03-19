package step_definitions;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

public class RunCakeTest {

	@RunWith(Cucumber.class)
	@CucumberOptions(features = "src/test/java/features", glue = "step_definitions", plugin = { "pretty",
			"html:target/cucumber", }

	)
	public class RunCukeTest {

	}

}
