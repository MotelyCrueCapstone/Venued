package com.motelycrue.venued.users;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.motelycrue.venued.services.KeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KeyController {

    @Autowired
    private KeyService keys;

    @GetMapping("/keys")
    public KeyService getKeys() throws JsonProcessingException {
        return keys;
    }
}
