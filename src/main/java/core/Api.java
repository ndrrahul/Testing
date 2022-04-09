package core;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Api {

    public static Response makecall(String method, String url){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(url.toString());
        RequestSpecification requestSpecification = RestAssured.given(requestSpecBuilder.build()).relaxedHTTPSValidation();
        Response response = requestSpecification.request(Method.valueOf(method.toString().trim().toUpperCase()));
        return response;
    }
}
