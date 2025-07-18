class PortalEventos { //Clase para la gestion de los eventos
    var listaEventos = ArrayList<Evento>()


    fun mostrarEventos() {
        for (evento in listaEventos) {
            println("- ${evento}")
        }
    }

    fun agregarEventos(listaDeEventos: ArrayList<Evento>) {
        listaEventos.addAll(listaDeEventos)
    }
}