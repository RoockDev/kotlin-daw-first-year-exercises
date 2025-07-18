package org.example.protectorasergio

import AccesoADatos.AnimalDAOImplement
import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.*
import org.example.Animal
import org.example.Gato
import org.example.Perro
import java.io.File
import java.io.FileWriter
import java.net.URL
import java.time.LocalDate
import java.util.ResourceBundle

class AnimalController:Initializable {

    // ComboBox para seleccionar animales
    @FXML private lateinit var comboAnimal: ComboBox<String>

    // Campos comunes para todos los animales
    @FXML private lateinit var txtNombre: TextField
    @FXML private lateinit var txtTipo: TextField
    @FXML private lateinit var txtTexto: TextField // Veo que se llama txtTexto en lugar de txtSexo
    @FXML private lateinit var txtEdad: TextField
    @FXML private lateinit var chkSociable: CheckBox
    @FXML private lateinit var chkApadrinado: CheckBox

    // Campos específicos para perros
    @FXML private lateinit var txtRaza: TextField
    @FXML private lateinit var txtTamanio: TextField
    @FXML private lateinit var chkPPP: CheckBox
    @FXML private lateinit var chkLeishmania: CheckBox

    // Campo específico para gatos
    @FXML private lateinit var chkEsterilizado: CheckBox

    // Botones
    @FXML private lateinit var btnSolicitud: Button
    @FXML private lateinit var btnSolicitud1: Button // Parece que tienes dos botones con el mismo nombre
    @FXML private lateinit var btnPienso: Button

