package com.medha.base;

import com.medha.asserts.AssertsAction;
import com.medha.asserts.AssertsAction;
import com.medha.endpoints.APIConstant;
import com.medha.modules.PayloadManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    // CommonToAll Testcase
    //   // Base URL, Content Type - json - common

    public RequestSpecification requestSpecification;
    public AssertsAction assertAction;
    public PayloadManager payloadManager;
    public JsonPath jsonPath;
    public Response response;
    public ValidatableResponse validatableResponse;

    @BeforeTest
    public void setUp() {
        // Base URL, Content Type - json
        payloadManager = new PayloadManager();
        assertAction = new AssertsAction();

//        requestSpecification = RestAssured.given();
//        requestSpecification.baseUri(APIConstants.BASE_URL);
//        requestSpecification.contentType(ContentType.JSON).log().all();


        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(APIConstant.BASE_URL)
                .addHeader("Content-Type", "application/json")
                .build().log().all();



    }


    public String getToken() {
        requestSpecification = RestAssured
                .given()
                .baseUri(APIConstant.BASE_URL)
                .basePath(APIConstant.AUTH_URL);

        // Setting the payload
        String payload = payloadManager.setAuthPayload();

        // Get the Token
        response = requestSpecification.contentType(ContentType.JSON).body(payload).when().post();
        // String Extraction
        String token = payloadManager.getTokenFromJSON(response.asString());

        return token;


    }
}
