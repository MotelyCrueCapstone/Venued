"use strict";

$(function(){
     
     let body  = $("body")
     
     //getting the users longitude/latitude to use for our servers api
     navigator.geolocation.getCurrentPosition((position) => {
          let lat = position.coords.latitude;
          let long = position.coords.longitude;
          
          //gettign the venues according to the users location
          fetch(`http://localhost:8083/event/food?latitude=${lat.toFixed(4)}&longitude=${long.toFixed(4)}`, {method: "GET"})
               .then(response => response.json())
               .then(json =>  console.log(json))
          
     });
     
})




