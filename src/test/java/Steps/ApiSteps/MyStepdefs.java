package Steps.ApiSteps;

import Utils.Download;
import core.Api;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.IOException;

public class MyStepdefs {
    @Given("Load API endpoint {string}")
    public void loadAPIEndpoint(String endPoint) {
        Download download = new Download();
        download.downloadLocally(endPoint, "GET");
    }

    @Then("Verify text from pdf endpoint {string} contains text {string}")
    public void verifyTextFromPdfEndpointContainsText(String endPoint, String text) throws IOException {
        Download download = new Download();
        String content = download.extractContent(endPoint, "GET");
        Assert.assertTrue(content.contains(text), "Expected text  - '" + text + "' not found in PDF file");
//        System.out.println(content);
    }
}
