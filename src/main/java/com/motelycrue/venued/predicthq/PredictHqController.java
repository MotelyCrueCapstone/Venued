package com.motelycrue.venued.predicthq;

import com.motelycrue.venued.yelp_api.YelpApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@Controller
public class PredictHqController {

    @Autowired
    private PredictHqApiService predictHqApiService;

    @GetMapping(value = "/event", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin("*")
    @ResponseBody
    String returnEvents(@RequestParam Optional<String> latitude,
                        @RequestParam Optional<String> longitude) throws IOException{

            //making sure the longitude and latitude are both present in the
            //parameters or the controller will return the default page for the
            //venue or event
            if(latitude.isPresent() && longitude.isPresent()){
                return PredictHqApiService.execute(latitude.get(), longitude.get());
            }else{
                //reminding frontend you need to add the longitude latitude to the request
                return "{\"result\" : \"requires longitude and latitude parameters\"}";
            }
    }
    //http://localhost:8085/predicthq?latitude=30.43187&longitude=-97.71844


}

