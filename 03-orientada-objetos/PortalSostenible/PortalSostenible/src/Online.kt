class Online:Evento {
    var plataforma = ""
    var idOnline = 1

    companion object{
        private var contador = 1
    }

    constructor() : super() {
        idOnline = contador
        contador++
    }

    constructor(plataforma: String) : super() {
        this.plataforma = plataforma
        idOnline = contador
        contador++
    }

    override fun inscribirUsuario(usuario: Usuarios) {
        super.inscribirUsuario(usuario)
    }


    override fun elimirarInscripcion(usuario: Usuarios) {
        super.elimirarInscripcion(usuario)
    }

    override fun toString(): String {
        return "Online(plataforma='$plataforma', idOnline=$idOnline) ${super.toString()}"
    }


}