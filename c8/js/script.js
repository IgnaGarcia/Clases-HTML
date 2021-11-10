document.addEventListener('DOMContentLoaded', () => {

    console.log(document.querySelector("h1"))

    let i = 0;
    document.querySelector("button")
        .addEventListener("click", () => {
            i++
            document.getElementById("contador").innerHTML = `<b>clickeo ${i} veces</b>`
        })
})

/*
1) Se pide crear una función que permita al usuario ingresar un texto, 
verificar que el mismo contenga solo numeros del 0 al 9 y una coma (,) 
como máximo; y devolver el número como string pero sin 0 demás delante 
ni detras.
Para la entrada "00,45" la salida debe ser "0,45". Para la entrada "hola", 
la salida debe ser "". Para la entrada "123,0500", la salida debe ser 
"123,05". Para la entrada "0.5", la salida debe ser "".
1- crear un input y un boton para ejecutar funcion
2- en la funcion verificar que el input tenga caracteres validos(con regex)
3- en la funcion limpiar los 0 de mas

/([\d]+[,\d]*)/.test(input)
*/

/*
2) Se pide crear una función que reciba como parámetro un array de 
boolean y devuelva como salida cuantos elementos adyacentes se 
repiten como máximo (cuantos true o false seguidos máximos hay).
Para la entrada [true, true, false, true, false, false] la salida 
debe ser 2. Para la entrada [] la salida debe ser 0. Para la entrada 
[true, true, true, true, true, false, true] la salida debe ser 5.
*/
function contarSeguidos(arr) {
    let ultimo = arr[0], contador = 0, maximo = 0

    arr.forEach((el, idx) => {
        if(ultimo == el) contador++
        else{
            contador = 0
            ultimo = el
        }
        if(contador > maximo) maximo = contador
    })

    return maximo
}

console.log(contarSeguidos([true, true, true]) == 3)
console.log(contarSeguidos([true, true, false, true, false, false]) == 2)
console.log(contarSeguidos([]) == 0)
console.log(contarSeguidos([true, true, true, true, true, false, true]) == 5)

/*
3) Se pide crear una función que reciba como parámetro un string 
y que devuelva la cantidad de veces que encontró contenida la palabra "ana"
Para la entrada "qwertyanasd" la salida debe ser 1. Para la entrada 
"banana y anana son frutas" la salida debe ser 4. Para la entrada 
"Anana" la salida debe ser 1.
1- recorren la palabra buscando si alguna letra 
coincide con la primera letra de la palabra a buscar
2- si coincide abrir un nuevo for a partir de la posicion en 
la que se quedo para ver si en verdad tiene la palabra
*/

