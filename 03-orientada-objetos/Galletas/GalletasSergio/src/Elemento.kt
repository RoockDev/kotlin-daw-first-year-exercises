 open class Ingrediente {
    var nombre = " "
    var grasas = 0
    var carbohidratos = 0
    var porcentaje = 0

     companion object{
         var ingredientes = listOf(
             Ingrediente("Harina", 3,50,0),
             Ingrediente("Mantequilla", 12,25,0),
             Ingrediente("canela", 1,1,0),
             Ingrediente("Leche",6,35,0),
             Ingrediente("Chocolate",34,35,0)
         )
     }



    constructor()
    constructor(nombre:String,grasas:Int,carbohidratos:Int,porcentaje:Int){
        this.nombre = nombre
        this.grasas = grasas
        this.carbohidratos = carbohidratos
        this.porcentaje = porcentaje
    }

     override fun toString(): String {
         return "Elemento(nombre='$nombre', grasas=$grasas, carbohidratos=$carbohidratos, porcentaje=$porcentaje)"
     }


 }