class Mina {
    var trabajadores = ArrayList<Aldeano>()
    var tipoItemMina = ITEM.ORO // por defecto
    var cantidadItemsCantera = 500
    var cantera = MutableList(cantidadItemsCantera) { tipoItemMina } // con arraylist no funciona


    constructor()
    constructor(tipoItemMina: ITEM, cantidadItemsCantera: Int) {
        this.tipoItemMina = tipoItemMina
        this.cantidadItemsCantera = cantidadItemsCantera
        cantera = MutableList(this.cantidadItemsCantera) { this.tipoItemMina }
    }

    fun itemExtraido() {
        if (cantera.isNotEmpty()) {
            cantera.removeFirst()
            cantidadItemsCantera--
        } else {
            println("La cantera está vacia")
        }

    }

    fun agregarTrabajadorAlaMina(aldeano: Aldeano) {
        trabajadores.add(aldeano)
    }

    fun agregarTrabajadorProbabilidad(aldeano1: Aldeano, aldeano2: Aldeano) {
        var probabilidad = (1..100).random()
        when (probabilidad) {
            in 1..20 -> {
                trabajadores.add(aldeano1)
                println("Aldeano ${aldeano1.devuelveNombreCivilizacion()} agregado a la mina")
            }

            in 1..40 -> {
                trabajadores.add(aldeano2)
                println("Aldeano ${aldeano2.devuelveNombreCivilizacion()} agregado a la mina")
            }

            in 41..100 -> {
                println("No se agregan trabajadores a la mina")

            }

        }

    }

    // no se si esta bien aqui este metodo
    fun ataqueCuraBizantino() {
        var aldeanoConvertido = 0
        var indice = 0
        while (aldeanoConvertido != 1 && indice < trabajadores.size) {
            var aldeano = trabajadores[indice]
            if (aldeano.devuelveTipoCivilizacion() == Civilizaciones.ESPANOLA) {
                println("Se ha producido un ataque de cura bizantino, Aldeano Espagnol Convertido.")
                aldeano.civilizacionPerteneciente = Civilizacion(Civilizaciones.BIZANTINA)
                aldeanoConvertido++
            }
            indice++
        }
    }

    fun mostrarInformacionTrabajadores() {
        for (i in trabajadores) {
            println("${i}")
        }
    }

}