class Parque : Lugar_Turistico {
    var numeroAtracciones = (Constantes.MINIMO..Constantes.MAXIMOATRACCIONES).random()
    var numeroJuegos = (Constantes.MINIMO..Constantes.MAXIMOGENERICO).random()
    private var idParque = 1

    companion object {
        private var contador = 1
    }

    constructor() {
        idParque = contador
        contador++
        nombre = NombreObjetos.PARQUE.name + idParque


    }

    constructor(nombre: String, precio: Int, valoracion: Int, nAtracciones: Int, nJuegos: Int) {
        idParque = contador
        contador++
        this.nombre = NombreObjetos.PARQUE.name + nombre + idParque
        this.precio = 0
        this.valoracion = valoracion
        this.numeroJuegos = nJuegos
        this.numeroAtracciones = numeroAtracciones

    }

    constructor(atracciones: Int, juegos: Int) {
        idParque = contador
        contador++
        this.nombre = NombreObjetos.PARQUE.name + idParque
        this.numeroAtracciones = atracciones
        this.numeroJuegos = juegos

    }

    open override fun calculaMediaCalidad(): Double {
        return if (numeroAtracciones != 0) (precio / numeroAtracciones.toDouble()) else 0.0
    }

    override fun toString(): String {
        return "Parque(nombre= ${nombre},precio = ${precio}, valoracion= ${valoracion}, numeroAtracciones=${numeroAtracciones}, numeroJuegos=${numeroJuegos},mediaCalidad=${calculaMediaCalidad()})"
    }

}