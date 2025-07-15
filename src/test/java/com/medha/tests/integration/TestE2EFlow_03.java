package com.medha.tests.integration;

import com.medha.base.BaseTest;

import com.medha.endpoints.APIConstant;
import com.medha.pojos.Booking;
import com.medha.pojos.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestE2EFlow_03 extends BaseTest {
    @Test(groups = "qa", priority = 1)
    @Owner("Medha")
    @Description("TC#UPDATE1 - Create Booking, then Update using PUT and verify response")
    public void testUpdateBooking() {

        // Step 1: Create a Booking
        requestSpecification.basePath(APIConstant.CREATE_UPDATE_BOOKING_URL);

        response = RestAssured
                .given(requestSpecification)
                .when()
                .body(payloadManager.createPayloadBookingAsString())
                .post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());
        Integer bookingid = bookingResponse.getBookingid();
        assertThat(bookingid).isNotNull();

        // Step 2: Get Auth Token
        String token = getToken();
        assertThat(token).isNotEmpty();

        // Step 3: Update the Booking with PUT
        String updateURL = APIConstant.CREATE_UPDATE_BOOKING_URL + "/" + bookingid;

        requestSpecification.basePath(updateURL).cookie("token", token);

        response = RestAssured
                .given(requestSpecification)
                .when()
                .body(payloadManager.fullUpdatePayloadAsString())
                .put();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // Step 4: Deserialize and Verify Response
        Booking updatedBooking = payloadManager.getResponseFromJSON(response.asString());

        assertThat(updatedBooking.getFirstname()).isEqualTo("Sonu");
        assertThat(updatedBooking.getLastname()).isEqualTo("Wanjari");
        assertThat(updatedBooking.getTotalprice()).isGreaterThan(0);
    }
}
