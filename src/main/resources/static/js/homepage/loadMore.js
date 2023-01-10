const cardContainer = document.querySelector('#recent-cards');
const loadMoreButton = document.querySelector('#load-more-button');
let cardsToShow = 3;

window.addEventListener('load', function() {
    function showCards() {
        const cardContent = document.querySelectorAll('.recent-card');
        for (let i = 0; i < cardContent.length; i++) {
            if (i < cardsToShow) {
                cardContent[i].style.display = "block";
            } else {
                cardContent[i].style.display = "none";
            }
        }
    }

    showCards();

    loadMoreButton.addEventListener('click', () => {
        cardsToShow += 3;
        showCards();
    });
});
