fun main() {
    println("Disegna un algoritmo que indique el mayor de una serie de números que introducimos por teclado\n" +
            "Crea dos versiones: en la primera la cantidad esta definida en la segunda será indefinida")

    /*ar cantidad = 5 //cantidad de numeros que queremos introducir
    var contador = 1
    var mayor = 0

    while (contador<=cantidad){
            println("introduce un numero")
            var numero = readln().toInt()
            if (numero>=mayor){
                mayor=numero
            }
        contador++

    }
    println("el numero mayor es $mayor")*/

    var mayor = 0

    do {
        println("Introduce un numero")
        var numero = readln().toInt()
        if (numero>mayor){
            mayor=numero
        }
    }while (numero>0)

    println("el numero mayor es $mayor")

}