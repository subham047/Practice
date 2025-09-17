package com.subham.Practice.Utilities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class redisCompDecomp {

    public static void main(String[] args) throws IOException {

        String flightRequest = "{\"itineraryId\":\"Ease342316923599587203579\",\"convFee\":0,\"clientName\":\"HDFC243\",\"serviceName\":\"Flight\",\"partnerName\":\"Easemytrip\",\"itineraryType\":2,\"price\":\"9344\",\"scid\":\"\",\"comboFare\":false,\"origin\":\"DEL\",\"destination\":\"BOM\",\"onwardCheckInDate\":\"2023-09-27\",\"orderId\":\"\",\"adults\":1,\"child\":0,\"infants\":0,\"tripType\":\"DOM\",\"gstDetails\":{\"gstNumber\":\"\",\"name\":\"\",\"address\":\"\",\"city\":\"\",\"pincode\":0,\"state\":\"\"},\"threadName\":\"\",\"itinerary\":{\"cabinType\":\"E\",\"fareDetails\":[{\"amount\":3425,\"fareKey\":\"Ease342316923599587203579\",\"flightKey\":\"DELBOM20230927\"},{\"amount\":5919,\"fareKey\":\"Ease342316923599587669805\",\"flightKey\":\"BOMDEL20231028\"}],\"flights\":[{\"segments\":{\"onwardSegmentSpec\":[{\"departureAirport\":\"DEL\",\"arrivalAirport\":\"AMD\",\"flightNumber\":\"929\",\"airline\":\"UK\",\"operatingAirline\":\"\",\"departureDate\":\"2023-09-27\",\"stops\":0,\"segNum\":\"1\",\"duration\":\"5700\",\"arrivalDateTime\":\"22:55:00\",\"departureDateTime\":\"21:20:00\",\"arrivalDate\":\"2023-09-27\",\"bookingClass\":\"\"},{\"departureAirport\":\"AMD\",\"arrivalAirport\":\"BOM\",\"flightNumber\":\"908\",\"airline\":\"UK\",\"operatingAirline\":\"\",\"departureDate\":\"2023-09-28\",\"stops\":0,\"segNum\":\"2\",\"duration\":\"5400\",\"arrivalDateTime\":\"12:50:00\",\"departureDateTime\":\"11:20:00\",\"arrivalDate\":\"2023-09-28\",\"bookingClass\":\"\"}],\"returnSegmentSpec\":[{\"departureAirport\":\"BOM\",\"arrivalAirport\":\"DEL\",\"flightNumber\":\"635\",\"airline\":\"AI\",\"operatingAirline\":\"\",\"departureDate\":\"2023-10-28\",\"stops\":1,\"segNum\":\"1\",\"duration\":\"13200\",\"arrivalDateTime\":\"11:20:00\",\"departureDateTime\":\"07:40:00\",\"arrivalDate\":\"2023-10-28\",\"bookingClass\":\"\"}]}}],\"paxInfoList\":[{\"title\":\"Mr\",\"firstName\":\"Suresh\",\"lastName\":\"Mental\",\"type\":\"ADT\",\"dateOfBirth\":\"1990-11-11\",\"frequentFlyerNumbers\":[],\"paxID\":0}],\"contactDetail\":{\"title\":\"Mr\",\"firstName\":\"Suresh\",\"lastName\":\"Mental\",\"email\":\"krishna.k@reward360.co\",\"address\":\"Lavelle Road\",\"mobile\":\"9848158976\",\"landline\":\"000\",\"cityName\":\"Bangalore\",\"stateName\":\"Karnataka\",\"countryName\":\"India\",\"pinCode\":\"560001\",\"mobileIsdCode\":\"91\",\"additionalContact\":{\"email\":\"krishna.k@reward360.co\",\"mobile\":\"9848158976\",\"mobileIsdCode\":\"91\"}},\"paymentDetail\":{\"paymentType\":\"\",\"depositAccountId\":0}},\"customerId\":\"241010\",\"couponCode\":\"\",\"discountAmount\":0,\"operator\":\"\",\"osVersion\":\"web\",\"enabledVAS\":false}";
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode fltrqst = objectMapper.readValue(flightRequest, JsonNode.class);

        System.out.println("Original flightRequest : " + fltrqst);

        System.out.println("Size in KB before : " + getSizeInKB(fltrqst));
        System.out.println("Size in MB before : " + getSizeInMB(fltrqst));

        //compressing data
        byte[] compressedData = compressData(fltrqst.toString());
        System.out.println("compressed flightRequest : " + objectMapper.writeValueAsString(compressedData));

        System.out.println("Size in KB after : " + getSizeInKB(compressedData));
        System.out.println("Size in MB after : " + getSizeInMB(compressedData));

        String decompressedFlightRequest = decompressData(compressedData);

        System.out.println("decompressed flightRequest : " + objectMapper.readValue(decompressedFlightRequest, JsonNode.class));

    }

    public static double getSizeInKB(Object object) {
        if (object == null) {
            return 0.0;
        }

        // Calculate the size in bytes
        int bytes = Objects.toString(object).getBytes().length;

        // Convert to kilobytes
        return (double) bytes / 1024;
    }

    public static double getSizeInMB(Object object) {
        if (object == null) {
            return 0.0;
        }

        // Calculate the size in bytes
        int bytes = Objects.toString(object).getBytes().length;

        // Convert to megabytes
        return (double) bytes / (1024 * 1024);
    }

    private static byte[] compressData(String data) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream)) {
            gzipOutputStream.write(data.getBytes("UTF-8"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return outputStream.toByteArray();
    }

    private static String decompressData(byte[] compressedData) {
        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(compressedData);
             GZIPInputStream gzipInputStream = new GZIPInputStream(inputStream);
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = gzipInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            return new String(outputStream.toByteArray(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}


