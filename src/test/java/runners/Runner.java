package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",//Scenario steplerini konsola renkli yazdırır
                "html:target/reports/html-reports/default-cucumber-reports.html",//html formatında rapor için
                "json:target/reports/json-reports/cucumber1.json",//json formatında rapor için
                "junit:target/reports/xml-reports/cucumber1.xml",//xml formatında rapor için
                "rerun:target/failedScenarios.txt",//Fail olan scenarioların kaydını alır ve sadece bu testlerin koşulmasına yardımcı olur.
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" //Spark peport için

        },


        features = "src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@PositiveLogin",
        dryRun = false

)
public class Runner {

}
