enum class UBICACIONES_EVENTO {
    MADRID,
    BARCELONA,
    VALENCIA,
    SEVILLA,
    BILBAO;

    companion object {
        fun obtenerAleatorio(): String {
            return values().random().name
        }
    }
}
