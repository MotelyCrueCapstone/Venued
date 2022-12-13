"use strict";


$(function(){
     
     
     //
     // //getting the users longitude/latitude to use for our servers api
     navigator.geolocation.getCurrentPosition((position) => {
          let lat = position.coords.latitude;
          let long = position.coords.longitude;
          console.log(lat + long)
          let slideContainer = $(".slides")
          //gettign the venues according to the users location
          fetch(`http://localhost:8083/event/bar?latitude=${lat.toFixed(4)}&longitude=${long.toFixed(4)}`, {method: "GET"})
               .then(response => response.json())
               .then(json=>  {
                    for(let x of json){

                         // console.log(x.image_url)
                         let currentListItem =
                              `<li class="slide">
                                <img src="${x.image_url}" alt="${x.name}">
                              </li>`
                         $(slideContainer).append(currentListItem)

                    }
               })
     });

})

     /* Example slide:
          <li class="slide" data-active>
          <img src="https://source.unsplash.com/78A265wPiO4" alt="Nature Image #1">
          </li>
      */



