package org.example.crudjavafxbbdd
import DAO.UsuarioDAOImpl
import Modelo.Estadistica
import Modelo.Rol
import Modelo.Usuario
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import javafx.stage.Stage

class RegistroController {

    @FXML private lateinit var LblError: Label
    @FXML private lateinit var TxtApellidos: TextField
    @FXML private lateinit var TxtEdad: TextField
    @FXML private lateinit var TxtEmail: TextField
    @FXML private lateinit var TxtNombre: TextField
    @FXML private lateinit var TxtPasword: PasswordField
    @FXML private lateinit var BtnCancelar: Button



    @FXML
    fun initialize(){
        //Inicializar lbl vacia cuando se carga la pantalla
        LblError.text = ""
    }
    @FXML
    fun onRegistrarButtonClick(event: ActionEvent) {
        val email = TxtEmail.text.trim()
        val nombre = TxtNombre.text.trim()
        val apellidos = TxtApellidos.text.trim()
        val edad = TxtEdad.text.trim()
        val password = TxtPasword.text.trim()

        if (email.isEmpty() || nombre.isEmpty() || apellidos.isEmpty()
            || edad.isEmpty() || password.isEmpty()){
            LblError.text = "todos los campos son obligatorios"
        }else{
            try {
                //verificamos si el usuario existe
                val usuarioExistente = UsuarioDAOImpl().getUsuarioByEmail(email)

                if (usuarioExistente!= null){
                    LblError.text = "Este usuario ya existe"
                }else{
                    //creamos un nuevo usuario
                    val usuario = Usuario(email,nombre,apellidos,edad,password)

                    val registrado = UsuarioDAOImpl().insertUsuario(usuario)
                    if (registrado){
                        volverALogin()
                    }else LblError.text = "Error al registrar usuario"

                }

            }catch (e: Exception){
                LblError.text = "Error en el intento de registro: ${e.message}"
                e.printStackTrace()
            }
        }


    }

    @FXML
    fun onCancelarButtonClick(event: ActionEvent) {
        volverALogin()
    }

    private fun volverALogin(){
        try {
            val cargarVentana = FXMLLoader(RegistroController::class.java.getResource("VentanaRegistro.fxml"))
            val root = cargarVentana.load<Parent>()

            val stage = BtnCancelar.scene.window as Stage
            stage.scene = Scene(root)
            stage.title = "Login"
        }catch (e: Exception){
            e.printStackTrace()
            LblError.text = "Error al volver a la pantalla de login"
        }
    }



}