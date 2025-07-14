package com.medha.tests.crud;

import com.medha.base.BaseTest;
import com.medha.endpoints.APIConstant;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestHealthCheck extends BaseTest {
    @Test(groups = "reg", priority = 1)
    //@TmsLink("https://bugz.atlassian.net/browse/TS-1")
    @Owner("Medha")
    @Description("TC#3  - Verify Health")
    public void testGETHealthCheck() {
        requestSpecification.basePath(APIConstant.PING_URL);
        response = RestAssured.given(requestSpecification)
                .when()
                .get();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);
    }
}
