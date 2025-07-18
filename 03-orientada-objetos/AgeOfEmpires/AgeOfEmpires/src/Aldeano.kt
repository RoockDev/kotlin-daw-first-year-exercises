class Aldeano {
    var nombre = NOMBRES_ALDEANOS.obtenerNombreAleatorio()
    var IndicadorDesalud = 200
    var civilizacionPerteneciente: Civilizacion = Civilizacion() //no me convence
    var idAldeano = 1


    companion object {
        private var contador = 1
    }

    constructor() {
        idAldeano = contador++
        if (civilizacionPerteneciente == Civilizacion(Civilizaciones.BIZANTINA)) {
            IndicadorDesalud = 250
        }

    }

    constructor(civilizacion: Civilizacion) {
        idAldeano = contador++
        civilizacionPerteneciente = civilizacion
        if (civilizacion.tipoCivilizacion == Civilizaciones.BIZANTINA)
            IndicadorDesalud = 250
    }


    constructor(nombre: String, civilizacion: Civilizacion) {
        this.nombre = nombre
        civilizacionPerteneciente = civilizacion
        if (civilizacion.tipoCivilizacion == Civilizaciones.BIZANTINA)
            IndicadorDesalud = 250
        idAldeano = contador++
    }

    fun extraerItemMina(mina: Mina) {
        if (mina.cantidadItemsCantera > 0) {
            mina.itemExtraido()
            civilizacionPerteneciente.itemAgregado(mina)
        }


    }

    fun devuelveNombreCivilizacion(): String {
        var nombreCivilizacion = civilizacionPerteneciente.tipoCivilizacion.name //mejorar luego
        return nombreCivilizacion
    }

    fun devuelveTipoCivilizacion(): Civilizaciones {
        var tipoCivilizacion = civilizacionPerteneciente.devuelveTipoCivilizacion()
        return tipoCivilizacion

    }


    override fun toString(): String {
        return "Aldeano(nombre='$nombre', IndicadorDesalud=$IndicadorDesalud, civilizacionPerteneciente=$civilizacionPerteneciente, idAldeano=$idAldeano)"
    }
}



