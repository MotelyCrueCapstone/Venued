const tips = document.querySelectorAll('.tip');

tips.forEach(tip => {
    const tipId = tip.dataset.id;
    const upvoteButton = tip.querySelector('.upvoteButton');
    const downvoteButton = tip.querySelector('.downvoteButton');


    upvoteButton.addEventListener("click", () => handleVote("up"));
    downvoteButton.addEventListener("click", () => handleVote("down"));
});

const handleVote = (direction) => {
    // Send a POST request to the /api/vote endpoint with the vote data
    fetch("/api/vote", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({ tipId: currentTipId, direction }),
    });
};
