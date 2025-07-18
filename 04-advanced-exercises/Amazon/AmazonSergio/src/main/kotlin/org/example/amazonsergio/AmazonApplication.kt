package org.example.amazonsergio

import Negocio.CONSTANTES
import Negocio.Factoria
import Negocio.MaquinaGenerica
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage
import java.awt.List

class HelloApplication : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("hello-view.fxml"))
        val scene = Scene(fxmlLoader.load(), 320.0, 240.0)
        stage.title = "Hello!"
        stage.scene = scene
        stage.show()

    }
}

fun main() {
    Application.launch(HelloApplication::class.java)

    var dia = CONSTANTES.MINIMO
    var MCG1 = Factoria.generarMaquinaCajasGrandes()
    var MCG2 = Factoria.generarMaquinaCajasGrandes()
    var MG = Factoria.generarMaquinaCajasGrandes()
    var MCOP = Factoria.generarMaquinaObjetosPeligrosos()
    var maquinas = ArrayList<MaquinaGenerica>()
    maquinas.add(MCG1)
    maquinas.add(MCG2)
    maquinas.add(MG)
    maquinas.add(MCOP)


    while(dia < CONSTANTES.TOTAL_DIAS_MES_TRABAJO){
        //vamos agregando las cajas aleatoriamente
        for (i in CONSTANTES.MINIMO_ALEATORIO..CONSTANTES.MAXIMO_ALEATORIO){
            for (i in maquinas){
                i.agregarCaja(Factoria.generarCaja())
                //agregamos los objetos a las cajas
                i.agregarObjetos(Factoria.generarObjetos())
            }
        }

    }

}