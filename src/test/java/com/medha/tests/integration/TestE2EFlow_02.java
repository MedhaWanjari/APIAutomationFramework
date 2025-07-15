package com.medha.tests.integration;

import com.medha.base.BaseTest;
import com.medha.endpoints.APIConstant;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class TestE2EFlow_02 extends BaseTest {
    // Create Booking -> Delete it -> Verify
    @Test(groups = "qa", priority = 1)
    @Owner("Medha")
    @Description("TC#DEL1 - Create Booking, then Delete it using token")
    public void testDeleteBooking() {

        // Step 1: Create Booking
        requestSpecification.basePath(APIConstant.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification)
                .when().body(payloadManager.createPayloadBookingAsString())
                .post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        Integer bookingid = payloadManager.bookingResponseJava(response.asString()).getBookingid();
        assertThat(bookingid).isNotNull();

        // Step 2: Get Token
        String token = getToken();
        assertThat(token).isNotNull().isNotEmpty();

        // Step 3: Delete Booking by ID
        String deletePath = APIConstant.CREATE_UPDATE_BOOKING_URL + "/" + bookingid;
        requestSpecification.basePath(deletePath).cookie("token", token);

        validatableResponse = RestAssured.given()
                .spec(requestSpecification)
                .when().delete()
                .then().log().all();

        validatableResponse.statusCode(201); // Some APIs may return 200 or 204 too

        // Optionally: You can recheck GET call here to confirm it's deleted (Expect 404)
    }
}

