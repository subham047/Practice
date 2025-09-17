package com.subham.Practice.Utilities;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ToStringImpl {
    public static void main(String[] args) throws IOException {
        String jsonInString = new String(Files.readAllBytes(Paths.get("/home/subham.s@reward360.local/Office/long string test/jsonToString.json")));
        try {
            // Convert the JSON string to pretty format for better readability (optional)
            ObjectMapper objectMapper = new ObjectMapper();
            Object jsonObj = objectMapper.readValue(jsonInString, Object.class);
            String jsonString = objectMapper.writeValueAsString(jsonObj);

            System.out.println(jsonString);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



/*
UPDATE `portal`.`orders`
SET `order_status` = 'Successful',
    `booking_details` = '{"pnr":[{"airlinepnr":"QTUCYZ","flightno":"","ticket_number":"QTUCYZ,QTUCYZ,","bookingid":"GOFLDMT7AEFD1720442485","segmentid":"1"},{"airlinepnr":"QTUCYZ","flightno":"","ticket_number":"QTUCYZ,QTUCYZ,","bookingid":"GOFLDMT7AEFD1720442485","segmentid":"2"},{"airlinepnr":"CWFMHV","flightno":"","ticket_number":"CWFMHV,CWFMHV,","bookingid":"GOFLDMT7AEFD1720442485","segmentid":"3"},{"airlinepnr":"CWFMHV","flightno":"","ticket_number":"CWFMHV,CWFMHV,","bookingid":"GOFLDMT7AEFD1720442485","segmentid":"4"},{"airlinepnr":"FABSTK","flightno":"","ticket_number":"FABSTK,FABSTK,","bookingid":"GOFLDMT7AEFD1720442414","segmentid":"5"},{"airlinepnr":"FABSTK","flightno":"","ticket_number":"FABSTK,FABSTK,","bookingid":"GOFLDMT7AEFD1720442414","segmentid":"6"}]}'
WHERE (`order_ref_num` = '44117272617451332997');


UPDATE `portal`.`orders`
SET `order_status` = 'Successful',
    `booking_details` = '{"pnr":[{"airlinepnr":"P2GU9X","flightno":"","ticket_number":"P2GU9X","bookingid":"GOFLDMT8DB3A1720462769","segmentid":"1"},{"airlinepnr":"P2GU9X","flightno":"","ticket_number":"P2GU9X","bookingid":"GOFLDMT8DB3A1720462769","segmentid":"2"},{"airlinepnr":"Z4GP7U","flightno":"","ticket_number":"Z4GP7U","bookingid":"GOFLDMT8DB3A1720462769","segmentid":"3"}]}'
WHERE (`order_ref_num` = '44117272594075805198');

*/
