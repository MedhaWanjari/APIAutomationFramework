package com.medha.tests.crud;

import com.medha.base.BaseTest;
import com.medha.endpoints.APIConstant;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestCreateToken extends BaseTest {
    @Test(groups = "reg", priority = 1)
    //@TmsLink("https://bugz.atlassian.net/browse/TS-1")
    @Owner("Medha")
    @Description("TC#2  - Create Token and Verify")
    public void testTokenPOST() {
        requestSpecification.basePath(APIConstant.AUTH_URL);
        response = RestAssured.given(requestSpecification)
                .when().body(payloadManager.setAuthPayload())
                .post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        String token = payloadManager.getTokenFromJSON(response.asString());
        assertAction.verifyStringKeyNotNull(token);
    }

}
