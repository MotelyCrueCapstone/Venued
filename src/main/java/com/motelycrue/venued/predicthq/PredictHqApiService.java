package com.motelycrue.venued.predicthq;

import org.springframework.stereotype.Service;
<<<<<<< HEAD
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


@Service("predictHqApiService")
public class PredictHqApiService {

    private final String predictBaseUrl = "https://api.predicthq.com/v1/events/";

    private static String makeAutoCompleteUrl(String latitude, String longitude){
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("http").host("www.baeldung.com").path("/junit-5").build();
        return String.format("", latitude, longitude);


=======

//getting the event according to longitude and latitude
//retrieved from yelp api
@Service
public class PredictHqApiService {

    private static String makeAutoCompleteUrl(String query, String latitude, String longitude){
        return String.format("%s%ssearch?latitude=%s&longitude=%s&term=%s&radius=2000&categories=club&sort_by=rating&limit=20",
                yelpBaseUrl,businesses, latitude, longitude, query);
>>>>>>> main
    }
}
