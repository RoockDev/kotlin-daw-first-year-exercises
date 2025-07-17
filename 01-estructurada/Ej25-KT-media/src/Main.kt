fun main() {
    println("Calcula la media para una cantidad indefinida de números. El programa parará de pedir números\n" +
            "cuando se le introduzca un número negativo, en ese momento nos dará la media de los números introducidos\n" +
            "hasta ese momento y la cantidad de los mismos (sin incluir al negativo que usamos para acabar)")

    var suma = 0
    var contador = 0
    var numero = 0

     while (numero>=0){
        println("Introduce un numero")
         numero = readln().toInt()
         if (numero>=0){
             suma+=numero
             contador++
         }

     }
    var media = suma/contador
    println("se han introducido una cantidad de $contador numeros y su media es $media")
}