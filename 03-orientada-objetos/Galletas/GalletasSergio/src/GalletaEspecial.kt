class GalletaEspecial:Galleta {

    var formaGalleta = " "
        set(value) {
            field = if (value.isNotBlank()) value else "arbol" // forma arbol por defecto si no se introduce una forma correcta
        }
    //Estos atributos estan sin usar todavia, pensando como implementarlos
    var dificultad = (1..10).random()
    var tiempoModelado = (1..60).random()
    companion object{
        var cantidadGalletasEspeciales = 0
    }
    constructor(){
        cantidadFabricadas++
        cantidadGalletasEspeciales++

    }
    constructor(forma:Int){
        this.formaGalleta = formaGalleta
        cantidadFabricadas++
        this.dificultad = dificultad
        this.tiempoModelado = tiempoModelado
        cantidadGalletasEspeciales++
    }

    // Metodo para darle forma a la galleta
    fun moldeadoGalleta(){
        when{
            (this.dificultad in 1..2 && this.tiempoModelado in 1..20) -> this.formaGalleta = "Arbol"
            (this.dificultad in 3..4 && this.tiempoModelado in 21..40) -> this.formaGalleta = "Perro"
            (this.dificultad in 5..6 && this.tiempoModelado in 41..60) -> this.formaGalleta = "Gato"
            (this.dificultad in 7..8 && this.tiempoModelado in 61..80) -> this.formaGalleta = "Dinosaurio"
            (this.dificultad in 9..10 && this.tiempoModelado in 81..100) -> this.formaGalleta = "Edificio"
            else -> this.formaGalleta = "Circulo"

        }
    }


}