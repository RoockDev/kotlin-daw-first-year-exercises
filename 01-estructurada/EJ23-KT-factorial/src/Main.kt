fun main() {
    println("Calcula el factorial de un número entero. El factorial es el resultado de multiplicar\n" +
            " ese número por todos los números menores que él. Ejemplo: 4! = 4*3*2*1 = 24.")
    var numero = 4
    var resuelveFactorial = factorial(numero)
    println("El factorial de $numero es $resuelveFactorial")
}
fun factorial(numero:Int): Int {
    var resultado = 1
    for (i in 1..numero){
        resultado *=i

    }
    return resultado
}
