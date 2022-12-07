package com.motelycrue.venued.venues;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

//going to be used to convert
//Venue entity to JSON pojo without complications
public class VenueJson {
    private Long id;
    private String venueName;
    private String venueDescription;
}
