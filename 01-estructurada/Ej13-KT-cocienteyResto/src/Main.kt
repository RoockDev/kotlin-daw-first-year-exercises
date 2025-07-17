fun main() {
    println("Dados dos números enteros, realizar el algoritmo que calcule el cociente y el resto" +
            " mediante restas sucesivas.")
    println("Introduce el primer numero")
    var num1 = readln().toInt()
    println("Introduce el segundo numero")
    var num2 = readln().toInt()
    var cociente = 0
    var resto = num1
    if (num2 > num1) {
        println("el segundo numero no puede ser mayor que el primero, intentelo de nuevo")
        return // detiene la ejecucion de la funcion main
    }
    do {
        resto -= num2
        cociente++
    } while (resto >= num2)

    println("El resto de la operacion es $resto")
    println("El cociente de la operacion es $cociente")

}