package com.motelycrue.venued.yelp_api;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import retrofit2.http.Path;

import java.io.IOException;

@Controller
public class YelpApiController {
    @ResponseBody
    @GetMapping(value = "/event/{query}/{long}/{latitude}",
            produces = MediaType.APPLICATION_JSON_VALUE)

    public String yelp(@PathVariable String query)
            throws IOException {
        return YelpApiService.execute(query);
    }
}
