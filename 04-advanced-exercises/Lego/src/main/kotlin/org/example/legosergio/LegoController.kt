package org.example.legosergio

import AccesoADatos.GuerrerasDAO
import AccesoADatos.GuerrerasDAOImplem
import AccesoADatos.ResultadoDAO
import AccesoADatos.ResultadoDAOFichero
import Negocio.MujerGuerrera
import Negocio.Reto
import Negocio.Tablero
import Utillidades.CONSTANTES
import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.ComboBox
import javafx.scene.control.Label
import javafx.scene.control.TextArea
import javafx.stage.FileChooser
import java.net.URL
import java.util.*

class LegoController:Initializable {


    @FXML
    private lateinit var cmbGuerreras: ComboBox<Int>

    @FXML
    private lateinit var cmbSimulaciones: ComboBox<Int>

    @FXML
    private lateinit var txtResultados: TextArea

    // Acceso a la base de datos
    private val guerreraDAO: GuerrerasDAO = GuerrerasDAOImplem()

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        // Inicializar ComboBox de guerreras (2-5)
        var guerrera = guerreraDAO.getAllGuerreras()
        cmbGuerreras.items = FXCollections.observableArrayList(guerreraDAO.getAllGuerreras())
        cmbGuerreras.selectionModel.select(1) // Seleccionar 3 por defecto

        // Inicializar ComboBox de simulaciones (1-3)
        cmbSimulaciones.items = FXCollections.observableArrayList(1, 2, 3)
        cmbSimulaciones.selectionModel.select(1) // Seleccionar 2 por defecto

        // Mostrar info inicial
        txtResultados.text = "Bienvenido al Juego LEGO.\n\n"

        // Mostrar cantidad de guerreras en la base de datos
        try {
            val totalGuerreras = guerreraDAO.getAllGuerreras()
            txtResultados.appendText("Base de datos: Se han encontrado ${totalGuerreras.size} guerreras disponibles.\n\n")
        } catch (e: Exception) {
            txtResultados.appendText("Error al conectar con la base de datos: ${e.message}\n\n")
        }

