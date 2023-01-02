const cardContainer = document.getElementById('recent-cards');
const loadMoreButton = document.getElementById('load-more-button');
const cardContent = document.getElementById('recent-card');


let currentSet = 1;

loadMoreButton.addEventListener('click', () => {
// Create new card elements
    const card1 = document.createElement('div');
    card1.classList.add('recent-card');
    card1.innerHTML = `
                         <div class="recent-card">
                            <figure>
                                <div>
                                    <img src="/imgs/Avatar-Placeholder.png" alt="" class="user-image">
                                    </div>
                                        <div>
                                            <small>username</small>
                                            <small>venuename</small>
                                            <small>San Antonio, TX</small>
                                        </div>
                            </figure>
                                        <div>
                                        <p>Does this venue have free parking</p>
                                    <div>
                                    <img src="/imgs/restaurant-image.jpg" alt="restaurant image" class="image">
                                </div>
                                <button>Answer Question</button>
                            </div>
                        </div>
    `;
    const card2 = document.createElement('div');
    card2.classList.add('recent-card');
    card2.innerHTML = `
                         <div class="recent-card">
                            <figure>
                                <div>
                                    <img src="/imgs/Avatar-Placeholder.png" alt="" class="user-image">
                                    </div>
                                        <div>
                                            <small>username</small>
                                            <small>venuename</small>
                                            <small>San Antonio, TX</small>
                                        </div>
                            </figure>
                                        <div>
                                        <p>Does this venue have free parking</p>
                                    <div>
                                    <img src="/imgs/restaurant-image.jpg" alt="restaurant image" class="image">
                                </div>
                                <button>Answer Question</button>
                            </div>
                        </div>
    `;
    const card3 = document.createElement('div');
    card3.classList.add('recent-card');
    card3.innerHTML = `
                         <div class="recent-card">
                            <figure>
                                <div>
                                    <img src="/imgs/Avatar-Placeholder.png" alt="" class="user-image">
                                    </div>
                                        <div>
                                            <small>username</small>
                                            <small>venuename</small>
                                            <small>San Antonio, TX</small>
                                        </div>
                            </figure>
                                        <div>
                                        <p>Does this venue have free parking</p>
                                    <div>
                                    <img src="/imgs/restaurant-image.jpg" alt="restaurant image" class="image">
                                </div>
                                <button>Answer Question</button>
                            </div>
                        </div>
    `;

// Append new cards to the end of the list
    cardContainer.appendChild(card1);
    cardContainer.appendChild(card2);
    cardContainer.appendChild(card3);

    loadMoreButton.scrollIntoView({ behavior: 'smooth' });

    // Increment counter
    currentSet++;


});



