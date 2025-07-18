class Usuarios {
    var nombre = ""
    var correo = ""
    var idUsuario = 1
    var eventosApuntado = ArrayList<Evento>()

    companion object {
        private var contador = 1

    }

    constructor() {
        idUsuario = contador
        contador++
    }

    constructor(nombre: String) {
        this.nombre = nombre
    }

    fun inscirbirAevento(evento: Evento) {
        evento.inscribirUsuario(this)
        eventosApuntado.add(evento)
        println("Inscrito con exito al evento ${evento.nombre}")
    }

    fun cancelarInscripcion() {
        if (eventosApuntado.isNotEmpty()) {
            var random = (0 until eventosApuntado.size).random()
            var eventoCancelado = eventosApuntado[random]
            eventosApuntado.remove(eventoCancelado)
            println("Has cancelado la inscripcion al evento:  ${eventoCancelado.nombre}")
        } else {
            println("No puedes cancelar un evento al que no estas inscrito")
        }
    }

    fun mostrarEventosApuntado() {
        println("Eventos a los que estas inscrit@ : ")
        if (eventosApuntado.isNotEmpty()) {
            for (i in eventosApuntado) {
                println(" - ${i}")
            }
        } else {
            println("El usuario no esta apuntado a ningun evento")
        }
    }


    fun confirmarAsistencia() {
        if (eventosApuntado.isNotEmpty()) {
            var random = (0 until eventosApuntado.size).random()
            var eventoAleatorio = eventosApuntado[random]
            println("Asistencia Confirmada al evento:  ${eventoAleatorio.nombre}")
        } else {
            println("No se puede asistir sin inscripcion previa")
        }


    }

    override fun toString(): String {
        return "Usuarios(" +
                "nombre='$nombre', " +
                "idUsuario=$idUsuario" +
                ")"
    }


}