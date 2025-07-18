enum class CATEGORIAS {
    TALLER,
    CONFERENCIA,
    OTRAS;

    companion object {
        fun obtenerAleatorio(): String {
            return values().random().name
        }
    }
}