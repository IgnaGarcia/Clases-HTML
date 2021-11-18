function onClick(){
    console.log("me clickearon")
    toggleTheme()
}

function toggleTheme(){
    if(isDark){
        document.documentElement.style.setProperty('--fondo', '#e5e5e5');
        document.documentElement.style.setProperty('--color', '#111');
    }
    else{
        document.documentElement.style.setProperty('--fondo', '#252525');
        document.documentElement.style.setProperty('--color', '#eee');
    }
    isDark = !isDark;
}
/*
function unNumero(){
    return 5;
}

function ejecutar(callback){
    return callback()
}

console.log(ejecutar(onClick))
*/
function main(){
    toggleTheme()

    const btn = document.querySelector("#btn")
    btn.addEventListener("mouseover", () => { 
        btn.className += " rotate-center"
    })
    btn.addEventListener("click", onClick)
}
var isDark = true
main()