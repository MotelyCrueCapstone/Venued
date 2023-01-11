// JavaScript file

// Variables to store the latitude and longitude parameters
let latitude = 'your_latitude';
let longitude = 'your_longitude';

// Make a GET request to the /event endpoint of your API
fetch(`/event?latitude=${latitude}&longitude=${longitude}`)
    .then(response => response.json())
    .then(data => {
        // The data variable contains the array of events

        // loop through the data array and get the first 5 events
        for (let i = 0; i < 5; i++) {
            let event = data[i];
            let eventContainer = document.querySelector("#event-container");
            eventContainer.innerHTML += `
        <div>
            <p class="title eventText">${event.name}</p>
            <p class="desc event-desc eventText">${event.description}</p>
        </div>
      `;
        }
    })
    .catch(error => {
        console.error('Error:', error);
    });
