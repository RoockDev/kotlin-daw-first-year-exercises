package Negocio

class MujerSanadora:Mujer {

    constructor(nombre:String,esperanzaVida:Int,edad:Int,indiceInteligencia:Int)
    :super(nombre,esperanzaVida,edad,indiceInteligencia)

    constructor(nombre:String,indiceInteligencia:Int)
    : super(nombre,indiceInteligencia)

    //metodo para tratar a un ser vivo y aumentar su esperanza de vida
    fun tratarSerVivo(serVivo:SerVivo):String{
        //aumentamos la esperanza de vida un año
        serVivo.aumentarEsperanzaVida(1)

        return "He tratado a ${serVivo.nombre} y su esperanza de vida ha aumentado 1 año"
    }


    //sobreescribimos el metodo PuedeRealizarTarea
    override fun puedeRealizarTarea(
        inteligenciaRequerida: Int?,
        edadMinima: Int?,
        edadMaxima: Int?,
        b: Boolean,
        fuerzaRequerida: Int?
    ):Boolean{
        //verificamos los requisitos basicos de mujer
        val  requisitosBasicos = super.puedeRealizarTarea(
            inteligenciaRequerida,
            edadMinima,
            edadMaxima,
            true,
            reto.fuerzaRequerida
        )

        //las sanadoras cno pueden resolver tareas de fuerza

        return requisitosBasicos
    }

    //Metodo para verificar que no puede resovler una tarea de fuerza
    fun puedeRealizarTareaDeFuerza():Boolean{
        return false

    }

    //sobreescribimos el metodo comunicarCapacidadTarea

    override fun comunicarCapacidadTarea(inteligenciaRequerida:Int,edadMinima:Int,edadMaxima:Int):String{
        //para tareas normales
        val mensajeBase = super.comunicarCapacidadTarea(inteligenciaRequerida,edadMinima,edadMaxima)

        return mensajeBase
    }

    //metodo para comunicar que no puede hacer tareas de fuerza
    fun comunicarCapacidadTareaDeFuerza():String{
        return "No puedo resolver tareas de fuerza, soy sanadora"

    }




}