class CoronaCristal : Entidad {
    var id = 1
    var cristalesDelUniverso = ArrayList<Cristal>()
    var registroCristales = ArrayList<Cristal>()
    var totalCristalesPurpuras = CONSTANTES.CANTIDAD_MAXIMA_CRISTALES_PURPURA
    var totalCristalesBasicos = CONSTANTES.CANTIDAD_MAXIMA_CRISTALES_BASICOS
    var cristalesRestantes = CONSTANTES.CANTIDAD_CRISTALES_EXISTENTES



    constructor()

    fun asignacionDeCristalesBasicos(){
        for ( i in 1..CONSTANTES.CANTIDAD_MAXIMA_CRISTALES_BASICOS){
            cristalesDelUniverso.add(Factoria.crearCristalBasico())

        }

    }
    fun asignacionCristalesPurpura(){
        for (i in 1..CONSTANTES.CANTIDAD_MAXIMA_CRISTALES_PURPURA){
            cristalesDelUniverso.add(Factoria.crearCristalPurpura())
        }
    }

    fun removerCristales(){
        cristalesDelUniverso.shuffle()
    }

    fun guardarRegistro(){
        registroCristales.addAll(cristalesDelUniverso)
    }

    fun devuelveCristalBasico(): Cristal {

        var cristal = cristalesDelUniverso[0] //asignamos el primero por defecto para no utilizar nulos
        var i = 0
        var salir = false

        while (i < cristalesDelUniverso.size && !salir) {
            if (cristalesDelUniverso[i].color != ColoresCristales.PURPURA) {
                cristal = cristalesDelUniverso[i]
                salir = true


            }
            i++

        }



        cristalesDelUniverso.remove(cristal)
        totalCristalesBasicos--
        cristalesRestantes--
        return cristal
    }

    fun devuelveCristalPurpura():Cristal{
        var cristal = cristalesDelUniverso[0] //asignamos el primero por defecto para no utilizar nulos
        var i = 0
        var salir = false
        while (i < cristalesDelUniverso.size){
            if (cristalesDelUniverso[i].color == ColoresCristales.PURPURA){
                cristal = cristalesDelUniverso[i]
                salir = true
            }
            i++
        }
        cristalesDelUniverso.remove(cristal)
        totalCristalesPurpuras--
        cristalesRestantes--
        return cristal
    }

    fun purpuraExistentes():Boolean{
        var quedanPurpuras = true
        if (totalCristalesPurpuras < 1){
            quedanPurpuras = false
        }
        return quedanPurpuras

    }

    fun cristalesBasicosExistentes():Boolean{
        var quedanBasicos = true
        if (totalCristalesBasicos < 1){
            quedanBasicos = false
        }
        return quedanBasicos
    }

    fun existenciaCristales():Boolean{
        var quedanCristales = true
        if (cristalesRestantes < 1){
            quedanCristales = false
        }
        return quedanCristales
    }

    fun localizaCristales(){ //Metodo para localizar los cristales
        for (i in registroCristales){
            if (i.guardianPoseedor != null){
                println("Cristal ${i.idCristal} pertenece al guardian Estelar")
            }else if (i.adversarioPoseedor != null){
                println("El cristal ${i.idCristal} pertenece al adversario ${i.nombrePoseedor()}")
            }else println("El cristal ${i.idCristal} no pertenece a nadie")

        }
    }




}