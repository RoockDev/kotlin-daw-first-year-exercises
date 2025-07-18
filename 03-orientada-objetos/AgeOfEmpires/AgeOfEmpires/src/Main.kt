fun main() {

    println("Bienvenidos a la Simulacion de una mina de recursos en Age of Empires")
    var mina = Factoria.crearMina()
    var aldeanoEspagnol = Factoria.crearAldeanoEspagnol()
    var aldeanoBizantino = Factoria.crearAldeanoBizantino()
    mina.agregarTrabajadorAlaMina(aldeanoEspagnol)
    mina.agregarTrabajadorAlaMina(aldeanoBizantino)
    var segundo = 1
    while (segundo != 61) {
        println("Segundo ${segundo}")
        for (i in mina.trabajadores) {
            i.extraerItemMina(mina)
        }
        if (segundo % 2 == 0) {
            mina.agregarTrabajadorProbabilidad(Factoria.crearAldeanoBizantino(), Factoria.crearAldeanoEspagnol())
        }
        if (segundo % 5 == 0) {
            mina.ataqueCuraBizantino()
        }
        mina.mostrarInformacionTrabajadores()
        segundo++
    }


}