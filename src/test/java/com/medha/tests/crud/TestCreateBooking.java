package com.medha.tests.crud;

import com.medha.base.BaseTest;
import com.medha.endpoints.APIConstant;
import com.medha.pojos.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestCreateBooking extends BaseTest {
    // Create A Booking, Create a Token
    // Verify that Get booking -
    // Update the Booking
    // Delete the Booking

    @Test(groups = "reg", priority = 1)
    @Owner("Medha")
    @Description("TC#INT1 - Step 1. Verify that the Booking can be Created")
    public void testCreateBookingPOST(){
        requestSpecification.basePath(APIConstant.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification)
                .when().body(payloadManager.createPayloadBookingAsString())
                .post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());
        assertAction.verifyStringKey(bookingResponse.getBooking().getFirstname(), "Medha");
        assertAction.verifyStringKeyNotNull(bookingResponse.getBookingid());


    }

    }




