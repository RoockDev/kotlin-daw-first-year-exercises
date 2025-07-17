fun main() {
    println("Dada una hora por teclado (horas, minutos y segundos) realiza un algoritmo\n" +
            "que muestre la hora después de incrementarle un segundo")
    println("Introduce las horas")
    var horas = readln().toInt()
    println("Introduce los minutos")
    var minutos = readln().toInt()
    println("introduce los segundos")
    var segundos = readln().toInt()


    println("la hora seria ${incrementoSegundo(horas,minutos,segundos)}")
}

fun incrementoSegundo(horas:Int, minutos:Int, segundos:Int): String{
    var otrasHoras = horas
    var otrosMinutos = minutos
    var otrosSegundos = segundos + 1

    if (otrosSegundos == 60){
        otrosSegundos = 0
        otrosMinutos ++
    }
    if (otrosMinutos == 60){
        otrosMinutos = 0
        otrasHoras ++
    }
    if (otrasHoras==24){
        otrasHoras = 0
    }
    return "$otrasHoras:$otrosMinutos:$otrosSegundos"
}