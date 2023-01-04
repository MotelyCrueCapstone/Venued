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
    @CrossOrigin("*")
    @GetMapping(value = "/yelp/{query}", produces = MediaType.APPLICATION_JSON_VALUE)

    //optional parameter gives you the ability to omit paramaters so
    //if they don't have these parameters the request won't fail off the bat
    public String yelp(@PathVariable String query,
                       @RequestParam Optional<String> latitude,
                       @RequestParam Optional<String> longitude,
                       @RequestParam Optional<String> location)throws IOException {

        //making sure the longitude and latitude are both present in the
        //parameters or the controller will return the default page for the
        //venue or event
        if(latitude.isPresent() && longitude.isPresent()){
            return YelpApiService.execute(query, latitude.get(), longitude.get());
        }else if(location.isPresent()){

            //if longitude and latitude not provided location string will be used
           return YelpApiService.execute(query, location.get());
        }else{

            //reminding frontend you need to use the longitude and latitude or the location
            return "{\"result\" : \"requires longitude/latitude combination\"}";
        }
    }
}
