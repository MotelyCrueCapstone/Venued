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
        const title = events[eventIndex].title;
        const description = events[eventIndex].description;
        let date = new Date(events[eventIndex].start);
        const eventDate =`${date.getMonth()+1}/${date.getDate()}/${date.getFullYear()}`;

        $('.title-info').text(title);
        $('.desc-info').text(description);
        $('.event-date').text(eventDate);
        eventIndex++;
        if (eventIndex >= events.length) {
            eventIndex = 0;
        }
    }

    let mainSection = $('#main-section')
    let latitude = $(mainSection).data("venue-latitude");
    let longitude = $(mainSection).data("venue-longitude");

    grabEvents(latitude, longitude);
    setInterval(updateEvent, 7000);
});
