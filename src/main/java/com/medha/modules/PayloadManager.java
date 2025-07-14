package com.medha.modules;

import com.google.gson.Gson;
import com.medha.pojos.*;

public class PayloadManager {

    // Convert Java Objects to JSON
    // Gson -> Ser and DeSer.

    Gson gson;

    public String createPayloadBookingAsString(){
        Booking booking = new Booking();
        booking.setFirstname("medha");
        booking.setLastname("wanjari");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2024-02-01");
        bookingDates.setCheckout("2024-02-01");
        booking.setBookingDates(bookingDates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);
        // Java Object -> JSON

        Gson gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        System.out.println(jsonStringBooking);
        return jsonStringBooking;


    }
    // Converting the String to the JAVA Object

    public BookingResponse bookingResponseJava(String responseString){
        gson = new Gson();
        BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponse.class);
        return bookingResponse;
    }

    public String setAuthPayload(){
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");
        gson = new Gson();
        String jsonPayloadString = gson.toJson(auth);
        System.out.println("Payload set to the -> " + jsonPayloadString);
        return jsonPayloadString;
    }
    // JSON to Java
    public String getTokenFromJSON(String tokenResponse){
        gson = new Gson();
        TokenResponse tokenResponse1 = gson.fromJson(tokenResponse, TokenResponse.class);
        return tokenResponse1.getToken().toString();

    }

    public Booking getResponseFromJSON(String getResponse){
        gson = new Gson();
        Booking booking = gson.fromJson(getResponse,Booking.class);
        return booking;
    }

    public String fullUpdatePayloadAsString(){
        Booking booking = new Booking();
        booking.setFirstname("sonu");
        booking.setLastname("wanjari");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2024-02-01");
        bookingDates.setCheckout("2024-02-01");
        booking.setBookingDates(bookingDates);
        booking.setAdditionalneeds("Breakfast");
        return gson.toJson(booking);



    }
}
