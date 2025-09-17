package com.subham.Practice.Utilities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class groupBy {
    public static void main(String[] args) throws IOException {
        String goibiboSegmentDetails = "{\n" +
                "    \"returns\": {},\n" +
                "    \"onwards\": {\n" +
                "        \"HYD$CCU$2023-11-17 20:25$6E-944\": [\n" +
                "            {\n" +
                "                \"modifiedLoc\": \"HYD$CCU\",\n" +
                "                \"segment\": \"3\",\n" +
                "                \"arrAirport\": \"CCU\",\n" +
                "                \"flightKey\": \"HYD$CCU$2023-11-17 20:25$6E-944\",\n" +
                "                \"depAirport\": \"HYD\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"DEL$MAA$2023-11-17 10:20$6E-6903|MAA$HYD$2023-11-17 16:05$6E-6471\": [\n" +
                "            {\n" +
                "                \"modifiedLoc\": \"DEL$MAA\",\n" +
                "                \"segment\": \"1\",\n" +
                "                \"arrAirport\": \"MAA\",\n" +
                "                \"flightKey\": \"DEL$MAA$2023-11-17 10:20$6E-6903\",\n" +
                "                \"depAirport\": \"DEL\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"modifiedLoc\": \"MAA$HYD\",\n" +
                "                \"segment\": \"2\",\n" +
                "                \"arrAirport\": \"HYD\",\n" +
                "                \"flightKey\": \"MAA$HYD$2023-11-17 16:05$6E-6471\",\n" +
                "                \"depAirport\": \"MAA\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}\n";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode goibiboFlightDetailsNode = objectMapper.readValue(goibiboSegmentDetails, JsonNode.class);
        System.out.println(goibiboFlightDetailsNode);

        List<String> directionKeyList = new ArrayList<>();
        Iterator<String> directionKeyIterator = goibiboFlightDetailsNode.fieldNames();
        directionKeyIterator.forEachRemaining(directionKeyList::add);

        List<JsonNode> segmentOrderList = new ArrayList<>();
        for (String directionKey : directionKeyList) {

            List<String> journeyKeyList = new ArrayList<>();
            Iterator<String> journeyKeyIterator = goibiboFlightDetailsNode.get(directionKey).fieldNames();
            journeyKeyIterator.forEachRemaining(journeyKeyList::add);

            for (String journeyKey : journeyKeyList) {
                ArrayNode journeyKeyArray = (ArrayNode) goibiboFlightDetailsNode.get(directionKey).get(journeyKey);
                for (JsonNode journeyKeyArrayIndex : journeyKeyArray) {
                    segmentOrderList.add(journeyKeyArrayIndex);
                }
            }
        }

        System.out.println("segmentOrderList : " + getOrderDetailsDTOJSON(segmentOrderList));
//
//        Map<String, List<JsonNode>> segmentOrderMap = segmentOrderList.parallelStream()
//                .collect(Collectors.groupingBy(segmentPojoObj -> String.valueOf(segmentPojoObj.get("segment").asText())));
//
//        System.out.println(getOrderDetailsDTOJSON(segmentOrderMap));

        // Sort the list based on the 'segment' key using Java Streams
        List<JsonNode> sortedData = segmentOrderList.stream()
                .sorted(Comparator.comparingInt(jsonObj -> Integer.parseInt(jsonObj.get("segment").asText())))
                .collect(Collectors.toList());

        // Print the sorted list
        System.out.println("sortedData : " + getOrderDetailsDTOJSON(sortedData));

    }

    static String getOrderDetailsDTOJSON(Object orderDetailsDTO) {
        String json = "";
        try {
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writeValueAsString(orderDetailsDTO);
        } catch (Exception e) {
            System.out.println("Error on converting  orderDetailsDTO to json" + e);
        }
        return json;
    }


}
