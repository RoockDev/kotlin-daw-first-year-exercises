fun main() {
    println("Diseña un algoritmo que muestre todos los divisores de un número. Ejemplo,\n" +
            "si el usuario introduce un 12, el programa mostrará: 2,3,4,6. Si no tuviera\n" +
            "divisores no mostrará nada, se valora que muestre al final un mensaje no tiene divisores\n" +
            " caso de ocurrir.\n")

        println("introduce un numero")
        var number = readln().toInt()
        var divisor = 1

        while (divisor<=number){
            if (number%divisor==0){
                println(divisor)
            }
            divisor+=1
        }


}