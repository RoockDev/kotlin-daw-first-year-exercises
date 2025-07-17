import kotlin.random.Random
fun main() {
    println("vamos a jugar a la primitiva")
    println("Debes introducir 6 numeros y ver si te ha tocado")
    println("Introduce el numero 1")
    var num1 = readln().toInt()
    println("Introduce el numero 2")
    var num2 = readln().toInt()
    println("Introduce el numero 3")
    var num3 = readln().toInt()
    println("Introduce el numero 4")
    var num4 = readln().toInt()
    println("Introduce el numero 5")
    var num5 = readln().toInt()
    println("Introduce el numero 6")
    var num6 = readln().toInt()

    var cantidad = 6
    var contador = 0

    do {
        var random = Random.nextInt(1 , 50)
        cantidad--
        if (num1==random){
            contador++
        }else if (num2==random){
            contador++
        }else if (num3==random){
            contador++
        }else if (num4==random){
            contador++
        }else if (num5==random){
            contador++
        }else if (num6==random){
            contador++
        }
    }while (cantidad!=0)
    println("Has tenido $contador aciertos")


}