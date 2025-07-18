fun main() {
    var nidoSerpientes = ArrayList<Serpiente>()
    var tiempoSimulacion = 1
    var idSerpiente = 0

    while (tiempoSimulacion<300){
        println("Agno: $tiempoSimulacion")
        if ((tiempoSimulacion % 5 == 0) && (nidoSerpientes.size < 20)){
            var nacimientoSerpiente = (1..3).random()
            while (nacimientoSerpiente>0){
                nidoSerpientes.add(Serpiente(idSerpiente++))
                nacimientoSerpiente--
            }

        }
        // utilizo while para modificar atributos y usar metodos de serpiente
        // con el for no funciona este
        var i =0
        while (i < nidoSerpientes.size){
            nidoSerpientes[i].edad++
            nidoSerpientes[i].EtapaVida()
            if (nidoSerpientes[i].vida()){
                nidoSerpientes.removeAt(i)
            }else{
                i++
            }
        }
        if (tiempoSimulacion % 10 == 0 && nidoSerpientes.size < 20){
            var comidaMangosta = (1..100).random()
            var serpientesComidas = (0..4).random()
            if (comidaMangosta in 1..20){
                while (serpientesComidas>0){
                    if (nidoSerpientes.isNotEmpty())
                        println(" La Mangosta se ha zampado a la Serpiente $idSerpiente")
                    nidoSerpientes.removeFirst()
                    serpientesComidas--
                }
            }

        }
        // esto esta comentado para poder ver la simulacion si no se corta antes
        // no esta bien, hay que buscar otra manera

       /* for (i in nidoSerpientes){
            if (i.vida()){
                if (nidoSerpientes.isNotEmpty()){
                    println("Se acaba la simulacion")
                    tiempoSimulacion = 300
                }

            }
        }*/

        tiempoSimulacion++

        println("$nidoSerpientes")
    }

}