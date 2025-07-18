class Factoria {
    companion object {
        fun nuevoOrganizor(): Organizadores {
            var organizador = Organizadores(NOMBRES_RANDOM.obtenerAleatorio())

            return organizador
        }

        fun crearUsuarioAleatorio(): Usuarios {
            var usuario = Usuarios(NOMBRES_RANDOM.obtenerAleatorio())
            return usuario
        }

        // Para pruebas y simulaciones
        fun crearEventoAletorio(): Evento {
            var evento = Evento(
                NOMBRES_EVENTO.obtenerAleatorio(),
                FECHAS_EVENTO.obtenerAleatorio(),
                UBICACIONES_EVENTO.obtenerAleatorio(),
                CATEGORIAS.obtenerAleatorio()
            )
            return evento

        }

        // Para pruebas y simulaciones
        fun crearMuchosEventosAletorios(): ArrayList<Evento> {
            var listaDeEventos = ArrayList<Evento>()
            var totalEventos = 10
            for (i in 1..totalEventos) {
                listaDeEventos.add(crearEventoAletorio())
            }
            return listaDeEventos
        }


    }
}