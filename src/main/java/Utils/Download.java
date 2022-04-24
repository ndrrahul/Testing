package Utils;

import enums.Context;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class Download {


    public byte[] downloadPdf(String url, String method) {

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(url.toString());
        RequestSpecification requestSpecification = RestAssured.given(requestSpecBuilder.build()).relaxedHTTPSValidation();
        Response response = requestSpecification.request(Method.valueOf(method.toString().trim().toUpperCase()));
        return response.asByteArray();
    }

    public Response apiExecute(String url, String method, String body) {

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(url);
        RequestSpecification requestSpecification = RestAssured.given(requestSpecBuilder.build()).relaxedHTTPSValidation();
        requestSpecification.header("Accept-Encoding", "gzip, deflate, br");
        requestSpecification.header("Accept", "*/*");
        if (body != null) {
            requestSpecification.body(body);
        }
        Response response = requestSpecification.request(Method.valueOf(method.trim().toUpperCase()));
        return response;
    }

    public void downloadLocally(byte[] pdfFile) {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(System.getProperty("user.home") + "/" + "file001" + ".pdf");
            fos.write(pdfFile);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    Extract content in a pdf file
    */

    public String extractContent(byte[] pdfData) throws IOException {
        PDDocument pdfDocument = PDDocument.load(new ByteArrayInputStream(pdfData));
        try {
            return new PDFTextStripper().getText(pdfDocument);
        } finally {
            pdfDocument.close();
        }
    }

}
