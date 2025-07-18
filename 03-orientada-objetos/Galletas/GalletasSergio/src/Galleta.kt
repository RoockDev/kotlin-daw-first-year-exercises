
open class Galleta {
    var sabor = " "
        set(value) {
            field = if (value.isNotBlank()) value else "Vainilla"  // sabor por defecto en caso de que no se introduzca
        }
    // falta por terminar lista de ingredientes
    var listaIngredientes = ArrayList<Ingrediente>()
    // Coste y dulzura no se estan utilizando aun.
    var costeSabor = 0.0
    var dulzura = 0
    var peso = 0
        set(value){
            field = if (value > 0) value else 20 // 20 gramos por defecto en caso de que no se meta un tamanio considerable
        }
    companion object{
        var cantidadFabricadas = 0

    }

    constructor(){
        cantidadFabricadas++
    }
    constructor(sabor:String,peso:Int){
        this.sabor = sabor
        this.peso  = peso
        this.costeSabor = costeSabor
        this.dulzura = dulzura
        cantidadFabricadas++
    }

    // no se muy bien como hacerlo, lo dejamos para mas tarde
    fun IngredientesGalleta(Ingrediente: Ingrediente){
        var ingrediente = Ingrediente()
        var porcentaje = 0
    }


    override fun toString(): String {
        return "Galleta(sabor='$sabor', peso=$peso)"
    }


}