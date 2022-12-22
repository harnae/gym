
// 登録テック

function signUpCheck(e) {

    let id = document.getElementById("id").value
    let name = document.getElementById("name").value
    let password = document.getElementById("password").value
    let passwordCheck = document.getElementById("passwordCheck").value
    let area = document.getElementById("area").value
    let phone = document.getElementById("phone").value
    let gender_man = document.getElementById("gender_man").checked
    let gender_woman = document.getElementById("gender_woman").checked
    let check = true;

    // ID
    if (id === "") {
        document.getElementById("idError").innerHTML = "IDを入力してください"
        check = false
    } else {
        document.getElementById("idError").innerHTML = ""
    }


    // 名前
    if (name === "") {
        document.getElementById("nameError").innerHTML = "名前を入力してください"
        check = false
    } else {
        document.getElementById("nameError").innerHTML = ""
    }


    // 暗証番号
    if (password !== passwordCheck) {
        document.getElementById("passwordError").innerHTML = ""
        document.getElementById("passwordCheckError").innerHTML = "同じ暗証番号を入力してください"
        check = false
    } else {
        document.getElementById("passwordError").innerHTML = ""
        document.getElementById("passwordCheckError").innerHTML = ""
    }

    if (password === "") {
        document.getElementById("passwordError").innerHTML = "暗証番号を入力してください"
        check = false
    } else {
        document.getElementById("passwordError").innerHTML = ""
    }
    if (passwordCheck === "") {
        document.getElementById("passwordCheckError").innerHTML = "もう一度暗証番号を入力してください"
        check = false
    } else {
        document.getElementById("passwordCheckError").innerHTML = ""
    }

    //電話番号
    if (phone === "") {
        document.getElementById("phoneError").innerHTML = "電話番号を入力してください"
        check = false
    } else {
        document.getElementById("phoneError").innerHTML = ""
    }

    //電話番号
    if (area === "") {
        document.getElementById("areaError").innerHTML = "住所を入力してください"
        check = false
    } else {
        document.getElementById("areaError").innerHTML = ""
    }

    // 性別
    if (!gender_man && !gender_woman) {
        document.getElementById("genderError").innerHTML = "性別を選んで下さい"
        check = false
    } else {
        document.getElementById("genderError").innerHTML = ""
    }

    if (check) {
        document.getElementById("emailError").innerHTML = ""
        document.getElementById("nameError").innerHTML = ""
        document.getElementById("passwordError").innerHTML = ""
        document.getElementById("passwordCheckError").innerHTML = ""
        document.getElementById("phoneError").innerHTML = ""
        document.getElementById("areaError").innerHTML = ""
        document.getElementById("genderError").innerHTML = ""
        document.getElementById("signInId").onsubmit = ()=>{
            alert("登録を完了しました");
        };
        
    }
    return check;
    
}
