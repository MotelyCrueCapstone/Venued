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
         
         navigator.geolocation.getCurrentPosition(position => { //getting the latitude longitude from the doms geolocation api
              //and setting the decimal length to be fixed at 2 so we dont get any
              //super long decimal numbers
              let latitude = position.coords.latitude.toFixed(2);
              let longitude = position.coords.longitude.toFixed(2);
          
              fetch(`http://localhost:8085/yelp/${query}?latitude=${latitude}&longitude=${longitude}`)
                    .then(response => response.json())
                    .then(venuesJson => {
                         venuesJson.forEach(currentVenue =>{
                              console.log((currentVenue.id))
                              console.log(currentVenue.alias)
                         })
                    })
         });
    }
    $(searchButton).on("click", () => search($(input).val()))
})();