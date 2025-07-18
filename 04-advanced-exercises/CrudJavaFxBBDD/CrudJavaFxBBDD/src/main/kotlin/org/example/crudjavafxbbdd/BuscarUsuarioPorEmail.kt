package org.example.crudjavafxbbdd

import DAO.UsuarioDAOImpl
import Modelo.Estadistica
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

class BuscarUsuarioPorEmail {

    @FXML private lateinit var btnBuscar: Button
    @FXML private lateinit var btnvolver: Button
    @FXML private lateinit var txtEmail: TextField
    @FXML private lateinit var lblresultado: Label

    val usuarioDAO = UsuarioDAOImpl()

    @FXML
    fun onBuscarButtonClick(event: ActionEvent) {
        val email = txtEmail.text.trim()

        if (email.isEmpty()){
            lblresultado.text = "Por favor, introduce el email"
        }else{
            try {
                val usuario = usuarioDAO.getUsuarioByEmail(email)

                if (usuario!= null){
                    lblresultado.text = """
                        Email: ${usuario.email}
                        Nombre: ${usuario.nombre}
                        Apellidos: ${usuario.apellidos}
                        Edad: ${usuario.edad}
                        Rol: ${usuario.rol.name}
                    """.trimIndent()
                }else{
                    lblresultado.text = "No hay ningun usuario registrado con ese email"
                }
            }catch (e: Exception){
                lblresultado.text = "Error al buscar un usuario por emial: ${e.message}"
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
        }catch (e: Exception){
            e.printStackTrace()
            lblresultado.text = "Error al volver al panel de administrador"
        }

    }
}