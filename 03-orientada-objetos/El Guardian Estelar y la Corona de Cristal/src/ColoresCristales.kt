enum class ColoresCristales {
    ROJO,
    AZUL,
    VERDE,
    PURPURA;

    companion object {
        fun obtenerAleatorio(): String {
            return values().random().name
        }
    }

}