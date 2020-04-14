let element = document.getElementById("category");
check();

function check() {
    if (element.value === "Business") {
        addSelectList();
    } else {
        removeSelectList();
    }
}

function addSelectList() {
    let parent = document.getElementById('form');
    let saveButton = document.getElementById('save');
    let newElement = document.createElement("SELECT");

    let array = ["Boss", "Co-worker", "Client"];
    newElement.className = "form-control mb-4 col-4";
    newElement.id = "newSelect";
    parent.insertBefore(newElement, saveButton);

    for (let i = 0; i < array.length; i++) {
        let option = document.createElement("option");
        option.value = array[i];
        option.text = array[i];
        newElement.appendChild(option);
    }
}

function removeSelectList() {
    let element = document.getElementById("newSelect");
    if (!element) {
        element.parentNode.removeChild(element);
    }
}
