package com.subham.Practice.Utilities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsonNodeLoop {

    public static void main(String[] args) throws IOException {


        String seat = "23A";
        String seatAlpha = seat.substring(seat.length()-1);
        System.out.println(seatAlpha);
        seat = seat.replace(seatAlpha,"");
        System.out.println(seat);

        String v1 = "\"VGML\"";
        System.out.println(v1);

        String value = "0";
        value = "1";
        value = "2";

        System.out.println("value = " + value);


        String jsonNodeInString = "{\n" +
                "  \"VASDetails\": {\n" +
                "    \"addonsMap\": {\n" +
                "      \"0\": {\n" +
                "        \"seats\": {\n" +
                "          \"seat\": {\n" +
                "            \"DEL$BOM\": [\n" +
                "              {\n" +
                "                \"paxID\": 0,\n" +
                "                \"seatDetail\": {\n" +
                "                  \"3A\": {\n" +
                "                    \"premium\": false,\n" +
                "                    \"available\": true,\n" +
                "                    \"currency\": null,\n" +
                "                    \"sellPrice\": 900,\n" +
                "                    \"exchangeable\": false,\n" +
                "                    \"refundable\": false,\n" +
                "                    \"seatCharacteristics\": [\n" +
                "                      \"WINDOW\",\n" +
                "                      \"INFANT\",\n" +
                "                      \"SENIOR_CITIZEN\",\n" +
                "                      \"CHILD\",\n" +
                "                      \"ADULT\"\n" +
                "                    ]\n" +
                "                  }\n" +
                "                }\n" +
                "              },\n" +
                "              {\n" +
                "                \"paxID\": 1,\n" +
                "                \"seatDetail\": {\n" +
                "                  \"3B\": {\n" +
                "                    \"premium\": false,\n" +
                "                    \"available\": true,\n" +
                "                    \"currency\": null,\n" +
                "                    \"sellPrice\": 700,\n" +
                "                    \"exchangeable\": false,\n" +
                "                    \"refundable\": false,\n" +
                "                    \"seatCharacteristics\": [\n" +
                "                      \"MIDDLE\",\n" +
                "                      \"INFANT\",\n" +
                "                      \"SENIOR_CITIZEN\",\n" +
                "                      \"CHILD\",\n" +
                "                      \"ADULT\"\n" +
                "                    ]\n" +
                "                  }\n" +
                "                }\n" +
                "              }\n" +
                "            ]\n" +
                "          }\n" +
                "        },\n" +
                "        \"ancillaryInfo\": {\n" +
                "          \"baggage\": {\n" +
                "            \"ssr\": {\n" +
                "              \"DEL$BOM\": [\n" +
                "                {\n" +
                "                  \"paxID\": 0,\n" +
                "                  \"ssrList\": {\n" +
                "                    \"sellPrice\": 13500,\n" +
                "                    \"availability\": null,\n" +
                "                    \"maxCountAvailable\": null,\n" +
                "                    \"description\": \"Excess Baggage\",\n" +
                "                    \"currencyCode\": null,\n" +
                "                    \"mandatory\": null,\n" +
                "                    \"value\": 30,\n" +
                "                    \"unit\": \"KG\",\n" +
                "                    \"ssrType\": \"CHECKIN_BAGGAGE\",\n" +
                "                    \"ssrcode\": \"EB30\",\n" +
                "                    \"imageURL\": null,\n" +
                "                    \"mealType\": null\n" +
                "                  }\n" +
                "                },\n" +
                "                {\n" +
                "                  \"paxID\": 1,\n" +
                "                  \"ssrList\": {\n" +
                "                    \"sellPrice\": 6750,\n" +
                "                    \"availability\": null,\n" +
                "                    \"maxCountAvailable\": null,\n" +
                "                    \"description\": \"Excess Baggage\",\n" +
                "                    \"currencyCode\": null,\n" +
                "                    \"mandatory\": null,\n" +
                "                    \"value\": 15,\n" +
                "                    \"unit\": \"KG\",\n" +
                "                    \"ssrType\": \"CHECKIN_BAGGAGE\",\n" +
                "                    \"ssrcode\": \"EB15\",\n" +
                "                    \"imageURL\": null,\n" +
                "                    \"mealType\": null\n" +
                "                  }\n" +
                "                }\n" +
                "              ]\n" +
                "            },\n" +
                "            \"error\": null\n" +
                "          },\n" +
                "          \"meals\": {\n" +
                "            \"ssr\": {\n" +
                "              \"DEL$BOM\": [\n" +
                "                {\n" +
                "                  \"paxID\": 0,\n" +
                "                  \"ssrList\": {\n" +
                "                    \"sellPrice\": 300,\n" +
                "                    \"availability\": null,\n" +
                "                    \"maxCountAvailable\": null,\n" +
                "                    \"description\": \"Chicken in Red Thai Curry with Steamed Rice (200 gms)\",\n" +
                "                    \"currencyCode\": null,\n" +
                "                    \"mandatory\": null,\n" +
                "                    \"value\": null,\n" +
                "                    \"unit\": null,\n" +
                "                    \"ssrType\": null,\n" +
                "                    \"ssrcode\": \"NCC2\",\n" +
                "                    \"imageURL\": null,\n" +
                "                    \"mealType\": null\n" +
                "                  }\n" +
                "                },\n" +
                "                {\n" +
                "                  \"paxID\": 1,\n" +
                "                  \"ssrList\": {\n" +
                "                    \"sellPrice\": 300,\n" +
                "                    \"availability\": null,\n" +
                "                    \"maxCountAvailable\": null,\n" +
                "                    \"description\": \"Chicken schezwan on bed of fried rice (210 gms)\",\n" +
                "                    \"currencyCode\": null,\n" +
                "                    \"mandatory\": null,\n" +
                "                    \"value\": null,\n" +
                "                    \"unit\": null,\n" +
                "                    \"ssrType\": null,\n" +
                "                    \"ssrcode\": \"NCC6\",\n" +
                "                    \"imageURL\": null,\n" +
                "                    \"mealType\": null\n" +
                "                  }\n" +
                "                }\n" +
                "              ]\n" +
                "            },\n" +
                "            \"error\": null\n" +
                "          }\n" +
                "        }\n" +
                "      },\n" +
                "      \"1\": {\n" +
                "        \"seats\": {\n" +
                "          \"seat\": {\n" +
                "            \"BOM$DEL\": [\n" +
                "              {\n" +
                "                \"paxID\": 0,\n" +
                "                \"seatDetail\": {\n" +
                "                  \"1A\": {\n" +
                "                    \"premium\": false,\n" +
                "                    \"available\": true,\n" +
                "                    \"currency\": null,\n" +
                "                    \"sellPrice\": 999,\n" +
                "                    \"exchangeable\": false,\n" +
                "                    \"refundable\": false,\n" +
                "                    \"seatCharacteristics\": [\n" +
                "                      \"WINDOW\",\n" +
                "                      \"INFANT\",\n" +
                "                      \"SENIOR_CITIZEN\",\n" +
                "                      \"CHILD\",\n" +
                "                      \"ADULT\"\n" +
                "                    ]\n" +
                "                  }\n" +
                "                }\n" +
                "              },\n" +
                "              {\n" +
                "                \"paxID\": 1,\n" +
                "                \"seatDetail\": {\n" +
                "                  \"1B\": {\n" +
                "                    \"premium\": false,\n" +
                "                    \"available\": true,\n" +
                "                    \"currency\": null,\n" +
                "                    \"sellPrice\": 999,\n" +
                "                    \"exchangeable\": false,\n" +
                "                    \"refundable\": false,\n" +
                "                    \"seatCharacteristics\": [\n" +
                "                      \"MIDDLE\",\n" +
                "                      \"INFANT\",\n" +
                "                      \"SENIOR_CITIZEN\",\n" +
                "                      \"CHILD\",\n" +
                "                      \"ADULT\"\n" +
                "                    ]\n" +
                "                  }\n" +
                "                }\n" +
                "              }\n" +
                "            ]\n" +
                "          }\n" +
                "        },\n" +
                "        \"ancillaryInfo\": {\n" +
                "          \"baggage\": {\n" +
                "            \"ssr\": {\n" +
                "              \"BOM$DEL\": [\n" +
                "                {\n" +
                "                  \"paxID\": 0,\n" +
                "                  \"ssrList\": {\n" +
                "                    \"sellPrice\": 13500,\n" +
                "                    \"availability\": null,\n" +
                "                    \"maxCountAvailable\": null,\n" +
                "                    \"description\": \"Excess Baggage\",\n" +
                "                    \"currencyCode\": null,\n" +
                "                    \"mandatory\": null,\n" +
                "                    \"value\": 30,\n" +
                "                    \"unit\": \"KG\",\n" +
                "                    \"ssrType\": \"CHECKIN_BAGGAGE\",\n" +
                "                    \"ssrcode\": \"EB30\",\n" +
                "                    \"imageURL\": null,\n" +
                "                    \"mealType\": null\n" +
                "                  }\n" +
                "                },\n" +
                "                {\n" +
                "                  \"paxID\": 1,\n" +
                "                  \"ssrList\": {\n" +
                "                    \"sellPrice\": 6750,\n" +
                "                    \"availability\": null,\n" +
                "                    \"maxCountAvailable\": null,\n" +
                "                    \"description\": \"Excess Baggage\",\n" +
                "                    \"currencyCode\": null,\n" +
                "                    \"mandatory\": null,\n" +
                "                    \"value\": 15,\n" +
                "                    \"unit\": \"KG\",\n" +
                "                    \"ssrType\": \"CHECKIN_BAGGAGE\",\n" +
                "                    \"ssrcode\": \"EB15\",\n" +
                "                    \"imageURL\": null,\n" +
                "                    \"mealType\": null\n" +
                "                  }\n" +
                "                }\n" +
                "              ]\n" +
                "            },\n" +
                "            \"error\": null\n" +
                "          },\n" +
                "          \"meals\": {\n" +
                "            \"ssr\": {\n" +
                "              \"BOM$DEL\": [\n" +
                "                {\n" +
                "                  \"paxID\": 0,\n" +
                "                  \"ssrList\": {\n" +
                "                    \"sellPrice\": 300,\n" +
                "                    \"availability\": null,\n" +
                "                    \"maxCountAvailable\": null,\n" +
                "                    \"description\": \"Chicken in Red Thai Curry with Steamed Rice (200 gms)\",\n" +
                "                    \"currencyCode\": null,\n" +
                "                    \"mandatory\": null,\n" +
                "                    \"value\": null,\n" +
                "                    \"unit\": null,\n" +
                "                    \"ssrType\": null,\n" +
                "                    \"ssrcode\": \"NCC2\",\n" +
                "                    \"imageURL\": null,\n" +
                "                    \"mealType\": null\n" +
                "                  }\n" +
                "                },\n" +
                "                {\n" +
                "                  \"paxID\": 1,\n" +
                "                  \"ssrList\": {\n" +
                "                    \"sellPrice\": 300,\n" +
                "                    \"availability\": null,\n" +
                "                    \"maxCountAvailable\": null,\n" +
                "                    \"description\": \"Chicken schezwan on bed of fried rice (210 gms)\",\n" +
                "                    \"currencyCode\": null,\n" +
                "                    \"mandatory\": null,\n" +
                "                    \"value\": null,\n" +
                "                    \"unit\": null,\n" +
                "                    \"ssrType\": null,\n" +
                "                    \"ssrcode\": \"NCC6\",\n" +
                "                    \"imageURL\": null,\n" +
                "                    \"mealType\": null\n" +
                "                  }\n" +
                "                }\n" +
                "              ]\n" +
                "            },\n" +
                "            \"error\": null\n" +
                "          }\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}";
        List<String> seatKeysList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readValue(jsonNodeInString, JsonNode.class);
        System.out.println(jsonNode);

        List<String> paxIdList = new ArrayList<>();
        if (jsonNode.has("VASDetails")) {
            if (jsonNode.get("VASDetails").get("addonsMap").has("0")) {
                Iterator<String> seatKeys = jsonNode.get("VASDetails").get("addonsMap").get("0").get("seats").get("seat").fieldNames();
                JsonNode seatNode = jsonNode.get("VASDetails").get("addonsMap").get("0").get("seats").get("seat");
                seatKeys.forEachRemaining(e -> seatKeysList.add(e));
                for (String key : seatKeysList) {
                    ArrayNode seatArray = (ArrayNode) seatNode.get(key);
                    for (JsonNode jsnIndex : seatArray) {
                        paxIdList.add(String.valueOf(jsnIndex.get("paxID")));
                    }
                }
            }
            for (String paxId : paxIdList) {
                System.out.println(paxId);
            }
        }


        for (String paxId : paxIdList) {
            System.out.println(paxId);
            if (jsonNode.has("VASDetails")) {
                System.out.println(jsonNode.has("VASDetails"));
                if (jsonNode.get("VASDetails").get("addonsMap").has("0")) {

                    //seat details
                    Iterator<String> seatKeys = jsonNode.get("VASDetails").get("addonsMap").get("0").get("seats").get("seat").fieldNames();
                    JsonNode seatNode = jsonNode.get("VASDetails").get("addonsMap").get("0").get("seats").get("seat");
                    seatKeys.forEachRemaining(e -> seatKeysList.add(e));

                    for (String key : seatKeysList) {
//                    System.out.println(key);
//                    System.out.println(seatNode.get(key));
                        ArrayNode seatArray = (ArrayNode) seatNode.get(key);
//                    System.out.println("seatArray = "+seatArray);
                        for (JsonNode jsnIndex : seatArray) {
                            System.out.println("jsnIndex = " + jsnIndex);
                            System.out.println(jsnIndex.get("seatDetail"));

                            if ((jsnIndex.get("paxID") + "").equals(paxId)) {
                                Iterator<String> seatDetailKeys = jsnIndex.get("seatDetail").fieldNames();
                                JsonNode seatDetailNode = jsnIndex.get("seatDetail");
                                System.out.println("seatDetailNode = " + seatDetailNode);
                                List<String> seatDetailKeysList = new ArrayList<>();
                                seatDetailKeys.forEachRemaining(e -> seatDetailKeysList.add(e));

                                for (String key1 : seatDetailKeysList) {
                                    System.out.println(key1);
                                    System.out.println(seatDetailNode.get(key1).get("sellPrice"));
                                }
                            }
                        }
                    }

                    //  baggage details
//                System.out.println(jsonNode.get("VASDetails").get("addonsMap").get("0").get("ancillaryInfo").get("baggage"));
                    List<String> baggageSourceDestKeysList = new ArrayList<>();
                    if (jsonNode.get("VASDetails").get("addonsMap").get("0").get("ancillaryInfo").has("baggage")) {
                        Iterator<String> baggageSourceDestKeys = jsonNode.get("VASDetails").get("addonsMap").get("0").get("ancillaryInfo").get("baggage").get("ssr").fieldNames();
                        JsonNode ssrJsonNode = jsonNode.get("VASDetails").get("addonsMap").get("0").get("ancillaryInfo").get("baggage").get("ssr");
                        baggageSourceDestKeys.forEachRemaining(e -> baggageSourceDestKeysList.add(e));

                        for (String baggageSourceDestKey : baggageSourceDestKeysList) {
                            ArrayNode baggageSourceDestArray = (ArrayNode) ssrJsonNode.get(baggageSourceDestKey);
                            System.out.println("baggageSourceDestArray = " + baggageSourceDestArray);
                            for (JsonNode baggageIndex : baggageSourceDestArray) {
//                            for (String paxId:paxIdList) {
//                                System.out.println("paxId from ssrnode : "+baggageIndex.get("paxID"));
//                                System.out.println("paxId from paxList : "+paxId);
//                                System.out.println((baggageIndex.get("paxID")+"").equals(paxId));
                                if ((baggageIndex.get("paxID") + "").equals(paxId)) {
                                    System.out.println(baggageIndex.get("paxID"));
                                }
//                            }
                            }
                        }

                    }


                    //meals details
                    List<String> mealSourceDestKeysList = new ArrayList<>();
                    if (jsonNode.get("VASDetails").get("addonsMap").get("0").get("ancillaryInfo").has("baggage")) {
                        Iterator<String> mealsSourceDestKeys = jsonNode.get("VASDetails").get("addonsMap").get("0").get("ancillaryInfo").get("meals").get("ssr").fieldNames();
                        JsonNode ssrJsonNode = jsonNode.get("VASDetails").get("addonsMap").get("0").get("ancillaryInfo").get("meals").get("ssr");
                        mealsSourceDestKeys.forEachRemaining(e -> mealSourceDestKeysList.add(e));

                        for (String mealSourceDestKey : mealSourceDestKeysList) {
                            ArrayNode mealSourceDestArray = (ArrayNode) ssrJsonNode.get(mealSourceDestKey);
                            System.out.println("mealSourceDestArray = " + mealSourceDestArray);
                            for (JsonNode mealIndex : mealSourceDestArray) {
//                            for (String paxId:paxIdList) {
//                                System.out.println("paxId from ssrnode : "+baggageIndex.get("paxID"));
//                                System.out.println("paxId from paxList : "+paxId);
//                                System.out.println((baggageIndex.get("paxID")+"").equals(paxId));
                                if ((mealIndex.get("paxID") + "").equals(paxId)) {
                                    System.out.println(mealIndex.get("paxID"));
                                }
//                            }
                            }
                        }

                    }
                }
            }
        }

    }
}
