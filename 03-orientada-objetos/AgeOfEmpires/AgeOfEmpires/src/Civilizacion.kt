class Civilizacion {
    var tipoCivilizacion = Civilizaciones.NINGUNA // por defecto
    var almacen = ArrayList<ITEM>()
    var gobernador: Gobernador? = null


    constructor()
    constructor(tipoCivilizacion: Civilizaciones) {
        this.tipoCivilizacion = tipoCivilizacion
        estableceGobernador()
    }


    constructor(gobernador: Gobernador) {
        if (this.gobernador == null) {
            if (gobernador.civilizacion == null) { // si el gobernador que se le asigna no tiene civilizacion se asignara esta civilizacion
                gobernador.civilizacion = this
                this.gobernador = gobernador
            } else {
                println("El gobernador ya tiene una civilizacion")
            }
        } else {
            println("La civilizacion ya tiene gobernador")
        }


    }

    constructor(tipoCivilizacion: Civilizaciones, gobernador: Gobernador) {
        this.tipoCivilizacion = tipoCivilizacion
        if (gobernador.civilizacion == null) {
            gobernador.civilizacion = this
            this.gobernador = gobernador
        }
    }

    fun estableceGobernador() {
        this.gobernador = when (tipoCivilizacion) {
            Civilizaciones.ESPANOLA -> Gobernador(GOBERNADORES.ISABEL)
            Civilizaciones.MESOPOTAMICA -> Gobernador(GOBERNADORES.ALEJAMDRO)
            Civilizaciones.INGLESA -> Gobernador(GOBERNADORES.ALEJAMDRO)
            Civilizaciones.BIZANTINA -> Gobernador(GOBERNADORES.CONSTANTINO)
            else -> null // la civilizacion puede no tener gobernador si en un futuro se pide
        }
    }

    fun itemAgregado(mina: Mina) {
        if (mina.cantidadItemsCantera > 0) {
            almacen.add(mina.tipoItemMina)
        } else {
            println("La cantera de la mina esta vacia")
        }

    }

    fun devuelveTipoCivilizacion(): Civilizaciones {
        return tipoCivilizacion
    }

    override fun toString(): String {
        return "Civilizacion(tipoCivilizacion=$tipoCivilizacion, almacen=$almacen, gobernador=$gobernador)"
    }


}