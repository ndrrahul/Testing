package Steps.ApiSteps;

import core.Api;
import io.cucumber.java.en.Given;

public class MyStepdefs {
    @Given("Load API endpoint {string}")
    public void loadAPIEndpoint(String endPoint) {
        Api.makecall("GET",endPoint);
    }
}
