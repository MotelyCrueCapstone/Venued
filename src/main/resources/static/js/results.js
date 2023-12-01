"use strict";

(function () {
    let searchInput = $(".search_input");
    let searchButton = $(".search_icon");
    let searchLocation = $("#search_location_input");

    function toggleResults(){
         $(".results").html("");
         $(".results-container").removeClass("hide");
    }

    function search(query) {
         
         //fetching api data from yelp
         fetch(`https:venued.us/yelp/${query.trimEnd()}?location=${searchLocation.val()}`)
               .then(response => response.json())
               .then(venuesJson => {
                    venuesJson.forEach(currentVenue =>{
                         //getting the current venue id to checkout existence in the database later
                         let currentVenueId = currentVenue.id;
                         let currentVenueAlias = currentVenue.alias;
                         let urlString =     `"/venues/id/${currentVenue.id}"`;

                         $(".results").append($(`<li class="result">

                                        <div class="result-image">
                                            <img src="${currentVenue.image_url}" alt="resultImage">
                                           
                                        </div>
<!--                                        results container goes here-->
                                        <div class="result-body">
                       
                                            <div class="result-name-container">
                                          
                                                <a href=${urlString}> ${currentVenue.name}</a>
                                              
                                            </div>
                                         
                                            <p class="result-address">${currentVenue.location.address1} ${currentVenue.location.city}</p>
                                     
                                        </div>
<!--                                       -->
                                        <div class="result-rating">
                                            <p>${currentVenue.rating} </p>
                                        </div>
                                   </li>`));


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
                         });

                         //sending retrieved data from the api to be sent to the controller backend to be
                         // checked if venue exist or not if it does it saves it to the database
                         fetch(`https://venued.us/venues/create/${currentVenueId}?${currentVenueParams.toString()}`,{method: "GET"})
                             .then(response => console.log(response.status))
                         });
               });
    }

    //when user clicks search or presses enter run search from yelp api
    $(searchInput).on("keypress", (event) =>{
          if(event.keyCode === 13){
             search($(searchInput).val());
          }
    });
   
    //on search input click
    $(searchInput).one("click", ()=>{
         toggleResults();
    })
     
     //on search button click test
    $(searchButton).on("click", () => {
         search($(searchInput).val());
         $('.location-results-container').addClass('hide');
         toggleResults();
    });
    
    //on key up the search box appears
    $(".search_input").on("keyup", function() {
        $('.results-container').removeClass('hideme');
    });
    
// When the user clicks outside of the search bar, hide the search results container
    $(document).on('click', function(event) {
        if (!$(event.target).closest('.searchbar').length) {
            $('.results-container').addClass('hideme');
        }
    });
})();
