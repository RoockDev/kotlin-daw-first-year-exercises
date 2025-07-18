class RutasTuristicas {
    var nombre = ""
    var lugares = ArrayList<Lugar_Turistico>()
    private var idRuta = 1

    companion object {
        private var contador = 1
        private var rutasTotales = 1

    }

    constructor() {
        idRuta = contador
        contador++
        nombre = NombreObjetos.RUTA.name + idRuta
        rutasTotales++
    }

    constructor(nombre: String) {
        this.nombre = NombreObjetos.RUTA.name + nombre + idRuta
        idRuta = contador
        contador++
        rutasTotales++
    }

    fun rutaTerminada(): Boolean { // no me gusta, no es optimo si hay mas lugares, pero no se me ocurre otro
        var hayMuseo = false
        var hayMonumento = false
        var hayParque = false
        for (i in lugares) {
            when (i) {
                is Museo -> hayMuseo = true
                is Parque -> hayParque = true
                is Monumento -> hayMonumento = true

            }
        }
        return (hayParque && hayMuseo && hayMonumento)
    }

    /*fun agregarLugar(lugar:Lugar_Turistico){
        var random = (Constantes.MINIMOLUGARES..Constantes.MAXIMOLUGARES).random()
        when(random){
            1 -> lugares.add(Museo())
            2 -> lugares.add(Parque())
            3 -> lugares.add(Monumento())
        }
    }*/

    fun agregarLugar(lugarTuristico: Lugar_Turistico) {
        lugares.add(lugarTuristico)
    }


    fun mediaPrecioRuta(): Double {

        var resultado = 0
        var sumaLugares = 0
        if (lugares.isNotEmpty()) {
            for (i in lugares) {
                sumaLugares += i.precio
            }
            resultado = sumaLugares / lugares.size
        }

        return resultado.toDouble() //COMPROBAR PUEDE QUE ESTE MAL

    }

    override fun toString(): String {
        return """RutasTuristicas(nombre='${nombre}', mediaPrecios=${mediaPrecioRuta()},
            | [lugares=${lugares}])""".trimMargin()
    }


}