class Adversario {
    var nombre = Adversarios_Nombres.obtenerAleatorio()
    var almacenCristales = ArrayList<Cristal>()
    var maestroDeCristales = false



    constructor()


    fun probabilidadEncontrarCristal():Boolean {
        var cristalEncontrado = false
        var probabilidadCristal = (1..100).random()
        if (probabilidadCristal in 1..CONSTANTES.PROBABILIDAD_ENCONTRAR_CRISTAL) {
            cristalEncontrado = true

        }

        return cristalEncontrado


    }

    fun probabilidadEncontrarCristalPurpura():Boolean{
        var purpuraEncontrado = false
        var probabilidad = (1..CONSTANTES.PROBABILIDAD_ENCONTRAR_CRISTAL).random()
        if (probabilidad in 1..2){
            purpuraEncontrado = true
        }
        return purpuraEncontrado
    }



    fun pierdeCristalPurpura(): Cristal { //el adversario pierde el cristal y se devuelve para el guardian
        var cristal = Cristal()
        var perdido = false
        for (i in almacenCristales) {
            if (i.color == ColoresCristales.PURPURA && !perdido) {
                cristal = i
                perdido = true
            }
        }
        cristal.adversarioPoseedor = null // se le quita la posesion del cristal
        almacenCristales.remove(cristal)
        maestroDeCristales = false
        return cristal

    }

    fun devuelveEnergiaCristalPurpura(): Int {
        var energiaPurpura = 0
        var devuelta = false
        for (i in almacenCristales) {
            if (i.color == ColoresCristales.PURPURA && !devuelta) {
                energiaPurpura = i.energia
                devuelta = true
            }
        }
        return energiaPurpura
    }

    fun conversionMaestroDeCristales() {

            maestroDeCristales = true
            println("El adversario se ha convertido en el Maestro de Cristales")


    }

    fun agnadirCristalaAlmacen(cristal: Cristal) {
        if (almacenCristales.size < CONSTANTES.CANTIDAD_MAXIMA_ALMACEN_ADVERSARIO) {
            almacenCristales.add(cristal)
            cristal.adversarioPoseedor = this //se le asgina ese cristal a este adversario
            println("Cristal agnadido al almacen")
        } else if (almacenCristales.size == CONSTANTES.CANTIDAD_MAXIMA_ALMACEN_ADVERSARIO && cristal.color == ColoresCristales.PURPURA) {
            almacenCristales.removeFirst()
            almacenCristales.add(cristal)
            cristal.adversarioPoseedor = this
        } else {
            println("Almacen lleno no se puede guardar el cristal")
        }
    }




    fun mostrarCristales() {
        println("Adversario ${nombre}")
        println("Cristales: ")
        if (almacenCristales.isNotEmpty()) {
            for (i in almacenCristales) {
                print("[${i.color}]")
            }
            println()
        } else {
            println("Adversario ${nombre} no tiene cristales \n")
        }
    }


}