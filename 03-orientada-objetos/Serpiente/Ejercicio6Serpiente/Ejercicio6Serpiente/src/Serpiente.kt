class Serpiente {
    var idSerpiente = 0
    var anilla = ArrayList<Char>()
    var color = ' '
    var edad = 0
        set(value) {
            field = if (value in 0..100) value else 0
            // si la edad no esta entre 0 y 100 se le asigna 0 a la edad
        }

    // Generamos varios contructores por lo que pueda pasar
    constructor()
    constructor(idSerpiente: Int){
        this.idSerpiente = idSerpiente
    }

    constructor(color:Char, edad:Int){
         var colorAnilla = color.lowercaseChar()
        if (colorAnilla == 'r' || colorAnilla == 'v' || colorAnilla == 'a') this.color = colorAnilla
        this.edad = edad
        this.idSerpiente = idSerpiente

    }
    // Metodo para asignar un color de anilla a la serpiente
    fun asignaColorAnilla():Char{
        var randomColor = (1..3).random()
        when(randomColor){
            1 -> this.color = 'r'
            2 -> this.color = 'v'
            3 -> this.color = 'a'

        }
        return this.color
    }
    // Metodo en el que la serpiente puede crecer o decrecer segun su edad
    fun EtapaVida(){
        val crecimiento = (0..100).random()
        val decrecimienmto = (0..100).random()
        if (this.edad < 10 && crecimiento in (0..79)){
            this.anilla.add(asignaColorAnilla())
        }else if (this.edad < 10 && crecimiento in (80..100)){
            this.anilla.shuffle()
            println("La serpiente $idSerpiente ha mudado la piel")// cambia el cuerpo de la serpiente respetando el numero de anillas
        }
        if (this.edad>=10 && decrecimienmto in (0..89)){
            if (this.anilla.isNotEmpty()){
                this.anilla.removeLast()
            }

        }else if (this.edad >=10 && decrecimienmto in (90..100)){
            this.anilla.shuffle()
            println("La serpiente $idSerpiente ha mudado la piel")
        }
    }
    // Metodo para calcular la probabilidad que tiene la serpiente de ser atacada por la mangosta
    fun vida():Boolean{
        var vida = false
          if (anilla.isEmpty()){
              println("La serpiente $idSerpiente se ha quedado sin anillas, muere")
              vida = true
          }
        return vida
    }

    override fun toString(): String {
        return "Serpiente $idSerpiente (edad=$edad, anilla=$anilla, color=$color)"
    }


}