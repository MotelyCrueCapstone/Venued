const cardContainer = document.getElementById('recent-cards');
const loadMoreButton = document.getElementById('load-more-button');
const cardContent = document.getElementById('recent-card');


let currentSet = 1;

loadMoreButton.addEventListener('click', () => {
// Create new card elements
    const card1 = document.createElement('div');
    card1.classList.add('recent-card');
    card1.innerHTML = `
        <div class="recent-card" th:each="question : ${questions}">
            <figure>
                <div>
                    <img th:src="${question.getUser().getImgPath()}" alt="" class="user-image">
                </div>
                <div>
                    <small th:text="${question.getUser().getUsername()}">username</small>
                    <small th:text="${question.getVenue().getVenueName()}">venuename</small>
                    <small th:text="${question.getVenue().getAddress()}">San Antonio, TX</small>
                </div>
            </figure>
            
            <div>
                <p th:text="${question.getQuestion()}"></p>
                <div class="imagecenter">
                    <img th:src="${question.getVenue().getImgPath()}" alt="Image of this venue" class="venueImage">
                </div>
                <a th:class="answerLink" th:href="@{'/venues/' + ${question.getVenue().getId()}}">
                    <p class="button">Answer Question</p>
                </a>
            </div>
        <div>
    `;


// Append new cards to the end of the list
    cardContainer.appendChild(card1);

    loadMoreButton.scrollIntoView({ behavior: 'smooth' });

    // Increment counter
    currentSet++;
});



