

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


