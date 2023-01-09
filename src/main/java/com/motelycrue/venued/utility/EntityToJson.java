package com.motelycrue.venued.utility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.motelycrue.venued.tips.Tips;
import com.motelycrue.venued.tips.TipsJson;
import com.motelycrue.venued.users.User;
import com.motelycrue.venued.users.UserJson;
import com.motelycrue.venued.venues.Venue;
import com.motelycrue.venued.venues.VenueJson;

//conversion class turning entities into json
//by converting entity into an object representing
//its json value and converting the object
//representation into a raw json string

public class EntityToJson {

    public String userToJson(User user) throws JsonProcessingException {
        UserJson userJson = UserJson.builder()
                .userName(user.getUsername())
                .email(user.getEmail())
                .id(user.getId())
                .build();
        return ( new ObjectMapper().writeValueAsString(userJson));
    }

//    public String venueToJson(Venue venue) throws JsonProcessingException{
//        VenueJson venueJson = VenueJson.builder()
//                .id(venue.getId())
//                .venueDescription(venue.getVenueDescription())
//                .venueName(venue.getVenueName())
//                .build();
//        return ( new ObjectMapper().writeValueAsString(venueJson));
//    }

    public String tipToJson(Tips tip) throws JsonProcessingException{
        TipsJson tipsJson = TipsJson.builder()
                .tipName(tip.getTipName())
                .tipContent(tip.getTipContent())
                .upVotes(tip.getUpVotes())
                .downVotes(tip.getDownVotes())
                .id(tip.getId())
                .build();
        return ( new ObjectMapper().writeValueAsString(tipsJson));
    }
}
