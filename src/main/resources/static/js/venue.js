$(async function() {
    console.log("Inside venue.js");
    let eventIndex = 0;
    let events;

    $('.title-info').text("Loading...");
    $('.desc-info').text("");
    $('.event-date').text("");
    $('.event-venue').text("");

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
                updateEvent();
                setInterval(updateEvent, 7000);
            });
    }

    function updateEvent() {
        let hasEvents = false;
        while (true) {
            let date = new Date(events[eventIndex].start);
            if (date > new Date()) {
                hasEvents = true;
                const title = events[eventIndex].title;
                const category = events[eventIndex].category;
                const eventDate =`${date.getMonth()+1}/${date.getDate()}/${date.getFullYear()}`;

                $('.title-info').text(title);

                if (events[eventIndex].category) {
                    $('.event-desc').text("Event Type: " + events[eventIndex].category);
                } else {
                    $('.event-desc').text("");
                }


                $('.event-date').text(eventDate);

                if (events[eventIndex].entities && events[eventIndex].entities[0] && events[eventIndex].entities[0].name) {
                    const venue = events[eventIndex].entities[0].name;
                    $('.event-venue').text("Venue: " + events[eventIndex].entities[0].name);
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
                if (!hasEvents) {
                    $('.title-info').text("Sorry, no events soon!");
                    $('.desc-info').text("");
                    $('.event-date').text("");
                    $('.event-venue').text("");
                }
                break;
            }
        }
    }

    let mainSection = $('#main-section')
    let latitude = $(mainSection).data("venue-latitude");
    let longitude = $(mainSection).data("venue-longitude");

    grabEvents(latitude, longitude);
});

