package com.motelycrue.venued.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class KeyService {

    @Value("${fileStackKey}")
    private String fileStackKey;

    public String getFileStackKey() {
        return fileStackKey;
    }

    public void setFileStackKey(String fileStackKey) {
        this.fileStackKey = fileStackKey;
    }
}
