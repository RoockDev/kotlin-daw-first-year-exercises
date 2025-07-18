package org.example.crudjavafxbbdd

import DAO.UsuarioDAOImpl
import Modelo.Estadistica
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.stage.Stage

class EliminarUserController {
    @FXML private lateinit var btneliminar: Button
    @FXML private lateinit var btnvolver: Button
    @FXML private lateinit var lblresultado: Label
    @FXML private lateinit var txtemail: TextField

    private val usuarioDAO = UsuarioDAOImpl()

    @FXML
    fun onEliminarButtonClick(event: ActionEvent) {
        val email = txtemail.text.trim()

        if (email.isEmpty()){
            lblresultado.text = "Por favor introduce un email"
        }else{
            try {
                val usuario = usuarioDAO.getUsuarioByEmail(email)

                if (usuario!= null){
                    usuarioDAO.deleteUsuario(usuario)
                    lblresultado.text = "Usuario borrado correctamente"
                    txtemail.clear()
                }else{
                    lblresultado.text = "El email que ha introducido no existe"
                }
            }catch (e: Exception){
                lblresultado.text = "Error al intentar eliminar un usuario: ${e.message}"
                e.printStackTrace()
            }
        }

    }

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


    }


