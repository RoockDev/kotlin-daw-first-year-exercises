import kotlin.math.roundToInt

fun main() {
    println(" Diseña un algoritmo que calcule la media de tres número que pediremos al usuario.\n " +
            "Se deben dar dos resultado: la media con decimales y redondeada.")
           // println("Introduce el primer numero")
            //var num1= readln().toDouble()
            //println("Introduce el segundo numero")
            //var num2= readln().toDouble()
            //println("Introduce el tercer numero")
            //var num3= readln().toDouble()

            //var media=(num1+num2+num3)/3
            //println("la media de los 3 numeros es: $media")

            //println("la media de los 3 numeros es: ${media.roundToInt()}")
        println("de cuantos numeros quieres hacer la media")
        var numeros = readln().toInt()
        var suma=0
        var contador = 0

        while (contador<numeros){
                println("dime un numero")
                var num1 = readln().toInt()
                suma = suma + num1
                contador +=1

        }
        println("la media es ${suma/numeros}")

}