window.onload = ()=>{

    const toggleButton = document.getElementsByClassName('toggle-button')[0]
    const navbarLinks = document.getElementsByClassName('nav-items')[0]

    toggleButton.addEventListener('click', () => {
        navbarLinks.classList.toggle('active')
    });
}

const searchInput = document.querySelector('.search_input');
const dropdownMenu = document.querySelector('.dropdown-menu');



















//CHATGPT
// searchInput.addEventListener('input', () => {
//     const value = searchInput.value;
//
//     if (value.length > 0) {
//         // Show the dropdown menu
//         dropdownMenu.style.display = 'block';
//
//         // Make a request to the API to retrieve data
//         fetch(`http://localhost:8085/yelp/${query}`)
//             .then(response => response.json())
//             .then(data => {
//                 // Update the search bar with the results
//                 updateSearchResults(data);
//             })
//             .catch(error => {
//                 console.error(error);
//             });
//     } else {
//         // Hide the dropdown menu
//         dropdownMenu.style.display = 'none';
//     }
// });
//
// function updateSearchResults(data) {
//     // Clear the previous results
//     dropdownMenu.innerHTML = '';
//
//     // Loop through the results and add them to the dropdown menu
//     data.forEach(item => {
//         const option = document.createElement('option');
//         option.value = item.value;
//         option.text = item.text;
//         dropdownMenu.appendChild(option);
//     });
// }
