package com.motelycrue.venued.yelp_api;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import retrofit2.http.Path;

import java.io.IOException;
import java.util.Optional;

@Controller
public class YelpApiController {
    @ResponseBody
    @GetMapping(value = "/event/{query}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    // 	latitude: 29.50184
    // -longitude: 98.49869

    public String yelp(@PathVariable String query,
                       @RequestParam Optional<String> latitude,
                       @RequestParam Optional<String> longitude)
            throws IOException {


        //making sure the longitude and latitude are both present in the
        //parameters or the controller will return the default page for the
        //venue or event
        if(latitude.isPresent() && longitude.isPresent()){
            return YelpApiService.execute(query, latitude.get(), longitude.get());
        }else{
            return YelpApiService.execute(query);
        }
    }
}