        txtResultados.appendText("1. Selecciona el número de guerreras por equipo.\n")
        txtResultados.appendText("2. Selecciona el número de simulaciones a ejecutar.\n")
        txtResultados.appendText("3. Haz clic en 'Iniciar Simulación' para comenzar.\n")
    }


    @FXML
    private fun iniciarSimulacion() {
        val cantidadGuerreras = cmbGuerreras.value
        val cantidadJuegos = cmbSimulaciones.value

        if (cantidadGuerreras == null || cantidadJuegos == null) {
            txtResultados.text = "Error: Selecciona valores válidos para guerreras y simulaciones."
            return
        }

        try {
            // Limpiar resultados anteriores
            txtResultados.text = "Iniciando simulación...\n\n"

            // Crear el tablero (internamente carga las guerreras de la BD)
            val tablero = Tablero(cantidadGuerreras)

            // Jugar varias veces
            for (i in 1..cantidadJuegos) {
                txtResultados.appendText("=== JUEGO #$i ===\n")

                // Ejecutar el juego y mostrar resultados
                simularYMostrarResultados(tablero)

                txtResultados.appendText("\n")
            }

            txtResultados.appendText("=== FIN DE LA SIMULACIÓN ===\n")

        } catch (e: Exception) {
            txtResultados.appendText("\nError durante la simulación: ${e.message}\n")
        }
    }

    // Método que ejecuta un juego y muestra los resultados en el TextArea
    private fun simularYMostrarResultados(tablero: Tablero) {
        // Equipo A
        txtResultados.appendText("=== EQUIPO A ENFRENTA SUS RETOS ===\n")
        val equipoA = tablero.obtenerEquipoA()
        val retosA = tablero.obtenerRetosEquipoA()

        for (i in equipoA.indices) {
            val guerrera = equipoA[i]
            val reto = retosA[i]

            txtResultados.appendText("Guerrera: ${guerrera.nombre} enfrenta reto: ${reto.descripcion}\n")

            val puedeResolver = if (reto.esFuerza == true) {
                guerrera.puedeRealizarTarea(
                    reto.inteligenciaRequerida,
                    reto.edadMinima,
                    reto.edadMaxima,
                    true,
                    reto.fuerzaRequerida
                )
            } else {
                guerrera.puedeRealizarTarea(
                    reto.inteligenciaRequerida,
                    reto.edadMinima,
                    reto.edadMaxima,
                    true,
                    reto.fuerzaRequerida
                )
            }

            if (puedeResolver) {
                txtResultados.appendText("¡La guerrera ${guerrera.nombre} ha superado el reto!\n")
            } else {
                txtResultados.appendText("La guerrera ${guerrera.nombre} no ha podido superar el reto.\n")
            }
            txtResultados.appendText("\n")
        }

        // Equipo B
        txtResultados.appendText("=== EQUIPO B ENFRENTA SUS RETOS ===\n")
        val equipoB = tablero.obtenerEquipoB()
        val retosB = tablero.obtenerRetosEquipoB()

        for (i in equipoB.indices) {
            val guerrera = equipoB[i]
            val reto = retosB[i]

            txtResultados.appendText("Guerrera: ${guerrera.nombre} enfrenta reto: ${reto.descripcion}\n")

            val puedeResolver = if (reto.esFuerza == true) {
                guerrera.puedeRealizarTarea(
                    reto.inteligenciaRequerida,
                    reto.edadMinima,
                    reto.edadMaxima,
                    true,
                    reto.fuerzaRequerida
                )
            } else {
                guerrera.puedeRealizarTarea(
                    reto.inteligenciaRequerida,
                    reto.edadMinima,
                    reto.edadMaxima,
                    true,
                    reto.fuerzaRequerida
                )
            }

            if (puedeResolver) {
                txtResultados.appendText("¡La guerrera ${guerrera.nombre} ha superado el reto!\n")
            } else {
                txtResultados.appendText("La guerrera ${guerrera.nombre} no ha podido superar el reto.\n")
            }
            txtResultados.appendText("\n")
        }

        // Resultados finales
        txtResultados.appendText("RESULTADOS DEL JUEGO \n")
        // Para simplificar, no contamos realmente las ganadoras aquí
        txtResultados.appendText("Consulta los detalles arriba para ver qué guerreras superaron sus retos.\n")
    }

    @FXML
    private fun guardarResultados() {
        if (txtResultados.text.isBlank() || txtResultados.text.startsWith("Bienvenido")) {
            txtResultados.appendText("\nNo hay resultados para guardar. Ejecuta una simulación primero.\n")
            return
        }

        val fileChooser = FileChooser()
        fileChooser.title = "Guardar Resultados"
        fileChooser.initialFileName = "resultados_juego_lego.txt"
        fileChooser.extensionFilters.add(FileChooser.ExtensionFilter("Archivos de texto", "*.txt"))

        val file = fileChooser.showSaveDialog(cmbGuerreras.scene.window)

        if (file != null) {
            try {
                file.writeText(txtResultados.text)
                txtResultados.appendText("\nResultados guardados correctamente en: ${file.absolutePath}\n")
            } catch (e: Exception) {
                txtResultados.appendText("\nError al guardar los resultados: ${e.message}\n")
            }
        }
    }

    @FXML
    private fun cargarResultados() {
        val fileChooser = FileChooser()
        fileChooser.title = "Cargar Resultados"
        fileChooser.extensionFilters.add(FileChooser.ExtensionFilter("Archivos de texto", "*.txt"))

        val file = fileChooser.showOpenDialog(cmbGuerreras.scene.window)

        if (file != null) {
            try {
                val contenido = file.readText()
                txtResultados.text = "=== RESULTADOS CARGADOS ===\n\n$contenido"
            } catch (e: Exception) {
                txtResultados.appendText("\nError al cargar los resultados: ${e.message}\n")
            }
        }
    }
}


