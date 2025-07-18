package org.example.crudjavafxbbdd

import DAO.UsuarioDAOImpl
import Modelo.Usuario
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.stage.Stage
import java.net.URL
import java.util.ResourceBundle

class ListaUsuariosController: Initializable {

    @FXML private lateinit var btnvolver: Button
    @FXML private lateinit var lblmensaje: Label
    @FXML private lateinit var tvlista: TableView<Usuario>

    val usuarioDAO = UsuarioDAOImpl()

    @FXML
    fun onVolverButtonClick(event: ActionEvent) {
        volverAlPanelAdmin()
    }

    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        cargarDatos()
    }

    @FXML
    private fun cargarDatos(){
        try {
            //obtenemos la lista de usuarios
            val listaUsuarios = usuarioDAO.getAllUsuarios()

            // convertimos la lista observvable para tableview
            val listaObservable = FXCollections.observableArrayList<Usuario>(listaUsuarios)

            tvlista.items = listaObservable

            if (listaUsuarios.isEmpty()){
                lblmensaje.text = "La lista esta vacia"
            }else{
                lblmensaje.text = "Usuarios encontrados"
            }
        }catch (e: Exception){
            lblmensaje.text = "Error al cargar usuarios: ${e.message}"
            e.printStackTrace()
        }

    }

    @FXML
    private fun volverAlPanelAdmin(){
        try {
            val loader = FXMLLoader(AgnadirUsuarioController::class.java.getResource("PanelAdministrador.fxml"))
            val root = loader.load<Parent>()

            val stage = btnvolver.scene.window as Stage
            stage.scene = Scene(root)
            stage.title = "Panel de Administrador"
        } catch (e: Exception) {
            e.printStackTrace()
            lblmensaje.text = "Error al volver al panel de administrador"
        }
    }

}