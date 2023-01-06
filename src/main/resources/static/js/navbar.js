$(function(){
    let toggleButton = $('.toggle-button');
    let navbarLinks = $('.nav-items');

    //this will work lol
    $(toggleButton).on("click", () => {
        $(navbarLinks).toggleClass('active');
        // console.log($(navbarLinks).hasClass('active'));
        console.log("clicked");
    });
});

$(function() {
    // Retrieve and parse the JSON file
    $.getJSON('/json/cities.json', function(data) {
        // Create the dropdown menu
        const select = $("<select></select>");

        // Add options to the dropdown menu
        $.each(data, function(key, value) {
            select.append($("<option></option>").attr("value", key).text(value));
        });

        // Add the dropdown menu to the container
        $("#search_icon_container").append(select);
    });

    // When the user types in the search bar, update the dropdown menu
    $("#search_location_input").on("keyup", function() {
        // Get the search term the user entered
        const searchTerm = $(this).val().toLowerCase();

        // Show options in the dropdown menu that contain the search term
        $("#search_icon_container select option").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(searchTerm) > -1);
        });
    });
});





