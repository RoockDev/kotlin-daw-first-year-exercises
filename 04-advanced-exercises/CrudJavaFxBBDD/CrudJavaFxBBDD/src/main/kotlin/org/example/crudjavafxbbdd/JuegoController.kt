package org.example.crudjavafxbbdd

    import DAO.EstadisticaDAO
    import DAO.EstadisticaDAOImpl
    import javafx.event.ActionEvent
    import javafx.fxml.FXML
    import javafx.fxml.FXMLLoader
    import javafx.scene.Parent
    import javafx.scene.Scene
    import javafx.scene.control.Button
    import javafx.scene.control.Label
    import javafx.scene.control.TextField
    import javafx.stage.Stage


class JuegoController {



    @FXML private lateinit var BtnJugar: Button
    @FXML private lateinit var LblSolution: Label
    @FXML private lateinit var TxtNumero: TextField
    private val estadisticaDAO = EstadisticaDAOImpl()
    private var email = ""
    private var numeroSecreto = 0
    private var intentos = 0
    private val MAX_INTENTOS = 5
    private var juegoTerminado = false


    @FXML
    fun inicializarJuego(email: String){
        this.email = email
        reiniciarJuego()
    }

    @FXML
    fun reiniciarJuego(){
        numeroSecreto = (1..10).random()
        intentos = 0
        LblSolution.text = "Advinina un numero del 1 al 10 tienes ${MAX_INTENTOS}"
        TxtNumero.clear()
    }





    @FXML
    fun onJugarbuttonClick(event: ActionEvent) {
        if (juegoTerminado){
            TxtNumero.isDisable = false
            reiniciarJuego()
            juegoTerminado = false
            BtnJugar.text = "Jugar"
        }
        var numeroJugado = TxtNumero.text.trim()

        if (numeroJugado.isEmpty()){
            LblSolution.text = "Debes introducir un numero"
        }else{
            try {
                val numeroJugador = numeroJugado.toInt()
                if (numeroJugador !in 1..10){
                    LblSolution.text = "Has debes introducir un numero entre el 1 y el 10"
                    intentos++
                }else if (numeroJugador == numeroSecreto){
                    LblSolution.text = "Felicidades,Has ganado !!!"
                    estadisticaDAO.actualizaGanado(email)
                    finalizarJuego()
                }else if(intentos>= MAX_INTENTOS){{
                    LblSolution.text = "Has perdido, llegaste al numero maximo de intentos el numero era ${numeroSecreto}"
                    estadisticaDAO.actualizaPerdido(email)
                    finalizarJuego()
                }

                }else{
                    var pista = if (numeroSecreto < numeroJugador) "menor" else "mayor"
                    LblSolution.text = "Error, el numero introducido es ${pista} que el numero secreto"
                    intentos++

                }

            }catch (e: NumberFormatException){
                LblSolution.text = "Introduce un numero valido"
            }
        }

    }


    private fun finalizarJuego(){
        TxtNumero.isDisable = true
        BtnJugar.text = "Jugar de nuevo"
        juegoTerminado = true


    }



    @FXML
    private fun volverALogin(){
        try {
            val cargarVentana = FXMLLoader(JuegoController::class.java.getResource("main-view.fxml"))
            val root = cargarVentana.load<Parent>()

            val stage = BtnJugar.scene.window as Stage
            stage.scene = Scene(root)
            stage.title = "Login"
        }catch (e: Exception){
            e.printStackTrace()
            LblSolution.text = "Error al volver a la pantalla Login: ${e.message}"
        }
    }


    @FXML
    fun onVolverbuttonclick(event: ActionEvent) {
        volverALogin()
    }





}



