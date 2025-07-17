import kotlin.math.PI
import kotlin.math.pow
fun main() {
    println("Calcula el área y la circunferencia de un círculo cuyo radio se debe preguntar al usuario")

    println("Introduce el radio del circulo")
    var radio : Double= readln().toDouble()

    println("El area del circulo es: ${PI*(Math.pow(radio,2.0))}")
    println("La circunferencia del circulo es: ${2* PI*radio}")



}