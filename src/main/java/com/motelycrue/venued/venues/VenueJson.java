package com.motelycrue.venued.venues;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

//going to be used to convert
//Venue entity to JSON pojo without complications
@Data
@Builder
public class VenueJson {
    private Long id;
    private String venueName;
}
