const tips = document.querySelectorAll('.tip');

tips.forEach(tip => {
    const tipId = tip.dataset.id;
    const upVoteButton = tip.querySelector('.upVoteButton');
    const downVoteButton = tip.querySelector('.downVoteButton');
    upVoteButton.addEventListener("click", () => handleVote("up"));
    downVoteButton.addEventListener("click", () => handleVote("down"));

    function handleVote(voteType) {
        fetch(`/tips/${tipId}/vote`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                voteType: voteType
            })
        }).then(response => response.json())
            .then(data => {
                const votes = tip.querySelector('.votes');
                votes.innerHTML = data.votes;
            })
    }
});


