open class Evento {
    var nombre = ""
    var fecha = ""
    var ubicacion = ""
    var usuariosInscritos = ArrayList<Usuarios>()
    var organizadoresParticipantes = ArrayList<Organizadores>()
    var usuariosAssitentes = ArrayList<Usuarios>()
    var categoria = ""
    var idEvento = 1
    var seRealiza = true

    companion object {
        private var contador = 1
    }

    constructor() {
        idEvento = contador
        contador++
    }

    constructor(nombre: String, fecha: String, ubicacion: String, categorias: String) {
        this.nombre = nombre
        this.fecha = fecha
        this.ubicacion = ubicacion
        this.categoria = categorias
        idEvento = contador
        contador++
    }

    open fun inscribirUsuario(usuario: Usuarios) {
        usuariosInscritos.add(usuario)
    }

    // con este metodo comprobamos que solo pueda asistir un usuario si esta inscrito al evento
    open fun AsistenciaConfrimada(usuario: Usuarios): Boolean {
        var asiste = false
        if (usuario in usuariosInscritos) {
            usuariosAssitentes.add(usuario)
            asiste = true
        } else {
            println("El usuario no está inscrito, por lo tanto no puede asistir")
        }
        return asiste
    }


    fun mostrarUsuariosInscritos(): ArrayList<Usuarios> {
        return usuariosInscritos

    }

    fun cancelarEvento() {
        if (seRealiza) {
            seRealiza = false
            println("El evento $nombre se ha cancelado")
        } else {
            println("El evento $nombre ya estaba cancelado")
        }
    }

    open fun elimirarInscripcion(usuario: Usuarios) {
        usuariosInscritos.remove(usuario)

    }

    override fun toString(): String {
        return "Evento(nombre='$nombre', fecha='$fecha', ubicacion='$ubicacion', usuariosInscritos=$usuariosInscritos, organizadoresParticipantes=$organizadoresParticipantes, usuariosAssitentes=$usuariosAssitentes, categoria=$categoria, idEvento=$idEvento)"
    }


}