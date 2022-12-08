package com.motelycrue.venued.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.squareup.okhttp.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service("yelpApiService")
public class YelpApiService {


    @Value("${yelp_api_key}")
    private static String yelpApiKey;

    private static String yelpBaseUrl = "https://api.yelp.com/v3/";
    private static String autocomplete  = "autocomplete";
    private static String businesses = "businesses/";

    private static MediaType JSON = MediaType.parse("application/json; charset=utf-8");

//    private static HashMap<String, String> endpoints;
    private static String makeAutocompleteUrl(String query){
        return String.format("%s%s?text=%s",yelpBaseUrl, autocomplete, query);
    }

    private static String makeAutocompleteUrl(String query, String latitude, String longitude){
        //creating the url with the endpoints based on user data
        return String.format("%s%s?text=%s&latitude=%s&longitude=%s",
                yelpBaseUrl, autocomplete,query, latitude,longitude);
    }

    //sending test requests to api service
    public static String execute(String query) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        //creating the api endpoint url
        String requestUrl = makeAutocompleteUrl(query);

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(requestUrl)
                .addHeader("Authorization", yelpApiKey)
                .build(); // defaults to GET

        String allBusinessesJson = "";

        Response response = client.newCall(request).execute();
        String responseString  = response.body().string();
        ObjectNode objectNode = objectMapper.readValue(responseString, ObjectNode.class);

        //trying to pull the business key from the json object returned fromm the initial api call
        //so i can iterate through them and add them to the allBusinessesJson with api calls to each Id.

        if(objectNode.has("businesses")){
            return(objectNode.get("businesses").asText());
        }else{
            return(responseString);
        }
    }

    public static String execute(String query, String latitude, String longitude) throws IOException {
        ObjectMapper objectMapper =  new ObjectMapper();
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
