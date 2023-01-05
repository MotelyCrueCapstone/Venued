window.onload = ()=>{

    const toggleButton = document.getElementsByClassName('toggle-button')[0]
    const navbarLinks = document.getElementsByClassName('nav-items')[0]

    toggleButton.addEventListener('click', () => {
        navbarLinks.classList.toggle('active')
    });
}

let MY_KEY = config.MY_KEY;
