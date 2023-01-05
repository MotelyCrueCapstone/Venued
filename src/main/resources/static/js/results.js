"use strict";

(function () {
    
    let searchInput = $(".search_input")
    let searchButton = $(".search_icon")
    let searchLocation = $(".search_location_input")
    function toggleResults(){
         $(".results").html("")
         $(".results-container").removeClass("hide")
    }
    
    function search(query) {

         //fetching users current location to be used for the yelp apis longitude latitude position
         navigator.geolocation.getCurrentPosition(position => { //getting the latitude longitude from the DOM geolocation api
              
              //and setting the decimal length to be fixed at 2, so we don't get any
              //super long decimal numbers
              let latitude = position.coords.latitude.toFixed(2);
              let longitude = position.coords.longitude.toFixed(2);
              
              //fetching api data from yelp
              fetch(`http://localhost:8085/yelp/${query}?location=${searchLocation.val()}`)
                    .then(response => response.json())
                    .then(venuesJson => {

                         venuesJson.forEach(currentVenue =>{
                              //getting the current venue id to checkout existence in the database later
                              let currentVenueId = currentVenue.id;
                              let currentVenueAlias = currentVenue.alias;

                              $(".results").append($(`<li class="result">

                                             <div class="result-image">
                                                 <img src="${currentVenue.image_url}" alt="resultImage">
                                             </div>
                                             <div class="result-body">
                                                 <a href=""> ${currentVenue.name}</a>
                                             </div>
                                             
                                        </li>`))


                              //automatically creating paramter string for the controller request creation
                              let currentVenueParams = new URLSearchParams({
                                  venueId: currentVenueId,
                                  venueName: currentVenue.name,
                                  venueAlias: currentVenue.alias,
                                  imgPath: currentVenue.image_url,
                                  longitude: currentVenue.coordinates.longitude,
                                  latitude: currentVenue.coordinates.latitude,
                                  address: currentVenue.location.address1,
                                  rating: currentVenue.rating
                              })

                              //sending retrieved data from the api to be sent to the controller backend to be
                              // checked if venue exist or not if it does it saves it to the database
                              fetch(`http://localhost:8085/venues/${currentVenueId}?${currentVenueParams.toString()}`,{method: "POST"})
                                  .then(response => console.log(response.status))
                              })
                    })
         });
    }
    
    //when user clicks search or presses enter run search from yelp api
    $(searchInput).on("keypress", (event) =>{
          if(event.keyCode === 13){
             search($(searchInput).val());
             toggleResults();
          }
    });
    
    $(searchButton).on("click", () =>{
         search($(searchInput).val());
         toggleResults();
    });
})();

    // create dropdown the uses google places api to suggest locations
    function initAutocomplete(){
        let input = document.getElementById('search_location_input');
        let searchBox = new google.maps.places.SearchBox(input);
        searchBox.addListener('places_changed', function() {
            let places = searchBox.getPlaces();
            if (places.length == 0) {
                return;
            }
        });
    }

window.onload = function() {
    initAutocomplete();
};