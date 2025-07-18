package org.example.crudjavafxbbdd

import DAO.UsuarioDAO
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import java.sql.DriverManager.println
import DAO.UsuarioDAOImpl
import Modelo.Rol
import javax.security.auth.login.LoginException
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage



class MainController {

    @FXML private lateinit var BtnLogin: Button
    @FXML private lateinit var BtnRegistro: Button
    @FXML private lateinit var TxtEmail: TextField
    @FXML private lateinit var TxtPassword: PasswordField
    @FXML private lateinit var lbError: Label


    @FXML
    fun onLoginButtonClick(event: ActionEvent) {
        val email = TxtEmail.text
        val password = TxtPassword.text
        try {
            if (email.length == 0  || password.length == 0){
                lbError.text = "Por favor, complete todos los campos"
            }else{
                var usuario = UsuarioDAOImpl().getUsuarioByEmail(email)

                if (usuario != null  && usuario.password == password){
                    when(usuario.rol){
                        Rol.ESTANDAR -> abrirJuego()
                        Rol.ADMINISTRADOR -> abrirPanelAdmin()
                    }
                }else{
                    lbError.text = "Email o contraseña incorrectos"
                }
            }
        }catch (e:LoginException){
            println("Error al intentar hacer login: ${e.message}")
        }



    }

    @FXML
    fun onRegistrarseButtonClick(event: ActionEvent) {
        abrirRegistro()

    }
    @FXML
    fun initialize(){
        //limpiamos el mensaje de error al cargar la pantalla
        lbError.text = ""
    }

    private fun abrirRegistro(){
        try {
            val cargarVentana = FXMLLoader(MainController::class.java.getResource("VentanaRegistro.fxml"))
            val root = cargarVentana.load<Parent>()

            //obtener la ventana actual

            val stage = BtnRegistro.scene.window as Stage

            //Cambiar la escena
            stage.scene = Scene(root)
            stage.title = "Registro de Usuario"
        }catch (e: Exception){
            e.printStackTrace()
            lbError.text = "Error al abrir el registro: ${e.message}"
        }

    }
    @FXML
    fun abrirPanelAdmin() {
        try {
            val loader = FXMLLoader(MainController::class.java.getResource("PanelAdministrador.fxml"))
            val root = loader.load<Parent>()

            val stage = BtnLogin.scene.window as Stage
            stage.scene = Scene(root)
            stage.title = "Panel de Administrador"
        } catch (e: Exception) {
            e.printStackTrace()
            lbError.text = "Error al volver al panel de administrador"
        }
    }

    @FXML
    fun abrirJuego() {
        try {
            val loader = FXMLLoader(MainController::class.java.getResource("AdivinaElNumero.fxml"))
            val root = loader.load<Parent>()

            val stage = BtnLogin.scene.window as Stage
            stage.scene = Scene(root)
            stage.title = "Panel de Juego"
        } catch (e: Exception) {
            e.printStackTrace()
            lbError.text = "Error al volver al panel de Juego"
        }
    }




}