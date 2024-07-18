function addElement() {
    let text = document.getElementById("inputTextId").value;
    let ulInput = document.getElementById("ulId");
    let newLi, liText;

    text = text.trim();

    if (text.length == 0) {
        alert("El texto no puede estar vacío.");
        return;
    } 
    newLi = document.createElement("li");
    liText = document.createTextNode(text);
    newLi.appendChild(liText);
    ulInput.appendChild(newLi);

    document.getElementById("inputTextId").value = "";
}

function changeColor(obj) {
    document.getElementById("divId").style.backgroundColor = "red";
}

function originColor(obj) {
    document.getElementById("divId").style.backgroundColor = "white";
}
