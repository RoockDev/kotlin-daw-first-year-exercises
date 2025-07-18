open class Entidad {
    var tipoEntidad = TipoEntidad.PERSONAJE_SECUNDARIO //por defecto

    constructor()

    open fun representarse(): String {
        return "${tipoEntidad.name}"
    }

}