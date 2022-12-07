package com.motelycrue.venued.services;


import com.fasterxml.jackson.databind.ObjectMapper;

import com.squareup.okhttp.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

@Service("eventbriteService")
public class EventbriteApiService{

    private static final String baseUrl = "https://www.eventbriteapi.com/v3";
    private static final String test = "https://www.eventbriteapi.com/v3/users/me/?token=HVK7EH42PKKZTOPGDCE6";
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    //sending test requests to api service
    public void setEndpoint(String endpoint, String json) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, json);

        Request request = new Request.Builder()
                .url(test)
                .build(); // defaults to GET
        Response response = client.newCall(request).execute();
    }
}
