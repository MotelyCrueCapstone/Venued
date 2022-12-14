package com.motelycrue.venued.predicthq;

import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


@Service("predictHqApiService")
public class PredictHqApiService {

    private final String predictBaseUrl = "https://api.predicthq.com/v1/events/";

    private static String makeAutoCompleteUrl(String latitude, String longitude){
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("http").host("www.baeldung.com").path("/junit-5").build();
        return String.format("", latitude, longitude);


    }
}
