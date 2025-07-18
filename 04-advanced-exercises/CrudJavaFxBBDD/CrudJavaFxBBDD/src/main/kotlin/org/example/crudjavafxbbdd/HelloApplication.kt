package org.example.crudjavafxbbdd
import DAO.UsuarioDAOImpl
import Modelo.Rol
import Modelo.Usuario
import javafx.fxml.FXML
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class HelloApplication : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("main-view.fxml"))
        val scene = Scene(fxmlLoader.load(), 320.0, 240.0)
        stage.title = "Login"
        stage.scene = scene
        stage.show()
    }
}

fun main() {

    
    Application.launch(HelloApplication::class.java)
}