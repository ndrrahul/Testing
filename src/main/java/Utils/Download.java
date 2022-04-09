package Utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;
import static io.restassured.RestAssured.given;

public class Download {

    public byte[] downloadPdf(String url, String method) {

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(url.toString());
        RequestSpecification requestSpecification = RestAssured.given(requestSpecBuilder.build()).relaxedHTTPSValidation();
        Response response = requestSpecification.request(Method.valueOf(method.toString().trim().toUpperCase()));
        return response.asByteArray();

    }

    public void downloadLocally(String url, String method) {
        byte[] pdfFile = downloadPdf(url, method);
        FileOutputStream fos;
        try {
            System.out.println(System.getProperty("user.home") + "/" + "file001" +".pdf");
            fos = new FileOutputStream(System.getProperty("user.home") + "/" + "file001" +".pdf");
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

    public String extractContent(String url, String method) throws IOException {
        byte[] pdfData = downloadPdf(url,method);
        PDDocument pdfDocument = PDDocument.load(new ByteArrayInputStream(pdfData));
        try {
            return new PDFTextStripper().getText(pdfDocument);
        } finally {
            pdfDocument.close();
        }
    }
}
