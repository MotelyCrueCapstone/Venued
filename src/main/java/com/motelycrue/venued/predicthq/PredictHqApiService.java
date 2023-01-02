

package com.motelycrue.venued.predicthq;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.motelycrue.venued.utility.APIAccess;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;


@Service("predictHqApiService")
public class PredictHqApiService {

    private static final String predictBaseUrl = "api.predicthq.com";
    private static final String predictApiKey = APIAccess.getPredictHqApi();
    private static final String predictClientId = APIAccess.getPredictClientId();

    //https://api.predicthq.com/v1/events/?location_around.origin=30.43187%2C-97.71844
    private static String makeAutoCompleteUrl(String latitude, String longitude) {
        //making the uri adjustable by using the UriComponentsBuilder for the request
        return UriComponentsBuilder.newInstance()
                .scheme("https").host(predictBaseUrl).path("/v1/events/")
                    .queryParam("location_around.origin", String.format("%s,%s", latitude,longitude))
                    .build()
                .toUriString();
    }

    public static String execute(String latitude, String longitude) throws IOException {

        //using the okhttp to actually make the connection to the api server
        OkHttpClient client = new OkHttpClient();

        //creating the api endpoint url
        String requestUri = makeAutoCompleteUrl(latitude, longitude );

        //building api request with javas built in request builder
        Request request = new Request.Builder()
                .url(requestUri)
                .addHeader("Authorization", String.format("Bearer %s", predictApiKey))
                .addHeader("Accept", "application/json")
                .addHeader("Access-Control-Allow-Origin", "*")
                .build();

        Response response = client.newCall(request).execute();
        String responseString  = response.body().string();
        return responseString;
    }
}
