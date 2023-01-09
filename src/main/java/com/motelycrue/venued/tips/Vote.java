package com.motelycrue.venued.tips;

import org.springframework.beans.factory.annotation.Autowired;

public class Vote {

    @Autowired
    private Long tipId;

    @Autowired
    private String direction;

    public Long getTipId() {
        return tipId;
    }

    public void setTipId(Long tipId) {
        this.tipId = tipId;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

}
