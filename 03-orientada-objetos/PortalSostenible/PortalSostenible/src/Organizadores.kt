class Organizadores {
    var nombre = ""
    var nombreEmpresa = ""
    var correo = ""
    var eventosCreados = ArrayList<Evento>()
    var idOrganizador = 1

    companion object {
        private var contador = 1
    }

    constructor() {
        idOrganizador = contador
        contador++
    }

    constructor(nombre: String) {
        this.nombre = nombre
        idOrganizador = contador
        contador++
    }

    constructor(nombre: String, nombreEmpresa: String, correo: String) {
        this.nombre = nombre
        this.nombreEmpresa = nombreEmpresa
        this.correo = correo
        idOrganizador = contador
        contador++
    }

    fun eligeEventoAcrear(): Evento {
        var evento = Evento()
        var eleccion = 0
        var salir = false
        do {
            println("Que evento desea crear: [1]Generico, [2]Presencial,[3]Online,[4]Salir(Se crerara uno generico por defecto)")
            eleccion = readln().toIntOrNull() ?: -1
            when (eleccion) {
                1 -> {
                    evento = crearEventoGenerico(
                        NOMBRES_EVENTO.obtenerAleatorio(),
                        FECHAS_EVENTO.obtenerAleatorio(),
                        UBICACIONES_EVENTO.obtenerAleatorio(),
                        CATEGORIAS.obtenerAleatorio()
                    )
                }

                2 -> {
                    evento = crearEventoPresencial(
                        NOMBRES_EVENTO.obtenerAleatorio(),
                        FECHAS_EVENTO.obtenerAleatorio(),
                        UBICACIONES_EVENTO.obtenerAleatorio(),
                        DIRECCIONES_EVENTO.obtenerAleatorio(),
                        CATEGORIAS.obtenerAleatorio()
                    )
                }

                3 -> {
                    evento = crearEventoOnline(
                        NOMBRES_EVENTO.obtenerAleatorio(),
                        FECHAS_EVENTO.obtenerAleatorio(),
                        UBICACIONES_EVENTO.obtenerAleatorio(),
                        PLATAFORMAS_EVENTO.obtenerAleatorio(),
                        CATEGORIAS.obtenerAleatorio()
                    )
                }

                4 -> salir = true
            }

        } while (eleccion !in 1..4 && !salir)
        return evento
    }


    fun crearEventoGenerico(nombre: String, fecha: String, ubicacion: String, categoria: String): Evento {
        var eventoCreado = Evento(nombre, fecha, ubicacion, categoria)
        eventosCreados.add(eventoCreado)
        return eventoCreado //DUDA REVISAR LUEGO PARA LA LISTA DE ORGANIZADORES EN CLASE EVENTO
    }

    fun crearEventoPresencial(
        nombre: String,
        fecha: String,
        ubicacion: String,
        direccion: String,
        categoria: String
    ): Presencial {
        var eventoPresencial = Presencial(direccion)
        eventoPresencial.nombre = nombre
        eventoPresencial.fecha = fecha
        eventoPresencial.ubicacion = ubicacion
        eventoPresencial.categoria = categoria
        eventosCreados.add(eventoPresencial)
        return eventoPresencial
    }

    fun crearEventoOnline(
        nombre: String,
        fecha: String,
        ubicacion: String,
        plataforma: String,
        categoria: String
    ): Online {
        var eventoOnline = Online(plataforma)
        eventoOnline.nombre = nombre
        eventoOnline.fecha = fecha
        eventoOnline.ubicacion = ubicacion
        eventoOnline.categoria = categoria
        eventosCreados.add(eventoOnline)
        return eventoOnline //DUDA REVISAR LUEGO PARA LA LISTA DE ORGANIZADORES EN CLASE EVENTO
    }

    fun muestraInformacionEventoCreado(eventoCreado: Evento) {
        when (eventoCreado::class) { // se usa class para distinguir tipos exactos
            Evento::class -> println("Has creado un evento Generico")
            Presencial::class -> println("Has creado un evento Presencial")
            Online::class -> println("Has creado un evento Online")
        }
    }


    fun modificarEvento() {

        if (eventosCreados.isNotEmpty()) {
            var random = (0 until eventosCreados.size).random()
            eventosCreados[random].nombre = NOMBRES_EVENTO.obtenerAleatorio()
            eventosCreados[random].fecha = FECHAS_EVENTO.obtenerAleatorio()
            eventosCreados[random].ubicacion = UBICACIONES_EVENTO.obtenerAleatorio()
            eventosCreados[random].categoria = CATEGORIAS.obtenerAleatorio()
            println(
                "Evento ${
                    eventosCreados[random].nombre
                } modificado"
            )
        } else println("No hay eventos para modificar")

    }


    fun eliminarEvento() {
        if (eventosCreados.isNotEmpty()) {
            var random = (0 until eventosCreados.size).random()
            val eventoEliminado = eventosCreados[random]
            eventosCreados.remove(eventoEliminado)
            println("Evento ${eventoEliminado.nombre} eliminado")
        } else {
            println("No hay eventos disponibles para eliminar")
        }
    }

    fun mostrarEventos() {
        if (eventosCreados.isEmpty()) {
            println("El organizador ${nombre} no tiene ningun evento creado")
        } else {
            println("Eventos creados por ${nombre}")
            for (evento in eventosCreados) {
                println(" - ${evento.nombre}")
            }
        }
    }
}











