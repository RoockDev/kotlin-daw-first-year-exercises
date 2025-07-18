open class Lugar_Turistico {
    var nombre = ""
    var precio = 0
    var valoracion = 0

    constructor() {
        precio = (Constantes.PRECIO_MINIMO..Constantes.PRECIO_MAXIMO).random()
        valoracion = (Constantes.VALORACION_MINIMO..Constantes.VALORACION_MAXIMO).random()
    }

    constructor(nombre: String) {
        this.nombre = nombre
        precio = (Constantes.PRECIO_MINIMO..Constantes.PRECIO_MAXIMO).random()
        valoracion = (Constantes.VALORACION_MINIMO..Constantes.VALORACION_MAXIMO).random()
    }

    open fun calculaMediaCalidad(): Double {
        return if (valoracion != 0) (precio / valoracion.toDouble()) else 0.0 // devuelve 0 si se intenta dividir entre 0
    }


}