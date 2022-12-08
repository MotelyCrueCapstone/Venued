package com.motelycrue.venued.services;


import com.squareup.okhttp.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service("yelpApiService")
public class YelpApiService {

    @Value("${yelp_api_key}") private static String yelpApiKey;
    private static String yelpBaseUrl = "https://api.yelp.com/v3/";
    private static String autocomplete  = "autocomplete";
    private static String businesses = "businesses/";

    private static MediaType JSON = MediaType.parse("application/json; charset=utf-8");

//    private static HashMap<String, String> endpoints;
    private String makeAutocompleteUrl(String query){
        return String.format("%s%s?text=%s",yelpBaseUrl, autocomplete, query);
    }

    private String makeAutocompleteUrl(String query, String latitude, String longitude){
        //creating the url with the endpoints based on user data
        return String.format("%s%s?text=%s&latitude=%s&longitude=%s",
                yelpBaseUrl, autocomplete,query, latitude,longitude);
    }

    //sending test requests to api service
    public String execute(String query) throws IOException {

        //creating the api endpoint url
        String requestUrl = makeAutocompleteUrl(query);

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(requestUrl)
                .build(); // defaults to GET

        Response response = client.newCall(request).execute();

        //returns the json with business ids not the actual business data
        return response.body().string();

    }
    public String execute(String query, String latitude, String longitude) throws IOException {

        //creating the api endpoint url
        String requestUrl = makeAutocompleteUrl(query, latitude, longitude);

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(requestUrl)
                .build();
        Response response = client.newCall(request).execute();

        //returns businesess and business ids near lat/long values
        return response.body().string();
    }
}
