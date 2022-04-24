package Steps.ApiSteps;

import Utils.Download;
import core.Api;
import core.ScenarioContext;
import core.TestContext;
import enums.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseBodyExtractionOptions;
import org.testng.Assert;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class MyStepdefs {
    TestContext testContext = new TestContext();

    @Given("Load PDF API endpoint {string} with method {string}")
    public void loadPDFAPIEndpoint(String endPoint, String method) {
        Download download = new Download();
        byte[] pdfFile = download.downloadPdf(endPoint, method);
        testContext.scenarioContext.setContext(Context.API_RESPONSE, pdfFile);
    }

    @Given("Load API endpoint {string} with method {string}")
    public void loadAPIEndpoint(String endPoint, String method) {
        Download download = new Download();
        Response response;
            response = download.apiExecute(endPoint, method, (String) testContext.scenarioContext.getContext(Context.API_REQUEST));
//        ResponseBodyExtractionOptions responseBodyExtractionOptions = response.getBody();
        String strResponse = response.asPrettyString();
        int iStatusCode = response.getStatusCode();
//        String strResponse = new String(response.asByteArray(), StandardCharsets.UTF_8);
        testContext.scenarioContext.setContext(Context.API_RESPONSE, strResponse);
        testContext.scenarioContext.setContext(Context.API_STATUSCODE, iStatusCode);
        System.out.println("Status Code : - " + testContext.scenarioContext.getContext(Context.API_STATUSCODE));
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

    @Then("Set request body with template {string}")
    public void setRequestBodyWithTemplate(String strFile) throws IOException {
        File file = new File("src//test//resources//test_data//"+strFile);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String sCurrentLine, sRequest = "";
        while ((sCurrentLine = reader.readLine()) != null) {
            sRequest = sRequest + sCurrentLine;
        }
        testContext.scenarioContext.setContext(Context.API_REQUEST, sRequest);

    }
}
