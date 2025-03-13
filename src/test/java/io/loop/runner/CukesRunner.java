package io.loop.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin ={//"pretty",
                "html:target/html-reports/cucumber-report.html",
                "json:target/json-reports/json-report.json",
                "rerun:target/rerun.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = "C:/Users/advok/IdeaProjects/cucumber-project-b4/src/test/resources/features",
        glue ="io/loop/step_definitions",
        dryRun = false,
        tags="@task2",
        monochrome=true,
        publish = false
)

public class CukesRunner {

}
