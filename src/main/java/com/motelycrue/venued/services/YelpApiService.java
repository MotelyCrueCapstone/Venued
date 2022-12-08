package com.motelycrue.venued.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.HashMap;

@Service("yelpApiService")
public class YelpApiService {

    @Value("${yelp_api_key}") private static String yelpApiKey;
    private static String yelpBaseUrl = "https://api.yelp.com/v3.";
    private static MediaType JSON = MediaType.parse("application/json; charset=utf-8");

//    private static HashMap<String, String> endpoints;

    //sending test requests to api service
    public void execute(String query){

        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, json);

        Request request = new Request.Builder()
                .url(test)
                .build(); // defaults to GET
        Response response = client.newCall(request).execute();
    }
}
