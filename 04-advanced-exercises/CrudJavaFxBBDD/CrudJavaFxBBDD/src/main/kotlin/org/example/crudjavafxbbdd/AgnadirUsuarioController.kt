package org.example.crudjavafxbbdd

import DAO.UsuarioDAOImpl
import Modelo.Usuario
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.stage.Stage


class AgnadirUsuarioController {

    @FXML private lateinit var txtapellidos: TextField
    @FXML private lateinit var txtedad: TextField
    @FXML private lateinit var txtemail: TextField
    @FXML private lateinit var txtnombre: TextField
    @FXML private lateinit var txtpassword: TextField
    @FXML private lateinit var lblmensaje: Label
    @FXML private lateinit var btnsalir: Button


    private val usuarioDAO = UsuarioDAOImpl()

    @FXML
    fun initialize(){
        lblmensaje.text= ""

    }

    @FXML
    fun onGuardarButtonClick(event: ActionEvent) {
        val email = txtemail.text.trim()
        val nombre = txtnombre.text.trim()
        val apellidos = txtapellidos.text.trim()
        val edad = txtedad.text.trim()
        val password = txtpassword.text.trim()

        if (email.isEmpty() || nombre.isEmpty() || apellidos.isEmpty() ||
            edad.isEmpty() || password.isEmpty()){
            lblmensaje.text = "Todos los campos son obligatorios"
        }else{
            try {
                val usuarioExistente = usuarioDAO.getUsuarioByEmail(email)

                if (usuarioExistente != null){
                    lblmensaje.text = "El usuario ya existe"
                }else{
                    val nuevoUsuario = Usuario(email,nombre,apellidos,edad,password)
                    usuarioDAO.insertUsuario(nuevoUsuario)
                    limpiarCampos()
                    lblmensaje.text = "Usuario añadido correctamente"
                }
            }catch (e: Exception){
                lblmensaje.text = "Error al añadir usuario: ${e.message}"
                lblmensaje.style = "-fx-text-fill: red;"
                e.printStackTrace()
            }
        }

    }

    @FXML
    private fun limpiarCampos(){
        txtemail.clear()
        txtnombre.clear()
        txtapellidos.clear()
        txtedad.clear()
        txtpassword.clear()
    }

    @FXML
    fun onSalirButtonClick(event: ActionEvent) {
        volverAlPanelAdmin()

    }

    @FXML
    private fun volverAlPanelAdmin(){
        try {
            val loader = FXMLLoader(AgnadirUsuarioController::class.java.getResource("PanelAdministrador.fxml"))
            val root = loader.load<Parent>()

            val stage = btnsalir.scene.window as Stage
            stage.scene = Scene(root)
            stage.title = "Panel de Administrador"
        }catch (e: Exception){
            e.printStackTrace()
            lblmensaje.text = "Error al volver al panel de administrador"
        }
    }
}