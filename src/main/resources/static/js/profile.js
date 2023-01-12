$(function() {
    const formContainer = document.querySelector('.form-container');
    const editButton = document.querySelector('.edit-btn');
    const cancelButton = document.querySelector("#cancel-btn");

    const tabs = document.querySelectorAll('.tab-btn');
    const tabContents = document.querySelectorAll('.tab-content');


    editButton.addEventListener('click', function() {
        formContainer.classList.add('open');
        this.style.display = 'none';
    });

    cancelButton.addEventListener('click', function() {
        formContainer.classList.remove('open');
        editButton.style.display = 'block';
    });

    tabs.forEach(tab => tab.addEventListener('click', function() {
        tabs.forEach(tab => tab.classList.remove('active'));
        tabContents.forEach(tabContent => tabContent.classList.remove('show-content'));

        const contentId = this.dataset.content;
        this.classList.add("active");

        document.querySelector(`.tab-content[data-content="${contentId}"]`).classList.add('show-content');
    }));



});




