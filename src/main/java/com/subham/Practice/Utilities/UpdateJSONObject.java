package com.subham.Practice.Utilities;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class UpdateJSONObject {
    public static void main(String[] args) throws IOException {
//        String req = "{\"insuredPersonsCount\":\"1\",\"type\":\"D\",\"bookingId\":\"HDFCNGD17090289508345050\",\"bookingDate\":\"2024-02-27\",\"packageName\":\"HDFCN\",\"insuredPersons\":[{\"profession\":\"\",\"lastName\":\"Test\",\"address\":{\"country\":\"\",\"city\":\"\",\"street\":\"\",\"pinCode\":\"\",\"state\":\"\"},\"gender\":\"M\",\"mobile\":\"9951521206\",\"title\":\"Mr\",\"type\":\"N\",\"firstName\":\"Test\",\"dob\":\"1998-11-11\",\"nominee\":null,\"paxId\":\"1\",\"flights\":[{\"ticketNumber\":\"XS3LUF\",\"baseFare\":\"2810\",\"cancellationCharge\":\"519\",\"endDate\":\"2024-05-09T18:15:00\",\"destination\":\"BLR\",\"source\":\"GOI\",\"feesSurcharge\":\"0.0\",\"leg\":\"1\",\"convenienceFee\":\"0.0\",\"journeyType\":\"O\",\"providerTravelNo\":\"6784\",\"fareType\":\"N\",\"providerName\":\"6E\",\"startDate\":\"2024-05-09T17:15:00\",\"classType\":\"E\",\"travelMode\":\"A\"}],\"email\":\"suresh.d@reward360.co\"}],\"cancellationDate\":\"2024-02-27T16:26:07\"}";

//        String req = "{\"insuredPersonsCount\":\"1\",\"type\":\"D\",\"bookingId\":\"HDFCNGD17090289508345050\",\"bookingDate\":\"2024-02-27\",\"packageName\":\"HDFCN\",\"insuredPersons\":[{\"profession\":\"\",\"lastName\":\"Test\",\"address\":{\"country\":\"\",\"city\":\"\",\"street\":\"\",\"pinCode\":\"\",\"state\":\"\"},\"gender\":\"M\",\"mobile\":\"9951521206\",\"title\":\"Mr\",\"type\":\"N\",\"firstName\":\"Test\",\"dob\":\"1998-11-11\",\"nominee\":null,\"paxId\":\"1\",\"flights\":[{\"ticketNumber\":\"XS3LUF\",\"baseFare\":\"2810\",\"cancellationCharge\":\"519\",\"endDate\":\"2024-05-09T18:15:00\",\"destination\":\"BLR\",\"source\":\"GOI\",\"feesSurcharge\":\"0.0\",\"leg\":\"1\",\"convenienceFee\":\"0.0\",\"journeyType\":\"O\",\"providerTravelNo\":\"6784\",\"fareType\":\"N\",\"providerName\":\"6E\",\"startDate\":\"2024-05-09T17:15:00\",\"classType\":\"E\",\"travelMode\":\"A\"}],\"email\":\"suresh.d@reward360.co\"},{\"profession\":\"\",\"lastName\":\"Test\",\"address\":{\"country\":\"\",\"city\":\"\",\"street\":\"\",\"pinCode\":\"\",\"state\":\"\"},\"gender\":\"M\",\"mobile\":\"9951521206\",\"title\":\"Mr\",\"type\":\"N\",\"firstName\":\"Test\",\"dob\":\"1998-11-11\",\"nominee\":null,\"paxId\":\"1\",\"flights\":[{\"ticketNumber\":\"XS3LUF\",\"baseFare\":\"2810\",\"cancellationCharge\":\"519\",\"endDate\":\"2024-05-09T18:15:00\",\"destination\":\"BLR\",\"source\":\"GOI\",\"feesSurcharge\":\"0.0\",\"leg\":\"1\",\"convenienceFee\":\"0.0\",\"journeyType\":\"O\",\"providerTravelNo\":\"6784\",\"fareType\":\"N\",\"providerName\":\"6E\",\"startDate\":\"2024-05-09T17:15:00\",\"classType\":\"E\",\"travelMode\":\"A\"}],\"email\":\"suresh.d@reward360.co\"}],\"cancellationDate\":\"2024-02-27T16:26:07\"}";

        String req = "{\"insuredPersonsCount\":\"1\",\"type\":\"D\",\"bookingId\":\"HDFCNGD17090289508345050\",\"bookingDate\":\"2024-02-27\",\"packageName\":\"HDFCN\",\"insuredPersons\":[{\"profession\":\"\",\"lastName\":\"Test\",\"address\":{\"country\":\"\",\"city\":\"\",\"street\":\"\",\"pinCode\":\"\",\"state\":\"\"},\"gender\":\"M\",\"mobile\":\"9951521206\",\"title\":\"Mr\",\"type\":\"N\",\"firstName\":\"Test\",\"dob\":\"1998-11-11\",\"nominee\":null,\"paxId\":\"1\",\"flights\":[{\"ticketNumber\":\"XS3LUF\",\"baseFare\":\"2810\",\"cancellationCharge\":\"519\",\"endDate\":\"2024-05-09T18:15:00\",\"destination\":\"BLR\",\"source\":\"GOI\",\"feesSurcharge\":\"0.0\",\"leg\":\"1\",\"convenienceFee\":\"0.0\",\"journeyType\":\"O\",\"providerTravelNo\":\"6784\",\"fareType\":\"N\",\"providerName\":\"6E\",\"startDate\":\"2024-05-09T17:15:00\",\"classType\":\"E\",\"travelMode\":\"A\"},{\"ticketNumber\":\"XS3LUF\",\"baseFare\":\"2810\",\"cancellationCharge\":\"519\",\"endDate\":\"2024-05-09T18:15:00\",\"destination\":\"BLR\",\"source\":\"GOI\",\"feesSurcharge\":\"0.0\",\"leg\":\"2\",\"convenienceFee\":\"0.0\",\"journeyType\":\"O\",\"providerTravelNo\":\"6784\",\"fareType\":\"N\",\"providerName\":\"6E\",\"startDate\":\"2024-05-09T17:15:00\",\"classType\":\"E\",\"travelMode\":\"A\"}],\"email\":\"suresh.d@reward360.co\"},{\"profession\":\"\",\"lastName\":\"Test1\",\"address\":{\"country\":\"\",\"city\":\"\",\"street\":\"\",\"pinCode\":\"\",\"state\":\"\"},\"gender\":\"M\",\"mobile\":\"99515287945\",\"title\":\"Mr\",\"type\":\"N\",\"firstName\":\"Test1\",\"dob\":\"2000-11-11\",\"nominee\":null,\"paxId\":\"1\",\"flights\":[{\"ticketNumber\":\"XS38UF\",\"baseFare\":\"2810\",\"cancellationCharge\":\"519\",\"endDate\":\"2024-05-09T18:15:00\",\"destination\":\"BLR\",\"source\":\"GOI\",\"feesSurcharge\":\"0.0\",\"leg\":\"1\",\"convenienceFee\":\"0.0\",\"journeyType\":\"O\",\"providerTravelNo\":\"6784\",\"fareType\":\"N\",\"providerName\":\"6E\",\"startDate\":\"2024-05-09T17:15:00\",\"classType\":\"E\",\"travelMode\":\"A\"},{\"ticketNumber\":\"XS3LUF\",\"baseFare\":\"2810\",\"cancellationCharge\":\"519\",\"endDate\":\"2024-05-09T18:15:00\",\"destination\":\"BLR\",\"source\":\"GOI\",\"feesSurcharge\":\"0.0\",\"leg\":\"2\",\"convenienceFee\":\"0.0\",\"journeyType\":\"O\",\"providerTravelNo\":\"6784\",\"fareType\":\"N\",\"providerName\":\"6E\",\"startDate\":\"2024-05-09T17:15:00\",\"classType\":\"E\",\"travelMode\":\"A\"}],\"email\":\"suresh.d@reward360.co\"}],\"cancellationDate\":\"2024-02-27T16:26:07\"}";

        JSONObject claimRoot = new JSONObject(req);

        System.out.println(claimRoot);


        // setting cancellation charges - subham
        System.out.println("before cancellation charge changes : " + claimRoot);
        JSONArray insuredPersonsArray = claimRoot.getJSONArray("insuredPersons");
        int numOfPassengers = insuredPersonsArray.length();

        double personWiseCancellationCharges = (double) Integer.parseInt("40") / numOfPassengers;
        System.out.println("personWiseCharges : " + personWiseCancellationCharges);

        for (int i = 0; i < insuredPersonsArray.length(); i++) {
            JSONArray flightsArray = insuredPersonsArray.getJSONObject(i).getJSONArray("flights");
            int numberOfSegments = flightsArray.length();
            System.out.println("onwRetSenumOfSegments : " + numberOfSegments);

            double segmentWiseCancellationCharges = personWiseCancellationCharges / numberOfSegments;

            for (int j = 0; j < flightsArray.length(); j++) {
                flightsArray.getJSONObject(j).put("cancellationCharge", segmentWiseCancellationCharges);
            }
        }
        System.out.println("post cancellation charge changes : " + claimRoot);
    }

}
