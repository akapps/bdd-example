package ch.antaes.kapps.demo.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Main entry-point that runs Cucumber tests.
 * <p>
 *     Tip : Look at the report in build/cucumber
 * </p>
 *
 * @author Antoine Kapps
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:build/cucumber/domain", "json:build/cucumber/domain/api/results.json"},
        glue = "classpath:ch/antaes/kapps/demo/bdd/glue",
        features = "classpath:features/"
)
public class CucumberBusinessLauncher {
}
