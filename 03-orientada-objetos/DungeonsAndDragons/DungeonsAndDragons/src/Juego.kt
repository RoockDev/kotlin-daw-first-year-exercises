class Juego {
    constructor()

    fun EnfrentamientoCartas(carta1:Carta,carta2: Carta,dado: Dado){
        if ((carta1.MejorCarta(carta2)) && (carta1.dadoCarta.mejorDado(dado))){ //Gana nuestra carta
            var diferencia = carta1.poder - carta2.poder
            // Se le resta la diferencia del poder al indice de vida
            carta2.indiceVida -= diferencia
            println("La carta ganadora es ${carta1}")


        }else if ((!carta1.MejorCarta(carta2)) && (!carta1.dadoCarta.mejorDado(dado))){ //Gana la otra carta
            var diferencia = carta2.poder - carta1.poder
            // Se le resta la difierencia del poder al indice de vida
            carta1.indiceVida -= diferencia
            println("La carta ganadora es ${carta2}")
        }else{
            // Si una carta tiene un poder superior a otro pero el resultado del dado lanzado es menor se resta 5 a las 2
            carta1.indiceVida -= 5
            carta2.indiceVida -= 5
            println("Ambas carta pierden 5 de vida")
        }


    }
    // Metodo para comprobar la cantidad de cartas que hay en la partida
    fun sumaMazos(jugadorPrinciapl:Jugador,jugadorSecundario: Jugador):Int{
        var suma = 0
        for (i in jugadorPrinciapl.baraja){
            if (i.indiceVida>0) suma +=1

        }
        for (i in jugadorSecundario.baraja){
            if (i.indiceVida > 0) suma += 1
        }
        return suma
    }



}