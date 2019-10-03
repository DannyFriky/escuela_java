window.onload = () => {
    document.getElementById("btnSend").onclick = function () {
        let email = document.getElementById("email").value;
        let password = document.getElementById("password").value;
        let name = document.getElementById("name").value;
        let age = document.getElementById("age").value;
        
        
        let objUser ={
            "email":email,
            "password":password
        }
        
        objUser.name = name;
        objUser["edad"] = age;
        
        let jsonTextUser = JSON.stringify(objUser);
        
    }
}