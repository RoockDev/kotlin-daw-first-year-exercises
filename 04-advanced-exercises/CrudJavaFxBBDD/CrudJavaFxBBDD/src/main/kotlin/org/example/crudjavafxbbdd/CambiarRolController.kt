package org.example.crudjavafxbbdd

import DAO.UsuarioDAOImpl
import Modelo.Rol
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.stage.Stage

class CambiarRolController {
    @FXML private lateinit var btnVolver: Button
    @FXML private lateinit var btncambiarRol: Button
    @FXML private lateinit var lblresultado: Label
    @FXML private lateinit var txtemail: TextField
    val usuarioDAO = UsuarioDAOImpl()

    @FXML
    fun onCambiarRolButtonClick(event: ActionEvent) {
        val email = txtemail.text.trim()

        if (email.isEmpty()){
            lblresultado.text = "Por favor introduce un email"
        }else{
            try {
                val usuario = usuarioDAO.getUsuarioByEmail(email)

                if (usuario!= null){
                    if (usuario.rol == Rol.ESTANDAR){
                        usuario.rol = Rol.ADMINISTRADOR
                        lblresultado.text = "Nuevo Rol: ${usuario.rol.name}"
                        limpiarCampos()

                    }else if (usuario.rol == Rol.ADMINISTRADOR){
                        usuario.rol = Rol.ESTANDAR
                        lblresultado.text = "Nuevo Rol: ${usuario.rol.name}"
                        limpiarCampos()
                    }
                }else{
                    lblresultado.text = "Ese Email no existe"
                    limpiarCampos()
                }
            }catch (e: Exception){
                lblresultado.text = "Error al intentar cambiar el rol del usuario: ${e.message}"
                e.printStackTrace()
            }
        }

    }

    @FXML
    fun onVolverButtonClick(event: ActionEvent) {
        try {
            val loader = FXMLLoader(AgnadirUsuarioController::class.java.getResource("PanelAdministrador.fxml"))
            val root = loader.load<Parent>()

            val stage = btnVolver.scene.window as Stage
            stage.scene = Scene(root)
            stage.title = "Panel de Administrador"
        } catch (e: Exception) {
            e.printStackTrace()
            lblresultado.text = "Error al volver al panel de administrador"
        }

    }

    @FXML
    private fun limpiarCampos(){
        txtemail.clear()
    }
}