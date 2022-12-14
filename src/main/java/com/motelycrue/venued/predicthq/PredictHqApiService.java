package com.motelycrue.venued.predicthq;

import org.springframework.stereotype.Service;

//getting the event according to longitude and latitude
//retrieved from yelp api
@Service
public class PredictHqApiService {

    private static String makeAutoCompleteUrl(String query, String latitude, String longitude){
        return String.format("%s%ssearch?latitude=%s&longitude=%s&term=%s&radius=2000&categories=club&sort_by=rating&limit=20",
                yelpBaseUrl,businesses, latitude, longitude, query);
    }
}
