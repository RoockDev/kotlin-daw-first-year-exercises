package Negocio

open class MujerGuerrera:Mujer {

    var fuerza = 0
    var utensilios = ArrayList<Utensilio>()
    var animales = ArrayList<Animal>()

    constructor(nombre:String,esperanzaVida:Int,edad:Int,indiceInteligencia:Int,fuerza:Int)
    : super(nombre,esperanzaVida,edad,indiceInteligencia){
        this.fuerza = fuerza
    }

    constructor(nombre:String,indiceInteligencia:Int,fuerza:Int): super(nombre,indiceInteligencia){
        this.fuerza = fuerza
    }

    //agregamos utensilio
    fun  agregarUtensilio(utensilio: Utensilio){
        utensilios.add(utensilio)
    }

    //añadimos animal
    fun agregarAnimal(animal:Animal){
        animales.add(animal)
        animal.asignarDuena(this)
    }

    //verificamos si tiene animales
    fun tieneAnimales():Boolean{
        return animales.isNotEmpty()
    }

    //obtenemos fuerza total (incluyendo animales)
    fun obtenerFuerzaTotal():Int{
        var fuerzaTotal = fuerza
        for(animal in animales){
            fuerzaTotal += animal.fuerza
        }
        return fuerzaTotal
    }

    //Resolver tarea especifica para guerreras
    fun puedeResolverTarea(inteligenciaRequerida:Int,edadMinima:Int,edadMaxima:Int,esFuerza:Boolean,fuerzaRequerida:Int):Boolean{
        var puede = false
        //primero vemos si cumple los requisitos basicos como mujer
        val requisitosBasicos = puedeRealizarTarea(
            inteligenciaRequerida,
            edadMinima,
            edadMaxima,
            true,
            fuerzaRequerida
        )
        var fuerzaTotal = obtenerFuerzaTotal()
        if((requisitosBasicos && esFuerza) &&(fuerzaTotal >= fuerzaRequerida)) puede = true

        return puede
    }

    fun comunicarCapacidadResolverTarea(inteligenciaRequerida: Int, edadMinima: Int, edadMaxima: Int, esFuerza: Boolean, fuerzaRequerida: Int): String{
        var mensaje = ""
        //verficamos requisitos basicos mujer
        val mensajeBase = comunicarCapacidadTarea(inteligenciaRequerida,edadMinima,edadMaxima)

        //si no cumple con los requisitos basicos..
        if(!puedeRealizarTarea(inteligenciaRequerida, edadMinima, edadMaxima, true, fuerzaRequerida)){
            mensaje = mensajeBase
        }else if(!esFuerza){
            mensaje = "No puedo realizar esta tarea por que soy una guerrera"
        }else {
            //verificamos si tiene suficiente fuerza
            var fuerzaTotal = obtenerFuerzaTotal()
            if(fuerzaTotal >= fuerzaRequerida){
                mensaje = "Puedo resolver Esta tarea, mi fuerza me lo permite"
            }else mensaje = "No tengo fuerza para reaizar esta tarea, tengo que entrenar mas"
        }

        return mensaje
    }


}