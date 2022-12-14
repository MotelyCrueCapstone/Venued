

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

    private static final String predictBaseUrl = "api.predicthq.com/v1";
    private static final String predictApiKey = APIAccess.getPredictHqApi();

    private static String makeAutoCompleteUrl(String latitude, String longitude) {
        //making the uri adjustable by using the UriComponentsBuilder for the request
        return UriComponentsBuilder.newInstance()
                .scheme("https").host(predictBaseUrl).path("/events")
                    .queryParam("offset", "10")
                    .queryParam("location_around.origin", String.format("%s,%s", latitude, longitude))
                    .queryParam("limit", "20")
                    .build()
                .toUriString();
    }
    public static String execute(String latitude, String longitude) throws IOException {
        System.out.println(predictApiKey);
        OkHttpClient client = new OkHttpClient();
        //creating the api endpoint url
        String requestUri = makeAutoCompleteUrl(latitude, longitude );

        Request request = new Request.Builder()
                .url(requestUri)
                .addHeader("Authorization", "Bearer " + predictApiKey)
                .addHeader("Accept", "application/json")
                .build();

        Response response = client.newCall(request).execute();
        String responseString  = response.body().string();
//        ObjectNode objectNode = new ObjectMapper()
//                .readValue(responseString, ObjectNode.class);
        return responseString;
    }
}
