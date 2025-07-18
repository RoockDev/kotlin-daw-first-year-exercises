fun main() {
    //generamos un conjunto de eventos para el portal
    var portalDeEventos = PortalEventos()
    var eventosPortal = Factoria.crearMuchosEventosAletorios()
    portalDeEventos.agregarEventos(eventosPortal)


    println("Bienvenidos al portal web sostenible")
    var opcion = 0
    do {
        println("Es usted organizador[1] o usuario[2]")
        opcion = readln().toIntOrNull() ?: -1
    } while (opcion != 1 && opcion != 2)
    var salirDelPortal = false
    when (opcion) {
        1 -> {
            var organizador = Factoria.nuevoOrganizor()
            println("Bienvenid@ ${organizador.nombre}")
            var eleccionOrganizador = 0
            salirDelPortal = false
            do {
                println(
                    "Que desea hacer:" +
                            "[1] Crear un evento" +
                            "[2] Eliminar un evento" +
                            "[3] Modificar un evento" +
                            "[4] Consultar sus eventos" +
                            "[5] Salir del portal web"
                )
                eleccionOrganizador = readln().toIntOrNull() ?: -1
                when (eleccionOrganizador) {
                    1 -> {
                        var eventoCreado = organizador.eligeEventoAcrear()
                        organizador.muestraInformacionEventoCreado(eventoCreado)
                        println(eventoCreado)
                    }

                    2 -> organizador.eliminarEvento()
                    3 -> organizador.modificarEvento()
                    4 -> organizador.mostrarEventos()
                    5 -> {
                        salirDelPortal = true
                        println("Gracias por su visita.")
                    }

                }

            } while (eleccionOrganizador !in 1..5 || !salirDelPortal)

        }

        2 -> {
            salirDelPortal = false
            var usuario = Factoria.crearUsuarioAleatorio()
            var eleccionUsuario = 0

            do {
                println("Menu de usuario:")
                println("Bienvenid@ ${usuario.nombre}")
                println(
                    "Que desea hacer:" +
                            "[1] Inscribirse a un evento" +
                            "[2] Confirmar Asistencia a un evento" +
                            "[3] Cancelar inscripcion a un evento" +
                            "[4] Consultar lista de eventos" +
                            "[5] Consultar lista de eventos a los que estás inscrito" +
                            "[6] Salir del portal web"
                )
                eleccionUsuario = readln().toIntOrNull() ?: -1

                when (eleccionUsuario) {
                    1 -> usuario.inscirbirAevento(eventosPortal.random())
                    2 -> usuario.confirmarAsistencia()
                    3 -> usuario.cancelarInscripcion()
                    4 -> portalDeEventos.mostrarEventos()
                    5 -> usuario.mostrarEventosApuntado()
                    6 -> {
                        salirDelPortal = true
                        println("Gracias por su visita.")
                    }

                }

            } while (eleccionUsuario !in 1..6 || !salirDelPortal)


        }
    }


}