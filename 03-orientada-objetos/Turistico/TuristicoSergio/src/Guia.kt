class Guia {
    var nombre = ""
    var rutas = ArrayList<RutasTuristicas>()
    private var idGuia = 1


    companion object {

        private var contador = 1
    }

    constructor() {
        idGuia = contador
        contador++
        nombre = NombreObjetos.GUIA.name + idGuia

    }

    fun agregarRuta(ruta: RutasTuristicas) {
        rutas.add(ruta)
    }

    override fun toString(): String {
        return """ Guia(nombre='${nombre}', 
            | [rutas=${rutas})]""".trimMargin()
    }


}
