package com.motelycrue.venued.yelp_api;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.motelycrue.venued.utility.APIAccess;
import com.squareup.okhttp.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service("yelpApiService")
public class YelpApiService {


//    @Value("${apiKey:ad95qSYlKKcn-LAdY3BL5y2d6wPKiG028RptoMyqv7IGbVG85KyJINy1MKCm6Zbl-IPxtuv6daqmH8zVF0LYoqGPR6yqMr9sdMuilmweDa4xjY66xfFVL1hb7BCSY3Yx}")
    static String yelpApiKey = APIAccess.getApiKey();


    private static final String yelpBaseUrl = "https://api.yelp.com/v3/";
//    private static final String autocomplete  = "autocomplete";
    private static final String businesses = "businesses/";

    private static MediaType JSON = MediaType.parse("application/json; charset=utf-8");
     //example query string for the API call
    //https://api.yelp.com/v3/businesses/search?location=san%20antonio%20&term=music&radius=2000&categories=clubs&sort_by=best_match&limit=20"
//    private static HashMap<String, String> endpoints;
    private static String makeAutocompleteUrl(String query, String location){
        return String.format("%s%ssearch?location=%s&term=%s&radius=2000&categories=club&sort_by=best_match&limit=20",
                yelpBaseUrl,businesses, location,query);
    }
    //sending test requests to api service
    public static String execute(String query) throws IOException {

        OkHttpClient client = new OkHttpClient();

        //the object that turns POJOS into JSON objects
        ObjectMapper objectMapper = new ObjectMapper();

        //creating the api endpoint url
        String requestUrl = makeAutocompleteUrl(query, "San antonio");


        //turns the url into a viable http requestt with the
        // Bearer token so we can receive the results of our query

        Request request = new Request.Builder()
                .url(requestUrl)
                .addHeader("Authorization", "Bearer " + yelpApiKey)
                .addHeader("accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .build();


        Response response = client.newCall(request).execute();

        String responseString  = response.body().string();

        ObjectNode objectNode = objectMapper.readValue(responseString, ObjectNode.class);

        return objectNode.get("businesses").toString();
    }

}
