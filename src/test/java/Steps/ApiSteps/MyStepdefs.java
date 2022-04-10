package Steps.ApiSteps;

import Utils.Download;
import core.Api;
import core.ScenarioContext;
import core.TestContext;
import enums.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.IOException;

public class MyStepdefs {
    TestContext testContext = new TestContext();

    @Given("Load PDF API endpoint {string} with method {string}")
    public void loadAPIEndpoint(String endPoint, String method) {
        Download download = new Download();
        byte[] pdfFile = download.downloadPdf(endPoint, method);
        testContext.scenarioContext.setContext(Context.API_RESPONSE, pdfFile);
    }

    @Then("Verify text from PDF contains text {string}")
    public void verifyTextFromPdfEndpointContainsText(String endPoint, String text) throws IOException {
        Download download = new Download();
        String content = download.extractContent((byte[]) testContext.scenarioContext.getContext(Context.API_RESPONSE));
        Assert.assertTrue(content.contains(text), "Expected text  - '" + text + "' not found in PDF file");
//        System.out.println(content);
    }

    @Then("Download PDF and store in variable {string}")
    public void downloadPDFAndStoreInVariable(String var) {
        Download download = new Download();
        download.downloadLocally((byte[]) testContext.scenarioContext.getContext(Context.API_RESPONSE));
        testContext.scenarioContext.setContext(var, (byte[]) testContext.scenarioContext.getContext(Context.API_RESPONSE));
    }
}
