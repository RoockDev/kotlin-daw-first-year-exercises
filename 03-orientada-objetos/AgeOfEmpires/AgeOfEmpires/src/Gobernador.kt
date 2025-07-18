class Gobernador {
    var nombre = GOBERNADORES.DESCONOCIDO // por defecto
    var civilizacion: Civilizacion? = null // la civilizacion puede ser null y asignada mas tarde

    constructor()
    constructor(nombre: GOBERNADORES) {
        this.nombre = nombre
    }

    constructor(nombre: GOBERNADORES, civilizacion: Civilizacion) {
        this.nombre = nombre
        if (civilizacion.gobernador == null) {
            civilizacion.gobernador = this
            this.civilizacion = civilizacion
        } else {
            println("La civilizacion ya tiene un gobernador")
        }
    }


    override fun toString(): String {
        return "Gobernador(nombre=$nombre, civilizacion=$civilizacion)"
    }


}