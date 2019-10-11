function encrypt(valor)
{
    md5(valor);
    let hash = md5.create();
    hash.update(valor);
    return hash.hex();

}
document.load(function ()
{
    let beforeSend = function () {
        let password = document.getElementById("password");
        let passwordEncrypt = encrypt(password);
        let inputHiddenPsswd = document.createElement("input");
        inputHiddenPsswd.setAttribute("type", "hidden");
        inputHiddenPsswd.setAttribute("name", "password_encrypt");
        inputHiddenPsswd.setAttribute("value", passwordEncrypt);
        document.forms.formLogin.appendChild(inputHiddenPsswd);
        
    }
    //Pasamos la función como parámetro en la Callback
    document.forms.formLogin.addEventListener("submit", beforeSend());
})

