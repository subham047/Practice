package com.subham.Practice.Others.String;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.json.simple.parser.JSONParser;

import java.io.IOException;

public class StringManipulation {

    public static void main(String[] args) throws IOException {


        String str2 = "{\n" +
                "  \"pnr\": [ \n" +
                "    {\n" +
                "      \"airlinepnr\": \"G5327V\",  \n" +
                "      \"flightno\": \"SG-9991\",\n" +
                "      \"segmentid\": 1,\n" +
                "      \"bookingid\": \"DELBOMSG999120240329\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";


        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode bookingDetailslistNode = objectMapper.readValue(str2, JsonNode.class);
        ArrayNode pnrListNode = (ArrayNode) bookingDetailslistNode.get("pnr");

        System.out.println("pnrListNode : " + pnrListNode);
        String pnrListStr = pnrListNode.toString().replaceAll("airlinepnr","pnr");
        pnrListNode = objectMapper.readValue(pnrListStr, ArrayNode.class);

        System.out.println("pnrListNode : " + pnrListNode);


        String val = "1000.1";
        double val1 = Double.parseDouble(val);
        System.out.println("val1 : " + val1);


        String str = "DEL$HYD$TIR$2023-03-31 10:10$6E-2005";

        char[] fldnmeArr = str.toCharArray();
        int count = 0;
        for (int i = 0; i < fldnmeArr.length; i++) {
            if (fldnmeArr[i] == '$') {
                count = count + 1;
            }
        }


        String[] strArr = str.split("\\$");
        String[] finalStrArr = new String[strArr.length - 2];
        String[] connDestList = new String[finalStrArr.length - 1];
        String plc = "";
        if (count > 2) {

            int index = 0;
            for (String s : strArr) {
                if (index < strArr.length - 2) {
                    finalStrArr[index] = s;
                    index++;
                }
            }


            for (int i = 0; i < finalStrArr.length; i++) {
                if (i > 0) {
                    System.out.println("inside if-->");
                    i--;
                    plc = finalStrArr[i] + "$" + finalStrArr[++i];
                    System.out.println(plc);
                    connDestList[i - 1] = plc;
                }
            }
        }
        for (String s : connDestList) {
            System.out.println("connDestList index " + s);
        }


//        String str = "select * from orders where customer_id = :customer_id and client_token = :client_token  and (order_status='Failed' or order_status='Pending' or order_status='Successful' or order_status='Cancelled') and service_token = :service_token order by order_date desc limit :skip , :offset";
//        String newStr = str.replace(" limit :skip , :offset", "");
//        newStr = newStr.replace("*", "COUNT(*)");
//        System.out.println("newStr : " + newStr);
//
//
//        String countByServiceTokenQuery;
//        int index = newStr.indexOf("order by order_date");
//
//        countByServiceTokenQuery = newStr.substring(0, index) + "GROUP BY service_token " + newStr.substring(index);
//        countByServiceTokenQuery = countByServiceTokenQuery.replace("and service_token = :service_token ", "");
//        countByServiceTokenQuery = countByServiceTokenQuery.replace("COUNT(*)", "service_token, COUNT(*) AS count");
//        System.out.println("countByServiceTokenQuery : " + countByServiceTokenQuery);

    }

    public static org.json.simple.JSONObject stringTOSimpleJson(String soapmessageString) {
        org.json.simple.JSONObject jsonObj = null;
        JSONParser parser = new JSONParser();
        try {
            jsonObj = (org.json.simple.JSONObject) parser.parse(soapmessageString);
        } catch (Exception e) {
            jsonObj = null;
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return jsonObj;
    }

}
