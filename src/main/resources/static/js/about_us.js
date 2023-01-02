//Get Elements
const slider = document.querySelector('.slider-container'),
        slides = Array.from(document.querySelectorAll('.slide'));

//Set up current state
let isDragging = false,
    startPos = 0,
    currentTranslate = 0,
    prevTranslate = 0,
    animationID = 0,
    currentIndex = 0;

//Add event listeners
slides.forEach((slide, index) => {
    const slideImage = slide.querySelector('img');
    //Disable default drag behaviour
    slideImage.addEventListener('dragstart', (e) => e.preventDefault());

    // Touch events
    slide.addEventListener('touchstart', touchStart(index));
    slide.addEventListener('touchend', touchEnd);
    slide.addEventListener('touchmove', touchMove);

    // Mouse events
    slide.addEventListener('mousedown', touchStart(index));
    slide.addEventListener('mouseup', touchEnd);
    slide.addEventListener('mouseleave', touchEnd);
    slide.addEventListener('mousemove', touchMove);


});

// Make Responsive To viewport Changes
window.addEventListener('resize', setPositionByIndex)

//Disable context menu
window.oncontextmenu = function (event) {
    event.preventDefault();
    event.stopPropagation();
    return false;
}

function touchStart(index) {
    return function (event) {
        currentIndex = index;
        startPos = getPositionX(event);
        isDragging = true;

        animationID = requestAnimationFrame(animation);
        slider.classList.add('grabbing');
    };
}
function touchEnd() {
    isDragging = false;
    cancelAnimationFrame(animationID);

    const movedBy = currentTranslate - prevTranslate;

    if (movedBy < -100 && currentIndex < slides.length - 1) currentIndex += 1;

    if (movedBy > 100 && currentIndex > 0) currentIndex -= 1;

    setPositionByIndex();

    slider.classList.remove('grabbing');
}

// Touch Move
function touchMove(event) {
    if (isDragging) {
        const currentPosition = getPositionX(event);
        currentTranslate = prevTranslate + currentPosition - startPos;
    }
}

// Get Mouse or Touch Position
function getPositionX(event) {
    return event.type.includes('mouse')
        ? event.pageX
        : event.touches[0].clientX;
}

// Animation
function animation() {
    setSliderPosition();
    if (isDragging) requestAnimationFrame(animation);
}

// Set Slider Position
function setSliderPosition() {
    slider.style.transform = `translateX(${currentTranslate}px)`;
}

// Set position by index
function setPositionByIndex() {
    currentTranslate = currentIndex * -window.innerWidth;
    prevTranslate = currentTranslate;
    setSliderPosition();
}

//replaces subject and email labels with placeholders
$(document).ready(function(){
    let wid = $(this).width();
    if (wid < 810){
        $("#subject").placeholder.disable();
        $("#email").placeholder.hide();
    }
});


// EmailJS email forwarding function.
$('#contact-input').on('submit', function(event) {
    event.preventDefault(); // prevent reload

    let formData = new FormData(this);
    formData.append('service_id', 'service_j3dcin1');
    formData.append('template_id', 'template_z1y411l');
    formData.append('user_id', 'mVyb1RsOCWEHrXom1');
    formData.append('subject', document.getElementById('subject').value);
    formData.append('from_email', document.getElementById('email').value);
    formData.append('message_html', document.getElementById('message').value);
    formData.append('to_name', 'Venued');

    $.ajax('https://api.emailjs.com/api/v1.0/email/send-form', {
        type: 'POST',
        data: formData,
        contentType: false, // auto-detection
        processData: false // no need to parse formData to string
    }).done(function() {
        alert('Your mail is sent!');
    }).fail(function(error) {
        alert('Oops... ' + JSON.stringify(error));
    });
});

//Show Dialog
$(document).ready(function() {
    $('#showDialog').click(function() {
        $('#deshawnDialog').show();
    });
    $('.close-button').click(function() {
        $('#deshawnDialog').hide();
    });

});



