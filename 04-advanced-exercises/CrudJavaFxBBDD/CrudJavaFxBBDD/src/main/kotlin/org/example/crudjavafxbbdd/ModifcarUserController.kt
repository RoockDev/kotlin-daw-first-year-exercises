package org.example.crudjavafxbbdd

import DAO.UsuarioDAOImpl
import Modelo.Estadistica
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

class ModifcarUserController {
    @FXML private lateinit var btnmodificar: Button
    @FXML private lateinit var btnvolver: Button
    @FXML private lateinit var lblresultado: Label
    @FXML private lateinit var txtemail: TextField
    @FXML private lateinit var txtapellidos: TextField
    @FXML private lateinit var txtedad: TextField
    @FXML private lateinit var txtnombre: TextField
    @FXML private lateinit var txtpassword: TextField

    val usuarioDAO = UsuarioDAOImpl()


    @FXML
    fun onVolverButtonClick(event: ActionEvent) {
        try {
            val loader = FXMLLoader(AgnadirUsuarioController::class.java.getResource("PanelAdministrador.fxml"))
            val root = loader.load<Parent>()

            val stage = btnvolver.scene.window as Stage
            stage.scene = Scene(root)
            stage.title = "Panel de Administrador"
        } catch (e: Exception) {
            e.printStackTrace()
            lblresultado.text = "Error al volver al panel de administrador"
        }
    }

    @FXML
    fun onmodificarbuttonClick(event: ActionEvent) {
        val email = txtemail.text.trim()

        if (email.isEmpty()){
            lblresultado.text = "El email es obligatorio"
            limpiarCampos()
        }else{
            try {
                val usuario = usuarioDAO.getUsuarioByEmail(email)

                if (usuario != null){
                     var usuarioActual = usuario
                    usuarioDAO.deleteUsuario(usuario)
                    usuarioDAO.insertUsuario(usuarioActual)
                    lblresultado.text = "Usuario Modificado Correctamente"
                    limpiarCampos()
                }else{
                    lblresultado.text = "El usuario no se ha podido modificar"
                    limpiarCampos()
                }
            }catch (e: Exception){
                lblresultado.text = "Error al intentar modificar Usuario: ${e.message}"
                e.printStackTrace()
                limpiarCampos()
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
}