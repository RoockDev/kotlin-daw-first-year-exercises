package Negocio

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.CheckBox
import javafx.scene.control.ComboBox
import javafx.scene.control.DatePicker
import javafx.stage.Stage
import java.io.IOException
import java.net.URL
import java.util.ResourceBundle

class AltaController: Initializable {
    @FXML
    private lateinit var btnSalir: Button
    @FXML
    lateinit var cbPagado: CheckBox

    @FXML
    lateinit var dpFecha: DatePicker

    @FXML
    lateinit var comboUsuario: ComboBox<Usuario>
    @FXML
    lateinit var comboDestino: ComboBox<Destinos>
    @FXML
    private lateinit var obsListaUsuario: ObservableList<Usuario>
    @FXML
    private lateinit var obsListaDestino: ObservableList<Destinos>


    var destino = Destinos()
    var usu = ServicioUsuario()
    var des = ServicioDestino()

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        obsListaUsuario = FXCollections.observableArrayList<Usuario>(usu.devolverUsuarios())
        comboUsuario.items = obsListaUsuario

        obsListaDestino = FXCollections.observableArrayList<Destinos>(des.devolverDestinos())
        comboDestino.items = obsListaDestino

    }

    @FXML
    private fun Aceptar() {
        destino.id= comboUsuario.value.id
        destino.nombre = comboUsuario.value.nombre
        Cerrar()
    }
    @FXML
    private fun Cerrar() {
        try {
            //persona.nombre = "Cambio"
            val stage = btnSalir.scene.window as Stage
            stage.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
    fun transpaso(s:Destinos){
        this.destino = s
    }
}