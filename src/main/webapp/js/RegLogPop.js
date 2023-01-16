const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');
const modalButton = document.querySelector('.modal-button');
const closeModal = document.querySelector(".exit-button");
const modal = document.querySelector('.modal');

signUpButton.addEventListener('click', () => {
    container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
    container.classList.remove("right-panel-active");
});

modalButton.addEventListener("click", () => {
    modal.classList.toggle("modal-show");
    modalButton.classList.toggle("modal");
});

closeModal.addEventListener("click", () => {
    modal.classList.toggle("modal-show");
    modalButton.classList.toggle("modal");
});

