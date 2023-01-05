 $(document).ready(function() {
     let toggleButton = document.getElementsByClassName('toggle-button')[0]
     let navbarLinks = document.getElementsByClassName('nav-items')[0]

     toggleButton.addEventListener('click', () => {
         navbarLinks.classList.toggle('active')
         console.log("clicked");
     });
 });




