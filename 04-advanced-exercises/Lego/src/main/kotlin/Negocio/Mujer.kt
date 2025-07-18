package Negocio

open class Mujer:SerVivo {
    var indiceInteligencia = 0




    constructor(nombre:String,esperanzaVida:Int,edad:Int,indiceInteligencia:Int):super(nombre,esperanzaVida,edad){
        this.indiceInteligencia = indiceInteligencia
    }

    constructor(nombre:String,indiceInteligencia:Int):super(nombre){
        this.indiceInteligencia = indiceInteligencia
    }

    //verificamos si puede realizar una tarea
    open fun puedeRealizarTarea(
        inteligenciaRequerida: Int?,
        edadMinima: Int?,
        edadMaxima: Int?,
        b: Boolean,
        fuerzaRequerida: Int?
    ) :Boolean{
        var puede = false
        if(edad in edadMinima..edadMaxima && indiceInteligencia >= edadMaxima) puede = true
        return puede

    }

    //mostramos si puede realizar una tarea
    open fun comunicarCapacidadTarea(inteligenciaRequerida:Int,edadMinima:Int,edadMaxima:Int) : String {
        val puede = puedeRealizarTarea(inteligenciaRequerida, edadMinima, edadMaxima, true, reto.fuerzaRequerida)

        return if(puede){
            "Puedo realizar la tarea, cumplo con los requisitos"
        }else{
            val mensajeEdad = if (edad < edadMinima){
                "soy Joven no puedo realizar la tarea"
            }else if (edad > edadMaxima){
                "Soy mayor para realizar la tarea"
            }else{
                "Mi edad es la adecuada"
            }

            "No puedo realizar la tarea $mensajeEdad"
        }
    }

    override fun toString(): String {
        return "Mujer(indiceInteligencia=$indiceInteligencia)"
    }


}