
window.onload = function () {
    function encrypt(valor) {
        md5(valor);
        let hash = md5.create();
        hash.update(valor);
        return hash.hex();
    }


        let beforeSend = function (event) {
            let form = event.target;
            event.preventDefault();
            let password = document.getElementById("password");
            if (password.value.length > 2) {
                let passwdEncript = encrypt(password.value);
                let inputHiddenPsswd = document.createElement("input");
                inputHiddenPsswd.setAttribute("type", "hidden");
                inputHiddenPsswd.setAttribute("name", "password_encrypt");
                inputHiddenPsswd.setAttribute("value", passwdEncript);

                form.appendChild(inputHiddenPsswd);
                form.removeChild(form.password);
                form.submit();
            } else {
                alert("Password too short");
                return false;
            }
        };
        document.forms[0].addEventListener("submit", beforeSend);
    
};