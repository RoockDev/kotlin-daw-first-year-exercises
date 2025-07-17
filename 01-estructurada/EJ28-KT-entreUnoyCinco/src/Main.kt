fun main() {
    println("Piensa un algoritmo que pida números hasta que el número leído esté entre 1 y 5\n" +
            "en ese momento se debe salir")
        println("Introduce un numero")
        var number = readln().toInt()

        while ((number <= 1) || (number >= 5)){
            println("Debes de introducir otro numero")
            number = readln().toInt()
        }
        println("El programa ha finalizado")
}