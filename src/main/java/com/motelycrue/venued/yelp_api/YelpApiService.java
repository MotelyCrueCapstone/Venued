package com.motelycrue.venued.yelp_api;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.motelycrue.venued.utility.APIAccess;
import com.squareup.okhttp.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

@Service("yelpApiService")
public class YelpApiService {
    static String yelpApiKey = APIAccess.getApiKey();

    private static final String yelpBaseUrl = "api.yelp.com/v3";

    private static String makeAutoCompleteUrl(String query, String latitude, String longitude){
        //making the uri adjustable by using the UriComponentsBuilder for the request
        return UriComponentsBuilder.newInstance()
                .scheme("https").host(yelpBaseUrl).path("/businesses/search")
                    .queryParam("term", query)
                    .queryParam("latitude", latitude)
                    .queryParam("longitude", longitude)
                    .queryParam("radius", "2000")
                    .queryParam("categories", "club")
                    .queryParam("categories", "concert")
                    .queryParam("categories", "wedding")
                    .queryParam("categories", "music")
                    .queryParam("sort_by", "rating")
                    .queryParam("limit", "20")
                    .build()
                .toUriString();
    }
    private static String makeAutoCompleteUrl(String query, String location){
        //making the uri adjustable by using the UriComponentsBuilder for the request
        return UriComponentsBuilder.newInstance()
                .scheme("https").host(yelpBaseUrl).path("/businesses/search")
                .queryParam("term", query)
                .queryParam("location", location)
                .queryParam("radius", "2000")
                .queryParam("categories", "club")
                .queryParam("categories", "concert")
                .queryParam("categories", "wedding")
                .queryParam("categories", "music")
                .queryParam("sort_by", "rating")
                .queryParam("limit", "20")
                .build()
                .toUriString();
    }
    public static String execute(String query, String latitude, String longitude) throws IOException {

        OkHttpClient client = new OkHttpClient();

        //creating the api endpoint url
        String requestUri = makeAutoCompleteUrl(query, latitude, longitude );
        Request request = new Request.Builder()

                .url(requestUri)
                .addHeader("Access-Control-Allow-Origin","*")
                .addHeader("Authorization", "Bearer " + yelpApiKey)
                .build();

        Response response = client.newCall(request).execute();
        String responseString  = response.body().string();
        ObjectNode objectNode = new ObjectMapper()
                .readValue(responseString, ObjectNode.class);
        return objectNode.get("businesses").toPrettyString();
    }

    public static String execute(String query, String location) throws IOException {

        OkHttpClient client = new OkHttpClient();

        //creating the api endpoint url
        String requestUri = makeAutoCompleteUrl(query, location);
        Request request = new Request.Builder()

                .url(requestUri)
                .addHeader("Access-Control-Allow-Origin","*")
                .addHeader("Authorization", "Bearer " + yelpApiKey)
                .build();

        Response response = client.newCall(request).execute();
        String responseString  = response.body().string();
        ObjectNode objectNode = new ObjectMapper()
                .readValue(responseString, ObjectNode.class);
        return objectNode.get("businesses").toString();
    }
}
