import kotlin.random.Random
fun main() {
    println("vamos a jugar la primitiva")
    println("Debes introducir 6 numeros y ver si te ha tocado")

    val numeroUsuario = mutableListOf<Int>() //creamos una lista para almacenar los numeros

    for (i in 1..6){
        println("Introduce el numero $i")
        var number = readln().toInt()
        numeroUsuario.add(number) // se anade el numero introducido a tu lista
    }

    var cantidad = 6
    var contador = 0

    do {
        var random = Random.nextInt(1, 50 )
        cantidad--

        if (numeroUsuario.contains(random)){
            contador++
        }
    }while (cantidad!=0)

    println("Has tenido $contador aciertos")
}