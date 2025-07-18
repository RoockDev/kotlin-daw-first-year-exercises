class Dado {
    var numCaras = 6

    constructor()
    constructor(caras:Int){
        // si se introduce un numero que no este en ese rango devuelve 6 por defecto
        if (caras in 6..12) this.numCaras = caras else this.numCaras = 6
    }
    // Metodo que simula el lanzamiento de un dado
    fun lanzarDado():Int{
        var lanzamiento = (1..this.numCaras).random()
        return lanzamiento
    }

      fun mejorDado(dado: Dado):Boolean{
        var gana = false
         if (this.lanzarDado() > dado.lanzarDado()) gana = true
         return gana
    }
}
