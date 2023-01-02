function toSeconds(seconds){
        return seconds * 1000;
    }

    let video = document.querySelector('video')
    video.defaultPlaybackRate = 0.3
    video.load();

$(function(){

    let introductionBanner = 3
    let counter = introductionBanner;

    setInterval(function(){
        document.getElementById(`radio${counter}`).checked = true;

        //trying to set the counter back to what ever radio button the user clicked
        //on but am currently having complications.
        for(let i = 1; i <= 4; i++){
            $(`radio${i}`).on("click", ()=>{
                counter = i;
            })
        }

        counter++;
        if(counter > 4) {
            counter = 1;
        }

    }, toSeconds(4));
})
