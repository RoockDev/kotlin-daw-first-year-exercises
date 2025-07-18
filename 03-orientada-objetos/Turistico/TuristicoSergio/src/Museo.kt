class Museo : Lugar_Turistico {
    var numeroSalas = (Constantes.MINIMO..Constantes.MAXIMOSALAS).random()
    var tematica = Tematica.DESCONOCIDA // por defecto
    private var idMuseo = 1

    companion object {

         private var contador = 1
    }

    constructor() {
        idMuseo = contador
        contador++

        nombre = NombreObjetos.MUSEO.name + idMuseo
        this.tematica = Tematica.values().random()

    }

    constructor(nombre: String, precio: Int, valoracion: Int) {
        this.nombre = NombreObjetos.MUSEO.name + nombre + idMuseo
        this.precio = precio
        this.valoracion = valoracion
        this.tematica = Tematica.values().random()
        contador++
    }

    constructor(nombre: String, precio: Int, valoracion: Int, tematica: Tematica) {
        this.nombre = NombreObjetos.MUSEO.name + nombre + idMuseo
        this.precio = precio
        this.valoracion = valoracion
        contador++

    }

    override fun calculaMediaCalidad(): Double {
        return if (numeroSalas != 0) (precio / numeroSalas.toDouble()) else 0.0
    }

    override fun toString(): String {
        return "Museo(nombre= ${nombre}, precio= ${precio}, valoracion= ${valoracion}, tematica=${tematica}, numeroSalas=${numeroSalas},mediaCalidad= ${calculaMediaCalidad()})"
    }


}