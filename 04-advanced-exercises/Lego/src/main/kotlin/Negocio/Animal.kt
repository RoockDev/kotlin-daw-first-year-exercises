package Negocio

class Animal:SerVivo {

    var fuerza = 0
    private var duena:MujerGuerrera? = null

    constructor(nombre:String,esperanzaVida:Int,edad:Int,fuerza:Int)
    :super(nombre,esperanzaVida,edad){
        this.fuerza = fuerza
    }

    constructor(nombre:String,fuerza:Int)
    :super(nombre){
        this.fuerza = fuerza
    }

    //Metodo para ver si es libre
    fun esLibre():Boolean{
        return duena == null
    }

    //metodo para asignar dueña

    fun asignarDuena(nuevaDuena:MujerGuerrera){
        duena = nuevaDuena
    }

    // Metodo para liberar el animal
    fun liberar(){
        duena = null
    }



}