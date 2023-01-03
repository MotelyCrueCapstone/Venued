package com.motelycrue.venued.venues;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//building entity to save venues and information from the api
//calls
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String venueId;

    @Column(nullable = false)
    private String venueName;

    @Column(nullable = false)
    private String venueAlias;

    @Column
    private String imgPath;

    @Column
    private String longitude;

    @Column
    private String latitude;

    @Column
    private String address;

    @Column
    private String rating;

}
