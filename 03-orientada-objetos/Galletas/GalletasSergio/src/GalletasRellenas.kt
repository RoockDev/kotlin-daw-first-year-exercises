open class GalletasRellenas:Galleta {
    var Saborrelleno = " "
        set(value) {
            field = if (value.isNotBlank()) value else "Sin relleno" // si se introduce un relleno no valido asigna sin relleno por defecto
        }
    // Atributos sin implementar, pensando en la forma de implementarlos
    var relleno = (1..5).random()
    var cantidadRelleno = (1..50).random()
    companion object{
        var cantidadGalletasRellenas = 0
    }
    constructor(){
        cantidadGalletasRellenas++
        cantidadFabricadas++
    }

    // Segun el valor del atributo relleno, devuelve el relleno de la galleta
    fun tipoRelleno(){
        when(this.relleno){
            1 -> this.Saborrelleno = "Kinder"
            2 -> this.Saborrelleno = "Lotus"
            3 -> this.Saborrelleno = "Chocolate"
            4 -> this.Saborrelleno = "Chocolate Blanco"
            5 -> this.Saborrelleno = "Nata"
        }
    }
}