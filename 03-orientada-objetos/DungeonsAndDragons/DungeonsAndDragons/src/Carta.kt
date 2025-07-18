class Carta {
    var id = 1
    var poder = (10..20).random()
    var indiceVida = (5..100).random()
    var tipoCarta = TipoCarta.values().random()
    var dadoCarta = Dado()


    companion object{
        var contador = 1
    }
    constructor(){
        this.id = contador
        contador++
    }

    constructor(poder:Int,indiceVida:Int,tipoCarta: TipoCarta){
        if (poder in 10..20) this.poder = poder else this.poder = (10..20).random() // si introduce mal el rango devuelve random
        if (indiceVida in 5..100) this.indiceVida = indiceVida else this.indiceVida = (5..100).random() // si introduce mal devuelve random
        this.tipoCarta = tipoCarta
    }

    fun MejorCarta(carta:Carta):Boolean{
        var gana = false
        if (this.poder > carta.poder) gana = true
        return gana
    }

    // Metodo para comprobar si la carta ha perdido
    fun cartaMuerta():Boolean{
        var cartaMuerta = false
        if (this.indiceVida<0){
            this.indiceVida = 0
            cartaMuerta = true
        }else cartaMuerta =false
        return cartaMuerta
    }

    override fun toString(): String {
        return "Carta(" +
                "id=$id, " +
                "poder=$poder, " +
                "indiceVida=$indiceVida, " +
                "tipoCarta=$tipoCarta" +
                ")"
    }


}