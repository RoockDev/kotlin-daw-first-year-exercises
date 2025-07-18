import kotlin.random.Random

class GuardianEstelar : Entidad {
    var registroEnergiasGeneradas = ArrayList<Int>()
    var resistencia = CONSTANTES.RESISTENCIA_GUARDIAN
    var cristalesPurpura = ArrayList<Cristal>()
    var cantidadCristalesPurpura = 0
    var listaDeAdversariosGuardian = ArrayList<Adversario>()

    constructor()

    fun generaEnergiaAleatoria(): Int { //Energia aleatoria que genera cuando se enfrenta a un maestro de cristales
        var energiaGenerada = (1..CONSTANTES.ENERGIA_MAXIMA).random()
        registroEnergiasGeneradas.add(energiaGenerada) //No me gusta el metodo, hace dos cosas no cumple con srp
        cantidadCristalesPurpura++
        return energiaGenerada

    }

    fun mostrarEnergiasGeneradas() {
        for (i in registroEnergiasGeneradas) {
            println("${i}")
        }

    }



    fun mostrarCristalesPurpuraGuardian(){
        println("Cantidad de Cristales Purpura del guardian : ${cantidadCristalesPurpura}")
    }
    fun batallaVsMaestroCristales(adversario: Adversario):Boolean{
        var batallaGanada = Random.nextBoolean()
        if (batallaGanada){
            cristalesPurpura.add(adversario.pierdeCristalPurpura()) // si gana le quita el cristal al adversario
            cantidadCristalesPurpura++
            for (i in cristalesPurpura) i.guardianPoseedor = this //cristal asignado al guradian
        }else{
            resistencia -= adversario.devuelveEnergiaCristalPurpura()
            if (resistencia < 0) resistencia = 0
        }

        return batallaGanada
    }

    fun mostrarResistencia() {
        println("Resistencia restante del guardian: ${resistencia} \n")

    }


    fun cantidadCristalesPurpura(): Boolean {
        var tieneTodosPurpuras = false
        if (cantidadCristalesPurpura == CONSTANTES.CANTIDAD_MAXIMA_CRISTALES_PURPURA) {
            tieneTodosPurpuras = true

        }
        return tieneTodosPurpuras
    }


    fun GanaPartida() {
        if (cantidadCristalesPurpura()) {
            println("Cristales Purpura: ${cantidadCristalesPurpura}")
            println("Resistencia restante del guardian; ${resistencia}")
            println("El Guardian ha reunido todos los cristales purpura y gana la partida")
        } else if (resistencia < 1) {
            println("El Guardian ha sido abatido por los adversarios, Pierde la partida")
        }
    }

    fun vivo():Boolean{
        var vida = true
        if (resistencia < 0){
            vida = false
        }
        return vida
    }


    override fun representarse(): String {
        return super.representarse()
    }
}