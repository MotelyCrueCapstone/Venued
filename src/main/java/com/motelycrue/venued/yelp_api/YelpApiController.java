package com.motelycrue.venued.yelp_api;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import retrofit2.http.Path;

import java.io.IOException;

@Controller
public class YelpApiController {
    @ResponseBody
    @GetMapping(value = "/event/{query}",produces = MediaType.APPLICATION_JSON_VALUE)
    public String yelp(@PathVariable String query) throws IOException {
        return YelpApiService.execute(query);
    }
}
