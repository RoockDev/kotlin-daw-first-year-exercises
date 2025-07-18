class Galletitas:GalletasRellenas {
    var saborPrincipal = sabor // sabor heredado de galleta
    var saborEspecial = SaboresEspeciales.values().random()
    // Escoge aleatoriamente un sabor especial de la clase enum


    companion object{
        var cantidadGalletitasFabricadas = 0
    }
    constructor(){
            cantidadGalletitasFabricadas++
            cantidadFabricadas++
    }

    // Metodo para comprobar si la galleta es para consumo humano o no
    fun consumoHumano():Boolean{
        var random = (0..1).random()
        var consumoHumano = false
        when(random){
            1 -> consumoHumano = true
            else -> consumoHumano = false
        }
        return consumoHumano
    }


}