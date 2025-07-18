package Negocio

class Reto {
    var inteligenciaRequerida:Int? = null
    var edadMinima:Int? = null
    var edadMaxima:Int? = null
    var esFuerza:Boolean? = null
    var fuerzaRequerida:Int? = null
    var descripcion:String? = null

    constructor(
        inteligenciaRequerida:Int,
        edadMinima:Int,
        edadMaxima:Int,
        esFuerza:Boolean,
        fuerzaRequerida:Int,
        descripcion:String
    ){
        this.inteligenciaRequerida = inteligenciaRequerida
        this.edadMinima = edadMinima
        this.edadMaxima = edadMaxima
        this.esFuerza = esFuerza
        this.fuerzaRequerida = fuerzaRequerida
        this.descripcion = descripcion
    }

    constructor(
        inteligenciaRequerida:Int,
        edadMinima:Int,
        edadMaxima:Int,
        fuerzaRequerida:Int,
        descripcion:String
    ){
        this.inteligenciaRequerida = inteligenciaRequerida
        this.edadMinima = edadMinima
        this.edadMaxima = edadMaxima
        this.fuerzaRequerida = fuerzaRequerida
        this.descripcion = descripcion
    }

    override fun toString(): String {
        var tipoReto = if(esFuerza == true) "De fuerza" else "de habilidad"
        return "Reto $tipoReto: $descripcion (Requisitos - Inteligencia: $inteligenciaRequerida, " +
                "Edad: $edadMinima-$edadMaxima" +
                (if (esFuerza == true) ", Fuerza: $fuerzaRequerida" else "") +
                ")"
    }
}