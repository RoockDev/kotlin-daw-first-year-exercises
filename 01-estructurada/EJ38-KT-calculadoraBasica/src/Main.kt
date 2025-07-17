fun main() {
    println("La calculadora. Diseña un algoritmo que pida dos números y un operador (una operación aritmética básica:\n" +
            "sumar, restar, multiplicar o dividir). Se debe mostrar el resultado de dicha operación. Controla el posible error\n" +
            "como la división por cero, en este caso se indicará que no se puede realizar. El ejercicio se debe repetir indefinidamente\n" +
            "hasta que el usuario decida terminar.\n")
    println("Introduce el primer numero ")
    var num1 = readln().toInt()
    println("Introduce el segundo numero ")
    var num2 = readln().toInt()

    do {
        println("Que operacion deseas relizar [1]Suma, [2]resta, [3]multiplicar, [4]dividir, [5]salir ")
        var operacion = readln().toInt()
        when(operacion){
            1 -> println("La suma es ${num1+num2}")
            2 -> println("la resta es ${num1-num2}")
            3 -> println("La multiplicacion es ${num1*num2}")
            4 ->{
                if (num2==0){
                    println("No se puede dividir entre 0")
                }
                println("La division es ${num1/num2}")
            }
        }
    }while (operacion!=5)
    println("Programa finalizado")
}