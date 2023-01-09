$(function(){
    let toggleButton = $('.toggle-button');
    let navbarLinks = $('.nav-items');

    //this will work lol
    $(toggleButton).on("click", () => {
        $(navbarLinks).toggleClass('active');
        // console.log($(navbarLinks).hasClass('active'));
        console.log("clicked");
    });



    // Retrieve and parse the JSON file
    $.getJSON('./json/cities.json', function(data) {
        // When the user clicks on the search bar, show the search results container
        $("#search_location_input").on("keyup", function() {
            $('.location-results-container').removeClass('hide');
        });

        // When the user types in the search bar, update the search results list
        $("#search_location_input").on("keyup", function() {
            // Get the search term the user entered
            const searchTerm = $(this).val().toLowerCase();

            // Clear the search results list
            $('.location-results').empty();


            // Add a list item for each city and state that matches the search term
            $.each(data, function(state, cities) {
                $.each(cities, function(index, city) {
                    if (city.toLowerCase().indexOf(searchTerm) > -1) {
                        $('.location-results').append($('<li class="location-result"></li>').text(city + ', ' + state));
                    }
                });
            });
        });

        // When the user clicks on a search result, update the search bar
        $('.location-results').on('click', 'li', function() {
            $("#search_location_input").val($(this).text());
        });

        $(document).on('click', function(event) {
            if (!$(event.target).closest('.searchbar').length) {
                $('.location-results-container').addClass('hide');
            }
        });
    });
});








