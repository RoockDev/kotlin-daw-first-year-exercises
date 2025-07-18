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
import javafx.scene.control.ComboBox
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.AnchorPane
import javafx.stage.Stage
import java.net.URL
import java.util.ResourceBundle

class PanelAdminsitradorController: Initializable {


    @FXML private lateinit var txtapellidos: TextField
    @FXML private lateinit var txtedad: TextField
    @FXML private lateinit var txtemail: TextField
    @FXML private lateinit var txtnombre: TextField
    @FXML private lateinit var txtpassword: TextField
    @FXML private lateinit var BtnVolverALogin: Button
    @FXML private lateinit var CmbOpcion: ComboBox<String>
    @FXML private lateinit var lblmensaje: Label

    @FXML
    override fun initialize(p0: URL?, p1: ResourceBundle?) {

        // creamos una lista observable con las opciones del menu
        val opciones: ObservableList<String> = FXCollections.observableArrayList<String>(
            "Añadir Usuario",
            "Mostrar Usuarios",
            "Buscar usuario por email",
            "Borrar usuario",
            "Modificar usuario",
            "Cambiar permisos de usuario"
        )

        // asignamos la lista al ComboBox
        CmbOpcion.items = opciones

        // Establecemos una opcion por defecto
        CmbOpcion.selectionModel.selectFirst()


    }

    @FXML
    fun onComboClick(event: ActionEvent) {

        val opcionSeleccionada = CmbOpcion.selectionModel.selectedItem
        when(opcionSeleccionada){
            "Añadir Usuario" -> agnadirUsuario()
            "Mostrar Usuarios" -> mostrarUsuarios()
            "Buscar usuario por email" -> buscarUsuarioPorEmail()
            "Borrar usuario" -> borrarUsuario()
            "Modificar usuario" -> modificarUsuario()
            "Cambiar permisos de usuario" -> cambiarPermisosUsuario()
        }

    }


    @FXML
    private fun agnadirUsuario(){
        try {
            val loader = FXMLLoader(PanelAdminsitradorController::class.java.getResource("vistaAgnadirUsuario"))
            val root = loader.load<Parent>()

            val stage = CmbOpcion.scene.window as Stage
            stage.scene = Scene(root)
            stage.title = "Añadir Usuario"
        }catch (e: Exception){
            e.printStackTrace()
            lblmensaje.text = "Error al acceder al menu de añadir usuario"
        }

    }
    @FXML
    private fun cambiarPermisosUsuario(){
        try {
            val loader = FXMLLoader(PanelAdminsitradorController::class.java.getResource("vistaCambiarRol"))
            val root = loader.load<Parent>()

            val stage = CmbOpcion.scene.window as Stage
            stage.scene = Scene(root)
            stage.title = "Cambiar Rol"
        }catch (e: Exception){
            e.printStackTrace()
            lblmensaje.text = "Error al acceder al menu de Cambiar Rol"
        }

    }

    @FXML
    private fun modificarUsuario(){
        try {
            val loader = FXMLLoader(PanelAdminsitradorController::class.java.getResource("vistaModificarUser"))
            val root = loader.load<Parent>()

            val stage = CmbOpcion.scene.window as Stage
            stage.scene = Scene(root)
            stage.title = "Modificar Usuario"
        }catch (e: Exception){
            e.printStackTrace()
            lblmensaje.text = "Error al acceder al menu de Modificar Usuario"
        }

    }
    @FXML
    private fun borrarUsuario(){
        try {
            val loader = FXMLLoader(PanelAdminsitradorController::class.java.getResource("vistaEliminarUser"))
            val root = loader.load<Parent>()

            val stage = CmbOpcion.scene.window as Stage
            stage.scene = Scene(root)
            stage.title = "Eliminar Usuario"
        }catch (e: Exception){
            e.printStackTrace()
            lblmensaje.text = "Error al acceder al menu de añadir usuario"
        }

    }








    @FXML
    fun onVolverALoginbuttonClick(event: ActionEvent) {
        try {
            val cargarVentana = FXMLLoader(JuegoController::class.java.getResource("main-view.fxml"))
            val root = cargarVentana.load<Parent>()

            val stage = BtnVolverALogin.scene.window as Stage
            stage.scene = Scene(root)
            stage.title = "Login"
        }catch (e: Exception){
            e.printStackTrace()
            lblmensaje.text = "Error al volver a la pantalla Login: ${e.message}"
        }

    }

    @FXML
    private fun mostrarUsuarios(){
        try {
            val loader = FXMLLoader(PanelAdminsitradorController::class.java.getResource("vistaListaUsuarios"))
            val root = loader.load<Parent>()

            val stage = CmbOpcion.scene.window as Stage
            stage.scene = Scene(root)
            stage.title = "Lista de usuarios"
        }catch (e: Exception){
            e.printStackTrace()
            lblmensaje.text = "Error al ir a la lista de usuarios"
        }
    }

    @FXML
    private fun buscarUsuarioPorEmail(){
        try {
            val loader = FXMLLoader(PanelAdminsitradorController::class.java.getResource("vistaBuscarUsuarioEmail.fxml"))
            val root = loader.load<Parent>()

            val stage = CmbOpcion.scene.window as Stage
            stage.scene = Scene(root)
            stage.title = "Panel de Administrador"
        }catch (e: Exception){
            e.printStackTrace()
            lblmensaje.text = "Error al volver al panel de administrador"
        }
    }
}