let personas = ["nacho", "Facu", "Lucia", "Larry", "Calel"];
document.querySelector("body").innerHTML +=
    '<a href="https://www.google.com">google</a>';


function personaFactory(nombre, edad) {
    return {
        nombre: nombre,
        edad: edad,
        esMayor: () => edad > 18
    }
}

function extenderPersonaAEmpleado(obj, sueldo){
    obj.sueldo = sueldo
    obj.estaMalPago = () => sueldo < 30000
    return obj
}

function personaTemplate(p){
    return `<li> <h1>${p.nombre}</h1>  <h2>${p.edad}</h2> </li>`
}

let lista = [
    personaFactory("nacho", 12),
    personaFactory("larry", 24),
    personaFactory("diego", 23)
];
let personaList = `<ul>`
lista.forEach(p => {
    personaList += personaTemplate(p)
})
personaList += `</ul>`
document.getElementById("lista").innerHTML = personaList

/*
1) Se pide crear una función que permita al usuario ingresar un texto, 
verificar que el mismo contenga solo numeros del 0 al 9 y una coma (,) 
como máximo; y devolver el número como string pero sin 0 demás delante ni detras.
Para la entrada "00,45" la salida debe ser "0,45". Para la entrada "hola", 
la salida debe ser "". Para la entrada "123,0500", la salida debe ser "123,05". 
Para la entrada "0.5", la salida debe ser "".

1- crear un input en html
2- captar el evento enter o el send de un boton
3- verificar que la cadena no tenga caracteres inesperados(con RegEx o recorriendo y comparando)
4- eliminar 0 de mas 
*/
function limpiarInput(input) {
    let componentes = input.split(",");

    if(componentes.length > 2) return undefined
    else if(/\d+/.test(componentes[0]) && /\d+/.test(componentes[1])){
        console.log("hacer toda la logica")
    } else return undefined
    /* si quieren lo arreglan
        let str = "";
        for (let i = 0, ceros = 0; i < componentes[0].length; i++) {
            if (i + 1 == componentes[0].length && ceros >= 1) {
                componentes[0] = componentes[0].slice(
                    ceros,
                    componentes[0].length
                );
                break;
            } else if (componentes[0][i] == 0) ceros++;
            else {
                componentes[0] = componentes[0].slice(
                    ceros,
                    componentes[0].length
                );
                break;
            }
        }
        str += componentes[0];
        if (componentes[1]) {
            for (let i = componentes[1].length, ceros = 0; i >= 0; i--) {
                if (i == 0 && ceros >= 1) {
                    componentes[1] = componentes[1].slice(
                        0,
                        componentes[1].length - ceros
                    );
                    break;
                } else if (componentes[1][i] == 0) ceros++;
                else if (ceros > 1) {
                    componentes[1] = componentes[1].slice(
                        0,
                        componentes[1].length - ceros
                    );
                    break;
                }
            }
            str += "," + componentes[1];
        }
        return str;
    */
}

function submit() {
    let value = document.getElementById("input").value;
    let res = limpiarInput(value);
    document.getElementById("res").innerHTML = `<i>El resultado es: ${res}</i>`;
}
/*
console.log(limpiarInput("holam unco"))
console.log(limpiarInput("00000,200"))
console.log(limpiarInput("002500"))
console.log(limpiarInput("2500,2"))
console.log(limpiarInput("2500,"))
*/

/*
2) Se pide crear una función que reciba como parámetro un array de boolean y 
devuelva como salida cuantos elementos adyacentes se repiten como máximo 
(cuantos true o false seguidos máximos hay).
Para la entrada [true, true, false, true, false, false] la salida debe ser 2. 
Para la entrada [] la salida debe ser 0. Para la entrada 
[true, true, true, true, true, false, true] la salida debe ser 5.
*/
/*
function contarSeguidos(arr) {

    let ultimo = arr[0]
    let contador = 0
    let maximo = 0
    
    arr.forEach((value, i) => {
        if(ultimo == value) contador++
         else {
            contador = 1
            ultimo = value
        }
        if(contador > maximo) maximo = contador
    })
    
    return maximo
}

console.log(contarSeguidos([true, true, false, true, false, false]) == 2)
console.log(contarSeguidos([]) == 0)
console.log(contarSeguidos([true, true, true, true, true, false, true]) == 5)
*/

/*
3) Se pide crear una función que reciba como parámetro un string y que devuelva 
la cantidad de veces que encontró contenida la palabra "ana"
Para la entrada "qwertyanasd" la salida debe ser 1. Para la entrada 
"banana y anana son frutas" la salida debe ser 4. Para la entrada "Anana" 
la salida debe ser 1.

recorriendo y comparando:
    doble for, el primero busca la primera letra de la palabra a buscar, 
    si la encuentra activa el segundo para ver si coinciden las demas letras
*/
function search(str, s) {
    let count = 0;
    let flag = false;
    
    if(!srt.includes(s)) return 0;

    for (let i = 0; i < str.length; i++) {
        if (str[i] == s[0]) {
            flag = true;
            for (let j = 1; j < s.length; j++) {
                if (str[i + j] != s[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) count++;
        }
    }
    return count;
}
console.log(search("qwertyanasd", "ana"));
console.log(search("banana y anana son frutas", "ana"));
console.log(search("Anana", "ana"));
