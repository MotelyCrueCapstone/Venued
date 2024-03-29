const tips = document.querySelectorAll('.tip');

tips.forEach(tip => {
    const tipId = tip.dataset.id;
    //selecting the vote button elements to initiate the requests
    const upVoteButton = tip.querySelector('.upVoteButton');
    const downVoteButton = tip.querySelector('.downVoteButton');
    upVoteButton.addEventListener("click", () => handleVote("up"));
    downVoteButton.addEventListener("click", () => handleVote("down"));


    function handleVote(voteType) {
         //using a get request for the adding of the votes to avoid errors
fetch(`/tips/${tipId}/vote`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                voteType: voteType
            })
     
        }).then(res => res.json())
            .then(data => {
                const { upVotes, downVotes } = data;
                tip.querySelector('.upVotes').innerText = upVotes;
                tip.querySelector('.downVotes').innerText = downVotes;
            })
    }

});


