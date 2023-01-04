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
        // console.log("this is it");
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
    // console.log("this is it");
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
    // console.log("this is it");
    return event.type.includes('mouse')
        ? event.pageX
        : event.touches[0].clientX;
}

// Animation
function animation() {
    setSliderPosition();
    if (isDragging) requestAnimationFrame(animation);
    // console.log("this is it");
}

// Set Slider Position
function setSliderPosition() {
    slider.style.transform = `translateX(${currentTranslate}px)`;
    // console.log("this is it");
}

// Set position by index
function setPositionByIndex() {
    currentTranslate = currentIndex * -window.innerWidth;
    prevTranslate = currentTranslate;
    setSliderPosition();
    // console.log("this is it");
}

//replaces subject and email labels with placeholders
$(document).ready(function(){
    let wid = $(this).width();
    if (wid < 810){
        $("#subject").placeholder.disable();
        $("#email").placeholder.hide();
    }
});

const overlays = document.querySelectorAll('.overlay');

const observer = new IntersectionObserver((entries) => {
    entries.forEach((entry) => {
        // Toggle the show class on the overlays elements
        overlays.forEach(overlay => {
            overlay.classList.toggle('show', entry.isIntersecting);
        });
    });
}, {
    // rootMargin: '100% 0% 100% 0%'
    threshold: 1
});

// Observe the slides elements
// overlays.forEach(overlay => {
//     observer.observe(overlay);
// });
slides.forEach(slide => {
    observer.observe(slide);
});


// const slides = document.querySelectorAll('.slide');
slides.forEach(slide => {
    slide.addEventListener('click', (e) => {
        e.preventDefault();
        slide.classList.toggle('flipped');

        // toggle the show class on the overlays elements
        overlays.forEach(overlay => {
            overlay.classList.toggle('show');
        });
    });
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
    $('.showDialog').on("click", function (e) {
        e.preventDefault();
        $(this).parents(".img_overlay").siblings(".dialog").show();
        $(this).parents(".img_overlay_bottom").siblings(".dialog").show();

    });

    $('.close-button').click(function (e) {
        e.preventDefault();
        $(this).parents('.dialog').hide();
    });
});


//close dialog on click outside
$(document).mouseup(function (e) {
    let container = $(".dialog");
    if (!container.is(e.target) && container.has(e.target).length === 0) {
        container.hide();
    }
});


