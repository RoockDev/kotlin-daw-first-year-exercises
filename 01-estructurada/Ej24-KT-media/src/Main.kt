fun main() {
    println("calcular la media de 10 numero que pedimos por teclado, Generaliza la Solucion\n" +
    "para una cantidad cualquiera de numeros que pediremos por teclado")

    var numbers = IntArray(10) // creacion de array con 10 enteros

    /*var suma = 0
    for (i in 0 until 10){ // gua
        println("Introduce un numero")
        numbers[i]= readln().toInt()
        suma += i
    }
    var average = suma/10
    println("los numeros introducidos han sido ${numbers.joinToString()}")
    println("La media de los numeros introducidos $average")
*/

    println("Introduce la cantidad de numero que deseas almacenar en la lista")
    var totalNumeros = readln().toInt()

    var numeros = IntArray(totalNumeros)
    var suma = 0

    for (i in 0 until totalNumeros){
        println("Introducimos un numero")
        numeros[i] = readln().toInt()
        suma +=numeros[i]
    }
    var media = suma/totalNumeros
    println("Los numeros introducidos en la lista han sido ${numeros.joinToString()}")
    println("La media de todos los numero es $media")


}