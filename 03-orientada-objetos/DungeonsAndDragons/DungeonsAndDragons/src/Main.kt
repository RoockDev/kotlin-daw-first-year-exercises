fun main() {
    println("""
        Vamos a jugar al juego Dungeons && Dragons
        cada jugador tiene 5 cartas
        En cada tirada seleccionaran una de sus cartas
        y estas se enfrentaran entre ellas.
        la partida termina cuando haya menos 7 cartas en el juego
    """.trimIndent()
        )

    var jugadorPrincipal = Jugador("Agustin")
    var jugadorSecundario = Jugador("Evaristo")
    var juego = Juego()


    // LLenamos la baraja de cartas de los jugadores
    var mazoJP = jugadorPrincipal.llenarBaraja() //Mazo jugadorPrincipa;
    var mazoJS = jugadorSecundario.llenarBaraja() //Mazo jugadorSecundario

    var enferntamiento = false
    var ronda = 1
    while (!enferntamiento){
        println("Ronda $ronda:  jugardor 1: ${jugadorPrincipal.nombre}")
        var cartaJP = jugadorPrincipal.SeleccionarCarta()
        println(cartaJP)
        println("Ronda $ronda: jugador 2: ${jugadorSecundario.nombre}")
        var cartaJS = jugadorSecundario.SeleccionarCarta()
        println(cartaJS)
        println("Las cartas se van a enfrentar...")
        juego.EnfrentamientoCartas(cartaJP,cartaJS,cartaJS.dadoCarta)
        println(cartaJP)
        println(cartaJS)
        println("Ahora vamos a ver como están las barajas de nuestros jugadores.")
        println("Fuerza Cartas Jugador ${jugadorPrincipal.nombre} : ${jugadorPrincipal.fuerzaCartas()}")
        println("Fuerza Cartas Jugador ${jugadorSecundario.nombre}: ${jugadorSecundario.fuerzaCartas()}")
        println("Valor total Jugador ${jugadorPrincipal.nombre}: ${jugadorPrincipal.totalValor()}")
        println("Valor total jugador ${jugadorSecundario.nombre}: ${jugadorSecundario.totalValor()}")
        println("Por ultimo vamos a comprobar el estado de la partida: ")
        println("Comprobando numero total de cartas...")
        var totalCartas = juego.sumaMazos(jugadorPrincipal,jugadorSecundario)
        if (totalCartas < 7){
            println("Cartas en la partida: ${totalCartas}")
            println("Fin de la partida.")
            enferntamiento = true
        }else{
            println("Cartas en la partida: ${totalCartas}")
            println("El juego continua")
        }

        ronda++
    }

    var cartasJP = jugadorPrincipal.CartasBaraja()
    var cartasJS = jugadorSecundario.CartasBaraja()
    if (cartasJP > cartasJS){
        println("El jugador ${jugadorPrincipal.nombre} ha ganado la partida")
    }else{
        println("El jugador ${jugadorSecundario.nombre} ha ganado la partida")
    }

}