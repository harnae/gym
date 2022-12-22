

function ck(e){

    let id = e.getElementById("id").value;
    let password = e.getElementById("pwd").value;
    let check = true;

    console.log("asdsad"+id);

    if (password === "") {
        e.getElementById("passwordError").innerHTML = "暗証番号を入力してください";
        check = false;
    } else {
        e.getElementById("passwordError").innerHTML = "";
    }
    
    if (id === "") {
        e.getElementById("idError").innerHTML = "IDを入力してください";
        check = false;
    } else {
        e.getElementById("idError").innerHTML = "";
    }

    return check;

}