"use strict";

/*
 Creator: Deshawn Marquis, Williams,
 GitHub Profile: https://github.com/MarquisTheCoder,
 Date Created: 12/23/22,
 Time Created: 2:50 PM,
 File Name: events.js,
 File Description:
 */

//example geolocation functionality
//src: https://developers.marketo.com/blog/dynamically-change-page-content-based-on-a-users-location/

(function () {
     
     //taking the event name name and url to use in the
     //card blueprint
     function makeEventCard(eventName, imageUrl){
          let randomImageApiCall = "https://source.unsplash.com/random/?concert"
          
          //making each generated cards html template
          let cardHtml = `
          `
     }
     
     navigator.geolocation.getCurrentPosition((position) => {
          
          //getting the latitude longitude from the doms geolocation api
          //and setting the decimal length to be fixed at 2 so we dont get any
          //super long decimal numbers
          let latitude = position.coords.latitude.toFixed(2);
          let longitude = position.coords.longitude.toFixed(2);
          
          //fetching clients local events with our internal api grabbing them from predicthq
          fetch(`http://localhost:8085/event?latitude=${latitude}&longitude=${longitude}`, {method: "GET"})
               .then(response  => response.json())
               .then(json => (console.log(json)))
     })
     })();