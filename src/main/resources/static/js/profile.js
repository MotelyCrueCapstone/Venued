$(function() {
    // select all DOM nodes and store the object representation of each node in a variable
    const formContainer = document.querySelector('.form-container');
    const editButton = document.querySelector('.edit-btn');
    const cancelButton = document.querySelector("#cancel-btn");

    const tabs = document.querySelectorAll('.tab-btn');
    const tabContents = document.querySelectorAll('.tab-content');

    // execute the event listener function when editButton fires the click event
    // function adds open class to the selected element
    editButton.addEventListener('click', function() {
        formContainer.classList.add('open');
        this.style.display = 'none';
    });

    // event listener function listens to the click event, and it executes
    cancelButton.addEventListener('click', function() {
        formContainer.classList.remove('open');
        editButton.style.display = 'block';
    });

    // forEach loops through each tab and remove the active and show-content from
    // the selected element
    tabs.forEach(tab => tab.addEventListener('click', function() {
        tabs.forEach(tab => tab.classList.remove('active'));
        tabContents.forEach(tabContent => tabContent.classList.remove('show-content'));

        const contentId = this.dataset.content;
        this.classList.add("active");

        document.querySelector(`.tab-content[data-content="${contentId}"]`).classList.add('show-content');
    }));

});




