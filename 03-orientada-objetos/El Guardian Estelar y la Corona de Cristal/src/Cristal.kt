open class Cristal : Entidad {
    var color = ColoresCristales.values().random()
    var idCristal = 2
    var energia = 0
    var adversarioPoseedor:Adversario? = null // ppuede pertenecer o no a un adversario
    var guardianPoseedor:GuardianEstelar? = null // puede pertencer o no al guardian


    companion object {
        private var contador = 2
        var cristalesPurpura = CONSTANTES.CANTIDAD_MAXIMA_CRISTALES_PURPURA  //PROFESOR: Si esta sacando constants, este deberia ser de constantes
    }

    constructor() { //no me gusta pero manejamos bien la validacion, pensar una solucion que me guste mas
        idCristal = contador
        contador++
        if (cristalesPurpura == 0 && color == ColoresCristales.PURPURA) {
            color == ColoresCristales.AZUL //si ya se han creado los 6 cristales purpura por defecto se convierte en azul
        } else if (color == ColoresCristales.PURPURA) {
            energia = (CONSTANTES.ENERGIA_MINIMA..CONSTANTES.ENERGIA_MAXIMA).random() // si el cristal es purpura le ponemos esa energia
            cristalesPurpura--
        }


    }

    constructor(color: ColoresCristales) {
        idCristal = contador
        contador++
        this.color = color
        if (color == ColoresCristales.PURPURA) {
            energia = (CONSTANTES.ENERGIA_MINIMA..CONSTANTES.ENERGIA_MAXIMA).random()
            cristalesPurpura--
        }
    }
    fun nombrePoseedor() :String{

        return adversarioPoseedor?.nombre?: "Desconocido"
    }


    override fun representarse(): String {
        return super.representarse()
    }
}