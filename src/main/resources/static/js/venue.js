$(async function() {
    console.log("Inside venue.js");
    let eventIndex = 0;

    function grabEvents(latitude, longitude){
        fetch(`http://localhost:8085/event?latitude=${latitude}&longitude=${longitude}`)
            .then(res => res.json())
            .then(json => {
                console.log(json);
                events = json.results;
                events.sort(function(a, b) {
                    let dateA = new Date(a.start);
                    let dateB = new Date(b.start);
                    return dateA - dateB;
                });
            });
    }

    function updateEvent() {
        while (true) {
            let date = new Date(events[eventIndex].start);
            if (date > new Date()) {
                const title = events[eventIndex].title;
                const category = events[eventIndex].category;
                const eventDate =`${date.getMonth()+1}/${date.getDate()}/${date.getFullYear()}`;

                $('.title-info').text(title);
                $('.desc-info').text(category);
                $('.event-date').text(eventDate);

                if (events[eventIndex].entities && events[eventIndex].entities[0] && events[eventIndex].entities[0].name) {
                    const venue = events[eventIndex].entities[0].name;
                    $('.event-venue').text(venue);
                } else {
                    $('.event-venue').text("");
                }

                eventIndex++;
                if (eventIndex >= events.length) {
                    eventIndex = 0;
                }
                break;
            }
            eventIndex++;
            if (eventIndex >= events.length) {
                eventIndex = 0;
            }
        }
    }




    let mainSection = $('#main-section')
    let latitude = $(mainSection).data("venue-latitude");
    let longitude = $(mainSection).data("venue-longitude");

    grabEvents(latitude, longitude);
    setInterval(updateEvent, 1000);
});
