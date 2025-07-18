const val MAXIMO = 5
class Jugador {
    var nombre = " "
        set(value) {
            field = if (value.isNotBlank()) value else "Desconocido"
        }
    var baraja = ArrayList<Carta>(MAXIMO)

    constructor()
    constructor(nombre:String){
        this.nombre = nombre
    }

    // Metodo para llenar la bara del jugador

    fun llenarBaraja(){
        var llena = MAXIMO
        while (llena!=0){
            baraja.add(Carta())
            llena--
        }
    }

    // Metodo para seleccionar la carta con la que va jugar el jugador
    fun SeleccionarCarta(): Carta {
        var cartaJugada = Carta()
        var puedeJugar = false
        do {
            println("Con que carta deseas jugar")
            for (i in baraja.indices) {
                println(baraja[i])
            }
            var cartaSeleccionada = readln().toIntOrNull() ?: 1
            if (cartaSeleccionada in 1..baraja.size) {
                for (i in baraja.indices) {
                    if (baraja[cartaSeleccionada - 1] == baraja[i]) {
                        if (baraja[i].indiceVida > 0) {
                            cartaJugada = baraja[i]
                            puedeJugar = true

                        }
                    }
                }
                if (!puedeJugar) println("Opcion no válida, selecciona otra carta")
            } else println("Opcion no valida")


        } while (!puedeJugar)



        return cartaJugada
    }



    // Metodo para saber la fuerza total de todas sus cartas(se suman los indices)
  fun fuerzaCartas():Int{
      var totalFuerza = 0
      for (i in baraja.indices){
          totalFuerza += baraja[i].indiceVida
      }
      return totalFuerza
  }

    // Metodo para saber valor total de la baraja (suma de indice + poder de cada carta)
    fun totalValor():Int{
        var valorTotal = 0
        for (i in baraja.indices){
            valorTotal+= baraja[i].indiceVida
            valorTotal+= baraja[i].poder
        }
        return valorTotal
    }

    // Comprobamos cuantas cartas con vida tienen
    fun CartasBaraja():Int{
        var cartasVivas = 0
        for (i in baraja){
            if (i.indiceVida > 0)
                cartasVivas++
        }
        return cartasVivas
    }


}