$(async function() {
    console.log("Inside venue.js");

    function grabEvents(latitude, longitude){
        fetch(`http://localhost:8085/event?latitude=${latitude}&longitude=${longitude}`).
        then(res => res.json())
            .then(json => {
                console.log(json);

                const title = json.results[0].title;
                const description = json.results[0].description;
                const eventDate = json.results[0].start;

                $('.title-info').append(title);
                $('.desc-info').append(description);
                $('.event-date').append(eventDate);

            });
    }

    let mainSection = $('#main-section')
    let latitude = $(mainSection).data("venue-latitude");
    let longitude = $(mainSection).data("venue-longitude");

    grabEvents(latitude, longitude);


});