    // Lista de animales y DAO
    private val animalDAO = AnimalDAOImplement()
    private var listaAnimales = mutableListOf<Animal>()
    private var animalSeleccionado: Animal? = null

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        // Cargar los animales de la base de datos
        cargarAnimales()
    }

    private fun cargarAnimales() {
        try {

            listaAnimales = animalDAO.getAllAnimales().toMutableList()

            // Crear una lista para almacenar solo los nombres de los animales
            val nombreAnimales = mutableListOf<String>()

            // Recorrer todos los animales y extraer sus nombres
            for (animal in listaAnimales) {
                nombreAnimales.add(animal.nombre)
            }

            // Cargar los nombres en el ComboBox
            comboAnimal.items = FXCollections.observableArrayList(nombreAnimales)

            // Si hay animales, seleccionar el primero por defecto
            if (nombreAnimales.isNotEmpty()) {
                comboAnimal.selectionModel.selectFirst()
                seleccionarAnimal() // Mostrar datos del primer animal
            }
        } catch (e: Exception) {
            mostrarAlerta("Error", "No se pudieron cargar los animales desde la base de datos.", Alert.AlertType.ERROR)
            e.printStackTrace()
        }
    }

    @FXML
    fun seleccionarAnimal() {
        val nombreSeleccionado = comboAnimal.selectionModel.selectedItem ?: return

        // Buscar el animal con ese nombre
        animalSeleccionado = listaAnimales.find { it.nombre == nombreSeleccionado }

        if (animalSeleccionado != null) {
            // Limpiar campos primero
            limpiarCampos()

            // Cargar los datos comunes
            txtNombre.text = animalSeleccionado!!.nombre
            txtTipo.text = animalSeleccionado!!.tipo ?: ""
            txtTexto.text = animalSeleccionado!!.sexo ?: "" // Usando txtTexto para el sexo
            txtEdad.text = animalSeleccionado!!.edad?.toString() ?: ""
            chkSociable.isSelected = animalSeleccionado!!.sociables ?: false
            chkApadrinado.isSelected = animalSeleccionado!!.apadrinado ?: false

            // Verificar el tipo de animal y mostrar los datos específicos
            when (animalSeleccionado!!.tipo?.lowercase()) {
                "perro" -> {
                    try {
                        // Es un perro, mostrar datos específicos de perro
                        val perro = animalSeleccionado as Perro
                        txtRaza.text = perro.raza ?: ""
                        txtTamanio.text = perro.tamanio?.toString() ?: ""
                        chkPPP.isSelected = perro.ppp ?: false
                        chkLeishmania.isSelected = perro.tratamientoVsLeishmania ?: false

                        // Habilitar los campos de perro
                        habilitarCamposPerro(true)
                        // Deshabilitar los campos de gato
                        habilitarCamposGato(false)
                    } catch (e: Exception) {
                        println("Error al cargar datos de perro: ${e.message}")
                    }
                }
                "gato" -> {
                    try {
                        // Es un gato, mostrar datos específicos de gato
                        val gato = animalSeleccionado as Gato
                        chkEsterilizado.isSelected = gato.esterilizado ?: false

                        // Habilitar los campos de gato
                        habilitarCamposGato(true)
                        // Deshabilitar los campos de perro
                        habilitarCamposPerro(false)
                    } catch (e: Exception) {
                        println("Error al cargar datos de gato: ${e.message}")
                    }
                }
                else -> {
                    // Tipo desconocido, deshabilitar campos específicos
                    habilitarCamposPerro(false)
                    habilitarCamposGato(false)
                }
            }
        }
    }

    // Método para limpiar todos los campos
    private fun limpiarCampos() {
        // Limpiar campos comunes
        txtNombre.text = ""
        txtTipo.text = ""
        txtTexto.text = ""
        txtEdad.text = ""
        chkSociable.isSelected = false
        chkApadrinado.isSelected = false

        // Limpiar campos específicos de perro
        txtRaza.text = ""
        txtTamanio.text = ""
        chkPPP.isSelected = false
        chkLeishmania.isSelected = false

        // Limpiar campos específicos de gato
        chkEsterilizado.isSelected = false
    }

    // Método para habilitar o deshabilitar campos de perro
    private fun habilitarCamposPerro(habilitar: Boolean) {
        txtRaza.isDisable = !habilitar
        txtTamanio.isDisable = !habilitar
        chkPPP.isDisable = !habilitar
        chkLeishmania.isDisable = !habilitar
    }

    // Método para habilitar o deshabilitar campos de gato
    private fun habilitarCamposGato(habilitar: Boolean) {
        chkEsterilizado.isDisable = !habilitar
    }

    @FXML
    fun realizarSolicitud() {
        if (animalSeleccionado == null) {
            mostrarAlerta("Error", "Debes seleccionar un animal primero.", Alert.AlertType.WARNING)
            return
        }

        // Crear un diálogo para solicitar información de adopción
        val dialog = Dialog<Pair<Int, String>>()
        dialog.title = "Nueva Solicitud"
        dialog.headerText = "Solicitud para ${animalSeleccionado!!.nombre}"

        // Configurar botones
        dialog.dialogPane.buttonTypes.addAll(ButtonType.OK, ButtonType.CANCEL)

        // Crear layout para el diálogo
        val grid = GridPane()
        grid.hgap = 10.0
        grid.vgap = 10.0
        grid.padding = javafx.geometry.Insets(20.0, 150.0, 10.0, 10.0)

        // ComboBox para el tipo de solicitud
        val tipoSolicitud = ComboBox<String>()
        tipoSolicitud.items.addAll("Acogida", "Adopción")
        tipoSolicitud.selectionModel.selectFirst()

        // TextField para el email
        val email = TextField()
        email.promptText = "Email del solicitante"

        // Añadir los componentes al layout
        grid.add(Label("Tipo de solicitud:"), 0, 0)
        grid.add(tipoSolicitud, 1, 0)
        grid.add(Label("Email:"), 0, 1)
        grid.add(email, 1, 1)

        dialog.dialogPane.content = grid

        // Convertir el resultado cuando se pulsa OK
        dialog.setResultConverter { buttonType ->
            if (buttonType == ButtonType.OK) {
                val tipo = if (tipoSolicitud.value == "Acogida") 0 else 1
                Pair(tipo, email.text)
            } else {
                null
            }
        }

        // Mostrar el diálogo y procesar el resultado
        val result = dialog.showAndWait()

        if (result.isPresent) {
            val solicitud = result.get()
            guardarSolicitudEnFichero(animalSeleccionado!!.nombre, solicitud.first, solicitud.second)
        }
    }


    private fun guardarSolicitudEnFichero(nombreAnimal: String, tipoSolicitud: Int, email: String) {
        try {
            // Crear un fichero con el nombre del animal
            val nombreFichero = "${nombreAnimal}.txt"
            val file = File(nombreFichero)

            // Crear el fichero si no existe
            val fw = FileWriter(file, true) // true para añadir al final si ya existe

            // Escribir la solicitud en el fichero
            val tipoTexto = if (tipoSolicitud == 0) "Acogida" else "Adopción"
            val fecha = LocalDate.now().toString()
            fw.write("Fecha: $fecha | Tipo: $tipoTexto | Email: $email\n")
            fw.close()

            mostrarAlerta("Éxito", "Solicitud guardada correctamente en el fichero $nombreFichero", Alert.AlertType.INFORMATION)
        } catch (e: Exception) {
            mostrarAlerta("Error", "No se pudo guardar la solicitud en el fichero.", Alert.AlertType.ERROR)
            e.printStackTrace()
        }
    }

    @FXML
    fun estimarPienso() {
        // Implementación para el Ejercicio 5: Calcular la estimación de pienso
        try {
            var totalKg = 0.0
            val perrosAdultos = mutableListOf<Perro>()

            // Recorrer la lista de animales y calcular el pienso para perros adultos
            for (animal in listaAnimales) {
                if (animal.tipo?.lowercase() == "perro") {
                    val perro = animal as Perro
                    if (!perro.esCachorro()) {
                        perrosAdultos.add(perro)
                        // Calcular pienso diario y multiplicarlo por 7 para obtener semanal
                        totalKg += perro.calcularCantidadPienso() * 7
                    }
                }
            }

            // Mostrar el resultado
            val mensaje = "Estimación de pienso para perros adultos: $totalKg kg semanales.\n" +
                    "Total de perros adultos: ${perrosAdultos.size}"

            mostrarAlerta("Estimación de Pienso", mensaje, Alert.AlertType.INFORMATION)

            // Aquí se podría implementar la funcionalidad para guardar en un fichero serializable
            // como se pide en el Ejercicio 5

        } catch (e: Exception) {
            mostrarAlerta("Error", "No se pudo calcular la estimación de pienso.", Alert.AlertType.ERROR)
            e.printStackTrace()
        }
    }

    // Función auxiliar para mostrar alertas
    private fun mostrarAlerta(titulo: String, mensaje: String, tipo: Alert.AlertType) {
        val alert = Alert(tipo)
        alert.title = titulo
        alert.headerText = null
        alert.contentText = mensaje
        alert.showAndWait()
    }

}