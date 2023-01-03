"use strict";

/*
 Creator: Deshawn Marquis, Williams,
 GitHub Profile: https://github.com/MarquisTheCoder,
 Date Created: 1/2/23,
 Time Created: 10:15 AM,
 File Name: results.js,
 File Description:
 */


(function () {
    
    let input = $(".search_input")
    let searchButton = $(".search_icon")
    
    function search(query) {
         
         navigator.geolocation.getCurrentPosition(position => { //getting the latitude longitude from the DOM geolocation api
              //and setting the decimal length to be fixed at 2, so we don't get any
              //super long decimal numbers
              let latitude = position.coords.latitude.toFixed(2);
              let longitude = position.coords.longitude.toFixed(2);
          
              fetch(`http://localhost:8085/yelp/${query}?latitude=${latitude}&longitude=${longitude}`)
                    .then(response => response.json())
                    .then(venuesJson => {
                         venuesJson.forEach(currentVenue =>{
                              //getting the current venue id to check out existence in the database later
                              let currentVenueId = currentVenue.id;
                              let currentVenueParams = {
                                  venueId: currentVenueId,
                                  venueName: currentVenue.name,
                                  venueAlias: currentVenue.alias,
                                  imgPath: currentVenue.image_url,
                                  longitude: currentVenue.coordinates.longitude,
                                    latitude: currentVenue.coordinates.latitude,
                                    address: currentVenue.location.address1,
                                  rating: currentVenue.rating,
                              }
                              fetch(`http://localhost:8085/venue/${currentVenueId}?${currentVenueParams}`,{method: "POST"})
                                  .then(response => console.log(response.status))
                         })
                    })
         });
    }
    $(searchButton).on("click", () => search($(input).val()))
})();