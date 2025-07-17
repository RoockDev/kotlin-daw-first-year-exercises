import kotlin.random.Random
fun main() {
    println("Quiniela, Genera las apuestas y los resultados e indica cuantos aciertos has conseguido")
    var aciertos = 0
    for (i in 1..15){
        var resultado = Random.nextInt(1,4)
        var apuestas = Random.nextInt(1,4)

        when(resultado){
            1 -> println("El resultado del partido $i: 1")
            2 -> println("El resultado del partido $i: x")
            3 -> println("El resultado del partido $i: 2")
        }
        when(apuestas){
            1 -> println("La apuesta del partido $i: 1")
            2 -> println("La apuesta del partido $i: x")
            3 -> println("La apuesta del partido $i: 2")
        }
        if (resultado==apuestas){
            aciertos++
        }
        }
    println("Has obtenido $aciertos aciertos")


    }










