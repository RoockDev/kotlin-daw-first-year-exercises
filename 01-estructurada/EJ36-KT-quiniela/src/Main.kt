import kotlin.random.Random
fun main() {
    println("Genera combinaciones al azar de una quiniela de futbol, recordemos que son 15 resultados 1 x y 2")
   /* for (i in 1..15){
        var resultado = Random.nextInt(1, 4)
        when(resultado){
            1 -> println("1")
            2 -> println("x")
            3 -> println("2")
        }

    }*/
    var cantidad = 15
    do {
        cantidad--
        var resultado = Random.nextInt(1,4)
        when(resultado){
            1 -> println("1")
            2 -> println("x")
            3 -> println("2")
        }


    }while (cantidad != 0)
}