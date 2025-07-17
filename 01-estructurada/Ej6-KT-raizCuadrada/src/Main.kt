
import kotlin.math.sqrt

fun main() {
    println("""
            Calcula la raíz cuadrada de un número que pedimos por teclado, teniendo la precaución de que el número
            no sea negativo; en este caso se debe informar de que la operación no es posible. """)
        println("Introduce un numero")
        var numero= readln().toIntOrNull()
        while (numero==null){
            println("Introduce un numero")
            numero= readln().toIntOrNull()
        }
        var raiz= sqrt(numero.toDouble())
        if (numero>=0){
            println("la raiz cuadrada de $numero es $raiz")
        }else{
            println("No se puede ejecutar la raiz de numero negativo")
        }



    }



