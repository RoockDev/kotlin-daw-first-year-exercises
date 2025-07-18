enum class NOMBRES_ALDEANOS {
    JUAN, PEDRO, LUCAS, MARIA, ANA, MIGUEL, CARLOS, ELENA, SANTIAGO, PABLO;

    companion object {
        fun obtenerNombreAleatorio(): String {
            return values().random().name
        }
    }
}