let personas = [ "nacho","Facu", "Lucia", "Larry", "Calel" ]
document.querySelector("body").innerHTML += "<a href=\"https://www.google.com\">google</a>"

/*
1) Se pide crear una función que permita al usuario ingresar un texto, 
verificar que el mismo contenga solo numeros del 0 al 9 y una coma (,) 
como máximo; y devolver el número como string pero sin 0 demás delante ni detras.
Para la entrada "00,45" la salida debe ser "0,45". Para la entrada "hola", 
la salida debe ser "". Para la entrada "123,0500", la salida debe ser "123,05". 
Para la entrada "0.5", la salida debe ser "".
*/
/*
1- crear un input en html
2- captar el evento enter o el send de un boton
3- verificar que la cadena no tenga caracteres inesperados(con RegEx o recorriendo y comparando)
4- eliminar 0 de mas 
*/


/*
2) Se pide crear una función que reciba como parámetro un array de boolean y 
devuelva como salida cuantos elementos adyacentes se repiten como máximo 
(cuantos true o false seguidos máximos hay).
Para la entrada [true, true, false, true, false, false] la salida debe ser 2. 
Para la entrada [] la salida debe ser 0. Para la entrada 
[true, true, true, true, true, false, true] la salida debe ser 5.
*/
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

/*
3) Se pide crear una función que reciba como parámetro un string y que devuelva 
la cantidad de veces que encontró contenida la palabra "ana"
Para la entrada "qwertyanasd" la salida debe ser 1. Para la entrada 
"banana y anana son frutas" la salida debe ser 4. Para la entrada "Anana" 
la salida debe ser 1.
*/
/*
RegEx o recorriendo y comparando
recorriendo y comparando:
    doble for, el primero busca la primera letra de la palabra a buscar, 
    si la encuentra activa el segundo para ver si coinciden las demas letras
*/